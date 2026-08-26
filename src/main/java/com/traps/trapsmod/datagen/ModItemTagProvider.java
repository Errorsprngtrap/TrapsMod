package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TrapsMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //do add tag do teh same as block so tag .add ect


    }
}
