package seremis.geninfusion.api.soul;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import seremis.geninfusion.api.soul.util.Data;

import java.util.Random;

public interface IEntitySoulCustom extends IRangedAttackMob {

    ISoul getSoul();

    World getWorld();

    AxisAlignedBB getBoundingBox();

    int getEntityId();

    Random getRandom();

    /**
     * This method returns the entity as an instance of the class in the parameters. This only works for standard
     * Minecraft classes, like EntityCreature, EntityMob, etc. The variables of the entity will remain the same.
     *
     * @param clzz The class this method should return an instance of.
     * @return A EntitySoulCustom as instance of the class provided.
     */
    IEntitySoulCustom getEntityAsInstanceOf(Class<? extends EntityLiving> clzz);

    /*
     * Use this method to set a variable as persistent. This variable will save and load with NBT.
     * This will NOT work with objects.
     */
    void makePersistent(String name);
    
    /*
     * Use these methods to get and set a variable in the entity class. This can be used to set position, motion etc but also custom variables, like bar, boo and foo.
     */

    void setBoolean(String name, boolean variable);

    void setByte(String name, byte variable);

    void setShort(String name, short variable);

    void setInteger(String name, int variable);

    void setFloat(String name, float variable);

    void setDouble(String name, double variable);

    void setString(String name, String variable);

    void setLong(String name, long variable);

    void setItemStack(String name, ItemStack variable);

    void setNBT(String name, NBTTagCompound variable);

    void setData(String name, Data variable);

    boolean getBoolean(String name);

    byte getByte(String name);

    short getShort(String name);

    int getInteger(String name);

    float getFloat(String name);

    double getDouble(String name);

    long getLong(String name);

    String getString(String name);

    ItemStack getItemStack(String name);

    NBTTagCompound getNBT(String name);

    Data getData(String name);

    void setBooleanArray(String name, boolean[] variable);

    void setByteArray(String name, byte[] variable);

    void setShortArray(String name, short[] variable);

    void setIntegerArray(String name, int[] variable);

    void setFloatArray(String name, float[] variable);

    void setDoubleArray(String name, double[] variable);

    void setLongArray(String name, long[] variable);

    void setStringArray(String name, String[] variable);

    void setItemStackArray(String name, ItemStack[] variable);

    void setNBTArray(String name, NBTTagCompound[] variable);

    void setDataArray(String name, Data[] variable);

    /**
     * Use this to set an Object. The Object will not persist over saves, write an Object to a Data object if you want
     * it to persist.
     */
    void setObject(String name, Object object);

    boolean[] getBooleanArray(String name);

    byte[] getByteArray(String name);

    short[] getShortArray(String name);

    int[] getIntegerArray(String name);

    float[] getFloatArray(String name);

    double[] getDoubleArray(String name);

    long[] getLongArray(String name);

    String[] getStringArray(String name);

    ItemStack[] getItemStackArray(String name);

    NBTTagCompound[] getNBTArray(String name);

    Data[] getDataArray(String name);

    /**
     * Use this to get an Object. The Object will not persist over saves, write an Object to a Data object if you want
     * it to persist.
     *
     * @param name The name of the variable
     */
    Object getObject(String name);


    NBTTagCompound getEntityData();

    void playSound(String sound, float volume, float pitch);

    boolean attackEntityFrom(DamageSource source, float damage);

    void attackEntity(Entity entity, float distance);

    void setFlag(int id, boolean value);

    boolean getFlag(int id);

    void onDeathUpdate();

    void damageEntity(DamageSource source, float damage);

    void updateAITick();

    boolean canDespawn();

    boolean isMovementCeased();

    Entity findPlayerToAttack();

    void setBeenAttacked();

    String getDeathSound();

    String getHurtSound();

    float getSoundVolume();

    float getSoundPitch();

    float applyArmorCalculations(DamageSource source, float damage);

    float applyPotionDamageCalculations(DamageSource source, float damage);

    void damageArmor(float damage);

    void setOnFireFromLava();

    float getBlockPathWeight(int x, int y, int z);

    void updateWanderPath();

    void updateEntityActionState();

    int decreaseAirSupply(int air);

    void updatePotionEffects();

    void jump();

    void collideWithNearbyEntities();
}
