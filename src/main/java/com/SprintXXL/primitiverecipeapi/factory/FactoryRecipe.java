package com.SprintXXL.primitiverecipeapi.factory;

import com.SprintXXL.primitiverecipeapi.factory.data.FactoryRecipeData;

public class FactoryRecipe {

    private final String recipeID;
    private final String factoryID;
    private final FactoryRecipeData data;

    public FactoryRecipe(
            String recipeID,
            String factoryID,
            FactoryRecipeData data
    ) {
        this.recipeID = recipeID;
        this.factoryID = factoryID;
        this.data = data;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public String getFactoryID() {
        return factoryID;
    }

    public FactoryRecipeData getData() {
        return data;
    }
}
