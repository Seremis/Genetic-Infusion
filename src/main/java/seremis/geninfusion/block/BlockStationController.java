package seremis.geninfusion.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import seremis.geninfusion.GeneticInfusion;
import seremis.geninfusion.core.proxy.CommonProxy;
import seremis.geninfusion.lib.Blocks;
import seremis.geninfusion.lib.GuiIds;
import seremis.geninfusion.tileentity.TileStationController;
import seremis.geninfusion.util.UtilBlock;

public class BlockStationController extends GIBlockContainerRotateable {

    private static String[] textureNames = {"side", "side", "side", "side", "front", "side"};

    public BlockStationController(Material material) {
        super(material, true, textureNames);
        setBlockName(Blocks.STATION_CONTROLLER_UNLOCALIZED_NAME);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(CommonProxy.instance.isServerWorld(world)) {
            if(isNeighbourBlockPowered(world, x, y, z)) {
                TileStationController tile = (TileStationController) world.getTileEntity(x, y, z);
                tile.onRedstoneSignal();
            }
        }
    }
    
    public boolean isNeighbourBlockPowered(World world, int x, int y, int z) {
        if(world.getBlockPowerInput(x, y, z) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x-1, y, z) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x+1, y, z) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x, y, z-1) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x, y, z+1) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x-1, y, z-1) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x+1, y, z-1) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x+1, y, z-1) > 0) {
            return true;
        }
        if(world.getBlockPowerInput(x+1, y, z+1) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(player.isSneaking()) {
            return false;
        }
        if(CommonProxy.instance.isServerWorld(world)) {
            TileStationController tile = (TileStationController) world.getTileEntity(x, y, z);
            if(multiblockCheck(world, x, y, z)) {
                tile.initiateMultiblock();
                if(tile.isMultiblock) {
                    player.openGui(GeneticInfusion.instance, GuiIds.GUI_STATION_TRANSPORTER_SCREEN_ID, world, x, y, z);
                }
            }
        }
        return true;
    }

    private boolean multiblockCheck(World world, int x, int y, int z) {
        if(CommonProxy.instance.isServerWorld(world)) {
            TileStationController tile = (TileStationController) world.getTileEntity(x, y, z);
            if(tile != null) {
                if(tile.isValid()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        super.breakBlock(world, x, y, z, block, metadata);
        UtilBlock.dropItemsFromTile(world, x, y, z);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileStationController();
    }
}
