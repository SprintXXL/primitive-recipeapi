package com.SprintXXL.primitiverecipeapi.crafting;

import com.SprintXXL.primitiverecipeapi.crafting.data.CraftingRecipeData;
import com.SprintXXL.primitiverecipeapi.shared.Category;
import com.SprintXXL.primitiverecipeapi.shared.Owner;
import com.SprintXXL.primitiverecipeapi.shared.RecipeRuntime;

public class CraftingRecipe {

    private final String id;
    private final Owner owner;
    private final RecipeRuntime runtime;
    private final Category category;
    private final CraftingRecipeData data;

    public CraftingRecipe(
            String id,
            Owner owner,
            RecipeRuntime runtime,
            Category category,
            CraftingRecipeData data
    ) {
        this.id = id;
        this.owner = owner;
        this.runtime = runtime;
        this.category = category;
        this.data = data;
    }

    public String getID() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public RecipeRuntime getRuntime() {
        return runtime;
    }

    public Category getCategory() {
        return category;
    }

    public CraftingRecipeData getData() {
        return data;
    }
}
