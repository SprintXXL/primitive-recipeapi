package com.SprintXXL.primitiverecipeapi.api;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;
import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResourceType;
import com.SprintXXL.primitiverecipeapi.resources.definition.ResourceDefinition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public final class RecipeResourceResolver {

    private RecipeResourceResolver() {}

    public static Item getItem(ResourceDefinition resource) {

        if (resource == null) {
            return null;
        }

        return ForgeRegistries.ITEMS.getValue(resource.getID());
    }

    public static ItemStack createStack(RecipeResource recipeResource, int count) {

        if (recipeResource == null) {
            return ItemStack.EMPTY;
        }

        if (recipeResource.getType() != RecipeResourceType.RESOURCE) {
            return ItemStack.EMPTY;
        }

        ResourceDefinition resource = recipeResource.getResource();

        if (resource == null) {
            return ItemStack.EMPTY;
        }

        Item item = getItem(resource);

        if (item == null) {
            return ItemStack.EMPTY;
        }

        int meta = recipeResource.shouldMatchMeta() ? recipeResource.getMeta() : 0;

        return new ItemStack(item, count, meta);
    }

    public static ItemStack createStack(RecipeResource recipeResource) {

        if (recipeResource == null) {
            return ItemStack.EMPTY;
        }

        return createStack(recipeResource, recipeResource.getCount());
    }
}
