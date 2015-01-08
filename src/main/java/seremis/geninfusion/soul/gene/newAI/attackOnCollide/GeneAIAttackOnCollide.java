package seremis.geninfusion.soul.gene.newAI.attackOnCollide;

import seremis.geninfusion.api.soul.IAllele;
import seremis.geninfusion.api.soul.IGene;
import seremis.geninfusion.api.soul.SoulHelper;
import seremis.geninfusion.api.soul.lib.Genes;
import seremis.geninfusion.soul.MasterGene;
import seremis.geninfusion.soul.allele.AlleleBoolean;

public class GeneAIAttackOnCollide extends MasterGene {

    public GeneAIAttackOnCollide() {
        addControlledGene(SoulHelper.geneRegistry.getGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_TARGET));
        addControlledGene(SoulHelper.geneRegistry.getGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_MOVE_SPEED));
        addControlledGene(SoulHelper.geneRegistry.getGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_LONG_MEMORY));
    }

    @Override
    public Class<? extends IAllele> possibleAlleles() {
        return AlleleBoolean.class;
    }
}