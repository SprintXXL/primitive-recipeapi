package com.SprintXXL.primitiverecipeapi.api;

import com.SprintXXL.primitiverecipeapi.resources.recipe.RecipeResource;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class RecipeResourceMatcher {

    private RecipeResourceMatcher() {}

    public static boolean matches(RecipeResource recipeResource, ItemStack stack) {

        if (recipeResource == null) {
            return stack.isEmpty();
        }

        if (stack.isEmpty()) {
            return false;
        }

        switch (recipeResource.getType()) {

            case RESOURCE:

                if (recipeResource.getResource() == null || stack.getItem().getRegistryName() == null) {
                    return false;
                }

                if (!stack.getItem().getRegistryName().equals(recipeResource.getResource().getID())) {
                    return false;
                }

                if (recipeResource.shouldMatchMeta() && stack.getMetadata() != recipeResource.getMeta()) {
                    return false;
                }

                return true;

            case TAG:

                String tag = recipeResource.getTag();

                if (tag == null || tag.isEmpty()) {
                    return false;
                }

                int[] oreIDs = OreDictionary.getOreIDs(stack);

                for (int oreID : oreIDs) {
                    String oreName = OreDictionary.getOreName(oreID);

                    if (tag.equals(oreName)) {
                        return true;
                    }
                }

                return false;

            default:
                return false;
        }
    }
}
