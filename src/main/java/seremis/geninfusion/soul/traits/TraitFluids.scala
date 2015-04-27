package seremis.geninfusion.soul.traits

import net.minecraft.block.material.Material
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.Potion
import net.minecraft.util.DamageSource
import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.api.soul.{IEntitySoulCustom, SoulHelper}

class TraitFluids extends Trait {

    override def onUpdate(entity: IEntitySoulCustom) {
        val living = entity.asInstanceOf[EntityLiving]

        val drownsInWater = SoulHelper.geneRegistry.getValueFromAllele[Boolean](entity, Genes.GENE_DROWNS_IN_WATER)

        if(drownsInWater) {
            if(!entity.getBoolean("isDead") && living.isInsideOfMaterial(Material.water)) {
                if(!living.canBreatheUnderwater && !living.isPotionActive(Potion.waterBreathing.id) && !(entity.isInstanceOf[EntityPlayer] && entity.asInstanceOf[EntityPlayer].capabilities.disableDamage)) {
                    living.setAir(entity.decreaseAirSupply(living.getAir))

                    if(living.getAir == -20) {
                        living.setAir(0)

                        for(i <- 0 until 8) {
                            val f = entity.getRandom.nextFloat() - entity.getRandom.nextFloat()
                            val f1 = entity.getRandom.nextFloat() - entity.getRandom.nextFloat()
                            val f2 = entity.getRandom.nextFloat() - entity.getRandom.nextFloat()
                            entity.getWorld.spawnParticle("bubble", living.posX + f.toDouble, living.posY + f1.toDouble, living.posZ + f2.toDouble, living.motionX, living.motionY, living.motionZ)
                        }
                        entity.attackEntityFrom(DamageSource.drown, 2.0F)
                    }
                }

                if(!entity.getWorld.isRemote && living.isRiding && living.ridingEntity != null && living.ridingEntity.shouldDismountInWater(living)) {
                    living.mountEntity(null)
                }
            } else {
                living.setAir(300)
            }
        }

        if(living.isInsideOfMaterial(Material.water)) {
            living.extinguish()
        }

        val drownsInAir = SoulHelper.geneRegistry.getValueFromAllele[Boolean](entity, Genes.GENE_DROWNS_IN_AIR)

        if(drownsInAir) {
            var air = living.getAir

            if(living.isEntityAlive && !living.isInWater) {
                air -= 1
                living.setAir(air)

                if(living.getAir == -20) {
                    living.setAir(0)
                    entity.attackEntityFrom(DamageSource.drown, 2.0F)
                }
            } else {
                living.setAir(300)
            }
        }
    }
}