package com.SprintXXL.primitiverecipeapi.resources.definition;

import net.minecraft.util.ResourceLocation;

import java.util.*;

public final class ResourceRegistry {

    private ResourceRegistry() {}

    private static final Map<ResourceLocation, ResourceDefinition> RESOURCES =
            new HashMap<>();

    private static final List<ResourceDefinition> ALL_RESOURCES =
            new ArrayList<>();

    public static List<ResourceDefinition> getAllResources() {
        return Collections.unmodifiableList(ALL_RESOURCES);
    }

    public static ResourceDefinition getResource(ResourceLocation id) {
        return RESOURCES.get(id);
    }

    public static void register(ResourceDefinition resource) {

        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }

        if (RESOURCES.containsKey(resource.getID())) {
            throw new IllegalArgumentException("Duplicate Resource ID: " + resource.getID());
        }

        RESOURCES.put(resource.getID(), resource);
        ALL_RESOURCES.add(resource);
    }
}
