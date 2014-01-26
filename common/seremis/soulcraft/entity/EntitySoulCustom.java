package seremis.soulcraft.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import seremis.soulcraft.soul.SoulHandler;
import seremis.soulcraft.soul.entity.IEntitySoulCustom;

public class EntitySoulCustom extends EntityLiving implements IEntitySoulCustom {

    public EntitySoulCustom(World world) {
        super(world);
    }
    
    public EntitySoulCustom(World world, double x, double y, double z) {
        super(world);
        setPosition(x, y, z);
        SoulHandler.entityInit(this);
    }

    //Modularity stuff//    
    @Override
    public double getPosX() {
        return posX;
    }
    
    @Override
    public double getPosY() {
        return posY;
    }
    
    @Override
    public double getPosZ() {
        return posZ;
    }
    
    @Override
    public float getRotationYaw() {
        return rotationYaw;
    }
    
    @Override
    public void setRotationYaw(float yaw) {
        rotationYaw = yaw;
    }
    
    @Override
    public float getRotationPitch() {
        return rotationPitch;
    }
    
    @Override
    public void setRotationPitch(float pitch) {
        rotationPitch = pitch;
    }
    
    @Override
    public World getWorld() {
        return worldObj;
    }
    
    @Override
    public float getBrightness() {
        return getBrightness(1.0F);
    }
    
    @Override
    public ItemStack getCurrentItemOrArmor(int slot) {
        return getCurrentItemOrArmor(slot);
    }
    
    @Override
    public void setArmor(int slot, ItemStack stack) {
        this.setCurrentItemOrArmor(slot+1, stack);
    }
    
    @Override
    public ItemStack getHeldItem() {
        return getCurrentItemOrArmor(0);
    }
    
    @Override
    public void setHeldItem(ItemStack stack) {
        setCurrentItemOrArmor(0, stack);
    }
    
    @Override
    public boolean getCanPickUpItems() {
        return canPickUpLoot();
    }
    
    @Override
    public void setCanPickUpItems(boolean canPickUp) {
        setCanPickUpLoot(canPickUp);
    }
    
    @Override
    public void dropItems(ItemStack stack) {
        this.entityDropItem(stack, getEyeHeight());
    }

    @Override
    public boolean getIsChild() {
        return isChild();
    }

    @Override
    public int getRecentlyHit() {
        return recentlyHit;
    }
    
    
    //Entity stuff//    
    @Override
    public boolean interact(EntityPlayer player) {
        SoulHandler.entityRightClicked(this, player);
        return super.interact(player);
    }
    
    @Override
    public void onUpdate() {
        SoulHandler.entityUpdate(this);
        super.onUpdate();
    }
    
    @Override
    public void onDeath(DamageSource source) {
        if(ForgeHooks.onLivingDeath(this, source)) return;
        
        if(source.getEntity() != null) {
            source.getEntity().onKillEntity(this);
        }
        dead = true;
        
        SoulHandler.entityDeath(this, source);
        this.worldObj.setEntityState(this, (byte)3);
    }
    
    @Override
    public void onKillEntity(EntityLivingBase entity) {
        SoulHandler.onKillEntity(this, entity);
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
       return SoulHandler.attackEntityFrom(this, source, damage);
    }
    
    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData data) {
        return SoulHandler.spawnEntityFromEgg(this, data);
    }
}
