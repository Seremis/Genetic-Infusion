package seremis.geninfusion.api.lib

object EntityMethods {
    final val GetEntityId = Genes.ID + ".entityMethod.getEntityId"
    final val SetEntityId = Genes.ID + ".entityMethod.setEntityId"
    final val EntityInit = Genes.ID + ".entityMethod.entityInit"
    final val GetDataWatcher = Genes.ID + ".entityMethod.getDataWatcher"
    final val Equals = Genes.ID + ".entityMethod.equals"
    final val HashCode = Genes.ID + ".entityMethod.hashCode"
    final val PreparePlayerToSpawn = Genes.ID + ".entityMethod.preparePlayerToSpawn"
    final val SetDead = Genes.ID + ".entityMethod.setDead"
    final val SetSize = Genes.ID + ".entityMethod.setSize"
    final val SetRotation = Genes.ID + ".entityMethod.setRotation"
    final val SetPosition = Genes.ID + ".entityMethod.setPosition"
    final val SetAngles = Genes.ID + ".entityMethod.setAngles"
    final val OnUpdate = Genes.ID + ".entityMethod.onUpdate"
    final val OnEntityUpdate = Genes.ID + ".entityMethod.onEntityUpdate"
    final val GetMaxInPortalTime = Genes.ID + ".entityMethod.getMaxInPortalTime"
    final val SetOnFireFromLava = Genes.ID + ".entityMethod.setOnFireFromLava"
    final val SetFire = Genes.ID + ".entityMethod.setFire"
    final val Extinguish = Genes.ID + ".entityMethod.extinguish"
    final val Kill = Genes.ID + ".entityMethod.kill"
    final val IsOffsetPositionInLiquid = Genes.ID + ".entityMethod.isOffsetPositionInLiquid"
    final val MoveEntity = Genes.ID + ".entityMethod.moveEntity"
    final val GetSwimSound = Genes.ID + ".entityMethod.getSwimSound"
    final val DoBlockCollisions = Genes.ID + ".entityMethod.doBlockCollisions"
    final val PlayStepSound = Genes.ID + ".entityMethod.playStepSound"
    final val PlaySound = Genes.ID + ".entityMethod.playSound"
    final val CanTriggerWalking = Genes.ID + ".entityMethod.canTriggerWalking"
    final val UpdateFallState = Genes.ID + ".entityMethod.updateFallState"
    final val GetBoundingBox = Genes.ID + ".entityMethod.getBoundingBox"
    final val DealFireDamage = Genes.ID + ".entityMethod.dealFireDamage"
    final val IsImmuneToFire = Genes.ID + ".entityMethod.isImmuneToFire"
    final val Fall = Genes.ID + ".entityMethod.fall"
    final val IsWet = Genes.ID + ".entityMethod.isWet"
    final val IsInWater = Genes.ID + ".entityMethod.isInWater"
    final val HandleWaterMovement = Genes.ID + ".entityMethod.handleWaterMovement"
    final val GetSplashSound = Genes.ID + ".entityMethod.getSplashSound"
    final val IsInsideOfMaterial = Genes.ID + ".entityMethod.isInsideOfMaterial"
    final val GetEyeHeight = Genes.ID + ".entityMethod.getEyeHeight"
    final val HandleLavaMovement = Genes.ID + ".entityMethod.handleLavaMovement"
    final val MoveFlying = Genes.ID + ".entityMethod.moveFlying"
    final val GetBrightnessForRender = Genes.ID + ".entityMethod.getBrightnessForRender"
    final val GetBrightness = Genes.ID + ".entityMethod.getBrightness"
    final val SetWorld = Genes.ID + ".entityMethod.setWorld"
    final val SetPositionAndRotation = Genes.ID + ".entityMethod.setPositionAndRotation"
    final val SetLocationAndAngles = Genes.ID + ".entityMethod.setLocationAndAngles"
    final val GetDistanceToEntity = Genes.ID + ".entityMethod.getDistanceToEntity"
    final val GetDistanceSq = Genes.ID + ".entityMethod.getDistanceSq"
    final val GetDistance = Genes.ID + ".entityMethod.getDistance"
    final val GetDistanceSqToEntity = Genes.ID + ".entityMethod.getDistanceSqToEntity"
    final val OnCollideWithPlayer = Genes.ID + ".entityMethod.onCollideWithPlayer"
    final val ApplyEntityCollision = Genes.ID + ".entityMethod.applyEntityCollision"
    final val AddVelocity = Genes.ID + ".entityMethod.addVelocity"
    final val SetBeenAttacked = Genes.ID + ".entityMethod.setBeenAttacked"
    final val AttackEntityFrom = Genes.ID + ".entityMethod.attackEntityFrom"
    final val CanBeCollidedWith = Genes.ID + ".entityMethod.canBeCollidedWith"
    final val CanBePushed = Genes.ID + ".entityMethod.canBePushed"
    final val AddToPlayerScore = Genes.ID + ".entityMethod.addToPlayerScore"
    final val IsInRangeToRender3d = Genes.ID + ".entityMethod.isInRangeToRender3d"
    final val IsInRangeToRenderDist = Genes.ID + ".entityMethod.isInRangeToRenderDist"
    final val WriteMountToNBT = Genes.ID + ".entityMethod.writeMountToNBT"
    final val WriteToNBTOptional = Genes.ID + ".entityMethod.writeToNBTOptional"
    final val WriteToNBT = Genes.ID + ".entityMethod.writeToNBT"
    final val ReadFromNBT = Genes.ID + ".entityMethod.readFromNBT"
    final val ShouldSetPosAfterLoading = Genes.ID + ".entityMethod.shouldSetPosAfterLoading"
    final val GetEntityString = Genes.ID + ".entityMethod.getEntityString"
    final val ReadEntityFromNBT = Genes.ID + ".entityMethod.readEntityFromNBT"
    final val WriteEntityToNBT = Genes.ID + ".entityMethod.writeEntityToNBT"
    final val OnChunkLoad = Genes.ID + ".entityMethod.onChunkLoad"
    final val NewDoubleNBTList = Genes.ID + ".entityMethod.newDoubleNBTList"
    final val NewFloatNBTList = Genes.ID + ".entityMethod.newFloatNBTList"
    final val DropItem = Genes.ID + ".entityMethod.dropItem"
    final val DropItemWithOffset = Genes.ID + ".entityMethod.dropItemWithOffset"
    final val EntityDropItem = Genes.ID + ".entityMethod.entityDropItem"
    final val GetShadowSize = Genes.ID + ".entityMethod.getShadowSize"
    final val IsEntityAlive = Genes.ID + ".entityMethod.isEntityAlive"
    final val IsEntityInsideOpaqueBlock = Genes.ID + ".entityMethod.isEntityInsideOpaqueBlock"
    final val InteractFirst = Genes.ID + ".entityMethod.interactFirst"
    final val GetCollisionBox = Genes.ID + ".entityMethod.getCollisionBox"
    final val UpdateRidden = Genes.ID + ".entityMethod.updateRidden"
    final val UpdateRiderPosition = Genes.ID + ".entityMethod.updateRiderPosition"
    final val GetYOffset = Genes.ID + ".entityMethod.getYOffset"
    final val GetMountedYOffset = Genes.ID + ".entityMethod.getMountedYOffset"
    final val MountEntity = Genes.ID + ".entityMethod.mountEntity"
    final val SetPositionAndRotation2 = Genes.ID + ".entityMethod.setPositionAndRotation2"
    final val GetCollisionBorderSize = Genes.ID + ".entityMethod.getCollisionBorderSize"
    final val GetLookVec = Genes.ID + ".entityMethod.getLookVec"
    final val SetInPortal = Genes.ID + ".entityMethod.setInPortal"
    final val GetPortalCooldown = Genes.ID + ".entityMethod.getPortalCooldown"
    final val SetVelocity = Genes.ID + ".entityMethod.setVelocity"
    final val HandleHealthUpdate = Genes.ID + ".entityMethod.handleHealthUpdate"
    final val PerformHurtAnimation = Genes.ID + ".entityMethod.performHurtAnimation"
    final val GetInventory = Genes.ID + ".entityMethod.getInventory"
    final val SetCurrentItemOrArmor = Genes.ID + ".entityMethod.setCurrentItemOrArmor"
    final val IsBurning = Genes.ID + ".entityMethod.isBurning"
    final val IsRiding = Genes.ID + ".entityMethod.isRiding"
    final val IsSneaking = Genes.ID + ".entityMethod.isSneaking"
    final val SetSneaking = Genes.ID + ".entityMethod.setSneaking"
    final val IsSprinting = Genes.ID + ".entityMethod.isSprinting"
    final val SetSprinting = Genes.ID + ".entityMethod.setSprinting"
    final val IsInvisible = Genes.ID + ".entityMethod.isInvisible"
    final val IsInvisibleToPlayer = Genes.ID + ".entityMethod.isInvisibleToPlayer"
    final val SetInvisible = Genes.ID + ".entityMethod.setInvisible"
    final val IsEating = Genes.ID + ".entityMethod.isEating"
    final val SetEating = Genes.ID + ".entityMethod.setEating"
    final val GetFlag = Genes.ID + ".entityMethod.getFlag"
    final val SetFlag = Genes.ID + ".entityMethod.setFlag"
    final val GetAir = Genes.ID + ".entityMethod.getAir"
    final val SetAir = Genes.ID + ".entityMethod.setAir"
    final val OnStruckByLightning = Genes.ID + ".entityMethod.onStruckByLightning"
    final val OnKillEntity = Genes.ID + ".entityMethod.onKillEntity"
    final val PushOutOfBlocks = Genes.ID + ".entityMethod.pushOutOfBlocks"
    final val SetInWeb = Genes.ID + ".entityMethod.setInWeb"
    final val GetCommandSenderName = Genes.ID + ".entityMethod.getCommandSenderName"
    final val GetParts = Genes.ID + ".entityMethod.getParts"
    final val IsEntityEqual = Genes.ID + ".entityMethod.isEntityEqual"
    final val GetRotationYawHead = Genes.ID + ".entityMethod.getRotationYawHead"
    final val SetRotationYawHead = Genes.ID + ".entityMethod.setRotationYawHead"
    final val CanAttackWithItem = Genes.ID + ".entityMethod.canAttackWithItem"
    final val HitByEntity = Genes.ID + ".entityMethod.hitByEntity"
    final val ToString = Genes.ID + ".entityMethod.toString"
    final val IsEntityInvulnerable = Genes.ID + ".entityMethod.isEntityInvulnerable"
    final val CopyLocationAndAnglesFrom = Genes.ID + ".entityMethod.copyLocationAndAnglesFrom"
    final val CopyDataFrom = Genes.ID + ".entityMethod.copyDataFrom"
    final val TravelToDimension = Genes.ID + ".entityMethod.travelToDimension"
    final val GetExplosionResistance = Genes.ID + ".entityMethod.getExplosionResistance"
    final val Func_145774_a = Genes.ID + ".entityMethod.func_145774_a"
    final val GetMaxFallHeight = Genes.ID + ".entityMethod.getMaxFallHeight"
    final val GetTeleportDirection = Genes.ID + ".entityMethod.getTeleportDirection"
    final val DoesEntityNotTriggerPressurePlate = Genes.ID + ".entityMethod.doesEntityNotTriggerPressurePlate"
    final val AddEntityCrashInfo = Genes.ID + ".entityMethod.addEntityCrashInfo"
    final val CanRenderOnFire = Genes.ID + ".entityMethod.canRenderOnFire"
    final val GetUniqueID = Genes.ID + ".entityMethod.getUniqueID"
    final val IsPushedByWater = Genes.ID + ".entityMethod.isPushedByWater"
    final val GetFormattedCommandSenderName = Genes.ID + ".entityMethod.getFormattedCommandSenderName"
    final val Func_145781_i = Genes.ID + ".entityMethod.func_145781_i"
    final val GetEntityData = Genes.ID + ".entityMethod.getEntityData"
    final val ShouldRiderSit = Genes.ID + ".entityMethod.shouldRiderSit"
    final val GetPickedResult = Genes.ID + ".entityMethod.getPickedResult"
    final val GetPersistentID = Genes.ID + ".entityMethod.getPersistentID"
    final val ResetEntityId = Genes.ID + ".entityMethod.resetEntityId"
    final val ShouldRenderInPass = Genes.ID + ".entityMethod.shouldRenderInPass"
    final val IsCreatureType = Genes.ID + ".entityMethod.isCreatureType"
    final val RegisterExtendedProperties = Genes.ID + ".entityMethod.registerExtendedProperties"
    final val GetExtendedProperties = Genes.ID + ".entityMethod.getExtendedProperties"
    final val CanRiderInteract = Genes.ID + ".entityMethod.canRiderInteract"
    final val ShouldDismountInWater = Genes.ID + ".entityMethod.shouldDismountInWater"
}

