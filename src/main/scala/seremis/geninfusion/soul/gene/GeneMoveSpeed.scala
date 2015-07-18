package seremis.geninfusion.soul.gene

import seremis.geninfusion.api.soul.IChromosome
import seremis.geninfusion.soul.Gene

class GeneMoveSpeed(clzz: Class[_]) extends Gene(clzz) {

    override def mutate(chromosome: IChromosome): IChromosome = {
        if(mutate) {
            var allele1Data = chromosome.getPrimary.getAlleleData
            var allele2Data = chromosome.getSecondary.getAlleleData

            getAlleleType.getAlleleTypeClass match {
                case a if a == classOf[Double] =>
                    if(rand.nextBoolean())
                        allele1Data = allele1Data.asInstanceOf[Double] * ((rand.nextFloat() * 2 * 0.1) + 0.9)
                    else
                        allele2Data = allele2Data.asInstanceOf[Double] * ((rand.nextFloat() * 2 * 0.1) + 0.9)
                case a if a == classOf[Array[Double]] =>
                    if(rand.nextBoolean()) {
                        val index = rand.nextInt(allele1Data.asInstanceOf[Array[Double]].length)
                        allele1Data.asInstanceOf[Array[Double]](index) = allele1Data.asInstanceOf[Array[Double]](index) * ((rand.nextFloat() * 2 * 0.1) + 0.9)
                    } else {
                        val index = rand.nextInt(allele2Data.asInstanceOf[Array[Double]].length)
                        allele2Data.asInstanceOf[Array[Double]](index) = allele2Data.asInstanceOf[Array[Double]](index) * ((rand.nextFloat() * 2 * 0.1) + 0.9)
                    }
            }
        }
        chromosome
    }
}