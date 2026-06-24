package com.SprintXXL.primitiverecipeapi.resources.recipe;

import com.SprintXXL.primitiverecipeapi.resources.definition.ResourceDefinition;

public class RecipeResource {

    private final RecipeResourceType type;
    private final ResourceDefinition resource;
    private final String tag;
    private final RemainingBehavior remainingBehavior;
    private final int count;
    private final int meta;
    private final boolean matchMeta;

    public RecipeResource(
            RecipeResourceType type,
            ResourceDefinition resource,
            String tag,
            RemainingBehavior remainingBehavior,
            int count,
            int meta,
            boolean matchMeta
    ) {
        this.type = type;
        this.resource = resource;
        this.tag = tag;
        this.remainingBehavior = remainingBehavior;
        this.count = count;
        this.meta = meta;
        this.matchMeta = matchMeta;
    }

    public RecipeResourceType getType() {
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

    public int getCount() {
        return count;
    }

    public int getMeta() {
        return meta;
    }

    public boolean shouldMatchMeta() {
        return matchMeta;
    }

    // RESOURCE \\
    public static RecipeResource item(ResourceDefinition resource) {
        return new RecipeResource(RecipeResourceType.RESOURCE, resource, null, RemainingBehavior.CONSUME, 1, 0, false);
    }

    public static RecipeResource itemCount(ResourceDefinition resource, int count) {
        return new RecipeResource(RecipeResourceType.RESOURCE, resource, null, RemainingBehavior.CONSUME, count, 0, false);
    }

    public static RecipeResource itemMeta(ResourceDefinition resource, int meta) {
        return new RecipeResource(RecipeResourceType.RESOURCE, resource, null, RemainingBehavior.CONSUME, 1, meta, true);
    }

    public static RecipeResource itemCountMeta(ResourceDefinition resource, int count, int meta) {
        return new RecipeResource(RecipeResourceType.RESOURCE, resource, null, RemainingBehavior.CONSUME, count, meta, true);
    }

    // TAG \\
    public static RecipeResource tag(String tag) {
        return new RecipeResource(RecipeResourceType.TAG, null, tag, RemainingBehavior.CONSUME, 1, 0, false);
    }

    public static RecipeResource tagCount(String tag, int count) {
        return new RecipeResource(RecipeResourceType.TAG, null, tag, RemainingBehavior.CONSUME, count, 0, false);
    }

    // BEHAVIOR \\
    public RecipeResource withBehavior(RemainingBehavior behavior) {
        return new RecipeResource(type, resource, tag, behavior, count, meta, matchMeta);
    }

}
