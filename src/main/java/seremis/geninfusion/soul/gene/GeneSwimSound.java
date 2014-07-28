package seremis.geninfusion.soul.gene;

import seremis.geninfusion.api.soul.IAllele;
import seremis.geninfusion.api.soul.IGene;
import seremis.geninfusion.soul.allele.AlleleString;

/**
 * @author Seremis
 */
public class GeneSwimSound implements IGene {

    @Override
    public Class<? extends IAllele> possibleAlleles() {
        return AlleleString.class;
    }
}
