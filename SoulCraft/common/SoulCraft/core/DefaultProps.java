package SoulCraft.core;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class DefaultProps {
	public static final String ID = "SC";
	public static final String name = "SoulCraft";
	public static final String version = "SoulCraft Pr1";
	public static final String acceptedMinecraftVersions = "1.4.6";
	
	
	/**
	 * The texture file for the blocks.
	 */
	public static final String BLOCKS_TEXTURE_FILE = "/SoulCraft/resources/gfx/blocks.png";
	/**
	 * The texture file for the items.
	 */
	public static final String ITEMS_TEXTURE_FILE = "/SoulCraft/resources/gfx/items.png";
	
	public static final int MonsterEggRenderID = RenderingRegistry.getNextAvailableRenderId();
	public static final int CompressorRenderID = RenderingRegistry.getNextAvailableRenderId();
	
	public static boolean spawnTitanium;
	public static boolean spawnOreSoulCrystal;
	public static boolean fancyCompressorRenderer;
	
	public static int OreTitaniumID;
	public static int OreIsolatziumID;
	public static int CompressorID;
	public static int MonsterEggID;
	
	public static int TitaniumIngotID;
	public static int ShardIsolatziumID;
	
	public static int CompressorRenderDistance;
}
