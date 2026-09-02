package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.ModBlocks;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider,recipeOutput);
        }

        @Override
        public String getName() {
            return "Template Mod Recipes";
        }
    }
    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.BANDAGE,3)
                .pattern("  P")
                .pattern(" P ")
                .pattern("P  ")
                .define('P', Items.PAPER)
                .unlockedBy("has_bandage", has(Items.PAPER))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.MINE)
                .pattern(" N ")
                .pattern("NTN")
                .pattern(" N ")
                .define('T', Items.TNT)
                .define('N', Items.IRON_NUGGET)
                .unlockedBy("has_tnt", has(Items.TNT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.IMPROVED_MINE)
                .pattern(" N ")
                .pattern("NTN")
                .pattern(" N ")
                .define('T', Items.TNT)
                .define('N', Items.IRON_INGOT)
                .unlockedBy("has_tnt", has(Items.TNT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.STEALTH_MINE)
                .pattern("PNP")
                .pattern("NTN")
                .pattern("PNP")
                .define('T', Items.TNT)
                .define('N', Items.IRON_NUGGET)
                .define('P', Items.PHANTOM_MEMBRANE)
                .unlockedBy("has_tnt", has(Items.TNT))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.BARBED_WIRE,12)
                .pattern("TTT")
                .pattern("TTT")
                .define('T', Items.IRON_BARS)
                .unlockedBy("has_iron_bar", has(Items.IRON_BARS))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.BEARTRAP,3)
                .pattern("NNN")
                .pattern("TTT")
                .define('T', Items.IRON_INGOT)
                .define('N', Items.IRON_NUGGET)
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.SPIKE_TRAP,3)
                .pattern("NNN")
                .pattern("TTT")
                .define('N', Items.IRON_INGOT)
                .define('T', ItemTags.PLANKS)
                .unlockedBy("has_iron", has(Items.IRON_NUGGET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.REDSTONE_SPIKE_TRAP,3)
                .pattern("NNN")
                .pattern("TPT")
                .define('N', Items.IRON_INGOT)
                .define('T', ItemTags.PLANKS)
                .define('P', Items.PISTON)
                .unlockedBy("has_iron", has(Items.IRON_NUGGET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.POISON_SPIKE_TRAP,3)
                .pattern(" N ")
                .pattern("TTT")
                .define('N', Items.FERMENTED_SPIDER_EYE)
                .define('T', ModBlocks.SPIKE_TRAP)
                .unlockedBy("has_spike_trap", has(ModBlocks.SPIKE_TRAP))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModBlocks.REDSTONE_POISON_SPIKE_TRAP,3)
                .pattern(" N ")
                .pattern("TTT")
                .define('N', Items.FERMENTED_SPIDER_EYE)
                .define('T', ModBlocks.REDSTONE_SPIKE_TRAP)
                .unlockedBy("has_spike_trap", has(ModBlocks.SPIKE_TRAP))
                .save(output);

        shapeless(RecipeCategory.COMBAT,ModBlocks.DIRT_FAKE_FLOOR,12)
                .requires(Items.DIRT).requires(Items.SHEARS)
                .unlockedBy("has_floor", has(Items.DIRT))
                .save(output);

        shapeless(RecipeCategory.COMBAT,ModBlocks.GRASS_FAKE_FLOOR,12)
                .requires(Items.GRASS_BLOCK).requires(Items.SHEARS)
                .unlockedBy("has_floor", has(Items.GRASS_BLOCK))
                .save(output);
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike item : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                    .group(group)
                    .unlockedBy(getHasName(item), this.has(item))
                    .save(this.output, TrapsMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(item));
        }
    }
}
