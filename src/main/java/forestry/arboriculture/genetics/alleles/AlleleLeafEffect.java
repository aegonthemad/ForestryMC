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
package forestry.arboriculture.genetics.alleles;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import forestry.api.arboriculture.EnumTreeChromosome;
import forestry.api.arboriculture.IAlleleLeafEffect;
import forestry.api.arboriculture.ITreeGenome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IEffectData;
import forestry.core.config.Constants;
import forestry.core.genetics.alleles.Allele;
import forestry.core.genetics.alleles.AlleleCategorized;
import forestry.core.utils.vect.Vect;

public class AlleleLeafEffect extends AlleleCategorized implements IAlleleLeafEffect {
	private static final int[] DEFAULT_EFFECT_AREA = new int[]{12, 12, 12};

	public static Allele leavesNone;

	public static void createAlleles() {
		leavesNone = new AlleleLeafEffectNone();
		AlleleManager.alleleRegistry.registerAllele(leavesNone, EnumTreeChromosome.EFFECT);
	}

	protected AlleleLeafEffect(String valueName, boolean isDominant) {
		super(Constants.MOD_ID, "leaves", valueName, isDominant);
	}

	@Override
	public boolean isCombinable() {
		return true;
	}

	@Override
	public IEffectData validateStorage(IEffectData storedData) {
		return storedData;
	}

	@Override
	public IEffectData doEffect(ITreeGenome genome, IEffectData storedData, World world, BlockPos pos) {
		return storedData;
	}

	protected static AxisAlignedBB getBounding(int x, int y, int z, float modifier) {
		int[] areaAr = DEFAULT_EFFECT_AREA;
		Vect area = new Vect(areaAr).multiply(modifier);
		Vect offset = area.multiply(-1 / 2.0f);

		Vect min = offset.add(x, y, z);
		Vect max = min.add(area);

		return new AxisAlignedBB(min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), max.getZ());
	}
}
