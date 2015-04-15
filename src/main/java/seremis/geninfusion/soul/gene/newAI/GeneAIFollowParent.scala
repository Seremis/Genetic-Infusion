package seremis.geninfusion.soul.gene.newAI

import seremis.geninfusion.api.soul.EnumAlleleType
import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.soul.MasterGene

class GeneAIFollowParent extends MasterGene(EnumAlleleType.BOOLEAN) {
    addControlledGene(Genes.GENE_AI_FOLLOW_PARENT_INDEX)
    addControlledGene(Genes.GENE_AI_FOLLOW_PARENT_MOVE_SPEED)
}
