package com.SprintXXL.primitiverecipeapi.crafting.data;

import net.minecraft.item.crafting.IRecipe;

import java.util.function.Supplier;

public class ExternalRecipeData implements CraftingRecipeData {

    private final Class<?> recipeClass;
    private final Supplier<IRecipe> recipeSupplier;

    public ExternalRecipeData(
            Class<?> recipeClass,
            Supplier<IRecipe> recipeSupplier
    ) {
        this.recipeClass = recipeClass;
        this.recipeSupplier = recipeSupplier;
    }

    public ExternalRecipeData(
            Class<?> recipeClass
    ) {
        this.recipeClass = recipeClass;
        this.recipeSupplier = null;
    }

    public Class<?> getRecipeClass() {
        return recipeClass;
    }

    public IRecipe createRecipe() {

        if (recipeSupplier == null) {
            throw new IllegalStateException(
                    recipeClass.getSimpleName() +
                            " has no forge recipe supplier"
            );
        }

        return recipeSupplier.get();
    }
}
