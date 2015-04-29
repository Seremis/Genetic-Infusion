package seremis.geninfusion.soul.standardSoul

import net.minecraft.client.model.ModelSkeleton
import net.minecraft.entity.monster.EntityCreeper
import net.minecraft.entity.passive.{EntityChicken, EntityTameable}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{EntityCreature, EntityLiving, SharedMonsterAttributes}
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import seremis.geninfusion.api.soul.EnumAlleleType._
import seremis.geninfusion.api.soul.lib.Genes._
import seremis.geninfusion.api.soul.util.ModelPart
import seremis.geninfusion.api.soul.{IChromosome, IStandardSoul}
import seremis.geninfusion.soul.{Allele, Chromosome}

abstract class StandardSoul extends IStandardSoul {

    override def getChromosomeFromGene(entity: EntityLiving, gene: String): IChromosome = {

        //Automatically detected genes.
        if(gene == GENE_ATTACK_DAMAGE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.attackDamage).getBaseValue, DOUBLE))
        if(gene == GENE_CREATURE_ATTRIBUTE)
            return new Chromosome(new Allele(true, entity.getCreatureAttribute.ordinal(), INTEGER))
        if(gene == GENE_FOLLOW_RANGE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.followRange).getBaseValue, DOUBLE))
        if(gene == GENE_IMMUNE_TO_FIRE)
            return new Chromosome(new Allele(true, entity.isImmuneToFire, BOOLEAN))
        if(gene == GENE_INVULNERABLE)
            return new Chromosome(new Allele(true, entity.isEntityInvulnerable, BOOLEAN))
        //TODO remove is_creature gene
        if(gene == GENE_IS_CREATURE)
            return new Chromosome(new Allele(false, entity.isInstanceOf[EntityCreature], BOOLEAN))
        if(gene == GENE_KNOCKBACK_RESISTANCE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.knockbackResistance).getBaseValue, DOUBLE))
        if(gene == GENE_MAX_HEALTH)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.maxHealth).getBaseValue, DOUBLE))
        if(gene == GENE_MAX_HURT_RESISTANT_TIME)
            return new Chromosome(new Allele(true, entity.maxHurtResistantTime, INTEGER))
        if(gene == GENE_MOVEMENT_SPEED)
            return new Chromosome(new Allele(true, entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue, DOUBLE))
        if(gene == GENE_PORTAL_COOLDOWN)
            return new Chromosome(new Allele(true, entity.getPortalCooldown, INTEGER))
        if(gene == GENE_TALK_INTERVAL)
            return new Chromosome(new Allele(true, entity.getTalkInterval, INTEGER))
        if(gene == GENE_TELEPORT_TIME_IN_PORTAL)
            return new Chromosome(new Allele(true, entity.getMaxInPortalTime, INTEGER))
        if(gene == GENE_VERTICAL_FACE_SPEED)
            return new Chromosome(new Allele(true, entity.getVerticalFaceSpeed, INTEGER))
        //TODO better isTameable check
        if(gene == GENE_IS_TAMEABLE)
            return new Chromosome(new Allele(true, entity.isInstanceOf[EntityTameable], BOOLEAN))


        //Manual genes.
        if(gene == GENE_BURNS_IN_DAYLIGHT) 
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_CEASE_AI_MOVEMENT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_CHILDREN_BURN_IN_DAYLIGHT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_DEATH_SOUND)
            return new Chromosome(new Allele(false, "game.hostile.die", STRING))
        if(gene == GENE_DROWNS_IN_AIR)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_DROWNS_IN_WATER)
            return new Chromosome(new Allele(false, true, BOOLEAN))
        if(gene == GENE_EQUIPMENT_DROP_CHANCES)
            return new Chromosome(new Allele(true, Array(0.085F, 0.085F, 0.085F, 0.085F, 0.085F), FLOAT_ARRAY))
        if(gene == GENE_EXPERIENCE_VALUE)
            return new Chromosome(new Allele(true, 5, INTEGER))
        if(gene == GENE_HURT_SOUND)
            return new Chromosome(new Allele(true, "mob.hostile.hurt", STRING))
        if(gene == GENE_ITEM_DROPS)
            return new Chromosome(new Allele(true, null, ITEMSTACK_ARRAY))
        if(gene == GENE_LIVING_SOUND)
            return new Chromosome(new Allele(false, null, STRING))
        if(gene == GENE_PICKS_UP_ITEMS)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_RARE_ITEM_DROP_CHANCES)
            return new Chromosome(new Allele(true, Array(0.33F, 0.33F, 0.33F), FLOAT_ARRAY))
        if(gene == GENE_RARE_ITEM_DROPS)
            return new Chromosome(new Allele(true, null, ITEMSTACK_ARRAY))
        if(gene == GENE_SET_ON_FIRE_FROM_ATTACK)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_SHOULD_DESPAWN)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_SOUND_VOLUME)
            return new Chromosome(new Allele(true, 1F, FLOAT))
        if(gene == GENE_SPLASH_SOUND)
            return new Chromosome(new Allele(true, "game.neutral.swim.splash", STRING))
        if(gene == GENE_SWIM_SOUND)
            return new Chromosome(new Allele(true, "game.neutral.swim", STRING))
        if(gene == GENE_WALK_SOUND)
            return new Chromosome(new Allele(true, "mob.neutral.step", STRING))
        if(gene == GENE_USE_NEW_AI)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_USE_OLD_AI)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_CAN_BE_CHARGED)
            return new Chromosome(new Allele(true, false, BOOLEAN))

        //AI genes
        if(gene == GENE_AI_ARROW_ATTACK)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_ARROW_ATTACK_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))
        if(gene == GENE_AI_ARROW_ATTACK_MAX_RANGED_ATTACK_TIME)
            return new Chromosome(new Allele(false, 0, INTEGER))
        if(gene == GENE_AI_ARROW_ATTACK_MIN_RANGED_ATTACK_TIME)
            return new Chromosome(new Allele(false, 0, INTEGER))
        if(gene == GENE_AI_ARROW_ATTACK_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))
        if(gene == GENE_AI_ARROW_ATTACK_RANGED_ATTACK_TIME_MODIFIER)
            return new Chromosome(new Allele(false, 1.0F, FLOAT))

        if(gene == GENE_AI_ATTACK_ON_COLLIDE)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_ATTACK_ON_COLLIDE_INDEX)
            return new Chromosome(new Allele(true, Array(2), INTEGER_ARRAY))
        if(gene == GENE_AI_ATTACK_ON_COLLIDE_LONG_MEMORY)
            return new Chromosome(new Allele(false, Array(false), BOOLEAN_ARRAY))
        if(gene == GENE_AI_ATTACK_ON_COLLIDE_MOVE_SPEED)
            return new Chromosome(new Allele(false, Array(1.0D), DOUBLE_ARRAY))
        if(gene == GENE_AI_ATTACK_ON_COLLIDE_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityPlayer]), CLASS_ARRAY))

        if(gene == GENE_AI_AVOID_ENTITY)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_AVOID_ENTITY_INDEX)
            return new Chromosome(new Allele(false, Array(3), INTEGER_ARRAY))
        if(gene == GENE_AI_AVOID_ENTITY_FAR_SPEED)
            return new Chromosome(new Allele(false, Array(1.0D), DOUBLE_ARRAY))
        if(gene == GENE_AI_AVOID_ENTITY_NEAR_SPEED)
            return new Chromosome(new Allele(false, Array(1.2D), DOUBLE_ARRAY))
        if(gene == GENE_AI_AVOID_ENTITY_RANGE)
            return new Chromosome(new Allele(false, Array(6.0F), FLOAT_ARRAY))
        if(gene == GENE_AI_AVOID_ENTITY_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityCreeper]), CLASS_ARRAY))

        if(gene == GENE_AI_BEG)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_BEG_INDEX)
            return new Chromosome(new Allele(true, 8, INTEGER))
        if(gene == GENE_AI_BEG_RANGE)
            return new Chromosome(new Allele(false, 0.0F, FLOAT))

        if(gene == GENE_AI_BREAK_DOOR)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_BREAK_DOOR_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))

        if(gene == GENE_AI_CONTROLLED_BY_PLAYER)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_CONTROLLED_BY_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))
        if(gene == GENE_AI_CONTROLLED_BY_PLAYER_MAX_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_CREEPER_SWELL)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_CREEPER_SWELL_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))

        if(gene == GENE_AI_DEFEND_VILLAGE)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_DEFEND_VILLAGE_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))

        if(gene == GENE_AI_EAT_GRASS)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_EAT_GRASS_INDEX)
            return new Chromosome(new Allele(true, 5, INTEGER))

        if(gene == GENE_AI_FLEE_SUN)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_FLEE_SUN_INDEX)
            return new Chromosome(new Allele(true, 3, INTEGER))
        if(gene == GENE_AI_FLEE_SUN_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_FOLLOW_GOLEM)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_FOLLOW_GOLEM_INDEX)
            return new Chromosome(new Allele(true, 7, INTEGER))

        if(gene == GENE_AI_FOLLOW_OWNER)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_FOLLOW_OWNER_INDEX)
            return new Chromosome(new Allele(true, 5, INTEGER))
        if(gene == GENE_AI_FOLLOW_OWNER_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))
        if(gene == GENE_AI_FOLLOW_OWNER_MIN_DISTANCE)
            return new Chromosome(new Allele(false, 5.0F, FLOAT))
        if(gene == GENE_AI_FOLLOW_OWNER_MAX_DISTANCE)
            return new Chromosome(new Allele(true, 10.0F, FLOAT))

        if(gene == GENE_AI_FOLLOW_PARENT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_FOLLOW_PARENT_INDEX)
            return new Chromosome(new Allele(true, 4, INTEGER))
        if(gene == GENE_AI_FOLLOW_PARENT_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_HURT_BY_TARGET)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_HURT_BY_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))
        if(gene == GENE_AI_HURT_BY_TARGET_CALL_HELP)
            return new Chromosome(new Allele(true, false, BOOLEAN))

        if(gene == GENE_AI_LEAP_AT_TARGET)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_LEAP_AT_TARGET_INDEX)
            return new Chromosome(new Allele(true, 3, INTEGER))
        if(gene == GENE_AI_LEAP_AT_TARGET_MOTION_Y)
            return new Chromosome(new Allele(false, 0.4F, FLOAT))

        if(gene == GENE_AI_LOOK_AT_TRADE_PLAYER)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_LOOK_AT_TRADE_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))

        if(gene == GENE_AI_LOOK_AT_VILLAGER)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_LOOK_AT_VILLAGER_INDEX)
            return new Chromosome(new Allele(true, 5, INTEGER))

        if(gene == GENE_AI_LOOK_IDLE)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_LOOK_IDLE_INDEX)
            return new Chromosome(new Allele(true, 8, INTEGER))

        if(gene == GENE_AI_MATE)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_MATE_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))
        if(gene == GENE_AI_MATE_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_MOVE_INDOORS)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_MOVE_INDOORS_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))

        if(gene == GENE_AI_MOVE_THROUGH_VILLAGE)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_MOVE_THROUGH_VILLAGE_INDEX)
            return new Chromosome(new Allele(true, 3, INTEGER))
        if(gene == GENE_AI_MOVE_THROUGH_VILLAGE_IS_NOCTURNAL)
            return new Chromosome(new Allele(false, true, BOOLEAN))
        if(gene == GENE_AI_MOVE_THROUGH_VILLAGE_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_MOVE_TOWARDS_RESTRICTION)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_MOVE_TOWARDS_RESTRICTION_INDEX)
            return new Chromosome(new Allele(true, 5, INTEGER))
        if(gene == GENE_AI_MOVE_TOWARDS_RESTRICTION_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_MOVE_TOWARDS_TARGET)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_MOVE_TOWARDS_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))
        if(gene == GENE_AI_MOVE_TOWARDS_TARGET_MAX_DISTANCE)
            return new Chromosome(new Allele(true, 32.0F, FLOAT))
        if(gene == GENE_AI_MOVE_TOWARDS_TARGET_MOVE_SPEED)
            return new Chromosome(new Allele(true, 0.9D, DOUBLE))

        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_INDEX)
            return new Chromosome(new Allele(true, Array(2), INTEGER_ARRAY))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_ENTITY_SELECTOR)
            return new Chromosome(new Allele(true, Array(""), STRING_ARRAY))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_NEARBY_ONLY)
            return new Chromosome(new Allele(true, Array(false), BOOLEAN_ARRAY))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityPlayer]), CLASS_ARRAY))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET_CHANCE)
            return new Chromosome(new Allele(true, Array(0), INTEGER_ARRAY))
        if(gene == GENE_AI_NEAREST_ATTACKABLE_TARGET_VISIBLE)
            return new Chromosome(new Allele(true, Array(false), BOOLEAN_ARRAY))

        if(gene == GENE_AI_OCELOT_ATTACK)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_OCELOT_ATTACK_INDEX)
            return new Chromosome(new Allele(true, 8, INTEGER))

        if(gene == GENE_AI_OCELOT_SIT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_OCELOT_SIT_INDEX)
            return new Chromosome(new Allele(true, 6, INTEGER))
        if(gene == GENE_AI_OCELOT_SIT_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_OPEN_DOOR)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_OPEN_DOOR_INDEX)
            return new Chromosome(new Allele(true, 4, INTEGER))
        if(gene == GENE_AI_OPEN_DOOR_CLOSE_DOOR)
            return new Chromosome(new Allele(false, true, BOOLEAN))

        if(gene == GENE_AI_OWNER_HURT_BY_TARGET)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_OWNER_HURT_BY_TARGET_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))
        if(gene == GENE_AI_OWNER_HURT_TARGET)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_OWNER_HURT_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))

        if(gene == GENE_AI_PANIC)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_PANIC_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))
        if(gene == GENE_AI_PANIC_MOVE_SPEED)
            return new Chromosome(new Allele(true, 1.25D, DOUBLE))

        if(gene == GENE_AI_PLAY)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_PLAY_INDEX)
            return new Chromosome(new Allele(true, 8, INTEGER))
        if(gene == GENE_AI_PLAY_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_RESTRICT_OPEN_DOOR)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_RESTRICT_OPEN_DOOR_INDEX)
            return new Chromosome(new Allele(true, 3, INTEGER))
        if(gene == GENE_AI_RESTRICT_SUN)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_RESTRICT_SUN_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))

        if(gene == GENE_AI_RUN_AROUND_LIKE_CRAZY)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_RUN_AROUND_LIKE_CRAZY_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))
        if(gene == GENE_AI_RUN_AROUND_LIKE_CRAZY_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, DOUBLE))

        if(gene == GENE_AI_SIT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_SIT_INDEX)
            return new Chromosome(new Allele(true, 2, INTEGER))

        if(gene == GENE_AI_SWIMMING)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_SWIMMING_INDEX)
            return new Chromosome(new Allele(true, 0, INTEGER))

        if(gene == GENE_AI_TARGET_NON_TAMED)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_TARGET_NON_TAMED_INDEX)
            return new Chromosome(new Allele(true, Array(1), INTEGER_ARRAY))
        if(gene == GENE_AI_TARGET_NON_TAMED_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityChicken]), CLASS_ARRAY))
        if(gene == GENE_AI_TARGET_NON_TAMED_TARGET_CHANCE)
            return new Chromosome(new Allele(true, Array(750), INTEGER_ARRAY))
        if(gene == GENE_AI_TARGET_NON_TAMED_VISIBLE)
            return new Chromosome(new Allele(true, Array(false), BOOLEAN_ARRAY))

        if(gene == GENE_AI_TEMPT)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_TEMPT_INDEX)
            return new Chromosome(new Allele(true, Array(2), INTEGER_ARRAY))
        if(gene == GENE_AI_TEMPT_ITEM)
            return new Chromosome(new Allele(true, Array(new ItemStack(Items.wheat)), ITEMSTACK_ARRAY))
        if(gene == GENE_AI_TEMPT_MOVE_SPEED)
            return new Chromosome(new Allele(true, Array(1.2D), DOUBLE_ARRAY))
        if(gene == GENE_AI_TEMPT_SCARED_BY_PLAYER)
            return new Chromosome(new Allele(true, Array(false), BOOLEAN_ARRAY))

        if(gene == GENE_AI_TRADE_PLAYER)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_TRADE_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 1, INTEGER))

        if(gene == GENE_AI_VILLAGER_MATE)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_VILLAGER_MATE_INDEX)
            return new Chromosome(new Allele(true, 6, INTEGER))

        if(gene == GENE_AI_WANDER)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_WANDER_INDEX)
            return new Chromosome(new Allele(true, 5, INTEGER))
        if(gene == GENE_AI_WANDER_MOVE_SPEED)
            return new Chromosome(new Allele(true, 1.0D, DOUBLE))

        if(gene == GENE_AI_WATCH_CLOSEST)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_AI_WATCH_CLOSEST_INDEX)
            return new Chromosome(new Allele(true, Array(6), INTEGER_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_CHANCE)
            return new Chromosome(new Allele(true, Array(0.02F), FLOAT_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_RANGE)
            return new Chromosome(new Allele(true, Array(8.0F), FLOAT_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityPlayer]), CLASS_ARRAY))

        if(gene == GENE_AI_WATCH_CLOSEST_2)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_AI_WATCH_CLOSEST_2_INDEX)
            return new Chromosome(new Allele(true, Array(9), INTEGER_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_2_CHANCE)
            return new Chromosome(new Allele(true, Array(1.0F), FLOAT_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_2_RANGE)
            return new Chromosome(new Allele(true, Array(3.0F), FLOAT_ARRAY))
        if(gene == GENE_AI_WATCH_CLOSEST_2_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityPlayer]), CLASS_ARRAY))

        //Rendering related Genes.
        if(gene == GENE_MODEL)
            return new Chromosome(new Allele(true, ModelPart.getModelPartsFromModel(new ModelSkeleton(), entity), MODELPART_ARRAY))
        if(gene == GENE_TEXTURE)
            return new Chromosome(new Allele(true, "textures/entity/skeleton/skeleton.png", STRING), new Allele(false, "textures/entity/skeleton/skeleton.png", STRING))


        //Explosion related genes
        if(gene == GENE_EXPLODES)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_FUSE_TIME)
            return new Chromosome(new Allele(true, 30, INTEGER))
        if(gene == GENE_EXPLOSION_RADIUS)
            return new Chromosome(new Allele(true, 3, INTEGER))
        if(gene == GENE_FLINT_AND_STEEL_IGNITE)
            return new Chromosome(new Allele(true, true, BOOLEAN))
        if(gene == GENE_CAN_BE_CHARGED)
            return new Chromosome(new Allele(true, true, BOOLEAN))

        if(gene == GENE_DROPS_ITEM_WHEN_KILLED_BY_SPECIFIC_ENTITY)
            return new Chromosome(new Allele(true, false, BOOLEAN))
        if(gene == GENE_KILLED_BY_SPECIFIC_ENTITY_DROPS)
            return new Chromosome(new Allele(false, null, ITEMSTACK_ARRAY))
        if(gene == GENE_KILLED_BY_SPECIFIC_ENTITY_ENTITY)
            return new Chromosome(new Allele(false, null, CLASS))

        null
    }
}