package com.SprintXXL.primitiverecipeapi.crafting;

import java.util.*;

public final class CraftingRecipeRegistry {

    private CraftingRecipeRegistry() {}

    private static final Map<String, CraftingRecipe> CRAFTING_RECIPES =
            new HashMap<>();

    private static final List<CraftingRecipe> ALL_CRAFTING_RECIPES =
            new ArrayList<>();

    public static List<CraftingRecipe> getAllRecipes() {
        return Collections.unmodifiableList(ALL_CRAFTING_RECIPES);
    }

    public static CraftingRecipe getRecipe(String id) {
        return CRAFTING_RECIPES.get(id);
    }

    public static void register(CraftingRecipe recipe) {

        if (CRAFTING_RECIPES.containsKey(recipe.getID())) {
            throw new IllegalArgumentException("Duplicate recipe ID: " + recipe.getID());
        }

        CRAFTING_RECIPES.put(recipe.getID(), recipe);
        ALL_CRAFTING_RECIPES.add(recipe);
    }
}
