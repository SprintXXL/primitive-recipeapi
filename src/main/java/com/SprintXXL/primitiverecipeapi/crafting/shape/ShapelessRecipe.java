package com.SprintXXL.primitiverecipeapi.crafting.shape;

import com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient;

import java.util.List;

public class ShapelessRecipe implements CraftingRecipeShape {

    private final List<RecipeIngredient> ingredients;

    public ShapelessRecipe(
            List<RecipeIngredient> ingredients
    ) {
        this.ingredients = ingredients;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }
}
