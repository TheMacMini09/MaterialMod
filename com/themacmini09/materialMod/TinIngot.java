package com.themacmini09.materialMod;
import com.themacmini09.materialMod.MaterialMod;

import net.minecraft.item.Item;


public class TinIngot extends Item {

	public TinIngot(int id) {
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(MaterialMod.materialTab);
		setUnlocalizedName("tinIngot");
		setTextureName("materialMod:tinIngot");
		
	}

}
