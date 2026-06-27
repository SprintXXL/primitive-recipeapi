package com.SprintXXL.primitiverecipeapi.factory;

import com.SprintXXL.primitiverecipeapi.factory.data.FactoryRecipeData;
import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.List;

public class FactoryRecipe {

    private final String recipeID;
    private final String factoryID;
    private final MatchingMode matchingMode;
    private final FactoryRecipeData data;

    public FactoryRecipe(
            String recipeID,
            String factoryID,
            MatchingMode matchingMode,
            FactoryRecipeData data
    ) {
        this.recipeID = recipeID;
        this.factoryID = factoryID;
        this.matchingMode = matchingMode;
        this.data = data;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public String getFactoryID() {
        return factoryID;
    }

    public MatchingMode getMatchingMode() {
        return matchingMode;
    }

    public FactoryRecipeData getData() {
        return data;
    }

    // API METHODS \\
    public int getDurationTicks() {
        return data.getDurationTicks();
    }

    public List<RecipeResource> getInputs() {
        return data.getInputs();
    }

    public List<RecipeResource> getOutputs() {
        return data.getOutputs();
    }
}
