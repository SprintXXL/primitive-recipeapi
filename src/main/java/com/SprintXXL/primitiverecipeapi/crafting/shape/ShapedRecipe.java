package com.SprintXXL.primitiverecipeapi.crafting.shape;

import com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient;

import java.util.Map;

public class ShapedRecipe implements CraftingRecipeShape {

    private final String[] pattern;
    private final Map<Character, RecipeIngredient> keys;

    public ShapedRecipe(
            String[] pattern,
            Map<Character, RecipeIngredient> keys
    ) {
        this.pattern = pattern;
        this.keys = keys;
    }

    public String[] getPattern() {
        return pattern;
    }

    public Map<Character, RecipeIngredient> getKeys() {
        return keys;
    }
}
