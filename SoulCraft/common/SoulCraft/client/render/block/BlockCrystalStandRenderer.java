package SoulCraft.client.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import SoulCraft.core.lib.RenderIds;
import SoulCraft.tileentity.TileCrystalStand;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockCrystalStandRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glRotatef(10.0F, 0.0F, 1.0F, 0.0F);
	    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	    GL11.glScalef(1.2F, 1.2F, 1.2F);
	    TileCrystalStand tile = new TileCrystalStand();
	    TileEntityRenderer.instance.renderTileEntityAt(tile, 0.0D, 0.0D, 0.0D, 0.0F);
	    GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderIds.CrystalStandRenderID;
	}

}
