package com.SprintXXL.primitiverecipeapi.factory;

import java.util.*;

public final class FactoryRecipeRegistry {
    
    private FactoryRecipeRegistry() {}

    private static final Map<String, FactoryRecipe> FACTORY_RECIPES =
            new HashMap<>();

    private static final List<FactoryRecipe> ALL_FACTORY_RECIPES =
            new ArrayList<>();

    public static List<FactoryRecipe> getAllRecipes() {
        return Collections.unmodifiableList(ALL_FACTORY_RECIPES);
    }

    public static FactoryRecipe getRecipe(String id) {
        return FACTORY_RECIPES.get(id);
    }

    public static void register(FactoryRecipe recipe) {

        if (recipe == null) {
            throw new IllegalArgumentException("Recipe cannot be null");
        }

        if (FACTORY_RECIPES.containsKey(recipe.getRecipeID())) {
            throw new IllegalArgumentException("Duplicate recipe ID: " + recipe.getRecipeID());
        }

        FACTORY_RECIPES.put(recipe.getRecipeID(), recipe);
        ALL_FACTORY_RECIPES.add(recipe);
    }
}
