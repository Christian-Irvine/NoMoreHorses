package me.craftymcfish.nomorehorses.block.custom.entity;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<MaceratorBlockEntity> MACERATOR_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NoMoreHorses.MOD_ID, "macerator_block_entity"),
                    FabricBlockEntityTypeBuilder.create(MaceratorBlockEntity::new,
                            ModBlocks.MACERATOR).build());

    public static final BlockEntityType<FisherBlockEntity> FISHER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NoMoreHorses.MOD_ID, "fisher_block_entity"),
                    FabricBlockEntityTypeBuilder.create(FisherBlockEntity::new,
                            ModBlocks.FISHER).build());

    public static void registerBlockEntities() {
        NoMoreHorses.LOGGER.info("Successfully Registered Block Entities");
    }
}
