package seremis.geninfusion.soul.gene.newAI

import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.soul.MasterGene

class GeneAILookAtVillager extends MasterGene(classOf[Boolean]) {
    addControlledGene(Genes.GENE_AI_LOOK_AT_VILLAGER_INDEX)
}
