package seremis.geninfusion.soul.gene.newAI

import seremis.geninfusion.api.soul.EnumAlleleType
import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.soul.MasterGene

class GeneAIControlledByPlayer extends MasterGene(EnumAlleleType.BOOLEAN) {
    addControlledGene(Genes.GENE_AI_CONTROLLED_BY_PLAYER_INDEX)
    addControlledGene(Genes.GENE_AI_CONTROLLED_BY_PLAYER_MAX_SPEED)
}
