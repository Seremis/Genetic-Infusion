package Seremis.SoulCraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Seremis.SoulCraft.core.lib.RenderIds;
import Seremis.SoulCraft.core.proxy.CommonProxy;
import Seremis.SoulCraft.item.ModItems;
import Seremis.SoulCraft.tileentity.TileTransporter;
import Seremis.SoulCraft.util.UtilBlock;

public class BlockTransporter extends SCBlock {

    public BlockTransporter(int ID, Material material) {
        super(ID, material);
        setUnlocalizedName("transporter");
        setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8f, 1.0f);
    }    
    
    @Override
    public void registerIcons(IconRegister iconRegister) {}
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    } 
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public int getRenderType() {
        return RenderIds.TransporterRenderID;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if(player.isSneaking()) {return false;}
        
        TileTransporter tile = (TileTransporter)(world.getBlockTileEntity(x, y, z));
        ItemStack playerItem = player.getCurrentEquippedItem();
        if(tile != null && playerItem != null && playerItem.itemID == ModItems.transporterEngines.itemID) {
            if(CommonProxy.proxy.isRenderWorld(world)){return false;}
            if(tile.hasEngine()) {
                player.sendChatToPlayer("This transporter already has engines");
                return true;
            }
            tile.setHasEngine(true);
        }
        if(tile != null && playerItem != null && playerItem.itemID == ModItems.transporterStorage.itemID) {
            if(CommonProxy.proxy.isRenderWorld(world)){return false;}
            if(tile.hasInventory()) {
                player.sendChatToPlayer("This transporter already has a storage module");
                return true;
            }
            tile.setHasInventory(true);
        }
        return true;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if(CommonProxy.proxy.isRenderWorld(world)){return;}
        TileTransporter tile = (TileTransporter)(world.getBlockTileEntity(x, y, z));
        if(tile != null && tile.hasInventory() && entity instanceof EntityItem){
            for(int a=0; a<9; a++)
            {
                if(((TileTransporter)tile).setInventorySlot(a, ((EntityItem) entity).getEntityItem())) {
                    CommonProxy.proxy.removeEntity(entity);
                    break;
                }
            }
        }
    }
    
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        UtilBlock.dropItemsFromTile(world, x, y, z);
        if(CommonProxy.proxy.isRenderWorld(world)){return;}
        TileTransporter tile = (TileTransporter)world.getBlockTileEntity(x, y, z);
        if(tile.hasEngine()) {
            EntityItem item = new EntityItem(world, x, y, z, new ItemStack(ModItems.transporterEngines, 1));
            world.spawnEntityInWorld(item);
        }
        if(tile.hasInventory()) {
            EntityItem item = new EntityItem(world, x, y, z, new ItemStack(ModItems.transporterStorage, 1));
            world.spawnEntityInWorld(item);
        }
        super.breakBlock(world, x, y, z, par5, par6);
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileTransporter();
    }
}
