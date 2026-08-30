package com.traps.trapsmod.event;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.effect.ModEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;

@EventBusSubscriber(modid = TrapsMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent

    public static void onLivingBleedHeal(LivingHealEvent event) {
        if (event.getEntity().hasEffect(ModEffects.BLEED_EFFECT)){
            event.setCanceled(true);
        }
    }

}
