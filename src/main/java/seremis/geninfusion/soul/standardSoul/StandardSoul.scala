package seremis.geninfusion.soul.standardSoul

import net.minecraft.client.model.ModelSkeleton
import net.minecraft.entity.monster.EntityCreeper
import net.minecraft.entity.passive.{EntityChicken, EntityTameable}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{EntityCreature, EntityLiving, SharedMonsterAttributes}
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import seremis.geninfusion.api.soul.lib.Genes
import seremis.geninfusion.api.soul.util.ModelPart
import seremis.geninfusion.api.soul.{EnumAlleleType, IChromosome, IStandardSoul}
import seremis.geninfusion.soul.{Allele, Chromosome}

abstract class StandardSoul extends IStandardSoul {

    override def getChromosomeFromGene(entity: EntityLiving, gene: String): IChromosome = {

        //Automatically detected genes.
        if(gene == Genes.GENE_ATTACK_DAMAGE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.attackDamage).getBaseValue, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_CREATURE_ATTRIBUTE)
            return new Chromosome(new Allele(true, entity.getCreatureAttribute.ordinal(), EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_FOLLOW_RANGE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.followRange).getBaseValue, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_IMMUNE_TO_FIRE)
            return new Chromosome(new Allele(true, entity.isImmuneToFire, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_INVULNERABLE)
            return new Chromosome(new Allele(true, entity.isEntityInvulnerable, EnumAlleleType.BOOLEAN))
        //TODO remove is_creature gene
        if(gene == Genes.GENE_IS_CREATURE)
            return new Chromosome(new Allele(false, entity.isInstanceOf[EntityCreature], EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_KNOCKBACK_RESISTANCE)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.knockbackResistance).getBaseValue, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_MAX_HEALTH)
            return new Chromosome(new Allele(true, entity.getAttributeMap.getAttributeInstance(SharedMonsterAttributes.maxHealth).getBaseValue, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_MAX_HURT_RESISTANT_TIME)
            return new Chromosome(new Allele(true, entity.maxHurtResistantTime, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_MOVEMENT_SPEED)
            return new Chromosome(new Allele(true, entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_PORTAL_COOLDOWN)
            return new Chromosome(new Allele(true, entity.getPortalCooldown, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_TALK_INTERVAL)
            return new Chromosome(new Allele(true, entity.getTalkInterval, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_TELEPORT_TIME_IN_PORTAL)
            return new Chromosome(new Allele(true, entity.getMaxInPortalTime, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_VERTICAL_FACE_SPEED)
            return new Chromosome(new Allele(true, entity.getVerticalFaceSpeed, EnumAlleleType.INTEGER))
        //TODO better isTameable check
        if(gene == Genes.GENE_IS_TAMEABLE)
            return new Chromosome(new Allele(true, entity.isInstanceOf[EntityTameable], EnumAlleleType.BOOLEAN))


        //Manual genes.
        if(gene == Genes.GENE_BURNS_IN_DAYLIGHT) 
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_CEASE_AI_MOVEMENT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_CHILDREN_BURN_IN_DAYLIGHT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_DEATH_SOUND)
            return new Chromosome(new Allele(false, "game.hostile.die", EnumAlleleType.STRING))
        if(gene == Genes.GENE_DROWNS_IN_AIR)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_DROWNS_IN_WATER)
            return new Chromosome(new Allele(false, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_EQUIPMENT_DROP_CHANCES)
            return new Chromosome(new Allele(true, Array(0.085F, 0.085F, 0.085F, 0.085F, 0.085F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_EXPERIENCE_VALUE)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_HURT_SOUND)
            return new Chromosome(new Allele(true, "mob.hostile.hurt", EnumAlleleType.STRING))
        if(gene == Genes.GENE_ITEM_DROPS)
            return new Chromosome(new Allele(true, Array(null.asInstanceOf[ItemStack]), EnumAlleleType.ITEMSTACK_ARRAY))
        if(gene == Genes.GENE_LIVING_SOUND)
            return new Chromosome(new Allele(false, null, EnumAlleleType.STRING))
        if(gene == Genes.GENE_PICKS_UP_ITEMS)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_RARE_ITEM_DROP_CHANCES)
            return new Chromosome(new Allele(true, Array(0.33F, 0.33F, 0.33F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_RARE_ITEM_DROPS)
            return new Chromosome(new Allele(true, Array(null.asInstanceOf[ItemStack]), EnumAlleleType.ITEMSTACK_ARRAY))
        if(gene == Genes.GENE_SET_ON_FIRE_FROM_ATTACK)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_SHOULD_DESPAWN)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_SOUND_VOLUME)
            return new Chromosome(new Allele(true, 1F, EnumAlleleType.FLOAT))
        if(gene == Genes.GENE_SPLASH_SOUND)
            return new Chromosome(new Allele(true, "game.neutral.swim.splash", EnumAlleleType.STRING))
        if(gene == Genes.GENE_SWIM_SOUND)
            return new Chromosome(new Allele(true, "game.neutral.swim", EnumAlleleType.STRING))
        if(gene == Genes.GENE_WALK_SOUND)
            return new Chromosome(new Allele(true, "mob.neutral.step", EnumAlleleType.STRING))
        if(gene == Genes.GENE_USE_NEW_AI)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_USE_OLD_AI)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))

        //AI genes
        if(gene == Genes.GENE_AI_ARROW_ATTACK)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_ARROW_ATTACK_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_ARROW_ATTACK_MAX_RANGED_ATTACK_TIME)
            return new Chromosome(new Allele(false, 0, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_ARROW_ATTACK_MIN_RANGED_ATTACK_TIME)
            return new Chromosome(new Allele(false, 0, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_ARROW_ATTACK_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_AI_ARROW_ATTACK_RANGED_ATTACK_TIME_MODIFIER)
            return new Chromosome(new Allele(false, 1.0F, EnumAlleleType.FLOAT))

        if(gene == Genes.GENE_AI_ATTACK_ON_COLLIDE)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_ATTACK_ON_COLLIDE_INDEX)
            return new Chromosome(new Allele(true, Array(2), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_ATTACK_ON_COLLIDE_LONG_MEMORY)
            return new Chromosome(new Allele(false, Array(false), EnumAlleleType.BOOLEAN_ARRAY))
        if(gene == Genes.GENE_AI_ATTACK_ON_COLLIDE_MOVE_SPEED)
            return new Chromosome(new Allele(false, Array(1.0D), EnumAlleleType.DOUBLE_ARRAY))
        if(gene == Genes.GENE_AI_ATTACK_ON_COLLIDE_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityPlayer]), EnumAlleleType.CLASS_ARRAY))

