package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> BLEED_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE,
            Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID, "bleed_damage"));

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(BLEED_DAMAGE,new DamageType("bleed damage",2.0f, DamageEffects.HURT));
    }

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(key));
    }
}
