package com.SprintXXL.primitiverecipeapi.crafting.shape;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.Collections;
import java.util.List;

public class ShapelessRecipe implements CraftingRecipeShape {

    private final List<RecipeResource> ingredients;

    public ShapelessRecipe(
            List<RecipeResource> ingredients
    ) {
        this.ingredients = ingredients;
    }

    public List<RecipeResource> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }
}
