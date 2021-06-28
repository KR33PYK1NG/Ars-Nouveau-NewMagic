package rmc.mixins.ars_nouveau_newmagic.inject;

import org.spongepowered.asm.mixin.Mixin;

import com.hollingsworth.arsnouveau.common.items.SpellBook;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = SpellBook.class)
public abstract class SpellBookMixin {

    @SuppressWarnings(value = "unused")
    private static final int rmc$MAX_SLOTS = 5;

}