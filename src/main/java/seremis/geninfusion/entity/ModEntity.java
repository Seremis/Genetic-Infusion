package seremis.geninfusion.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import seremis.geninfusion.GeneticInfusion;
import seremis.geninfusion.lib.EntityIds;
import seremis.geninfusion.soul.entity.EntitySoulCustom;

public class ModEntity {

    public static void init() {
        register();
        addNames();
    }

    public static void register() {
        EntityRegistry.registerModEntity(EntityTransporter.class, "transporter", EntityIds.transporterID, GeneticInfusion.instance, 80, 1, false);
        EntityRegistry.registerModEntity(EntitySoulCustom.class, "soulCustom", EntityIds.soulEntityID, GeneticInfusion.instance, 80, 1, true);
    }

    public static void addNames() {
        LanguageRegistry.instance().addStringLocalization("entity.SC.EntityTransporter.name", "en_US", "Plasma Transporter");
        LanguageRegistry.instance().addStringLocalization("entity.SC.EntitySoulCustom.name", "en_US", "Soul Entity");
    }
}
