package seremis.geninfusion.soul.gene.newAI

import seremis.geninfusion.api.soul.EnumAlleleType
import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.soul.MasterGene

class GeneAIBreakDoor extends MasterGene(EnumAlleleType.BOOLEAN) {
    addControlledGene(Genes.GENE_AI_BREAK_DOOR_INDEX)
}
