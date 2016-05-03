/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.apiculture.flowers;

import java.util.EnumSet;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.common.EnumPlantType;

import forestry.api.apiculture.FlowerManager;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.IPollinatable;
import forestry.core.utils.Translator;

public class FlowerProvider implements IFlowerProvider {

	private final String flowerType;
	private final String unlocalizedDescription;

	public FlowerProvider(String flowerType, String unlocalizedDescription) {
		this.flowerType = flowerType;
		this.unlocalizedDescription = unlocalizedDescription;
	}

	@Override
	public String getFlowerType() {
		return flowerType;
	}

	@Override
	public boolean isAcceptedPollinatable(World world, IPollinatable pollinatable) {

		EnumSet<EnumPlantType> plantTypes = pollinatable.getPlantType();

		switch (flowerType) {
			case FlowerManager.FlowerTypeNether:
				return plantTypes.contains(EnumPlantType.Nether);
			case FlowerManager.FlowerTypeCacti:
				return plantTypes.contains(EnumPlantType.Desert);
			default:
				return plantTypes.size() > 1 || !plantTypes.contains(EnumPlantType.Nether);
		}
	}

	@Override
	public String getDescription() {
		return Translator.translateToLocal(this.unlocalizedDescription);
	}

	@Override
	public ItemStack[] affectProducts(World world, IIndividual individual, BlockPos pos, ItemStack[] products) {
		return products;
	}

}
