package seremis.geninfusion.soul

import net.minecraft.entity.EntityLiving
import seremis.geninfusion.api.soul._

import scala.collection.mutable.ListBuffer

object StandardSoulRegistry extends IStandardSoulRegistry {

    var standardSouls: ListBuffer[IStandardSoul] = ListBuffer()

    override def register(standard: IStandardSoul) {
        standardSouls += standard
    }

    override def getSoulForEntity(entity: EntityLiving): ISoul = {
        val chromosomes = new Array[IChromosome](SoulHelper.geneRegistry.getGenes.size)
        for(i <- 0 until chromosomes.length) {
            val gene = SoulHelper.geneRegistry.getGene(i)
            val name = SoulHelper.geneRegistry.getGeneName(gene)

            chromosomes(i) = getStandardSoulForEntity(entity).getChromosomeFromGene(entity, name)
            if(chromosomes(i) == null) {
                throw new NullPointerException("There seems to be a Gene: (" + name + ") without an associated Chromosome for Entity: (" + entity + ").")
            } else if(chromosomes(i).getPrimary.getAlleleData != null && !EnumAlleleType.forClass(chromosomes(i).getPrimary.getAlleleData.getClass).equals(SoulHelper.geneRegistry.getGene(i).getAlleleType)) {
                throw new ClassCastException("Someone associated a Gene: (" + name + ") with an Allele (" + chromosomes(i).getPrimary.getAlleleData.getClass.getName + ") that isn't allowed for this gene. It should be: " + gene.getAlleleType.clzz.getName)
            }
        }
        new Soul(chromosomes)
    }

    override def getStandardSoulForEntity(entity: EntityLiving): IStandardSoul = {
        standardSouls.foreach(soul => if(soul.isStandardSoulForEntity(entity)) return soul)
        null
    }
}
