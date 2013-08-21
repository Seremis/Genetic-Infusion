package Seremis.SoulCraft.api.util.structure;

import net.minecraft.block.Block;
import Seremis.SoulCraft.api.util.Coordinate3D;

public interface IStructureBlock {

    public Block getBlock();
    
    /**
     * The metadata value of the block used in the structure
     * @return
     */
    public int getMetadata();
    
    /**
     * The position relative to the structure
     * @return
     */
    Coordinate3D getPosition();

    void setPosition(Coordinate3D position);
}
