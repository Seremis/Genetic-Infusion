package com.seremis.geninfusion.genetics

import com.seremis.geninfusion.api.GIApiInterface
import com.seremis.geninfusion.api.genetics.{IAncestry, IChromosome, ISoul}
import com.seremis.geninfusion.api.util.GeneName

import scala.collection.immutable.TreeMap

class Soul(genome: TreeMap[GeneName[_], IChromosome[_]], ancestry: IAncestry) extends ISoul {

    checkParameters()

    @throws[IllegalArgumentException]
    def getValueFromMap[A](name: GeneName[A]): IChromosome[A] = {
        genome.getOrElse(name, geneNotAvailable(name)).asInstanceOf[IChromosome[A]]
    }

    /**
      * Returns the value of the active IAlleleData for this gene.
      */
    @throws[IllegalArgumentException]
    override def getActiveValueForGene[A](name: GeneName[A]): A = getValueFromMap(name).getActiveAllele.getData

    /**
      * Returns the value of the inactive IAlleleData of this gene.
      */
    @throws[IllegalArgumentException]
    override def getPassiveValueForGene[A](name: GeneName[A]): A = getValueFromMap(name).getPassiveAllele.getData

    /**
      * Returns the IAncestry object for this soul.
      */
    override def getAncestry: IAncestry = ancestry

    @throws[IllegalArgumentException]
    def geneNotAvailable(name: GeneName[_]) = throw new IllegalArgumentException("There is no registered gene called '" + name.name + "' available. Is this gene registered?")

    @throws[IllegalArgumentException]
    def genomeMalformed(reason: String) = throw new IllegalArgumentException("The genome for a soul was malformed. " + reason)

    @throws[IllegalArgumentException]
    def checkParameters() {
        if(genome.nonEmpty) {
            val registeredGenes = GIApiInterface.geneRegistry.getAllGenes.sortBy(gene => gene.getGeneName)

            if(registeredGenes.length == genome.size) {

                var reason = ""

                var index = 0
                for((genomeGene, _) <- genome) {
                    val registeredGene = registeredGenes(index).getGeneName

                    if(genomeGene != registeredGene) {
                        reason += System.lineSeparator() + "\t The gene in the genome (" + genomeGene + ") does not match up with the gene that should be in that position (" + registeredGene + ")."
                    }

                    index += 1
                }

                if(reason != "") {
                    genomeMalformed("The genome has one or more errors: " + reason)
                }

            } else {
                genomeMalformed("The genome (" + genome.size + " genes) does not contain all registered genes (" + registeredGenes.length + " genes).")
            }
        } else {
            genomeMalformed("The genome map is empty.")
        }
    }

    override def toString = "Soul[genome = '" + genome.toString + "', ancestry = '" + ancestry + "]"

    /**
      * Get a TreeMap with all the typed Gene names as keys and the corresponding
      * IGeneData.
      * Every key-value pair has the same type parameters.
      */
    override def getGenome: TreeMap[GeneName[_], IChromosome[_]] = genome
}
