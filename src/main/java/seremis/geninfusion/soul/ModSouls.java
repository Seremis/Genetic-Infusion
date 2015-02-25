package seremis.geninfusion.soul;

import net.minecraft.entity.monster.EntityZombie;
import seremis.geninfusion.api.soul.lib.Genes;
import seremis.geninfusion.api.soul.lib.Traits;
import seremis.geninfusion.soul.gene.*;
import seremis.geninfusion.soul.gene.animation.GeneAnim;
import seremis.geninfusion.soul.gene.model.*;
import seremis.geninfusion.soul.gene.newAI.*;
import seremis.geninfusion.soul.gene.newAI.arrowAttack.*;
import seremis.geninfusion.soul.gene.newAI.attackOnCollide.GeneAIAttackOnCollide;
import seremis.geninfusion.soul.gene.newAI.attackOnCollide.GeneAIAttackOnCollideLongMemory;
import seremis.geninfusion.soul.gene.newAI.attackOnCollide.GeneAIAttackOnCollideMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.attackOnCollide.GeneAIAttackOnCollideTarget;
import seremis.geninfusion.soul.gene.newAI.avoidEntity.*;
import seremis.geninfusion.soul.gene.newAI.beg.GeneAIBeg;
import seremis.geninfusion.soul.gene.newAI.beg.GeneAIBegRange;
import seremis.geninfusion.soul.gene.newAI.breakDoor.GeneAIBreakDoor;
import seremis.geninfusion.soul.gene.newAI.controlledByPlayer.GeneAIControlledByPlayer;
import seremis.geninfusion.soul.gene.newAI.controlledByPlayer.GeneAIControlledByPlayerMaxSpeed;
import seremis.geninfusion.soul.gene.newAI.creeperSwell.GeneAICreeperSwell;
import seremis.geninfusion.soul.gene.newAI.defendVillage.GeneAIDefendVillage;
import seremis.geninfusion.soul.gene.newAI.eatGrass.GeneAIEatGrass;
import seremis.geninfusion.soul.gene.newAI.fleeSun.GeneAIFleeSun;
import seremis.geninfusion.soul.gene.newAI.fleeSun.GeneAIFleeSunMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.followGolem.GeneAIFollowGolem;
import seremis.geninfusion.soul.gene.newAI.followOwner.GeneAIFollowOwner;
import seremis.geninfusion.soul.gene.newAI.followOwner.GeneAIFollowOwnerMaxDistance;
import seremis.geninfusion.soul.gene.newAI.followOwner.GeneAIFollowOwnerMinDistance;
import seremis.geninfusion.soul.gene.newAI.followOwner.GeneAIFollowOwnerMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.followParent.GeneAIFollowParent;
import seremis.geninfusion.soul.gene.newAI.followParent.GeneAIFollowParentMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.hurtByTarget.GeneAIHurtByTarget;
import seremis.geninfusion.soul.gene.newAI.hurtByTarget.GeneAIHurtByTargetCallHelp;
import seremis.geninfusion.soul.gene.newAI.leapAtTarget.GeneAILeapAtTarget;
import seremis.geninfusion.soul.gene.newAI.leapAtTarget.GeneAILeapAtTargetMotionY;
import seremis.geninfusion.soul.gene.newAI.lookAtTradePlayer.GeneAILookAtTradePlayer;
import seremis.geninfusion.soul.gene.newAI.lookAtVillager.GeneAILookAtVillager;
import seremis.geninfusion.soul.gene.newAI.lookIdle.GeneAILookIdle;
import seremis.geninfusion.soul.gene.newAI.mate.GeneAIMate;
import seremis.geninfusion.soul.gene.newAI.mate.GeneAIMateMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.moveIndoors.GeneAIMoveIndoors;
import seremis.geninfusion.soul.gene.newAI.moveThroughVillage.GeneAIMoveThroughVillage;
import seremis.geninfusion.soul.gene.newAI.moveThroughVillage.GeneAIMoveThroughVillageIsNocturnal;
import seremis.geninfusion.soul.gene.newAI.moveThroughVillage.GeneAIMoveThroughVillageMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.moveTowardsRestriction.GeneAIMoveTowardsRestrictionMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.moveTowardsTarget.GeneAIMoveTowardsTarget;
import seremis.geninfusion.soul.gene.newAI.moveTowardsTarget.GeneAIMoveTowardsTargetMaxDistance;
import seremis.geninfusion.soul.gene.newAI.moveTowardsTarget.GeneAIMoveTowardsTargetMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.nearestAttackableTarget.*;
import seremis.geninfusion.soul.gene.newAI.ocelotAttack.GeneAIOcelotAttack;
import seremis.geninfusion.soul.gene.newAI.ocelotSit.GeneAIOcelotSit;
import seremis.geninfusion.soul.gene.newAI.ocelotSit.GeneAIOcelotSitMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.openDoor.GeneAIOpenDoor;
import seremis.geninfusion.soul.gene.newAI.openDoor.GeneAIOpenDoorCloseDoor;
import seremis.geninfusion.soul.gene.newAI.ownerHurtByTarget.GeneAIOwnerHurtByTarget;
import seremis.geninfusion.soul.gene.newAI.ownerHurtTarget.GeneAIOwnerHurtTarget;
import seremis.geninfusion.soul.gene.newAI.panic.GeneAIPanic;
import seremis.geninfusion.soul.gene.newAI.panic.GeneAIPanicMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.play.GeneAIPlay;
import seremis.geninfusion.soul.gene.newAI.play.GeneAIPlayMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.restrictOpenDoor.GeneAIRestrictOpenDoor;
import seremis.geninfusion.soul.gene.newAI.restrictSun.GeneAIRestrictSun;
import seremis.geninfusion.soul.gene.newAI.runAroundLikeCrazy.GeneAIRunAroundLikeCrazy;
import seremis.geninfusion.soul.gene.newAI.runAroundLikeCrazy.GeneAIRunAroundLikeCrazyMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.sit.GeneAISit;
import seremis.geninfusion.soul.gene.newAI.swimming.GeneAISwimming;
import seremis.geninfusion.soul.gene.newAI.targetNonTamed.GeneAITargetNonTamed;
import seremis.geninfusion.soul.gene.newAI.targetNonTamed.GeneAITargetNonTamedTarget;
import seremis.geninfusion.soul.gene.newAI.targetNonTamed.GeneAITargetNonTamedTargetChance;
import seremis.geninfusion.soul.gene.newAI.targetNonTamed.GeneAITargetNonTamedVisible;
import seremis.geninfusion.soul.gene.newAI.tempt.GeneAITempt;
import seremis.geninfusion.soul.gene.newAI.tempt.GeneAITemptItem;
import seremis.geninfusion.soul.gene.newAI.tempt.GeneAITemptMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.tempt.GeneAITemptScaredByPlayer;
import seremis.geninfusion.soul.gene.newAI.tradePlayer.GeneAITradePlayer;
import seremis.geninfusion.soul.gene.newAI.villagerMate.GeneAIVillagerMate;
import seremis.geninfusion.soul.gene.newAI.wander.GeneAIWander;
import seremis.geninfusion.soul.gene.newAI.wander.GeneAIWanderMoveSpeed;
import seremis.geninfusion.soul.gene.newAI.watchClosest.GeneAIWatchClosest;
import seremis.geninfusion.soul.gene.newAI.watchClosest.GeneAIWatchClosestChance;
import seremis.geninfusion.soul.gene.newAI.watchClosest.GeneAIWatchClosestRange;
import seremis.geninfusion.soul.gene.newAI.watchClosest.GeneAIWatchClosestTarget;
import seremis.geninfusion.soul.gene.newAI.watchClosest2.GeneAIWatchClosest2;
import seremis.geninfusion.soul.gene.newAI.watchClosest2.GeneAIWatchClosest2Chance;
import seremis.geninfusion.soul.gene.newAI.watchClosest2.GeneAIWatchClosest2Range;
import seremis.geninfusion.soul.gene.newAI.watchClosest2.GeneAIWatchClosest2Target;
import seremis.geninfusion.soul.gene.oldAI.GeneCeaseAIMovement;
import seremis.geninfusion.soul.standardSoul.StandardSoulZombie;
import seremis.geninfusion.soul.traits.*;

