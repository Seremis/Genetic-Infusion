package com.seremis.geninfusion.soulentity

import com.seremis.geninfusion.api.genetics.ISoul
import net.minecraft.entity.EntityLiving
import net.minecraft.world.World
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData

class SoulEntityLivingTraitLiving(world: World) extends EntityLiving(world) with SoulEntityLivingTrait with IEntityAdditionalSpawnData {
    override var soul: ISoul = _
    override val world: World = _
}
