package com.SprintXXL.primitiverecipeapi.ingredients;

import com.SprintXXL.primitiverecipeapi.resources.ResourceDefinition;
import com.SprintXXL.primitiverecipeapi.resources.ResourceResolver;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeIngredient {

    private final IngredientType type;
    private final ResourceDefinition resource;
    private final String tag;
    private final RemainingBehavior remainingBehavior;
    private final int meta;
    private final boolean matchMeta;

    public RecipeIngredient(
            IngredientType type,
            ResourceDefinition resource,
            String tag,
            RemainingBehavior remainingBehavior,
            int meta,
            boolean matchMeta
    ) {
        this.type = type;
        this.resource = resource;
        this.tag = tag;
        this.remainingBehavior = remainingBehavior;
        this.meta = meta;
        this.matchMeta = matchMeta;
    }

    public IngredientType getType() {
        return type;
    }

    public ResourceDefinition getResource() {
        return resource;
    }

    public String getTag() {
        return tag;
    }

    public RemainingBehavior getRemainingBehavior() {
        return remainingBehavior;
    }

    public int getMeta() {
        return meta;
    }

    public boolean shouldMatchMeta() {
        return matchMeta;
    }

    public static RecipeIngredient of(ResourceDefinition resource) {
        return new RecipeIngredient(IngredientType.RESOURCE, resource, null, RemainingBehavior.CONSUME, 0, false);
    }

    public static RecipeIngredient of(ResourceDefinition resource, int meta) {
        return new RecipeIngredient(IngredientType.RESOURCE, resource, null, RemainingBehavior.CONSUME, meta, true);
    }

    public static RecipeIngredient withBehavior(ResourceDefinition resource, RemainingBehavior behavior) {
        return new RecipeIngredient(IngredientType.RESOURCE, resource, null, behavior, 0, false);
    }

    public static RecipeIngredient tag(String tag) {
        return new RecipeIngredient(IngredientType.TAG, null, tag, RemainingBehavior.CONSUME, 0, false);
    }

    public static RecipeIngredient tagWithBehavior(String tag, RemainingBehavior behavior) {
        return new RecipeIngredient(IngredientType.TAG, null, tag, behavior, 0, false);
    }

    public boolean matches(ItemStack stack) {

        if (stack.isEmpty()) {
            return false;
        }

        switch (type) {

            case RESOURCE:

                if (resource == null || stack.getItem().getRegistryName() == null) {
                    return false;
                }

                if (!stack.getItem().getRegistryName().equals(resource.getID())) {
                    return false;
                }

                if (matchMeta && stack.getMetadata() != meta) {
                    return false;
                }

                return true;

            case TAG:

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

    public ItemStack createStack(int count) {

        if (type != IngredientType.RESOURCE || resource == null) {
            return ItemStack.EMPTY;
        }

        int stackMeta = matchMeta ? meta : 0;

        return new ItemStack(ResourceResolver.getItem(resource), count, stackMeta);
    }

    public ItemStack createStack() {

        if (type != IngredientType.RESOURCE || resource == null) {
            return ItemStack.EMPTY;
        }

        int stackMeta = matchMeta ? meta : 0;

        return new ItemStack(ResourceResolver.getItem(resource), 1,  stackMeta);
    }
}
