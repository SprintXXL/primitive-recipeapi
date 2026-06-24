package com.SprintXXL.primitiverecipeapi.factory.data;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.Collections;
import java.util.List;

public class BasicFactoryData implements FactoryRecipeData {

    private final int duration;
    private final List<RecipeResource> inputs;
    private final List<RecipeResource> outputs;

    public BasicFactoryData(
            int duration,
            List<RecipeResource> inputs,
            List<RecipeResource> outputs
    ) {
        this.duration = duration;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public int getDuration() {
        return duration;
    }

    public List<RecipeResource> getInputs() {
        return Collections.unmodifiableList(inputs);
    }

    public List<RecipeResource> getOutputs() {
        return Collections.unmodifiableList(outputs);
    }
}
