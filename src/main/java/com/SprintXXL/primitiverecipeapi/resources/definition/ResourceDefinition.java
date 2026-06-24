package com.SprintXXL.primitiverecipeapi.resources.definition;

import net.minecraft.util.ResourceLocation;

public class ResourceDefinition {

    private final ResourceLocation id;
    private final ResourceType type;

    public ResourceDefinition(
            ResourceLocation id,
            ResourceType type
    ) {
        this.id = id;
        this.type = type;
    }

    public ResourceLocation getID() {
        return id;
    }

    public ResourceType getType() {
        return type;
    }
}