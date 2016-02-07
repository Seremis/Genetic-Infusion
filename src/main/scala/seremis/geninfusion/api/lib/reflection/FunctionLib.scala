package seremis.geninfusion.api.lib.reflection

import seremis.geninfusion.helper.MCPNames._

/**
  * This is a library class containing all function names used in reflection.
  * The variables in this class will be converted to mcp names in the dev environment
  * by the MCPNames object.
  * The names that don't call the method() function are not used inside minecraft.
  */
object FunctionLib {

    final val EntityGetEntityId = field("func_145782_y")
    final val EntitySetEntityId = field("func_145769_d")
    final val EntityEntityInit = field("func_70088_a")
    final val EntityGetDataWatcher = field("func_70096_w")
    final val EntityEquals = "equals"
    final val EntityHashCode = "hashCode"
    final val EntityPreparePlayerToSpawn = field("func_70065_x")
    final val EntitySetDead = field("func_70106_y")
    final val EntitySetSize = field("func_70105_a")
    final val EntitySetRotation = field("func_70101_b")
    final val EntitySetPosition = field("func_70107_b")
    final val EntitySetAngles = field("func_70082_c")
    final val EntityOnUpdate = field("func_70071_h_")
    final val EntityOnEntityUpdate = field("func_70030_z")
    final val EntityGetMaxInPortalTime = field("func_82145_z")
    final val EntitySetOnFireFromLava = field("func_70044_A")
    final val EntitySetFire = field("func_70015_d")
    final val EntityExtinguish = field("func_70066_B")
    final val EntityKill = field("func_70076_C")
    final val EntityIsOffsetPositionInLiquid = field("func_70038_c")
    final val EntityMoveEntity = field("func_70091_d")
    final val EntityGetSwimSound = field("func_145776_H")
    final val EntityDoBlockCollisions = "doBlockCollisions"
    final val EntityPlayStepSound = "playStepSound"
    final val EntityPlaySound = field("func_72704_a")
    final val EntityCanTriggerWalking = field("func_70041_e_")
    final val EntityUpdateFallState = field("func_70064_a")
    final val EntityGetBoundingBox = field("func_70046_E")
    final val EntityDealFireDamage = field("func_70081_e")
    final val EntityIsImmuneToFire = field("func_70045_F")
    final val EntityFall = field("func_70069_a")
    final val EntityIsWet = field("func_70026_G")
    final val EntityIsInWater = field("func_70090_H")
    final val EntityHandleWaterMovement = field("func_70072_I")
    final val EntityGetSplashSound = field("func_145777_O")
    final val EntityIsInsideOfMaterial = field("func_70055_a")
    final val EntityGetEyeHeight = field("func_70047_e")
    final val EntityHandleLavaMovement = field("func_70058_J")
    final val EntityMoveFlying = field("func_70060_a")
    final val EntityGetBrightnessForRender = field("func_70070_b")
    final val EntityGetBrightness = field("func_70013_c")
    final val EntitySetWorld = field("func_70029_a")
    final val EntitySetPositionAndRotation = field("func_70080_a")
    final val EntitySetLocationAndAngles = field("func_70012_b")
    final val EntityGetDistanceToEntity = field("func_70032_d")
    final val EntityGetDistanceSq = field("func_70092_e")
    final val EntityGetDistance = field("func_70011_f")
    final val EntityGetDistanceSqToEntity = field("func_70068_e")
    final val EntityOnCollideWithPlayer = field("func_70100_b_")
    final val EntityApplyEntityCollision = field("func_70108_f")
    final val EntityAddVelocity = field("func_70024_g")
    final val EntitySetBeenAttacked = field("func_70018_K")
    final val EntityAttackEntityFrom = field("func_70097_a")
    final val EntityCanBeCollidedWith = field("func_70067_L")
    final val EntityCanBePushed = field("func_70104_M")
    final val EntityAddToPlayerScore = field("func_70084_c")
    final val EntityIsInRangeToRender3d = field("func_145770_h")
    final val EntityIsInRangeToRenderDist = field("func_70112_a")
    final val EntityWriteMountToNBT = field("func_98035_c")
    final val EntityWriteToNBTOptional = field("func_70039_c")
    final val EntityWriteToNBT = field("func_70109_d")
    final val EntityReadFromNBT = field("func_70020_e")
    final val EntityShouldSetPosAfterLoading = field("func_142008_O")
    final val EntityGetEntityString = field("func_70022_Q")
    final val EntityReadEntityFromNBT = field("func_70037_a")
    final val EntityWriteEntityToNBT = field("func_70014_b")
    final val EntityOnChunkLoad = field("func_76631_c")
    final val EntityNewDoubleNBTList = field("func_70087_a")
    final val EntityNewFloatNBTList = field("func_70049_a")
    final val EntityDropItem_ = field("func_145779_a")
    final val EntityDropItemWithOffset = "dropItemWithOffset"
    final val EntityEntityDropItem = field("func_70099_a")
    final val EntityGetShadowSize = field("func_70053_R")
    final val EntityIsEntityAlive = field("func_70089_S")
    final val EntityIsEntityInsideOpaqueBlock = field("func_70094_T")
    final val EntityInteractFirst = field("func_130002_c")
    final val EntityGetCollisionBox = field("func_70114_g")
    final val EntityUpdateRidden = field("func_70098_U")
    final val EntityUpdateRiderPosition = field("func_70043_V")
    final val EntityGetYOffset = field("func_70033_W")
    final val EntityGetMountedYOffset = field("func_70042_X")
    final val EntityMountEntity = field("func_70078_a")
    final val EntitySetPositionAndRotation2 = field("func_70056_a")
    final val EntityGetCollisionBorderSize = field("func_70111_Y")
    final val EntitySetInPortal = field("func_70063_aa")
    final val EntityGetPortalCooldown = field("func_82147_ab")
    final val EntitySetVelocity = field("func_70016_h")
    final val EntityHandleHealthUpdate = field("func_70103_a")
    final val EntityPerformHurtAnimation = field("func_70057_ab")
    final val EntitySetCurrentItemOrArmor = field("func_70062_b")
    final val EntityIsBurning = field("func_70027_ad")
    final val EntityIsRiding = field("func_70115_ae")
    final val EntityIsSneaking = field("func_70093_af")
    final val EntitySetSneaking = field("func_70095_a")
    final val EntityIsSprinting = field("func_70051_ag")
    final val EntitySetSprinting = field("func_70031_b")
    final val EntityIsInvisible = field("func_82150_aj")
    final val EntityIsInvisibleToPlayer = field("func_98034_c")
    final val EntitySetInvisible = field("func_82142_c")
    final val EntityIsEating = field("func_70113_ah")
    final val EntitySetEating = field("func_70019_c")
    final val EntityGetFlag = field("func_70083_f")
    final val EntitySetFlag = field("func_70052_a")
    final val EntityGetAir = field("func_70086_ai")
    final val EntitySetAir = field("func_70050_g")
    final val EntityOnStruckByLightning = field("func_70077_a")
    final val EntityOnKillEntity = field("func_70074_a")
    final val EntityPushOutOfBlocks = "pushOutOfBlocks"
    final val EntitySetInWeb = field("func_70110_aj")
    final val EntityGetCommandSenderName = field("func_70005_c_")
    final val EntityIsEntityEqual = field("func_70028_i")
    final val EntityGetRotationYawHead = field("func_70079_am")
    final val EntitySetRotationYawHead = field("func_70034_d")
    final val EntityCanAttackWithItem = field("func_70075_an")
    final val EntityHitByEntity = field("func_85031_j")
    final val EntityToString = "toString"
    final val EntityIsEntityInvulnerable = field("func_85032_ar")
    final val EntityCopyLocationAndAnglesFrom = field("func_82149_j")
    final val EntityCopyDataFrom = field("func_82141_a")
    final val EntityTravelToDimension = field("func_71027_c")
    final val EntityGetExplosionResistance = field("func_149638_a")
    final val EntityFunc_145774_a = "func_145774_a"
    final val EntityGetMaxFallHeight = "getMaxFallHeight"
    final val EntityGetTeleportDirection = field("func_82148_at")
    final val EntityDoesEntityNotTriggerPressurePlate = field("func_145773_az")
    final val EntityAddEntityCrashInfo = field("func_85029_a")
    final val EntityCanRenderOnFire = field("func_90999_ad")
    final val EntityGetUniqueID = field("func_80006_f")
    final val EntityIsPushedByWater = field("func_96092_aw")
    final val EntityFunc_145781_i = "func_145781_i"
    final val EntityGetEntityData = "getEntityData"
    final val EntityShouldRiderSit = "shouldRiderSit"
    final val EntityGetPersistentID = "getPersistentID"
    final val EntityResetEntityId = "resetEntityId"
    final val EntityShouldRenderInPass = "shouldRenderInPass"
    final val EntityIsCreatureType = "isCreatureType"
    final val EntityRegisterExtendedProperties = "registerExtendedProperties"
    final val EntityCanRiderInteract = "canRiderInteract"
    final val EntityShouldDismountInWater = "shouldDismountInWater"
}
