package seremis.geninfusion.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import seremis.geninfusion.core.proxy.CommonProxy;
import seremis.geninfusion.tileentity.GITile;
import seremis.geninfusion.tileentity.GITileMagnetConnector;
import seremis.geninfusion.tileentity.GITileMagnetConsumer;

public class GIBlockContainerRotateable extends GIBlockContainer {

    private boolean useTile;

    public GIBlockContainerRotateable(Material material, boolean useTile, String[] sidedTextureNames) {
        super(material);
        this.useTile = useTile;
        setNeedsSidedTexture(true, sidedTextureNames);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int direction = 0;
        int facing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        switch(facing) {
            case 3:
                direction = ForgeDirection.WEST.ordinal();
                break;
            case 2:
                direction = ForgeDirection.EAST.ordinal();
                break;
            case 1:
                direction = ForgeDirection.SOUTH.ordinal();
                break;
            case 0:
                direction = ForgeDirection.NORTH.ordinal();
                break;
        }
        if(!useTile) {
            world.setBlockMetadataWithNotify(x, y, z, direction - 2, 3);
        }
        if(useTile && CommonProxy.instance.isServerWorld(world)) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile != null && tile instanceof GITile) {
                ((GITile) tile).setDirection(direction);
            } else if(tile != null && tile instanceof GITileMagnetConnector) {
                ((GITileMagnetConnector) tile).setDirection(direction);
            } else if(tile != null && tile instanceof GITileMagnetConsumer) {
                ((GITileMagnetConsumer) tile).setDirection(direction);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return getSidedIcons()[side];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if(useTile) {
            TileEntity tile = blockAccess.getTileEntity(x, y, z);
            if(tile != null && tile instanceof GITile) {
                int direction = ((GITile) tile).getDirection();
                return getSidedIcons()[getTextureIndex(direction, side)];
            } else if(tile != null && tile instanceof GITileMagnetConnector) {
                int direction = ((GITileMagnetConnector) tile).getDirection();
                return getSidedIcons()[getTextureIndex(direction, side)];
            } else if(tile != null && tile instanceof GITileMagnetConsumer) {
                int direction = ((GITileMagnetConsumer) tile).getDirection();
                return getSidedIcons()[getTextureIndex(direction, side)];
            }
        } else {
            int direction = blockAccess.getBlockMetadata(x, y, z) + 2;
            return getSidedIcons()[getTextureIndex(direction, side)];
        }
        return null;
    }

    private int getTextureIndex(int direction, int side) {
        int index = side < 2 ? side : direction + side;
        while(index > 5) {
            index = index - 4;
        }
        return index;
    }
}
