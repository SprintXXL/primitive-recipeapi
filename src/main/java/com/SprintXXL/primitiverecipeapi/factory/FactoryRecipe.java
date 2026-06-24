package com.SprintXXL.primitiverecipeapi.factory;

import com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData;
import com.SprintXXL.primitiverecipeapi.factory.data.FactoryRecipeData;

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

    public BasicFactoryData getBasicFactoryData() {

        if (!(data instanceof BasicFactoryData)) {
            return null;
        }

        return (BasicFactoryData) data;
    }

    public int getDurationTicks() {
        if (data instanceof BasicFactoryData) {
            return ((BasicFactoryData) data).getDuration() * 20;
        }

        return 0;
    }
}
