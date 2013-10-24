package com.themacmini09.materialMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IconRegister;

public class PointyStick extends Item {
	
	public PointyStick(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(MaterialMod.materialTab);
		setUnlocalizedName("pointyStick");
		setTextureName("materialMod:pointyStick");
	}
}
