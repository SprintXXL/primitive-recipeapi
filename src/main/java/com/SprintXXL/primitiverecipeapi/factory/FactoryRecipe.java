package com.SprintXXL.primitiverecipeapi.factory;

import com.SprintXXL.primitiverecipeapi.factory.data.BasicFactoryData;
import com.SprintXXL.primitiverecipeapi.factory.data.FactoryRecipeData;
import net.minecraft.item.ItemStack;

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

    public BasicFactoryData getBasicFactoryData() {
        return (BasicFactoryData) data;
    }

    public boolean matches(ItemStack inputStack) {

        if (!(data instanceof BasicFactoryData)) {
            return false;
        }

        return ((BasicFactoryData) data).matches(inputStack);
    }

    public int getDurationTicks() {
        if (data instanceof BasicFactoryData) {
            return ((BasicFactoryData) data).getDuration() * 20;
        }

        return 0;
    }
}
