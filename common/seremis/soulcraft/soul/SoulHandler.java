package seremis.soulcraft.soul;

import seremis.soulcraft.soul.entity.IEntitySoulCustom;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;

public class SoulHandler {
    
    public static Soul getSoulFrom(IEntitySoulCustom entity) {
        return getSoulFrom((EntityLiving) entity);
    }
    
    public static Soul getSoulFrom(EntityLiving entity) {
        Soul soul = null;
        
        if(entity instanceof IEntitySoulCustom) {
            soul = ((IEntitySoulCustom)entity).getSoul();
        } else {
            soul = SoulTemplates.getSoulPreset(entity);
        }
        return soul;
    }
    
    public static boolean hasSoul(IEntitySoulCustom entity) {
        NBTTagCompound compound = entity.getEntityData();
        return compound.hasKey("soul");
    }

    public static IChromosome getChromosomeFrom(IEntitySoulCustom entity, EnumChromosome chromosome) {
        return getChromosomeFrom((EntityLiving) entity, chromosome);
    }
    
    public static IChromosome getChromosomeFrom(EntityLiving entity, EnumChromosome chromosome) {
        return getSoulFrom(entity).chromosomes[chromosome.ordinal()];
    }
}
