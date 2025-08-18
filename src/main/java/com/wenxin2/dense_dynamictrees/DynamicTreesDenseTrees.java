package com.wenxin2.dense_dynamictrees;

import com.dtteam.dynamictrees.block.fruit.Fruit;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.pod.Pod;
import com.dtteam.dynamictrees.block.soil.SoilProperties;
import com.dtteam.dynamictrees.data.GatherDataHelper;
import com.dtteam.dynamictrees.registry.DTRegistries;
import com.dtteam.dynamictrees.registry.NeoForgeRegistryHandler;
import com.dtteam.dynamictrees.tree.family.Family;
import com.dtteam.dynamictrees.tree.species.Species;
//import com.dtteam.dynamictreesplus.block.mushroom.CapProperties;
import com.wenxin2.dense_dynamictrees.registries.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(DynamicTreesDenseTrees.MOD_ID)
public final class DynamicTreesDenseTrees {
    public static final String MOD_ID = "dense_dynamictrees";
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);


    public DynamicTreesDenseTrees(IEventBus eventBus, ModContainer container) {
        eventBus.addListener(this::gatherData);
        eventBus.addListener(this::registerCreativeTab);

        //MinecraftForge.EVENT_BUS.register(this); //if your addons requires to interact with the game while running

        NeoForgeRegistryHandler.setup(MOD_ID, eventBus);
        ITEMS.register(eventBus);
        ItemRegistry.init();
    }

    private void gatherData(final GatherDataEvent event) {
        /**
        * Generate the required data with runData, make sure the mod you are making as an addon is in the build.gradle: add "--existing-mod", "your-mod" in create(data)
        */

        //Resources.MANAGER.gatherData();
        GatherDataHelper.gatherAllData(MOD_ID, event,
                SoilProperties.REGISTRY,
                Family.REGISTRY,
                Species.REGISTRY,
                LeavesProperties.REGISTRY,
                Fruit.REGISTRY,
                Pod.REGISTRY
                //,CapProperties.REGISTRY //Requires DTPlus
        );
    }

    private void registerCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == DTRegistries.DT_CREATIVE_TAB.get())
            addAfter(event, Species.findSpecies(DynamicTreesDenseTrees.location("dense_apple_oak"))
                    .getSeedStack(1).getItem(), ItemRegistry.LARGE_APPLE);
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
            addAfter(event, Items.APPLE, ItemRegistry.LARGE_APPLE);
    }

    public static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike afterItem, ItemLike item) {
        event.insertAfter(new ItemStack(afterItem), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    public static ResourceLocation location(final String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
