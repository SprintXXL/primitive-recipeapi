package com.SprintXXL.primitiverecipeapi.factory.data;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

import java.util.Arrays;
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

    @Override
    public int getDurationTicks() {
        return duration * 20;
    }

    @Override
    public List<RecipeResource> getInputs() {
        return Collections.unmodifiableList(inputs);
    }

    @Override
    public List<RecipeResource> getOutputs() {
        return Collections.unmodifiableList(outputs);
    }

    public static List<RecipeResource> inputs(RecipeResource... inputs) {
        return Arrays.asList(inputs);
    }

    public static List<RecipeResource> outputs(RecipeResource... outputs) {
        return Arrays.asList(outputs);
    }
}
