package com.SprintXXL.primitiverecipeapi.factory.data;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.List;

public interface FactoryRecipeData {

    int getDurationTicks();

    List<RecipeResource> getInputs();

    List<RecipeResource> getOutputs();
}
