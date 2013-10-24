package com.themacmini09.materialMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class TinOre extends Block {

	public TinOre(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("tinOre");
		setCreativeTab(MaterialMod.materialTab);
		setTextureName("materialMod:tinOre");
	}

}
