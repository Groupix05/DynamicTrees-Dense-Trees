package com.wenxin2.dense_dynamictrees.registries;

import com.wenxin2.dense_dynamictrees.DynamicTreesDenseTrees;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final RegistryObject<Item> LARGE_APPLE;
    public static final FoodProperties LARGE_APPLE_FOOD = new FoodProperties.Builder()
            .fast().nutrition(6).saturationMod(0.8F).build();

    static {
        LARGE_APPLE = DynamicTreesDenseTrees.ITEMS.register("large_apple", () -> {
            return new Item(new Item.Properties().food(LARGE_APPLE_FOOD));
        });
    }

    public static void init() {}
}