        if(gene == Genes.GENE_AI_AVOID_ENTITY)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_AVOID_ENTITY_INDEX)
            return new Chromosome(new Allele(false, Array(3), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_AVOID_ENTITY_FAR_SPEED)
            return new Chromosome(new Allele(false, Array(1.0D), EnumAlleleType.DOUBLE_ARRAY))
        if(gene == Genes.GENE_AI_AVOID_ENTITY_NEAR_SPEED)
            return new Chromosome(new Allele(false, Array(1.2D), EnumAlleleType.DOUBLE_ARRAY))
        if(gene == Genes.GENE_AI_AVOID_ENTITY_RANGE)
            return new Chromosome(new Allele(false, Array(6.0F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_AI_AVOID_ENTITY_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityCreeper]), EnumAlleleType.CLASS_ARRAY))

        if(gene == Genes.GENE_AI_BEG)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_BEG_INDEX)
            return new Chromosome(new Allele(true, 8, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_BEG_RANGE)
            return new Chromosome(new Allele(false, 0.0F, EnumAlleleType.FLOAT))

        if(gene == Genes.GENE_AI_BREAK_DOOR)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_BREAK_DOOR_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_CONTROLLED_BY_PLAYER)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_CONTROLLED_BY_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_CONTROLLED_BY_PLAYER_MAX_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_CREEPER_SWELL)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_CREEPER_SWELL_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_DEFEND_VILLAGE)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_DEFEND_VILLAGE_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_EAT_GRASS)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_EAT_GRASS_INDEX)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_FLEE_SUN)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_FLEE_SUN_INDEX)
            return new Chromosome(new Allele(true, 3, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_FLEE_SUN_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_FOLLOW_GOLEM)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_FOLLOW_GOLEM_INDEX)
            return new Chromosome(new Allele(true, 7, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_FOLLOW_OWNER)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_FOLLOW_OWNER_INDEX)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_FOLLOW_OWNER_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_AI_FOLLOW_OWNER_MIN_DISTANCE)
            return new Chromosome(new Allele(false, 5.0F, EnumAlleleType.FLOAT))
        if(gene == Genes.GENE_AI_FOLLOW_OWNER_MAX_DISTANCE)
            return new Chromosome(new Allele(true, 10.0F, EnumAlleleType.FLOAT))

        if(gene == Genes.GENE_AI_FOLLOW_PARENT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_FOLLOW_PARENT_INDEX)
            return new Chromosome(new Allele(true, 4, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_FOLLOW_PARENT_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_HURT_BY_TARGET)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_HURT_BY_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_HURT_BY_TARGET_CALL_HELP)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))

        if(gene == Genes.GENE_AI_LEAP_AT_TARGET)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_LEAP_AT_TARGET_INDEX)
            return new Chromosome(new Allele(true, 3, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_LEAP_AT_TARGET_MOTION_Y)
            return new Chromosome(new Allele(false, 0.4F, EnumAlleleType.FLOAT))

        if(gene == Genes.GENE_AI_LOOK_AT_TRADE_PLAYER)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_LOOK_AT_TRADE_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_LOOK_AT_VILLAGER)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_LOOK_AT_VILLAGER_INDEX)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_LOOK_IDLE)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_LOOK_IDLE_INDEX)
            return new Chromosome(new Allele(true, 8, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_MATE)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MATE_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_MATE_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_MOVE_INDOORS)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MOVE_INDOORS_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_MOVE_THROUGH_VILLAGE)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MOVE_THROUGH_VILLAGE_INDEX)
            return new Chromosome(new Allele(true, 3, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_MOVE_THROUGH_VILLAGE_IS_NOCTURNAL)
            return new Chromosome(new Allele(false, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MOVE_THROUGH_VILLAGE_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION_INDEX)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_MOVE_TOWARDS_RESTRICTION_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_MOVE_TOWARDS_TARGET)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_MOVE_TOWARDS_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_MOVE_TOWARDS_TARGET_MAX_DISTANCE)
            return new Chromosome(new Allele(true, 32.0F, EnumAlleleType.FLOAT))
        if(gene == Genes.GENE_AI_MOVE_TOWARDS_TARGET_MOVE_SPEED)
            return new Chromosome(new Allele(true, 0.9D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_INDEX)
            return new Chromosome(new Allele(true, Array(2), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_ENTITY_SELECTOR)
            return new Chromosome(new Allele(true, Array(""), EnumAlleleType.STRING_ARRAY))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_NEARBY_ONLY)
            return new Chromosome(new Allele(true, Array(false), EnumAlleleType.BOOLEAN_ARRAY))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET)
            return new Chromosome(new Allele(false, Array(classOf[EntityPlayer]), EnumAlleleType.CLASS_ARRAY))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_TARGET_CHANCE)
            return new Chromosome(new Allele(true, Array(0), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_NEAREST_ATTACKABLE_TARGET_VISIBLE)
            return new Chromosome(new Allele(true, Array(false), EnumAlleleType.BOOLEAN_ARRAY))

        if(gene == Genes.GENE_AI_OCELOT_ATTACK)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_OCELOT_ATTACK_INDEX)
            return new Chromosome(new Allele(true, 8, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_OCELOT_SIT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_OCELOT_SIT_INDEX)
            return new Chromosome(new Allele(true, 6, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_OCELOT_SIT_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_OPEN_DOOR)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_OPEN_DOOR_INDEX)
            return new Chromosome(new Allele(true, 4, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_OPEN_DOOR_CLOSE_DOOR)
            return new Chromosome(new Allele(false, true, EnumAlleleType.BOOLEAN))

        if(gene == Genes.GENE_AI_OWNER_HURT_BY_TARGET)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_OWNER_HURT_BY_TARGET_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_OWNER_HURT_TARGET)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_OWNER_HURT_TARGET_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_PANIC)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_PANIC_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_PANIC_MOVE_SPEED)
            return new Chromosome(new Allele(true, 1.25D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_PLAY)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_PLAY_INDEX)
            return new Chromosome(new Allele(true, 8, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_PLAY_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_RESTRICT_OPEN_DOOR)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_RESTRICT_OPEN_DOOR_INDEX)
            return new Chromosome(new Allele(true, 3, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_RESTRICT_SUN)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_RESTRICT_SUN_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))
        if(gene == Genes.GENE_AI_RUN_AROUND_LIKE_CRAZY_MOVE_SPEED)
            return new Chromosome(new Allele(false, 1.0D, EnumAlleleType.DOUBLE))

        if(gene == Genes.GENE_AI_SIT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_SIT_INDEX)
            return new Chromosome(new Allele(true, 2, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_SWIMMING)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_SWIMMING_INDEX)
            return new Chromosome(new Allele(true, 0, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_TARGET_NON_TAMED)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_TARGET_NON_TAMED_INDEX)
            return new Chromosome(new Allele(true, Array(1), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_TARGET_NON_TAMED_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityChicken]), EnumAlleleType.CLASS_ARRAY))
        if(gene == Genes.GENE_AI_TARGET_NON_TAMED_TARGET_CHANCE)
            return new Chromosome(new Allele(true, Array(750), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_TARGET_NON_TAMED_VISIBLE)
            return new Chromosome(new Allele(true, Array(false), EnumAlleleType.BOOLEAN_ARRAY))

        if(gene == Genes.GENE_AI_TEMPT)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_TEMPT_INDEX)
            return new Chromosome(new Allele(true, Array(2), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_TEMPT_ITEM)
            return new Chromosome(new Allele(true, Array(new ItemStack(Items.wheat)), EnumAlleleType.ITEMSTACK_ARRAY))
        if(gene == Genes.GENE_AI_TEMPT_MOVE_SPEED)
            return new Chromosome(new Allele(true, Array(1.2D), EnumAlleleType.DOUBLE_ARRAY))
        if(gene == Genes.GENE_AI_TEMPT_SCARED_BY_PLAYER)
            return new Chromosome(new Allele(true, Array(false), EnumAlleleType.BOOLEAN_ARRAY))

        if(gene == Genes.GENE_AI_TRADE_PLAYER)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_TRADE_PLAYER_INDEX)
            return new Chromosome(new Allele(true, 1, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_VILLAGER_MATE)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_VILLAGER_MATE_INDEX)
            return new Chromosome(new Allele(true, 6, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_WANDER)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_WANDER_INDEX)
            return new Chromosome(new Allele(true, 5, EnumAlleleType.INTEGER))

        if(gene == Genes.GENE_AI_WANDER_MOVE_SPEED)
            return new Chromosome(new Allele(true, 1.0D, EnumAlleleType.DOUBLE))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST)
            return new Chromosome(new Allele(true, true, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_INDEX)
            return new Chromosome(new Allele(true, Array(6), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_CHANCE)
            return new Chromosome(new Allele(true, Array(0.02F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_RANGE)
            return new Chromosome(new Allele(true, Array(8.0F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityPlayer]), EnumAlleleType.CLASS_ARRAY))

        if(gene == Genes.GENE_AI_WATCH_CLOSEST_2)
            return new Chromosome(new Allele(true, false, EnumAlleleType.BOOLEAN))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_2_INDEX)
            return new Chromosome(new Allele(true, Array(9), EnumAlleleType.INTEGER_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_2_CHANCE)
            return new Chromosome(new Allele(true, Array(1.0F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_2_RANGE)
            return new Chromosome(new Allele(true, Array(3.0F), EnumAlleleType.FLOAT_ARRAY))
        if(gene == Genes.GENE_AI_WATCH_CLOSEST_2_TARGET)
            return new Chromosome(new Allele(true, Array(classOf[EntityPlayer]), EnumAlleleType.CLASS_ARRAY))

        //Rendering related Genes.
        if(gene == Genes.GENE_MODEL)
            return new Chromosome(new Allele(true, ModelPart.getModelPartsFromModel(new ModelSkeleton(), entity), EnumAlleleType.MODELPART_ARRAY))
        if(gene == Genes.GENE_TEXTURE)
            return new Chromosome(new Allele(true, "textures/entity/skeleton/skeleton.png", EnumAlleleType.STRING), new Allele(false, "textures/entity/skeleton/skeleton.png", EnumAlleleType.STRING))
        null
    }
}