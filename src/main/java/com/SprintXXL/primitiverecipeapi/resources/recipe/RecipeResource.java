package com.SprintXXL.primitiverecipeapi.resources.recipe;

import com.SprintXXL.primitiverecipeapi.resources.definition.ResourceDefinition;

public class RecipeResource {

    private final RecipeResourceType type;
    private final ResourceDefinition resource;
    private final String tag;
    private final RemainingBehavior remainingBehavior;

    private int count = 1;
    private int meta;
    private boolean matchMeta;
    private int inputSlotOverride = -1;
    private int outputSlotOverride = -1;

    public RecipeResource(
            RecipeResourceType type,
            ResourceDefinition resource,
            String tag,
            RemainingBehavior remainingBehavior
    ) {
        this.type = type;
        this.resource = resource;
        this.tag = tag;
        this.remainingBehavior = remainingBehavior;
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

    public RecipeResource overrideInputSlot(int slot) {
        this.inputSlotOverride = slot;
        return this;
    }

    public boolean hasInputSlotOverride() {
        return inputSlotOverride >= 0;
    }

    public int getInputSlotOverride() {
        return inputSlotOverride;
    }

    public RecipeResource overrideOutputSlot(int slot) {
        this.outputSlotOverride = slot;
        return this;
    }

    public boolean hasOutputSlotOverride() {
        return outputSlotOverride >= 0;
    }

    public int getOutputSlotOverride() {
        return outputSlotOverride;
    }

    public RecipeResource count(int count) {

        if (count <= 0) {
            throw new IllegalArgumentException("RecipeResource count must be greater than 0.");
        }

        this.count = count;
        return this;
    }

    public RecipeResource meta(int meta) {
        this.meta = meta;
        this.matchMeta = true;
        return this;
    }

    // RESOURCE \\
    public static RecipeResource item(ResourceDefinition resource) {
        return new RecipeResource(RecipeResourceType.RESOURCE, resource, null, RemainingBehavior.CONSUME);
    }

    // TAG \\
    public static RecipeResource tag(String tag) {
        return new RecipeResource(RecipeResourceType.TAG, null, tag, RemainingBehavior.CONSUME);
    }

    // BEHAVIOR \\
    public RecipeResource withBehavior(RemainingBehavior behavior) {

        RecipeResource newResource = new RecipeResource(type, resource, tag, behavior);

        newResource.count = this.count;
        newResource.meta = this.meta;
        newResource.matchMeta = this.matchMeta;
        newResource.inputSlotOverride = this.inputSlotOverride;
        newResource.outputSlotOverride = this.outputSlotOverride;

        return newResource;
    }
}
