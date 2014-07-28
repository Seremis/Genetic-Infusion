package seremis.geninfusion.soul.gene;

import seremis.geninfusion.api.soul.IAllele;
import seremis.geninfusion.api.soul.IGene;
import seremis.geninfusion.soul.allele.AlleleFloat;

public class GeneMovementSpeed implements IGene {

	@Override
	public Class<? extends IAllele> possibleAlleles() {
		return AlleleFloat.class;
	}
}
