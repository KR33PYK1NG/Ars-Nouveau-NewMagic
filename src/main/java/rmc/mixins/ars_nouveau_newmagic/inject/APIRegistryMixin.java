package rmc.mixins.ars_nouveau_newmagic.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.hollingsworth.arsnouveau.api.spell.AbstractSpellPart;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectConjureWater;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectIntangible;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectSummonVex;
import com.hollingsworth.arsnouveau.setup.APIRegistry;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = APIRegistry.class)
public abstract class APIRegistryMixin {

    @Inject(method = "Lcom/hollingsworth/arsnouveau/setup/APIRegistry;registerSpell(Lcom/hollingsworth/arsnouveau/api/spell/AbstractSpellPart;)V",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private static void disableSpells(AbstractSpellPart spellPart, CallbackInfo mixin) {
        if (spellPart instanceof EffectSummonVex
         || spellPart instanceof EffectIntangible
         || spellPart instanceof EffectConjureWater) {
            mixin.cancel();
        }
    }

}