import static seremis.geninfusion.api.soul.SoulHelper.*;

public class ModSouls {

    public static void init() {
        geneRegistry.registerGene(Genes.GENE_MAX_HEALTH, new GeneMaxHealth());
        geneRegistry.registerGene(Genes.GENE_INVULNERABLE, new GeneInvulnerable());
        geneRegistry.registerGene(Genes.GENE_ATTACK_DAMAGE, new GeneAttackDamage());
        geneRegistry.registerGene(Genes.GENE_MOVEMENT_SPEED, new GeneMovementSpeed());
        geneRegistry.registerGene(Genes.GENE_FOLLOW_RANGE, new GeneFollowRange());
        geneRegistry.registerGene(Genes.GENE_BURNS_IN_DAYLIGHT, new GeneBurnsInDaylight());
        geneRegistry.registerGene(Genes.GENE_DROWNS_IN_WATER, new GeneDrownsInWater());
        geneRegistry.registerGene(Genes.GENE_DROWNS_IN_AIR, new GeneDrownsInAir());
        geneRegistry.registerGene(Genes.GENE_IMMUNE_TO_FIRE, new GeneImmuneToFire());
        geneRegistry.registerGene(Genes.GENE_MAX_HURT_RESISTANT_TIME, new GeneMaxHurtResistantTime());
        geneRegistry.registerGene(Genes.GENE_PICKS_UP_ITEMS, new GenePicksUpItems());
        geneRegistry.registerGene(Genes.GENE_ITEM_DROPS, new GeneItemDrops());
        geneRegistry.registerGene(Genes.GENE_RARE_ITEM_DROPS, new GeneRareItemDrops());
        geneRegistry.registerGene(Genes.GENE_RARE_ITEM_DROP_CHANCES, new GeneRareItemDropChances());
        geneRegistry.registerGene(Genes.GENE_EQUIPMENT_DROP_CHANCES, new GeneEquipmentDropChances());
        geneRegistry.registerGene(Genes.GENE_LIVING_SOUND, new GeneLivingSound());
        geneRegistry.registerGene(Genes.GENE_HURT_SOUND, new GeneHurtSound());
        geneRegistry.registerGene(Genes.GENE_DEATH_SOUND, new GeneDeathSound());
        geneRegistry.registerGene(Genes.GENE_WALK_SOUND, new GeneWalkSound());
        geneRegistry.registerGene(Genes.GENE_SPLASH_SOUND, new GeneSplashSound());
        geneRegistry.registerGene(Genes.GENE_SWIM_SOUND, new GeneSwimSound());
        geneRegistry.registerGene(Genes.GENE_SOUND_VOLUME, new GeneSoundVolume());
        geneRegistry.registerGene(Genes.GENE_CREATURE_ATTRIBUTE, new GeneCreatureAttribute());
        geneRegistry.registerGene(Genes.GENE_TELEPORT_TIME_IN_PORTAL, new GeneTeleportTimeInPortal());
        geneRegistry.registerGene(Genes.GENE_PORTAL_COOLDOWN, new GenePortalCooldown());
        geneRegistry.registerGene(Genes.GENE_KNOCKBACK_RESISTANCE, new GeneKnockbackResistance());
        geneRegistry.registerGene(Genes.GENE_SHOULD_DESPAWN, new GeneShouldDespawn());
        geneRegistry.registerGene(Genes.GENE_TALK_INTERVAL, new GeneTalkInterval());
        geneRegistry.registerGene(Genes.GENE_SET_ON_FIRE_FROM_ATTACK, new GeneSetOnFireFromAttack());
        geneRegistry.registerGene(Genes.GENE_EXPERIENCE_VALUE, new GeneExperienceValue());
        geneRegistry.registerGene(Genes.GENE_VERTICAL_FACE_SPEED, new GeneVerticalFaceSpeed());
        geneRegistry.registerGene(Genes.GENE_IS_CREATURE, new GeneIsCreature());
        geneRegistry.registerGene(Genes.GENE_CEASE_AI_MOVEMENT, new GeneCeaseAIMovement());
        geneRegistry.registerGene(Genes.GENE_CHILDREN_BURN_IN_DAYLIGHT, new GeneChildrenBurnInDaylight());
        geneRegistry.registerGene(Genes.GENE_IS_TAMEABLE, new GeneIsTameable());

        geneRegistry.registerGene(Genes.GENE_AI_ARROW_ATTACK_MAX_RANGED_ATTACK_TIME, new GeneAIArrowAttackMaxRangedAttackTime());
        geneRegistry.registerGene(Genes.GENE_AI_ARROW_ATTACK_MIN_RANGED_ATTACK_TIME, new GeneAIArrowAttackMinRangedAttackTime());
        geneRegistry.registerGene(Genes.GENE_AI_ARROW_ATTACK_MOVE_SPEED, new GeneAIArrowAttackMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_ARROW_ATTACK_RANGED_ATTACK_TIME_MODIFIER, new GeneAIArrowAttackRangedAttackTimeModifier());
        geneRegistry.registerGene(Genes.GENE_AI_ARROW_ATTACK_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_ARROW_ATTACK, new GeneAIArrowAttack());

        geneRegistry.registerGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_TARGET, new GeneAIAttackOnCollideTarget());
        geneRegistry.registerGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_MOVE_SPEED, new GeneAIAttackOnCollideMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_LONG_MEMORY, new GeneAIAttackOnCollideLongMemory());
        geneRegistry.registerGene(Genes.GENE_AI_ATTACK_ON_COLLIDE_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_ATTACK_ON_COLLIDE, new GeneAIAttackOnCollide());

        geneRegistry.registerGene(Genes.GENE_AI_AVOID_ENTITY_TARGET, new GeneAIAvoidEntityTarget());
        geneRegistry.registerGene(Genes.GENE_AI_AVOID_ENTITY_RANGE, new GeneAIAvoidEntityRange());
        geneRegistry.registerGene(Genes.GENE_AI_AVOID_ENTITY_NEAR_SPEED, new GeneAIAvoidEntityNearSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_AVOID_ENTITY_FAR_SPEED, new GeneAIAvoidEntityFarSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_AVOID_ENTITY_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_AVOID_ENTITY, new GeneAIAvoidEntity());

        geneRegistry.registerGene(Genes.GENE_AI_BEG_RANGE, new GeneAIBegRange());
        geneRegistry.registerGene(Genes.GENE_AI_BEG_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_BEG, new GeneAIBeg());

        geneRegistry.registerGene(Genes.GENE_AI_BREAK_DOOR_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_BREAK_DOOR, new GeneAIBreakDoor());

        geneRegistry.registerGene(Genes.GENE_AI_CONTROLLED_BY_PLAYER_MAX_SPEED, new GeneAIControlledByPlayerMaxSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_CONTROLLED_BY_PLAYER_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_CONTROLLED_BY_PLAYER, new GeneAIControlledByPlayer());

        geneRegistry.registerGene(Genes.GENE_AI_CREEPER_SWELL_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_CREEPER_SWELL, new GeneAICreeperSwell());

        geneRegistry.registerGene(Genes.GENE_AI_DEFEND_VILLAGE_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_DEFEND_VILLAGE, new GeneAIDefendVillage());

        geneRegistry.registerGene(Genes.GENE_AI_EAT_GRASS_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_EAT_GRASS, new GeneAIEatGrass());

        geneRegistry.registerGene(Genes.GENE_AI_FLEE_SUN_MOVE_SPEED, new GeneAIFleeSunMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_FLEE_SUN_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_FLEE_SUN, new GeneAIFleeSun());

        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_GOLEM_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_GOLEM, new GeneAIFollowGolem());

        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_OWNER_MOVE_SPEED, new GeneAIFollowOwnerMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_OWNER_MIN_DISTANCE, new GeneAIFollowOwnerMinDistance());
        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_OWNER_MAX_DISTANCE, new GeneAIFollowOwnerMaxDistance());
        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_OWNER_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_FOLLOW_OWNER, new GeneAIFollowOwner());

        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_PARENT_MOVE_SPEED, new GeneAIFollowParentMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_FOLLOW_PARENT_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_FOLLOW_PARENT, new GeneAIFollowParent());

        geneRegistry.registerGene(Genes.GENE_AI_HURT_BY_TARGET_CALL_HELP, new GeneAIHurtByTargetCallHelp());
        geneRegistry.registerGene(Genes.GENE_AI_HURT_BY_TARGET_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_HURT_BY_TARGET, new GeneAIHurtByTarget());

        geneRegistry.registerGene(Genes.GENE_AI_LEAP_AT_TARGET_MOTION_Y, new GeneAILeapAtTargetMotionY());
        geneRegistry.registerGene(Genes.GENE_AI_LEAP_AT_TARGET_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_LEAP_AT_TARGET, new GeneAILeapAtTarget());

        geneRegistry.registerGene(Genes.GENE_AI_LOOK_AT_TRADE_PLAYER_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_LOOK_AT_TRADE_PLAYER, new GeneAILookAtTradePlayer());

        geneRegistry.registerGene(Genes.GENE_AI_LOOK_AT_VILLAGER_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_LOOK_AT_VILLAGER, new GeneAILookAtVillager());

        geneRegistry.registerGene(Genes.GENE_AI_LOOK_IDLE_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_LOOK_IDLE, new GeneAILookIdle());

        geneRegistry.registerGene(Genes.GENE_AI_MATE_MOVE_SPEED, new GeneAIMateMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_MATE_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_MATE, new GeneAIMate());

        geneRegistry.registerGene(Genes.GENE_AI_MOVE_INDOORS_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_INDOORS, new GeneAIMoveIndoors());

        geneRegistry.registerGene(Genes.GENE_AI_MOVE_THROUGH_VILLAGE_MOVE_SPEED, new GeneAIMoveThroughVillageMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_THROUGH_VILLAGE_IS_NOCTURNAL, new GeneAIMoveThroughVillageIsNocturnal());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_THROUGH_VILLAGE_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_MOVE_THROUGH_VILLAGE, new GeneAIMoveThroughVillage());

        geneRegistry.registerGene(Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION_MOVE_SPEED, new GeneAIMoveTowardsRestrictionMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION, new GeneAIMoveThroughVillage());

        geneRegistry.registerGene(Genes.GENE_AI_MOVE_TOWARDS_TARGET_MOVE_SPEED, new GeneAIMoveTowardsTargetMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_TOWARDS_TARGET_MAX_DISTANCE, new GeneAIMoveTowardsTargetMaxDistance());
        geneRegistry.registerGene(Genes.GENE_AI_MOVE_TOWARDS_TARGET_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_MOVE_TOWARDS_TARGET, new GeneAIMoveTowardsTarget());

        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET, new GeneAINearestAttackableTargetTarget());
        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET_CHANCE, new GeneAINearestAttackableTargetTargetChance());
        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_VISIBLE, new GeneAINearestAttackableTargetVisible());
        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_NEARBY_ONLY, new GeneAINearestAttackableTargetNearbyOnly());
        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_ENTITY_SELECTOR, new GeneAINearestAttackableTargetEntitySelector());
        geneRegistry.registerGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET, new GeneAINearestAttackableTarget());

        geneRegistry.registerGene(Genes.GENE_AI_OCELOT_ATTACK_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_OCELOT_ATTACK, new GeneAIOcelotAttack());

        geneRegistry.registerGene(Genes.GENE_AI_OCELOT_SIT_MOVE_SPEED, new GeneAIOcelotSitMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_OCELOT_SIT_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_OCELOT_SIT, new GeneAIOcelotSit());

        geneRegistry.registerGene(Genes.GENE_AI_OPEN_DOOR_CLOSE_DOOR, new GeneAIOpenDoorCloseDoor());
        geneRegistry.registerGene(Genes.GENE_AI_OPEN_DOOR_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_OPEN_DOOR, new GeneAIOpenDoor());

        geneRegistry.registerGene(Genes.GENE_AI_OWNER_HURT_BY_TARGET_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_OWNER_HURT_BY_TARGET, new GeneAIOwnerHurtByTarget());

        geneRegistry.registerGene(Genes.GENE_AI_OWNER_HURT_TARGET_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_OWNER_HURT_TARGET, new GeneAIOwnerHurtTarget());

        geneRegistry.registerGene(Genes.GENE_AI_PANIC_MOVE_SPEED, new GeneAIPanicMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_PANIC_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_PANIC, new GeneAIPanic());

        geneRegistry.registerGene(Genes.GENE_AI_PLAY_MOVE_SPEED, new GeneAIPlayMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_PLAY_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_PLAY, new GeneAIPlay());

        geneRegistry.registerGene(Genes.GENE_AI_RESTRICT_OPEN_DOOR_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_RESTRICT_OPEN_DOOR, new GeneAIRestrictOpenDoor());

        geneRegistry.registerGene(Genes.GENE_AI_RESTRICT_SUN_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_RESTRICT_SUN, new GeneAIRestrictSun());

        geneRegistry.registerGene(Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY_MOVE_SPEED, new GeneAIRunAroundLikeCrazyMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY, new GeneAIRunAroundLikeCrazy());

        geneRegistry.registerGene(Genes.GENE_AI_SIT_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_SIT, new GeneAISit());

        geneRegistry.registerGene(Genes.GENE_AI_SWIMMING_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_SWIMMING, new GeneAISwimming());

        geneRegistry.registerGene(Genes.GENE_AI_TARGET_NON_TAMED_VISIBLE, new GeneAITargetNonTamedVisible());
        geneRegistry.registerGene(Genes.GENE_AI_TARGET_NON_TAMED_TARGET_CHANCE, new GeneAITargetNonTamedTargetChance());
        geneRegistry.registerGene(Genes.GENE_AI_TARGET_NON_TAMED_TARGET, new GeneAITargetNonTamedTarget());
        geneRegistry.registerGene(Genes.GENE_AI_TARGET_NON_TAMED_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_TARGET_NON_TAMED, new GeneAITargetNonTamed());

        geneRegistry.registerGene(Genes.GENE_AI_TEMPT_ITEM, new GeneAITemptItem());
        geneRegistry.registerGene(Genes.GENE_AI_TEMPT_MOVE_SPEED, new GeneAITemptMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_TEMPT_SCARED_BY_PLAYER, new GeneAITemptScaredByPlayer());
        geneRegistry.registerGene(Genes.GENE_AI_TEMPT_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_TEMPT, new GeneAITempt());

        geneRegistry.registerGene(Genes.GENE_AI_TRADE_PLAYER_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_TRADE_PLAYER, new GeneAITradePlayer());

        geneRegistry.registerGene(Genes.GENE_AI_VILLAGER_MATE_INDEX, new GeneAIIndex());
        geneRegistry.registerGene(Genes.GENE_AI_VILLAGER_MATE, new GeneAIVillagerMate());

        geneRegistry.registerGene(Genes.GENE_AI_WANDER_MOVE_SPEED, new GeneAIWanderMoveSpeed());
        geneRegistry.registerGene(Genes.GENE_AI_WANDER_INDEX, new GeneAIIndex());
        geneRegistry.registerMasterGene(Genes.GENE_AI_WANDER, new GeneAIWander());

        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_TARGET, new GeneAIWatchClosestTarget());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_RANGE, new GeneAIWatchClosestRange());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_CHANCE, new GeneAIWatchClosestChance());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_WATCH_CLOSEST, new GeneAIWatchClosest());

        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_2_TARGET, new GeneAIWatchClosest2Target());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_2_RANGE, new GeneAIWatchClosest2Range());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_2_CHANCE, new GeneAIWatchClosest2Chance());
        geneRegistry.registerGene(Genes.GENE_AI_WATCH_CLOSEST_2_INDEX, new GeneAIIndexArray());
        geneRegistry.registerMasterGene(Genes.GENE_AI_WATCH_CLOSEST_2, new GeneAIWatchClosest2());



        geneRegistry.registerMasterGene(Genes.GENE_USE_NEW_AI, new GeneUseNewAI());
        geneRegistry.registerMasterGene(Genes.GENE_USE_OLD_AI, new GeneUseOldAI());

        geneRegistry.registerGene(Genes.GENE_MODEL_BODY, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_HEAD, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_ARM_LEFT, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_ARM_RIGHT, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_LEG_LEFT, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_LEG_RIGHT, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_EARS, new GeneModel());
        geneRegistry.registerGene(Genes.GENE_MODEL_CLOAK, new GeneModel());

        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_ARM_LEFT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_ARM_RIGHT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_BODY, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_CLOAK, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_EARS, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_HEAD, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_WAVE_LEG_LEFT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_WAVE_LEG_RIGHT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_WAVE_ARM_LEFT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_WAVE_ARM_RIGHT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_LEG_LEFT, new GeneAnim());
        geneRegistry.registerGene(Genes.GENE_ANIM_LINEAR_LEG_RIGHT, new GeneAnim());

        geneRegistry.registerGene(Genes.GENE_TEXTURE, new GeneTexture());

        traitRegistry.registerTrait(Traits.TRAIT_FIRE, new TraitFire());
        traitRegistry.registerTrait(Traits.TRAIT_MOVEMENT, new TraitMovement());
        traitRegistry.registerTrait(Traits.TRAIT_ATTACKED, new TraitAttacked());
        traitRegistry.registerTrait(Traits.TRAIT_ITEM_PICKUP, new TraitItemPickup());
        traitRegistry.registerTrait(Traits.TRAIT_ITEM_DROPS, new TraitItemDrops());
        traitRegistry.registerTrait(Traits.TRAIT_FLUIDS, new TraitFluids());
        traitRegistry.registerTrait(Traits.TRAIT_SOUNDS, new TraitSounds());
        traitRegistry.registerTrait(Traits.TRAIT_ATTRIBUTES, new TraitInitialValues());
        traitRegistry.registerTrait(Traits.TRAIT_ATTACK, new TraitAttack());
        traitRegistry.registerTrait(Traits.TRAIT_AI, new TraitAI());
        traitRegistry.registerTrait(Traits.TRAIT_RENDER, new TraitRender());
        traitRegistry.registerTrait(Traits.TRAIT_HOME_AREA, new TraitHomeArea());
        traitRegistry.registerTrait(Traits.TRAIT_TEXTURE, new TraitTexture());

        standardSoulRegistry.register(new StandardSoulZombie(), EntityZombie.class);
    }
}
