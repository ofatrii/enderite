package me.oftr.block;

import me.oftr.Enderite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            AbstractBlock.Settings.create().strength(10f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE));

    public static final Block ENDERITE_ORE = registerExperienceDroppingBlock(
            "enderite_ore",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS),
    UniformIntProvider.create(2,5));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Enderite.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Enderite.MOD_ID, name), block);
    }

    private static Block registerExperienceDroppingBlock(String name, AbstractBlock.Settings blockSettings, IntProvider experienceDropped) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Enderite.MOD_ID, name));
        Block block = new ExperienceDroppingBlock(experienceDropped, blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Enderite.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Enderite.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        Enderite.LOGGER.info("Registering Mod Blocks for " + Enderite.MOD_ID);
    }

}
