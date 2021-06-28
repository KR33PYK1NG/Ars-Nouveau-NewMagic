package rmc.mixins.ars_nouveau_newmagic.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.hollingsworth.arsnouveau.common.entity.EntitySpellArrow;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = EntitySpellArrow.class)
public abstract class EntitySpellArrowMixin {

    private int rmc$aliveFor;

    @Inject(method = "Lcom/hollingsworth/arsnouveau/common/entity/EntitySpellArrow;tick()V",
            cancellable = true,
            at = @At(value = "HEAD"))
    private void limitAliveTime(CallbackInfo mixin) {
        if (this.rmc$aliveFor++ > 60) {
            ((EntitySpellArrow)(Object) this).remove();
            mixin.cancel();
        }
    }

}