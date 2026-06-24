package com.SprintXXL.primitiverecipeapi.crafting.shape;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.Collections;
import java.util.Map;

public class ShapedRecipe implements CraftingRecipeShape {

    private final String[] pattern;
    private final Map<Character, RecipeResource> keys;

    public ShapedRecipe(
            String[] pattern,
            Map<Character, RecipeResource> keys
    ) {
        this.pattern = pattern.clone();
        this.keys = keys;
    }

    public String[] getPattern() {
        return pattern.clone();
    }

    public Map<Character, RecipeResource> getKeys() {
        return Collections.unmodifiableMap(keys);
    }
}
