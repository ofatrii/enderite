package me.oftr.item.armor;

import me.oftr.Enderite;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class EnderiteArmorMatierial {
    public static final int BASE_DURABILITY = 4550;

    public static final RegistryKey<EquipmentAsset> ENDERITE_ARMOR_MATERIAL_KEY =  RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Enderite.MOD_ID, "enderite_ingot"));

    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(Enderite.MOD_ID, "repairs_enderite_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_ENDERITE_ARMOR,
            ENDERITE_ARMOR_MATERIAL_KEY
    );
}
