package voidrunner101.SoulCraft.common.core;

import net.minecraftforge.common.Configuration;
import voidrunner101.SoulCraft.mod_SoulCraft;

public class SCConfig {

	private static DefaultProps id;
	
	public static void configure(Configuration config) {
		config.load();
		//Blocks
		id.OreTitaniumID = config.getBlock("Titanium Ore", 1320).getInt();
		id.OreIsolatziumID = config.getBlock("Soul Crystal Ore", 1321).getInt();
		id.CompressorID = config.getBlock("Compressor", 1322).getInt();
		id.MonsterEggID = config.getBlock("Monster Eggs", 1325).getInt();
		//Items
		id.TitaniumIngotID = config.getItem("Titanium Ingot", 4520).getInt();
		id.ShardIsolatziumID = config.getItem("Isolatzium Shards", 4521).getInt();
		//Booleans
		id.spawnTitanium = config.get(Configuration.CATEGORY_GENERAL, "Spawn Titanium Ore in the world", true).getBoolean(true);
		id.spawnOreSoulCrystal = config.get(Configuration.CATEGORY_GENERAL, "Spawn Soul Crystal Ore (all colours) in the world", true).getBoolean(true);
		
		config.save();
	}
	
}