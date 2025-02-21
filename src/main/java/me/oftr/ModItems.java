package me.oftr;

import me.oftr.item.armor.EnderiteArmorMatierial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        return registeredItem;
    }

    public static final ToolMaterial ENDERITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            4550,
            7.0F,
            1.5F,
            22,
            EnderiteArmorMatierial.REPAIRS_ENDERITE_ARMOR
    );

    public static final RegistryKey<Item> ENDERITE_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, "enderite_ingot"));
    public static final Item ENDERITE_INGOT = register(
            new Item(new Item.Settings().registryKey(ENDERITE_INGOT_KEY)),
            ENDERITE_INGOT_KEY
    );

    public static final RegistryKey<Item> ENDERITE_SWORD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, "enderite_sword"));
    public static final Item ENDERITE_SWORD = register(new SwordItem(ENDERITE_TOOL_MATERIAL, 8f, 0.5f, new Item.Settings().registryKey(ENDERITE_SWORD_KEY)), ENDERITE_SWORD_KEY);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.ENDERITE_INGOT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.ENDERITE_SWORD));
    }
}
