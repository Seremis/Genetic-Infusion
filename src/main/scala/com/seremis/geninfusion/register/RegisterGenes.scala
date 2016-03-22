package com.seremis.geninfusion.register

import com.seremis.geninfusion.api.GIApiInterface._
import com.seremis.geninfusion.api.lib.Genes._
import com.seremis.geninfusion.api.util.TypedName
import com.seremis.geninfusion.genetics.{Allele, GeneData}

object RegisterGenes extends Register {

    override def register(): Unit = {
        geneRegistry.register(geneData(GeneTest, true, false, true, false))
    }

    def geneData[A](name: TypedName[A], default1: A, default2: A, dominant1: Boolean, dominant2: Boolean): GeneData[A] = GeneData(name, new Allele(default1, dominant1), new Allele(default2, dominant2))

    override def registerClient(): Unit = {}
    override def registerServer(): Unit = {}
}
