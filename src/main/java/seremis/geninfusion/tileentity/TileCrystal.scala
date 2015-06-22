package seremis.geninfusion.tileentity

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.play.server.S35PacketUpdateTileEntity
import net.minecraft.network.{NetworkManager, Packet}
import net.minecraft.tileentity.TileEntity
import seremis.geninfusion.api.soul.{ISoul, ISoulReceptor, SoulHelper}

class TileCrystal extends TileEntity with GITile with ISoulReceptor {

    var soul: Option[ISoul] = None

    override def updateEntity() {
    }

    /**
     * Gets the ISoul this ISoulReceptor currently has.
     * @return The Option[ISoul] this ISoulReceptor contains.
     */
    override def getSoul: Option[ISoul] = soul

    /**
     * Sets the ISoul for this ISoulReceptor to contain.
     * @param soul The ISoul to set.
     */
    override def setSoul(soul: Option[ISoul]) = this.soul = soul

    /**
     * @return true if this ISoulReceptor has an ISoul.
     */
    override def hasSoul: Boolean = soul.nonEmpty

    override def readFromNBT(compound: NBTTagCompound) {
        super.readFromNBT(compound)

        readSoul(compound)
    }

    def readSoul(compound: NBTTagCompound) {
        if(compound.hasKey("soul"))
            soul = SoulHelper.instanceHelper.getISoulInstance(compound.getCompoundTag("soul"))
        else
            soul = None
    }

    override def writeToNBT(compound: NBTTagCompound) {
        super.writeToNBT(compound)

        writeSoul(compound)
    }

    def writeSoul(compound: NBTTagCompound) {
        soul.foreach(s => compound.setTag("soul", s.writeToNBT(new NBTTagCompound)))
    }

    override def getDescriptionPacket: Packet = {
        val compound = new NBTTagCompound
        writeSoul(compound)
        new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, compound)
    }

    override def onDataPacket(manager: NetworkManager, packet: S35PacketUpdateTileEntity) {
        readSoul(packet.getNbtCompound)
    }
}
