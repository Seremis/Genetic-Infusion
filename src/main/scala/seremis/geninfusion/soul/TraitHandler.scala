package seremis.geninfusion.soul

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.entity.effect.EntityLightningBolt
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase, IEntityLivingData}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.{ResourceLocation, ChunkCoordinates, DamageSource}
import seremis.geninfusion.api.soul.{IEntitySoulCustom, SoulHelper}

object TraitHandler {

    def entityUpdate(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.onUpdate(entity)
        }
    }

    def interact(entity: IEntitySoulCustom, player: EntityPlayer): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.interact(entity, player)) {
            flag = true
        }
        flag
    }

    def entityDeath(entity: IEntitySoulCustom, source: DamageSource) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.onDeath(entity, source)
        }
    }

    def onKillEntity(entity: IEntitySoulCustom, killed: EntityLivingBase) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.onKillEntity(entity, killed)
        }
    }

    def attackEntityFrom(entity: IEntitySoulCustom, source: DamageSource, damage: Float): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.attackEntityFrom(entity, source, damage)) {
            flag = true
        }
        flag
    }

    def attackEntity(entity: IEntitySoulCustom, entityToAttack: Entity, distance: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.attackEntity(entity, entityToAttack, distance)
        }
    }

    def spawnEntityFromEgg(entity: IEntitySoulCustom, data: IEntityLivingData): IEntityLivingData = {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.onSpawnWithEgg(entity, data)
        }
        data
    }

    def playSoundAtEntity(entity: IEntitySoulCustom, name: String, volume: Float, pitch: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.playSound(entity, name, volume, pitch)
        }
    }

    def damageEntity(entity: IEntitySoulCustom, source: DamageSource, damage: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.damageEntity(entity, source, damage)
        }
    }

    def updateAITick(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.updateAITick(entity)
        }
    }

    def firstTick(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.firstTick(entity)
        }
    }

    def attackEntityAsMob(entity: IEntitySoulCustom, entityToAttack: Entity): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.attackEntityAsMob(entity, entityToAttack)) {
            flag = true
        }
        flag
    }

    def findPlayerToAttack(entity: IEntitySoulCustom): Entity = {
        var flag: Entity = null
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.findPlayerToAttack(entity)
            if (tmp != null) {
                flag = tmp
            }
        }
        flag
    }

    def applyArmorCalculations(entity: IEntitySoulCustom, source: DamageSource, damage: Float): Float = {
        var flag = 0.0F
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.applyArmorCalculations(entity, source, damage)
            if (tmp != 0.0F) {
                flag = tmp
            }
        }
        flag
    }

    def applyPotionDamageCalculations(entity: IEntitySoulCustom, source: DamageSource, damage: Float): Float = {
        var flag = 0.0F
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.applyPotionDamageCalculations(entity, source, damage)
            if (tmp != 0.0F) {
                flag = tmp
            }
        }
        flag
    }

    def damageArmor(entity: IEntitySoulCustom, damage: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.damageArmor(entity, damage)
        }
    }

    def setOnFireFromLava(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.setOnFireFromLava(entity)
        }
    }

    def getBlockPathWeight(entity: IEntitySoulCustom, x: Int, y: Int, z: Int): Float = {
        var flag = 0.0F
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.getBlockPathWeight(entity, x, y, z)
            if (tmp != 0.0F) {
                flag = tmp
            }
        }
        flag
    }

    def updateEntityActionState(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.updateEntityActionState(entity)
        }
    }

    def updateWanderPath(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.updateWanderPath(entity)
        }
    }

    def attackEntityWithRangedAttack(entity: IEntitySoulCustom, target: EntityLivingBase, distanceModified: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.attackEntityWithRangedAttack(entity, target, distanceModified)
        }
    }

    @SideOnly(Side.CLIENT)
    def render(entity: IEntitySoulCustom, timeModifier: Float, limbSwing: Float, specialRotation: Float, rotationYawHead: Float, rotationPitch: Float, scale: Float) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.render(entity, timeModifier, limbSwing, specialRotation, rotationYawHead, rotationPitch, scale)
        }
    }

    def isWithinHomeDistanceCurrentPosition(entity: IEntitySoulCustom): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.isWithinHomeDistanceCurrentPosition(entity)) {
            flag = true
        }
        flag
    }

    def isWithinHomeDistance(entity: IEntitySoulCustom, x: Int, y: Int, z: Int): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.isWithinHomeDistance(entity, x, y, z)) {
            flag = true
        }
        flag
    }

    def getHomePosition(entity: IEntitySoulCustom): ChunkCoordinates = {
        var flag: ChunkCoordinates = null
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val coords = trt.getHomePosition(entity)
            if (coords != null) {
                flag = coords
            }
        }
        flag
    }

    def setHomeArea(entity: IEntitySoulCustom, x: Int, y: Int, z: Int, maxDistance: Int) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.setHomeArea(entity, x, y, z, maxDistance)
        }
    }

    def getMaxHomeDistance(entity: IEntitySoulCustom): Float = {
        var flag = 0.0F
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val dist = trt.getMaxHomeDistance(entity)
            if (dist != 0.0F) {
                flag = dist
            }
        }
        flag
    }

    def detachHome(entity: IEntitySoulCustom) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.detachHome(entity)
        }
    }

    def hasHome(entity: IEntitySoulCustom): Boolean = {
        var flag = false
        for (trt <- SoulHelper.traitRegistry.getTraits if trt.hasHome(entity)) {
            flag = true
        }
        flag
    }

    def writeToNBT(entity: IEntitySoulCustom, compound: NBTTagCompound) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.writeToNBT(entity, compound)
        }
    }

    def readFromNBT(entity: IEntitySoulCustom, compound: NBTTagCompound) {
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            trt.readFromNBT(entity, compound)
        }
    }

    @SideOnly(Side.CLIENT)
    def getEntityTexture(entity: IEntitySoulCustom): ResourceLocation = {
        var flag: ResourceLocation = null
        for (trt <- SoulHelper.traitRegistry.getTraits) {
            val tex = trt.getEntityTexture(entity)
            if (tex != null) {
                flag = tex
            }
        }
        flag
    }

    def onStruckByLightning(entity: IEntitySoulCustom, lightingBolt: EntityLightningBolt) {
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            trt.onStruckByLightning(entity, lightingBolt)
        }
    }

    @SideOnly(Side.CLIENT)
    def preRenderCallback(entity: IEntitySoulCustom, partialTickTime: Float) {
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            trt.preRenderCallback(entity, partialTickTime)
        }
    }

    @SideOnly(Side.CLIENT)
    def getColorMultiplier(entity: IEntitySoulCustom, brightness: Float, partialTickTime: Float): Int = {
        var flag = 0
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.getColorMultiplier(entity, brightness, partialTickTime)
            if(tmp != 0) {
                flag = tmp
            }
        }
        flag
    }

    @SideOnly(Side.CLIENT)
    def shouldRenderPass(entity: IEntitySoulCustom, renderPass: Int, partialTickTime: Float): Int = {
        var flag = 0
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.shouldRenderPass(entity, renderPass, partialTickTime)
            if(tmp != 0) {
                flag = tmp
            }
        }
        flag
    }

    @SideOnly(Side.CLIENT)
    def inheritRenderPass(entity: IEntitySoulCustom, renderPass: Int, partialTickTime: Float): Int = {
        var flag = 0
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            val tmp = trt.inheritRenderPass(entity, renderPass, partialTickTime)
            if(tmp != 0) {
                flag = tmp
            }
        }
        flag
    }

    @SideOnly(Side.CLIENT)
    def renderEquippedItems(entity: IEntitySoulCustom, partialTickTime: Float) {
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            trt.renderEquippedItems(entity, partialTickTime)
        }
    }

    def setDead(entity: IEntitySoulCustom) {
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            trt.setDead(entity)
        }
    }

    def setCustomNameTag(entity: IEntitySoulCustom, nameTag: String) {
        for(trt <- SoulHelper.traitRegistry.getTraits) {
            trt.setCustomNameTag(entity, nameTag)
        }
    }

    def getCustomNameTag(entity: IEntitySoulCustom): String = {
        var flag: String = null
        for(trt <- SoulHelper.traitRegistry.getTraits if trt.getCustomNameTag(entity) != null) {
            flag = trt.getCustomNameTag(entity)
        }
        flag
    }

    def hasCustomNameTag(entity: IEntitySoulCustom): Boolean = {
        var flag = false
        for(trt <- SoulHelper.traitRegistry.getTraits if trt.hasCustomNameTag(entity)) {
            flag = trt.hasCustomNameTag(entity)
        }
        flag
    }
}