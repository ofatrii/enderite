package me.oftr.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class EnderiteSpearItem extends SwordItem {
    public EnderiteSpearItem(ToolMaterial material, int attackDamage, float attackSpeed,  Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PassiveEntity) {
            target.kill((ServerWorld) target.getWorld());
            return true;
        }
        return false;
    }
}
