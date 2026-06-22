package com.SprintXXL.primitiverecipeapi.factory.data;

import com.SprintXXL.primitiverecipeapi.ingredients.RecipeIngredient;

public class BasicFactoryData implements FactoryRecipeData {

    private final int duration;
    private final RecipeIngredient input;
    private final RecipeIngredient output;

    public BasicFactoryData(
            int duration,
            RecipeIngredient input,
            RecipeIngredient output
    ) {
        this.duration = duration;
        this.input = input;
        this.output = output;
    }

    public int getDuration() {
        return duration;
    }

    public RecipeIngredient getInput() {
        return input;
    }

    public RecipeIngredient getOutput() {
        return output;
    }
}
