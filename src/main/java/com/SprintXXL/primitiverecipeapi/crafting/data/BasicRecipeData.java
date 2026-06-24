package com.SprintXXL.primitiverecipeapi.crafting.data;

import com.SprintXXL.primitiverecipeapi.crafting.shape.CraftingRecipeShape;
import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;

public class BasicRecipeData implements CraftingRecipeData {

    private final CraftingRecipeShape shape;
    private final RecipeResource output;

    public BasicRecipeData(
            CraftingRecipeShape shape,
            RecipeResource output
    ) {
        this.shape = shape;
        this.output = output;
    }

    public CraftingRecipeShape getShape() {
        return shape;
    }

    public RecipeResource getOutput() {
        return output;
    }
}
