package com.wenxin2.dense_dynamictrees.event_handlers;

import com.ferreusveritas.dynamictrees.DynamicTrees;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import com.ferreusveritas.dynamictrees.init.DTTrees;
import com.wenxin2.dense_dynamictrees.DynamicTreesDenseTrees;
import com.wenxin2.dense_dynamictrees.registries.ItemRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DynamicTreesDenseTrees.MOD_ID)
public class RegistryEventHandlers {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

        if (event.getType() == VillagerProfession.FARMER) {
            trades.get(3).add((entity, random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ItemRegistry.LARGE_APPLE.get(), 4),
                    12, 5, 0.05F));
        }
    }

    @SubscribeEvent
    public static void addWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_acacia"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_apple_oak"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_azalea"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_birch"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_cherry"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_cocoa"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_crimson"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_dark_oak"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_jungle"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_mangrove"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_oak"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_spruce"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
        rareTrades.add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(TreeRegistry.findSpecies(DynamicTreesDenseTrees.location("dense_warped"))
                        .getSeedStack(1).getItemHolder().get(), 1),
                8, 10, 0.2F));
    }
}
