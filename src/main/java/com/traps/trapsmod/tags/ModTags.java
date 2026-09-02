package com.traps.trapsmod.tags;

import com.traps.trapsmod.TrapsMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class  Items{
        //create tag example just below
        //public static final TagKey<Item> NEEDS_TEST_TOOL = createTag("need_test_tool");
        //public static final TagKey<Item> INCORRECT_FOR_TEST_TOOL = createTag("incorrect_for_test_tool");


        //that shit create the tags
        private static TagKey<Item> createTag(String name){
            return ItemTags.create(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,name));
        }
    }

    public static class  Blocks{
        //create tag example just below
        public static final TagKey<Block> MINE = createTag("mine");
        public static final TagKey<Block> BEARTRAP = createTag("beartrap");
        public static final TagKey<Block> FAKE_FLOOR = createTag("fake_floor");
        public static final TagKey<Block> SPIKE = createTag("spike");
        public static final TagKey<Block> BARBED_WIRE = createTag("barbed_wire");

        //that shit create the tags
        private static TagKey<Block> createTag(String name){
            return BlockTags.create(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,name));
        }
    }

}