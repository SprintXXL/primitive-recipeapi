package com.SprintXXL.primitiverecipeapi.crafting.data;

import com.SprintXXL.primitiverecipeapi.crafting.shape.CraftingRecipeShape;
import com.SprintXXL.primitiverecipeapi.resources.ResourceDefinition;

public class BasicRecipeData implements CraftingRecipeData {

    private final CraftingRecipeShape shape;
    private final ResourceDefinition output;
    private final int count;

    public BasicRecipeData(
            CraftingRecipeShape shape,
            ResourceDefinition output,
            int count
    ) {
        this.shape = shape;
        this.output = output;
        this.count = count;
    }

    public CraftingRecipeShape getShape() {
        return shape;
    }

    public ResourceDefinition getOutput() {
        return output;
    }

    public int getCount() {
        return count;
    }
}
