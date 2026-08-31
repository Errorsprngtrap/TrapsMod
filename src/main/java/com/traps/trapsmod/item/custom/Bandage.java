package com.traps.trapsmod.item.custom;

import com.traps.trapsmod.effect.ModEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class Bandage extends Item {
    public Bandage(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!player.hasEffect(ModEffects.BLEED_EFFECT)) {
            return InteractionResult.FAIL;
        }

        if (!level.isClientSide()) {
            player.removeEffect(ModEffects.BLEED_EFFECT);
            player.getItemInHand(hand).consume(1, player);
        }

        return InteractionResult.SUCCESS;
    }

}
