package com.seremis.geninfusion.api.lib

import java.{lang, util}
import java.util._

import com.seremis.geninfusion.api.util.TypedName
import net.minecraft.block.material._
import net.minecraft.command._
import net.minecraft.entity._
import net.minecraft.entity.ai._
import net.minecraft.entity.ai.attributes._
import net.minecraft.entity.item._
import net.minecraft.item._
import net.minecraft.nbt._
import net.minecraft.network.datasync._
import net.minecraft.pathfinding._
import net.minecraft.potion._
import net.minecraft.scoreboard._
import net.minecraft.server._
import net.minecraft.util._
import net.minecraft.util.math._
import net.minecraft.util.text._
import net.minecraft.util.text.event._
import net.minecraft.world._

object FunctionLib {
    final val FuncEntityAddChatMessage = TypedName(method("func_145747_a"), classOf[Unit])
    final val FuncEntityAddEntityCrashInfo = TypedName(method("func_85029_a"), classOf[Unit])
    final val FuncEntityAddPassenger = TypedName(method("func_184200_o"), classOf[Unit])
    final val FuncEntityAddTag = TypedName(method("func_184211_a"), classOf[Boolean])
    final val FuncEntityAddToPlayerScore = TypedName(method("func_70084_c"), classOf[Unit])
    final val FuncEntityAddTrackingPlayer = TypedName(method("func_184178_b"), classOf[Unit])
    final val FuncEntityAddVelocity = TypedName(method("func_70024_g"), classOf[Unit])
    final val FuncEntityApplyEnchantments = TypedName(method("func_174815_a"), classOf[Unit])
    final val FuncEntityApplyEntityCollision = TypedName(method("func_70108_f"), classOf[Unit])
    final val FuncEntityApplyOrientationToEntity = TypedName(method("func_184190_l"), classOf[Unit])
    final val FuncEntityApplyPlayerInteraction = TypedName(method("func_184199_a"), classOf[EnumActionResult])
    final val FuncEntityAttackEntityFrom = TypedName(method("func_70097_a"), classOf[Boolean])
    final val FuncEntityCanAttackWithItem = TypedName(method("func_70075_an"), classOf[Boolean])
    final val FuncEntityCanBeCollidedWith = TypedName(method("func_70067_L"), classOf[Boolean])
    final val FuncEntityCanBePushed = TypedName(method("func_70104_M"), classOf[Boolean])
    final val FuncEntityCanBeRidden = TypedName(method("func_184228_n"), classOf[Boolean])
    final val FuncEntityCanCommandSenderUseCommand = TypedName(method("func_70003_b"), classOf[Boolean])
    final val FuncEntityCanFitPassenger = TypedName(method("func_184219_q"), classOf[Boolean])
    final val FuncEntityCanPassengerSteer = TypedName(method("func_184186_bw"), classOf[Boolean])
    final val FuncEntityCanRenderOnFire = TypedName(method("func_90999_ad"), classOf[Boolean])
    final val FuncEntityCanTriggerWalking = TypedName(method("func_70041_e_"), classOf[Boolean])
    final val FuncEntityChangeDimension = TypedName(method("func_184204_a"), classOf[Entity])
    final val FuncEntityCopyDataFromOld = TypedName(method("func_180432_n"), classOf[Unit])
    final val FuncEntityCopyLocationAndAnglesFrom = TypedName(method("func_82149_j"), classOf[Unit])
    final val FuncEntityCreateRunningParticles = TypedName(method("func_174808_Z"), classOf[Unit])
    final val FuncEntityDealFireDamage = TypedName(method("func_70081_e"), classOf[Unit])
    final val FuncEntityDecrementTimeUntilPortal = TypedName(method("func_184173_H"), classOf[Unit])
    final val FuncEntityDismountRidingEntity = TypedName(method("func_184210_p"), classOf[Unit])
    final val FuncEntityDoBlockCollisions = TypedName(method("func_145775_I"), classOf[Unit])
    final val FuncEntityDoesEntityNotTriggerPressurePlate = TypedName(method("func_145773_az"), classOf[Boolean])
    final val FuncEntityDropItem = TypedName(method("func_145779_a"), classOf[EntityItem])
    final val FuncEntityDropItemWithOffset = TypedName(method("func_145778_a"), classOf[EntityItem])
    final val FuncEntityEntityDropItem = TypedName(method("func_70099_a"), classOf[EntityItem])
    final val FuncEntityEntityInit = TypedName(method("func_70088_a"), classOf[Unit])
    final val FuncEntityEquals = TypedName("equals", classOf[Boolean])
    final val FuncEntityExtinguish = TypedName(method("func_70066_B"), classOf[Unit])
    final val FuncEntityFall = TypedName(method("func_180430_e"), classOf[Unit])
    final val FuncEntityFunc_184213_bq = TypedName("func_184213_bq", classOf[Boolean])
    final val FuncEntityGetAdjustedHorizontalFacing = TypedName(method("func_184172_bi"), classOf[EnumFacing])
    final val FuncEntityGetAir = TypedName(method("func_70086_ai"), classOf[Int])
    final val FuncEntityGetAlwaysRenderNameTag = TypedName(method("func_174833_aM"), classOf[Boolean])
    final val FuncEntityGetAlwaysRenderNameTagForRender = TypedName(method("func_94059_bO"), classOf[Boolean])
    final val FuncEntityGetArmorInventoryList = TypedName(method("func_184193_aE"), classOf[lang.Iterable[ItemStack]])
    final val FuncEntityGetBrightness = TypedName(method("func_70013_c"), classOf[Float])
    final val FuncEntityGetBrightnessForRender = TypedName(method("func_70070_b"), classOf[Int])
    final val FuncEntityGetCollisionBorderSize = TypedName(method("func_70111_Y"), classOf[Float])
    final val FuncEntityGetCollisionBoundingBox = TypedName(method("func_70046_E"), classOf[AxisAlignedBB])
    final val FuncEntityGetCollisionBox = TypedName(method("func_70114_g"), classOf[AxisAlignedBB])
    final val FuncEntityGetCommandSenderEntity = TypedName(method("func_174793_f"), classOf[Entity])
    final val FuncEntityGetCommandStats = TypedName(method("func_174807_aT"), classOf[CommandResultStats])
    final val FuncEntityGetControllingPassenger = TypedName(method("func_184179_bs"), classOf[Entity])
    final val FuncEntityGetCustomNameTag = TypedName(method("func_95999_t"), classOf[String])
    final val FuncEntityGetDataManager = TypedName(method("func_184212_Q"), classOf[EntityDataManager])
    final val FuncEntityGetDisplayName = TypedName(method("func_145748_c_"), classOf[ITextComponent])
    final val FuncEntityGetDistance = TypedName(method("func_70011_f"), classOf[Double])
    final val FuncEntityGetDistanceSq_0 = TypedName(method("func_70092_e"), classOf[Double])
    final val FuncEntityGetDistanceSq_1 = TypedName(method("func_174818_b"), classOf[Double])
    final val FuncEntityGetDistanceSqToCenter = TypedName(method("func_174831_c"), classOf[Double])
    final val FuncEntityGetDistanceSqToEntity = TypedName(method("func_70068_e"), classOf[Double])
    final val FuncEntityGetDistanceToEntity = TypedName(method("func_70032_d"), classOf[Float])
    final val FuncEntityGetEntityBoundingBox = TypedName(method("func_174813_aQ"), classOf[AxisAlignedBB])
    final val FuncEntityGetEntityId = TypedName(method("func_145782_y"), classOf[Int])
    final val FuncEntityGetEntityString = TypedName(method("func_70022_Q"), classOf[String])
    final val FuncEntityGetEntityWorld = TypedName(method("func_130014_f_"), classOf[World])
    final val FuncEntityGetEquipmentAndArmor = TypedName(method("func_184209_aF"), classOf[lang.Iterable[ItemStack]])
    final val FuncEntityGetExplosionResistance = TypedName(method("func_180428_a"), classOf[Float])
    final val FuncEntityGetEyeHeight = TypedName(method("func_70047_e"), classOf[Float])
    final val FuncEntityGetFlag = TypedName(method("func_70083_f"), classOf[Boolean])
    final val FuncEntityGetHeldEquipment = TypedName(method("func_184214_aD"), classOf[lang.Iterable[ItemStack]])
    final val FuncEntityGetHorizontalFacing = TypedName(method("func_174811_aO"), classOf[EnumFacing])
    final val FuncEntityGetHoverEvent = TypedName(method("func_174823_aP"), classOf[HoverEvent])
    final val FuncEntityGetLastPortalVec = TypedName(method("func_181014_aG"), classOf[Vec3d])
    final val FuncEntityGetLook = TypedName(method("func_70676_i"), classOf[Vec3d])
    final val FuncEntityGetLookVec = TypedName(method("func_70040_Z"), classOf[Vec3d])
    final val FuncEntityGetLowestRidingEntity = TypedName(method("func_184208_bv"), classOf[Entity])
    final val FuncEntityGetMaxFallHeight = TypedName(method("func_82143_as"), classOf[Int])
    final val FuncEntityGetMaxInPortalTime = TypedName(method("func_82145_z"), classOf[Int])
    final val FuncEntityGetMirroredYaw = TypedName(method("func_184217_a"), classOf[Float])
    final val FuncEntityGetMountedYOffset = TypedName(method("func_70042_X"), classOf[Double])
    final val FuncEntityGetName = TypedName(method("func_70005_c_"), classOf[String])
    final val FuncEntityGetParts = TypedName(method("func_70021_al"), classOf[Array[Entity]])
    final val FuncEntityGetPassengers = TypedName(method("func_184188_bt"), classOf[List[Entity]])
    final val FuncEntityGetPortalCooldown = TypedName(method("func_82147_ab"), classOf[Int])
    final val FuncEntityGetPosition = TypedName(method("func_180425_c"), classOf[BlockPos])
    final val FuncEntityGetPositionEyes = TypedName(method("func_174824_e"), classOf[Vec3d])
    final val FuncEntityGetPositionVector = TypedName(method("func_174791_d"), classOf[Vec3d])
    final val FuncEntityGetPushReaction = TypedName(method("func_184192_z"), classOf[EnumPushReaction])
    final val FuncEntityGetRecursivePassengers = TypedName(method("func_184182_bu"), classOf[util.Collection[Entity]])
    final val FuncEntityGetRecursivePassengersByType_0 = TypedName(method("func_184180_b"), classOf[util.Collection[_]])
    final val FuncEntityGetRecursivePassengersByType_1 = TypedName(method("func_184175_a"), classOf[Unit])
    final val FuncEntityGetRenderBoundingBox = TypedName(method("func_184177_bl"), classOf[AxisAlignedBB])
    final val FuncEntityGetRidingEntity = TypedName(method("func_184187_bx"), classOf[Entity])
    final val FuncEntityGetRotatedYaw = TypedName(method("func_184229_a"), classOf[Float])
    final val FuncEntityGetRotationYawHead = TypedName(method("func_70079_am"), classOf[Float])
    final val FuncEntityGetServer = TypedName(method("func_184102_h"), classOf[MinecraftServer])
    final val FuncEntityGetSoundCategory = TypedName(method("func_184176_by"), classOf[SoundCategory])
    final val FuncEntityGetSplashSound = TypedName(method("func_184181_aa"), classOf[SoundEvent])
    final val FuncEntityGetSwimSound = TypedName(method("func_184184_Z"), classOf[SoundEvent])
    final val FuncEntityGetTags = TypedName(method("func_184216_O"), classOf[util.Set[String]])
    final val FuncEntityGetTeam = TypedName(method("func_96124_cp"), classOf[Team])
    final val FuncEntityGetTeleportDirection = TypedName(method("func_181012_aH"), classOf[EnumFacing])
    final val FuncEntityGetUniqueID = TypedName(method("func_110124_au"), classOf[UUID])
    final val FuncEntityGetVectorForRotation = TypedName(method("func_174806_f"), classOf[Vec3d])
    final val FuncEntityGetYOffset = TypedName(method("func_70033_W"), classOf[Double])
    final val FuncEntityHandleStatusUpdate = TypedName(method("func_70103_a"), classOf[Unit])
    final val FuncEntityHandleWaterMovement = TypedName(method("func_70072_I"), classOf[Boolean])
    final val FuncEntityHasCustomName = TypedName(method("func_145818_k_"), classOf[Boolean])
    final val FuncEntityHashCode = TypedName("hashCode", classOf[Int])
    final val FuncEntityHitByEntity = TypedName(method("func_85031_j"), classOf[Boolean])
    final val FuncEntityIsBeingRidden = TypedName(method("func_184207_aI"), classOf[Boolean])
    final val FuncEntityIsBurning = TypedName(method("func_70027_ad"), classOf[Boolean])
    final val FuncEntityIsEntityAlive = TypedName(method("func_70089_S"), classOf[Boolean])
    final val FuncEntityIsEntityEqual = TypedName(method("func_70028_i"), classOf[Boolean])
    final val FuncEntityIsEntityInsideOpaqueBlock = TypedName(method("func_70094_T"), classOf[Boolean])
    final val FuncEntityIsEntityInvulnerable = TypedName(method("func_180431_b"), classOf[Boolean])
    final val FuncEntityIsGlowing = TypedName(method("func_184202_aL"), classOf[Boolean])
    final val FuncEntityIsImmuneToExplosions = TypedName(method("func_180427_aV"), classOf[Boolean])
    final val FuncEntityIsImmuneToFire = TypedName(method("func_70045_F"), classOf[Boolean])
    final val FuncEntityIsInLava = TypedName(method("func_180799_ab"), classOf[Boolean])
    final val FuncEntityIsInRangeToRender3d = TypedName(method("func_145770_h"), classOf[Boolean])
    final val FuncEntityIsInRangeToRenderDist = TypedName(method("func_70112_a"), classOf[Boolean])
    final val FuncEntityIsInWater = TypedName(method("func_70090_H"), classOf[Boolean])
    final val FuncEntityIsInsideOfMaterial = TypedName(method("func_70055_a"), classOf[Boolean])
    final val FuncEntityIsInvisible = TypedName(method("func_82150_aj"), classOf[Boolean])
    final val FuncEntityIsInvisibleToPlayer = TypedName(method("func_98034_c"), classOf[Boolean])
    final val FuncEntityIsLiquidPresentInAABB = TypedName(method("func_174809_b"), classOf[Boolean])
    final val FuncEntityIsNonBoss = TypedName(method("func_184222_aU"), classOf[Boolean])
    final val FuncEntityIsOffsetPositionInLiquid = TypedName(method("func_70038_c"), classOf[Boolean])
    final val FuncEntityIsOnSameTeam = TypedName(method("func_184191_r"), classOf[Boolean])
    final val FuncEntityIsOnScoreboardTeam = TypedName(method("func_184194_a"), classOf[Boolean])
    final val FuncEntityIsOutsideBorder = TypedName(method("func_174832_aS"), classOf[Boolean])
    final val FuncEntityIsPassenger = TypedName(method("func_184196_w"), classOf[Boolean])
    final val FuncEntityIsPushedByWater = TypedName(method("func_96092_aw"), classOf[Boolean])
    final val FuncEntityIsRiding = TypedName(method("func_184218_aH"), classOf[Boolean])
    final val FuncEntityIsRidingOrBeingRiddenBy = TypedName(method("func_184215_y"), classOf[Boolean])
    final val FuncEntityIsRidingSameEntity = TypedName(method("func_184223_x"), classOf[Boolean])
    final val FuncEntityIsSilent = TypedName(method("func_174814_R"), classOf[Boolean])
    final val FuncEntityIsSneaking = TypedName(method("func_70093_af"), classOf[Boolean])
    final val FuncEntityIsSpectatedByPlayer = TypedName(method("func_174827_a"), classOf[Boolean])
    final val FuncEntityIsSprinting = TypedName(method("func_70051_ag"), classOf[Boolean])
    final val FuncEntityIsWet = TypedName(method("func_70026_G"), classOf[Boolean])
    final val FuncEntityKill = TypedName(method("func_70076_C"), classOf[Unit])
    final val FuncEntityMoveEntity = TypedName(method("func_70091_d"), classOf[Unit])
    final val FuncEntityMoveFlying = TypedName(method("func_70060_a"), classOf[Unit])
    final val FuncEntityMoveToBlockPosAndAngles = TypedName(method("func_174828_a"), classOf[Unit])
    final val FuncEntityNewDoubleNBTList = TypedName(method("func_70087_a"), classOf[NBTTagList])
    final val FuncEntityNewFloatNBTList = TypedName(method("func_70049_a"), classOf[NBTTagList])
    final val FuncEntityNotifyDataManagerChange = TypedName(method("func_184206_a"), classOf[Unit])
    final val FuncEntityOnChunkLoad = TypedName(method("func_110123_P"), classOf[Unit])
    final val FuncEntityOnCollideWithPlayer = TypedName(method("func_70100_b_"), classOf[Unit])
    final val FuncEntityOnEntityUpdate = TypedName(method("func_70030_z"), classOf[Unit])
    final val FuncEntityOnKillCommand = TypedName(method("func_174812_G"), classOf[Unit])
    final val FuncEntityOnKillEntity = TypedName(method("func_70074_a"), classOf[Unit])
    final val FuncEntityOnStruckByLightning = TypedName(method("func_70077_a"), classOf[Unit])
    final val FuncEntityOnUpdate = TypedName(method("func_70071_h_"), classOf[Unit])
    final val FuncEntityPerformHurtAnimation = TypedName(method("func_70057_ab"), classOf[Unit])
    final val FuncEntityPlaySound = TypedName(method("func_184185_a"), classOf[Unit])
    final val FuncEntityPlayStepSound = TypedName(method("func_180429_a"), classOf[Unit])
    final val FuncEntityPreparePlayerToSpawn = TypedName(method("func_70065_x"), classOf[Unit])
    final val FuncEntityProcessInitialInteract = TypedName(method("func_184230_a"), classOf[Boolean])
    final val FuncEntityPushOutOfBlocks = TypedName(method("func_145771_j"), classOf[Boolean])
    final val FuncEntityRayTrace = TypedName(method("func_174822_a"), classOf[RayTraceResult])
    final val FuncEntityReadEntityFromNBT = TypedName(method("func_70037_a"), classOf[Unit])
    final val FuncEntityReadFromNBT = TypedName(method("func_70020_e"), classOf[Unit])
    final val FuncEntityRemovePassenger = TypedName(method("func_184225_p"), classOf[Unit])
    final val FuncEntityRemovePassengers = TypedName(method("func_184226_ay"), classOf[Unit])
    final val FuncEntityRemoveTag = TypedName(method("func_184197_b"), classOf[Boolean])
    final val FuncEntityRemoveTrackingPlayer = TypedName(method("func_184203_c"), classOf[Unit])
    final val FuncEntityReplaceItemInInventory = TypedName(method("func_174820_d"), classOf[Boolean])
    final val FuncEntityResetHeight = TypedName(method("func_71061_d_"), classOf[Unit])
    final val FuncEntityResetPositionToBB = TypedName(method("func_174829_m"), classOf[Unit])
    final val FuncEntitySendCommandFeedback = TypedName(method("func_174792_t_"), classOf[Boolean])
    final val FuncEntitySetAir = TypedName(method("func_70050_g"), classOf[Unit])
    final val FuncEntitySetAlwaysRenderNameTag = TypedName(method("func_174805_g"), classOf[Unit])
    final val FuncEntitySetAngles = TypedName(method("func_70082_c"), classOf[Unit])
    final val FuncEntitySetBeenAttacked = TypedName(method("func_70018_K"), classOf[Unit])
    final val FuncEntitySetCommandStat = TypedName(method("func_174794_a"), classOf[Unit])
    final val FuncEntitySetCommandStats = TypedName(method("func_174817_o"), classOf[Unit])
    final val FuncEntitySetCustomNameTag = TypedName(method("func_96094_a"), classOf[Unit])
    final val FuncEntitySetDead = TypedName(method("func_70106_y"), classOf[Unit])
    final val FuncEntitySetDropItemsWhenDead = TypedName(method("func_184174_b"), classOf[Unit])
    final val FuncEntitySetEntityBoundingBox = TypedName(method("func_174826_a"), classOf[Unit])
    final val FuncEntitySetEntityId = TypedName(method("func_145769_d"), classOf[Unit])
    final val FuncEntitySetEntityInvulnerable = TypedName(method("func_184224_h"), classOf[Unit])
    final val FuncEntitySetFire = TypedName(method("func_70015_d"), classOf[Unit])
    final val FuncEntitySetFlag = TypedName(method("func_70052_a"), classOf[Unit])
    final val FuncEntitySetGlowing = TypedName(method("func_184195_f"), classOf[Unit])
    final val FuncEntitySetInWeb = TypedName(method("func_70110_aj"), classOf[Unit])
    final val FuncEntitySetInvisible = TypedName(method("func_82142_c"), classOf[Unit])
    final val FuncEntitySetItemStackToSlot = TypedName(method("func_184201_a"), classOf[Unit])
    final val FuncEntitySetLocationAndAngles = TypedName(method("func_70012_b"), classOf[Unit])
    final val FuncEntitySetOnFireFromLava = TypedName(method("func_70044_A"), classOf[Unit])
    final val FuncEntitySetOutsideBorder = TypedName(method("func_174821_h"), classOf[Unit])
    final val FuncEntitySetPortal = TypedName(method("func_181015_d"), classOf[Unit])
    final val FuncEntitySetPosition = TypedName(method("func_70107_b"), classOf[Unit])
    final val FuncEntitySetPositionAndRotation = TypedName(method("func_70080_a"), classOf[Unit])
    final val FuncEntitySetPositionAndRotation2 = TypedName(method("func_180426_a"), classOf[Unit])
    final val FuncEntitySetPositionAndUpdate = TypedName(method("func_70634_a"), classOf[Unit])
    final val FuncEntitySetPositionNonDirty = TypedName(method("func_184189_br"), classOf[Boolean])
    final val FuncEntitySetRenderYawOffset = TypedName(method("func_181013_g"), classOf[Unit])
    final val FuncEntitySetRotation = TypedName(method("func_70101_b"), classOf[Unit])
    final val FuncEntitySetRotationYawHead = TypedName(method("func_70034_d"), classOf[Unit])
    final val FuncEntitySetSilent = TypedName(method("func_174810_b"), classOf[Unit])
    final val FuncEntitySetSize = TypedName(method("func_70105_a"), classOf[Unit])
    final val FuncEntitySetSneaking = TypedName(method("func_70095_a"), classOf[Unit])
    final val FuncEntitySetSprinting = TypedName(method("func_70031_b"), classOf[Unit])
    final val FuncEntitySetUniqueId = TypedName(method("func_184221_a"), classOf[Unit])
    final val FuncEntitySetVelocity = TypedName(method("func_70016_h"), classOf[Unit])
    final val FuncEntitySetWorld = TypedName(method("func_70029_a"), classOf[Unit])
    final val FuncEntityShouldSetPosAfterLoading = TypedName(method("func_142008_O"), classOf[Boolean])
    final val FuncEntitySpawnRunningParticles = TypedName(method("func_174830_Y"), classOf[Unit])
    final val FuncEntityStartRiding_0 = TypedName(method("func_184220_m"), classOf[Boolean])
    final val FuncEntityStartRiding_1 = TypedName(method("func_184205_a"), classOf[Boolean])
    final val FuncEntityToString = TypedName("toString", classOf[String])
    final val FuncEntityUpdateFallState = TypedName(method("func_184231_a"), classOf[Unit])
    final val FuncEntityUpdatePassenger = TypedName(method("func_184232_k"), classOf[Unit])
    final val FuncEntityUpdateRidden = TypedName(method("func_70098_U"), classOf[Unit])
    final val FuncEntityVerifyExplosion = TypedName(method("func_174816_a"), classOf[Boolean])
    final val FuncEntityWriteEntityToNBT = TypedName(method("func_70014_b"), classOf[Unit])
    final val FuncEntityWriteToNBT = TypedName(method("func_70109_d"), classOf[Unit])
    final val FuncEntityWriteToNBTAtomically = TypedName(method("func_184198_c"), classOf[Boolean])
    final val FuncEntityWriteToNBTOptional = TypedName(method("func_70039_c"), classOf[Boolean])
    final val FuncEntityLivingApplyEntityAI = TypedName(method("func_175456_n"), classOf[Unit])
    final val FuncEntityLivingCanAttackClass = TypedName(method("func_70686_a"), classOf[Boolean])
    final val FuncEntityLivingCanBeLeashedTo = TypedName(method("func_184652_a"), classOf[Boolean])
    final val FuncEntityLivingCanBeSteered = TypedName(method("func_82171_bF"), classOf[Boolean])
    final val FuncEntityLivingCanDespawn = TypedName(method("func_70692_ba"), classOf[Boolean])
    final val FuncEntityLivingCanEquipItem = TypedName(method("func_175448_a"), classOf[Boolean])
    final val FuncEntityLivingCanPickUpLoot = TypedName(method("func_98052_bS"), classOf[Boolean])
    final val FuncEntityLivingClearLeashed = TypedName(method("func_110160_i"), classOf[Unit])
    final val FuncEntityLivingCreateBodyHelper = TypedName(method("func_184650_s"), classOf[EntityBodyHelper])
    final val FuncEntityLivingDespawnEntity = TypedName(method("func_70623_bb"), classOf[Unit])
    final val FuncEntityLivingEatGrassBonus = TypedName(method("func_70615_aA"), classOf[Unit])
    final val FuncEntityLivingEnablePersistence = TypedName(method("func_110163_bv"), classOf[Unit])
    final val FuncEntityLivingFaceEntity = TypedName(method("func_70625_a"), classOf[Unit])
    final val FuncEntityLivingGetAmbientSound = TypedName(method("func_184639_G"), classOf[SoundEvent])
    final val FuncEntityLivingGetAttackTarget = TypedName(method("func_70638_az"), classOf[EntityLivingBase])
    final val FuncEntityLivingGetCanSpawnHere = TypedName(method("func_70601_bi"), classOf[Boolean])
    final val FuncEntityLivingGetDropItem = TypedName(method("func_146068_u"), classOf[Item])
    final val FuncEntityLivingGetEntitySenses = TypedName(method("func_70635_at"), classOf[EntitySenses])
    final val FuncEntityLivingGetHorizontalFaceSpeed = TypedName(method("func_184649_cE"), classOf[Int])
    final val FuncEntityLivingGetJumpHelper = TypedName(method("func_70683_ar"), classOf[EntityJumpHelper])
    final val FuncEntityLivingGetLeashed = TypedName(method("func_110167_bD"), classOf[Boolean])
    final val FuncEntityLivingGetLeashedToEntity = TypedName(method("func_110166_bE"), classOf[Entity])
    final val FuncEntityLivingGetLookHelper = TypedName(method("func_70671_ap"), classOf[EntityLookHelper])
    final val FuncEntityLivingGetLootTable = TypedName(method("func_184647_J"), classOf[ResourceLocation])
    final val FuncEntityLivingGetMaxSpawnedInChunk = TypedName(method("func_70641_bl"), classOf[Int])
    final val FuncEntityLivingGetMoveHelper = TypedName(method("func_70605_aq"), classOf[EntityMoveHelper])
    final val FuncEntityLivingGetNavigator = TypedName(method("func_70661_as"), classOf[PathNavigate])
    final val FuncEntityLivingGetNewNavigator = TypedName(method("func_175447_b"), classOf[PathNavigate])
    final val FuncEntityLivingGetPathPriority = TypedName(method("func_184643_a"), classOf[Float])
    final val FuncEntityLivingGetRenderSizeModifier = TypedName(method("func_70603_bj"), classOf[Float])
    final val FuncEntityLivingGetTalkInterval = TypedName(method("func_70627_aG"), classOf[Int])
    final val FuncEntityLivingGetVerticalFaceSpeed = TypedName(method("func_70646_bf"), classOf[Int])
    final val FuncEntityLivingInitEntityAI = TypedName(method("func_184651_r"), classOf[Unit])
    final val FuncEntityLivingIsAIDisabled = TypedName(method("func_175446_cd"), classOf[Boolean])
    final val FuncEntityLivingIsLeftHanded = TypedName(method("func_184638_cS"), classOf[Boolean])
    final val FuncEntityLivingIsNoDespawnRequired = TypedName(method("func_104002_bU"), classOf[Boolean])
    final val FuncEntityLivingIsNotColliding = TypedName(method("func_70058_J"), classOf[Boolean])
    final val FuncEntityLivingOnInitialSpawn = TypedName(method("func_180482_a"), classOf[IEntityLivingData])
    final val FuncEntityLivingPlayLivingSound = TypedName(method("func_70642_aH"), classOf[Unit])
    final val FuncEntityLivingProcessInteract = TypedName(method("func_184645_a"), classOf[Boolean])
    final val FuncEntityLivingRecreateLeash = TypedName(method("func_110165_bF"), classOf[Unit])
    final val FuncEntityLivingSetAttackTarget = TypedName(method("func_70624_b"), classOf[Unit])
    final val FuncEntityLivingSetCanPickUpLoot = TypedName(method("func_98053_h"), classOf[Unit])
    final val FuncEntityLivingSetDropChance = TypedName(method("func_184642_a"), classOf[Unit])
    final val FuncEntityLivingSetEnchantmentBasedOnDifficulty = TypedName(method("func_180483_b"), classOf[Unit])
    final val FuncEntityLivingSetEquipmentBasedOnDifficulty = TypedName(method("func_180481_a"), classOf[Unit])
    final val FuncEntityLivingSetLeashedToEntity = TypedName(method("func_110162_b"), classOf[Unit])
    final val FuncEntityLivingSetLeftHanded = TypedName(method("func_184641_n"), classOf[Unit])
    final val FuncEntityLivingSetMoveForward = TypedName(method("func_70657_f"), classOf[Unit])
    final val FuncEntityLivingSetMoveStrafing = TypedName(method("func_184646_p"), classOf[Unit])
    final val FuncEntityLivingSetNoAI = TypedName(method("func_94061_f"), classOf[Unit])
    final val FuncEntityLivingSetPathPriority = TypedName(method("func_184644_a"), classOf[Unit])
    final val FuncEntityLivingSpawnExplosionParticle = TypedName(method("func_70656_aK"), classOf[Unit])
    final val FuncEntityLivingUpdateAITasks = TypedName(method("func_70619_bc"), classOf[Unit])
    final val FuncEntityLivingUpdateEquipmentIfNeeded = TypedName(method("func_175445_a"), classOf[Unit])
    final val FuncEntityLivingUpdateLeashedState = TypedName(method("func_110159_bB"), classOf[Unit])
    final val FuncEntityLivingUpdateRotation = TypedName(method("func_70663_b"), classOf[Float])
    final val FuncEntityLivingBaseAddPotionEffect = TypedName(method("func_70690_d"), classOf[Unit])
    final val FuncEntityLivingBaseApplyArmorCalculations = TypedName(method("func_70655_b"), classOf[Float])
    final val FuncEntityLivingBaseApplyEntityAttributes = TypedName(method("func_110147_ax"), classOf[Unit])
    final val FuncEntityLivingBaseApplyPotionDamageCalculations = TypedName(method("func_70672_c"), classOf[Float])
    final val FuncEntityLivingBaseAttackEntityAsMob = TypedName(method("func_70652_k"), classOf[Boolean])
    final val FuncEntityLivingBaseCanBeHitWithPotion = TypedName(method("func_184603_cC"), classOf[Boolean])
    final val FuncEntityLivingBaseCanBlockDamageSource = TypedName(method("func_184583_d"), classOf[Boolean])
    final val FuncEntityLivingBaseCanBreatheUnderwater = TypedName(method("func_70648_aU"), classOf[Boolean])
    final val FuncEntityLivingBaseCanDropLoot = TypedName(method("func_146066_aG"), classOf[Boolean])
    final val FuncEntityLivingBaseCanEntityBeSeen = TypedName(method("func_70685_l"), classOf[Boolean])
    final val FuncEntityLivingBaseCanGoThroughtTrapDoorOnLadder = TypedName(method("func_184604_a"), classOf[Boolean])
    final val FuncEntityLivingBaseClearActivePotions = TypedName(method("func_70674_bp"), classOf[Unit])
    final val FuncEntityLivingBaseCollideWithEntity = TypedName(method("func_82167_n"), classOf[Unit])
    final val FuncEntityLivingBaseCollideWithNearbyEntities = TypedName(method("func_85033_bc"), classOf[Unit])
    final val FuncEntityLivingBaseDamageArmor = TypedName(method("func_70675_k"), classOf[Unit])
    final val FuncEntityLivingBaseDamageEntity = TypedName(method("func_70665_d"), classOf[Unit])
    final val FuncEntityLivingBaseDamageShield = TypedName(method("func_184590_k"), classOf[Unit])
    final val FuncEntityLivingBaseDecreaseAirSupply = TypedName(method("func_70682_h"), classOf[Int])
    final val FuncEntityLivingBaseDismountEntity = TypedName(method("func_110145_l"), classOf[Unit])
    final val FuncEntityLivingBaseDropEquipment = TypedName(method("func_82160_b"), classOf[Unit])
    final val FuncEntityLivingBaseDropFewItems = TypedName(method("func_70628_a"), classOf[Unit])
    final val FuncEntityLivingBaseDropLoot = TypedName(method("func_184610_a"), classOf[Unit])
    final val FuncEntityLivingBaseFrostWalk = TypedName(method("func_184594_b"), classOf[Unit])
    final val FuncEntityLivingBaseGetAIMoveSpeed = TypedName(method("func_70689_ay"), classOf[Float])
    final val FuncEntityLivingBaseGetAITarget = TypedName(method("func_70643_av"), classOf[EntityLivingBase])
    final val FuncEntityLivingBaseGetAbsorptionAmount = TypedName(method("func_110139_bj"), classOf[Float])
    final val FuncEntityLivingBaseGetActiveHand = TypedName(method("func_184600_cs"), classOf[EnumHand])
    final val FuncEntityLivingBaseGetActiveItemStack = TypedName(method("func_184607_cu"), classOf[ItemStack])
    final val FuncEntityLivingBaseGetActivePotionEffect = TypedName(method("func_70660_b"), classOf[PotionEffect])
    final val FuncEntityLivingBaseGetActivePotionEffects = TypedName(method("func_70651_bq"), classOf[util.Collection[PotionEffect]])
    final val FuncEntityLivingBaseGetAge = TypedName(method("func_70654_ax"), classOf[Int])
    final val FuncEntityLivingBaseGetArmSwingAnimationEnd = TypedName(method("func_82166_i"), classOf[Int])
    final val FuncEntityLivingBaseGetArrowCountInEntity = TypedName(method("func_85035_bI"), classOf[Int])
    final val FuncEntityLivingBaseGetAttackingEntity = TypedName(method("func_94060_bK"), classOf[EntityLivingBase])
    final val FuncEntityLivingBaseGetAttributeMap = TypedName(method("func_110140_aT"), classOf[AbstractAttributeMap])
    final val FuncEntityLivingBaseGetCombatTracker = TypedName(method("func_110142_aN"), classOf[CombatTracker])
    final val FuncEntityLivingBaseGetCreatureAttribute = TypedName(method("func_70668_bt"), classOf[EnumCreatureAttribute])
    final val FuncEntityLivingBaseGetDeathSound = TypedName(method("func_184615_bR"), classOf[SoundEvent])
    final val FuncEntityLivingBaseGetEntityAttribute = TypedName(method("func_110148_a"), classOf[IAttributeInstance])
    final val FuncEntityLivingBaseGetExperiencePoints = TypedName(method("func_70693_a"), classOf[Int])
    final val FuncEntityLivingBaseGetFallSound = TypedName(method("func_184588_d"), classOf[SoundEvent])
    final val FuncEntityLivingBaseGetHealth = TypedName(method("func_110143_aJ"), classOf[Float])
    final val FuncEntityLivingBaseGetHeldItem = TypedName(method("func_184586_b"), classOf[ItemStack])
    final val FuncEntityLivingBaseGetHeldItemMainhand = TypedName(method("func_184614_ca"), classOf[ItemStack])
    final val FuncEntityLivingBaseGetHeldItemOffhand = TypedName(method("func_184592_cb"), classOf[ItemStack])
    final val FuncEntityLivingBaseGetHurtSound = TypedName(method("func_184601_bQ"), classOf[SoundEvent])
    final val FuncEntityLivingBaseGetItemInUseCount = TypedName(method("func_184605_cv"), classOf[Int])
    final val FuncEntityLivingBaseGetItemInUseMaxCount = TypedName(method("func_184612_cw"), classOf[Int])
    final val FuncEntityLivingBaseGetItemStackFromSlot = TypedName(method("func_184582_a"), classOf[ItemStack])
    final val FuncEntityLivingBaseGetJumpUpwardsMotion = TypedName(method("func_175134_bD"), classOf[Float])
    final val FuncEntityLivingBaseGetLastAttacker = TypedName(method("func_110144_aD"), classOf[EntityLivingBase])
    final val FuncEntityLivingBaseGetLastAttackerTime = TypedName(method("func_142013_aG"), classOf[Int])
    final val FuncEntityLivingBaseGetMaxHealth = TypedName(method("func_110138_aP"), classOf[Float])
    final val FuncEntityLivingBaseGetPrimaryHand = TypedName(method("func_184591_cq"), classOf[EnumHandSide])
    final val FuncEntityLivingBaseGetRNG = TypedName(method("func_70681_au"), classOf[Random])
    final val FuncEntityLivingBaseGetRevengeTimer = TypedName(method("func_142015_aE"), classOf[Int])
    final val FuncEntityLivingBaseGetSoundPitch = TypedName(method("func_70647_i"), classOf[Float])
    final val FuncEntityLivingBaseGetSoundVolume = TypedName(method("func_70599_aP"), classOf[Float])
    final val FuncEntityLivingBaseGetSwingProgress = TypedName(method("func_70678_g"), classOf[Float])
    final val FuncEntityLivingBaseGetTicksElytraFlying = TypedName(method("func_184599_cB"), classOf[Int])
    final val FuncEntityLivingBaseGetTotalArmorValue = TypedName(method("func_70658_aO"), classOf[Int])
    final val FuncEntityLivingBaseHandleJumpLava = TypedName(method("func_180466_bG"), classOf[Unit])
    final val FuncEntityLivingBaseHeal = TypedName(method("func_70691_i"), classOf[Unit])
    final val FuncEntityLivingBaseIsActiveItemStackBlocking = TypedName(method("func_184585_cz"), classOf[Boolean])
    final val FuncEntityLivingBaseIsChild = TypedName(method("func_70631_g_"), classOf[Boolean])
    final val FuncEntityLivingBaseIsElytraFlying = TypedName(method("func_184613_cA"), classOf[Boolean])
    final val FuncEntityLivingBaseIsEntityUndead = TypedName(method("func_70662_br"), classOf[Boolean])
    final val FuncEntityLivingBaseIsHandActive = TypedName(method("func_184587_cr"), classOf[Boolean])
    final val FuncEntityLivingBaseIsMovementBlocked = TypedName(method("func_70610_aX"), classOf[Boolean])
    final val FuncEntityLivingBaseIsOnLadder = TypedName(method("func_70617_f_"), classOf[Boolean])
    final val FuncEntityLivingBaseIsPlayer = TypedName(method("func_70684_aJ"), classOf[Boolean])
    final val FuncEntityLivingBaseIsPlayerSleeping = TypedName(method("func_70608_bn"), classOf[Boolean])
    final val FuncEntityLivingBaseIsPotionActive = TypedName(method("func_70644_a"), classOf[Boolean])
    final val FuncEntityLivingBaseIsPotionApplicable = TypedName(method("func_70687_e"), classOf[Boolean])
    final val FuncEntityLivingBaseIsServerWorld = TypedName(method("func_70613_aW"), classOf[Boolean])
    final val FuncEntityLivingBaseJump = TypedName(method("func_70664_aZ"), classOf[Unit])
    final val FuncEntityLivingBaseKnockBack = TypedName(method("func_70653_a"), classOf[Unit])
    final val FuncEntityLivingBaseMarkPotionsDirty = TypedName(method("func_175136_bO"), classOf[Unit])
    final val FuncEntityLivingBaseMoveEntityWithHeading = TypedName(method("func_70612_e"), classOf[Unit])
    final val FuncEntityLivingBaseOnChangedPotionEffect = TypedName(method("func_70695_b"), classOf[Unit])
    final val FuncEntityLivingBaseOnDeath = TypedName(method("func_70645_a"), classOf[Unit])
    final val FuncEntityLivingBaseOnDeathUpdate = TypedName(method("func_70609_aI"), classOf[Unit])
    final val FuncEntityLivingBaseOnFinishedPotionEffect = TypedName(method("func_70688_c"), classOf[Unit])
    final val FuncEntityLivingBaseOnItemPickup = TypedName(method("func_71001_a"), classOf[Unit])
    final val FuncEntityLivingBaseOnItemUseFinish = TypedName(method("func_71036_o"), classOf[Unit])
    final val FuncEntityLivingBaseOnLivingUpdate = TypedName(method("func_70636_d"), classOf[Unit])
    final val FuncEntityLivingBaseOnNewPotionEffect = TypedName(method("func_70670_a"), classOf[Unit])
    final val FuncEntityLivingBasePlayEquipSound = TypedName(method("func_184606_a_"), classOf[Unit])
    final val FuncEntityLivingBasePlayHurtSound = TypedName(method("func_184581_c"), classOf[Unit])
    final val FuncEntityLivingBaseRemoveActivePotionEffect = TypedName(method("func_184596_c"), classOf[PotionEffect])
    final val FuncEntityLivingBaseRemovePotionEffect = TypedName(method("func_184589_d"), classOf[Unit])
    final val FuncEntityLivingBaseRenderBrokenItemStack = TypedName(method("func_70669_a"), classOf[Unit])
    final val FuncEntityLivingBaseResetActiveHand = TypedName(method("func_184602_cy"), classOf[Unit])
    final val FuncEntityLivingBaseResetPotionEffectMetadata = TypedName(method("func_175133_bi"), classOf[Unit])
    final val FuncEntityLivingBaseSendEndCombat = TypedName(method("func_152112_bu"), classOf[Unit])
    final val FuncEntityLivingBaseSendEnterCombat = TypedName(method("func_152111_bt"), classOf[Unit])
    final val FuncEntityLivingBaseSetAIMoveSpeed = TypedName(method("func_70659_e"), classOf[Unit])
    final val FuncEntityLivingBaseSetAbsorptionAmount = TypedName(method("func_110149_m"), classOf[Unit])
    final val FuncEntityLivingBaseSetActiveHand = TypedName(method("func_184598_c"), classOf[Unit])
    final val FuncEntityLivingBaseSetArrowCountInEntity = TypedName(method("func_85034_r"), classOf[Unit])
    final val FuncEntityLivingBaseSetHealth = TypedName(method("func_70606_j"), classOf[Unit])
    final val FuncEntityLivingBaseSetHeldItem = TypedName(method("func_184611_a"), classOf[Unit])
    final val FuncEntityLivingBaseSetJumping = TypedName(method("func_70637_d"), classOf[Unit])
    final val FuncEntityLivingBaseSetLastAttacker = TypedName(method("func_130011_c"), classOf[Unit])
    final val FuncEntityLivingBaseSetRevengeTarget = TypedName(method("func_70604_c"), classOf[Unit])
    final val FuncEntityLivingBaseStopActiveHand = TypedName(method("func_184597_cx"), classOf[Unit])
    final val FuncEntityLivingBaseSwingArm = TypedName(method("func_184609_a"), classOf[Unit])
    final val FuncEntityLivingBaseTeleportTo_ = TypedName(method("func_184595_k"), classOf[Boolean])
    final val FuncEntityLivingBaseUpdateAITick = TypedName(method("func_70629_bd"), classOf[Unit])
    final val FuncEntityLivingBaseUpdateActiveHand = TypedName(method("func_184608_ct"), classOf[Unit])
    final val FuncEntityLivingBaseUpdateArmSwingProgress = TypedName(method("func_82168_bl"), classOf[Unit])
    final val FuncEntityLivingBaseUpdateDistance = TypedName(method("func_110146_f"), classOf[Float])
    final val FuncEntityLivingBaseUpdateElytra = TypedName(method("func_184616_r"), classOf[Unit])
    final val FuncEntityLivingBaseUpdateEntityActionState = TypedName(method("func_70626_be"), classOf[Unit])
    final val FuncEntityLivingBaseUpdateItemUse = TypedName(method("func_184584_a"), classOf[Unit])
    final val FuncEntityLivingBaseUpdatePotionEffects = TypedName(method("func_70679_bo"), classOf[Unit])
    final val FuncEntityLivingBaseUpdatePotionMetadata = TypedName(method("func_175135_B"), classOf[Unit])
}
