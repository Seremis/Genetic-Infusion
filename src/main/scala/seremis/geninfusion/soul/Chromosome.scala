package seremis.geninfusion.soul

import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import net.minecraftforge.common.util.Constants
import seremis.geninfusion.api.soul.{IAllele, IChromosome}

class Chromosome(var geneName: String, var allele1: IAllele, var allele2: IAllele) extends IChromosome {

    def this(geneName: String, allele: IAllele) {
        this(geneName, allele, allele)
    }

    def this(compound: NBTTagCompound) {
        this(null, null)
        readFromNBT(compound)
    }

    override def getActive: IAllele = {
        if (allele1.isDominant) {
            return allele1
        }
        if (allele2.isDominant) {
            return allele2
        }
        allele1
    }

    override def getRecessive: IAllele = {
        if (!allele1.isDominant) {
            return allele1
        }
        if (!allele2.isDominant) {
            return allele2
        }
        allele2
    }

    override def getPrimary: IAllele = allele1

    override def getSecondary: IAllele = allele2

    override def getGeneName: String = geneName

    override def writeToNBT(compound: NBTTagCompound): NBTTagCompound = {
        val list = new NBTTagList()

        val compound1 = new NBTTagCompound()
        allele1.writeToNBT(compound1)
        val compound2 = new NBTTagCompound()
        allele2.writeToNBT(compound2)

        list.appendTag(compound1)
        list.appendTag(compound2)

        compound.setTag("alleles", list)
        compound.setString("geneName", geneName)
        compound
    }

    override def readFromNBT(compound: NBTTagCompound): NBTTagCompound = {
        val list = compound.getTagList("alleles", Constants.NBT.TAG_COMPOUND)

        allele1 = new Allele(list.getCompoundTagAt(0))
        allele2 = new Allele(list.getCompoundTagAt(1))

        geneName = compound.getString("geneName")

        compound
    }

    override def toString: String = {
        "Chromosome:[geneName: " + geneName + ", allele1: " + allele1 + ", allele2: " + allele2 + "]"
    }
}