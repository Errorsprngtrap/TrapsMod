package com.traps.trapsmod.creativetab;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.ModBlocks;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TrapsMod.MOD_ID);


    public static final Supplier<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetabs.templatemod.test_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST_ITEM);
                        output.accept(ModBlocks.MINE);
                        output.accept(ModBlocks.STEALTH_MINE);
                        output.accept(ModBlocks.IMPROVED_MINE);
                        output.accept(ModBlocks.BARBED_WIRE);
                        output.accept(ModBlocks.GRASS_FAKE_FLOOR);
                        output.accept(ModBlocks.DIRT_FAKE_FLOOR);
                        output.accept(ModBlocks.SPIKE_TRAP);
                        output.accept(ModBlocks.POISON_SPIKE_TRAP);
                        output.accept(ModBlocks.REDSTONE_SPIKE_TRAP);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
