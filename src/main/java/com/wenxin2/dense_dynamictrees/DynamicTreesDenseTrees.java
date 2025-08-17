package com.wenxin2.dense_dynamictrees;

import com.ferreusveritas.dynamictrees.DynamicTrees;
import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import com.ferreusveritas.dynamictrees.block.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.block.rooty.SoilProperties;
import com.ferreusveritas.dynamictrees.init.DTRegistries;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
//import com.ferreusveritas.dynamictreesplus.block.mushroom.CapProperties;
import com.wenxin2.dense_dynamictrees.registries.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(DynamicTreesDenseTrees.MOD_ID)
public final class DynamicTreesDenseTrees {
    public static final String MOD_ID = "dense_dynamictrees";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);


    public DynamicTreesDenseTrees() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::gatherData);
        eventBus.addListener(this::registerCreativeTab);

        //MinecraftForge.EVENT_BUS.register(this); //if your addons requires to interact with the game while running

        RegistryHandler.setup(MOD_ID);
        ITEMS.register(eventBus);
        ItemRegistry.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //DTTemplateRegistries.setup();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        //DTTemplateClient.setup();
    }

    private void gatherData(final GatherDataEvent event) {
        /**
        * Generate the required data with runData, make sure the mod your are making an addon is in the build.gradle: add "--existing-mod", "your-mod" in create(data)
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
            event.accept(ItemRegistry.LARGE_APPLE);
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
            event.accept(ItemRegistry.LARGE_APPLE);
    }

    public static ResourceLocation location(final String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
