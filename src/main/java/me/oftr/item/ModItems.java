package me.oftr.item;

import me.oftr.Enderite;
import me.oftr.item.custom.EnderiteSpearItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static final RegistryKey<Item> ENDERITE_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, "enderite_ingot"));
    public static final Item ENDERITE_INGOT = register(
            new Item(new Item.Settings().registryKey(ENDERITE_INGOT_KEY)),
            ENDERITE_INGOT_KEY
    );

    public static final RegistryKey<Item> ENDERITE_SPEAR_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, "enderite_spear"));
    public static final EnderiteSpearItem ENDERITE_SPEAR = (EnderiteSpearItem) register(new EnderiteSpearItem(ToolMaterial.NETHERITE, -4, 1f, new Item.Settings().registryKey(ENDERITE_SPEAR_KEY)), ENDERITE_SPEAR_KEY);

    //public static final RegistryKey<Item> ENDERITE_SWORD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, "enderite_sword"));
    //public static final Item ENDERITE_SWORD = register(new SwordItem(ENDERITE_TOOL_MATERIAL, 8f, 0.5f, new Item.Settings().registryKey(ENDERITE_SWORD_KEY)), ENDERITE_SWORD_KEY);

    public static void registerModItems() {
        Enderite.LOGGER.info("Registering Mod Items for " + Enderite.MOD_ID);
    }
}
