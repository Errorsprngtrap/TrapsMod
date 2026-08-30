package com.traps.trapsmod.item;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.item.custom.Bandage;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TrapsMod.MOD_ID);

    public static final DeferredItem<Item> BANDAGE = ITEMS.registerItem(
            "bandage",
            properties -> new Bandage(properties.stacksTo(16))
    );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
