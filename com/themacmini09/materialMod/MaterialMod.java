package com.themacmini09.materialMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import com.themacmini09.materialMod.generic.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="TheMacMini09_MaterialMod", name="Material Mod", version="0.0.2")
@NetworkMod(clientSideRequired=true)
public class MaterialMod {
	
		EventManager eventmanager = new EventManager();

        // The instance of your mod that Forge uses.
        @Instance(value = "TheMacMini09_MaterialMod")
        public static MaterialMod instance;
        
        private static Item pointyStick;
        private static Item tinIngot;
        public static Block tinOre;
        
        public static CreativeTabs materialTab = new CreativeTabs("materialTab") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(MaterialMod.pointyStick, 1, 0);
            }
    };
       
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.themacmini09.materialMod.client.ClientProxy", serverSide="com.themacmini09.materialMod.generic.CommonProxy")
        public static CommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                pointyStick = new PointyStick(4000)
                				.setTextureName("materialMod:pointyStick");
                tinOre = new TinOre(4001, Material.rock);
                tinIngot = new TinIngot(4002);
                
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //recipes
                GameRegistry.addRecipe(new ItemStack(Block.sponge), "GDG", "DWD", "GDG",
                        'D', Block.dirt, 'W', Item.bucketWater, 'G', Block.tallGrass);
                
                GameRegistry.addRecipe(new ItemStack(Block.bedrock), "OOO", "OOO", "OOO",
                        'O', Block.obsidian);
                
                GameRegistry.addSmelting(MaterialMod.tinOre.blockID, new ItemStack(MaterialMod.tinIngot), 0.5F);
                
                //Ore pickaxe stuff
                
                MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", 1);
                
                //language registry
                LanguageRegistry.addName(pointyStick, "Pointy Stick");
                LanguageRegistry.instance().addStringLocalization("itemGroup.materialTab", "en_US", "All of Material Mod's stuff.");
                LanguageRegistry.addName(tinOre, "Tin Ore");
                LanguageRegistry.addName(tinIngot, "Tin Ingot");
                
                //Game registry
                GameRegistry.registerBlock(tinOre, "tinOre");
                GameRegistry.registerWorldGenerator(eventmanager);
                
        }
        
        
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}