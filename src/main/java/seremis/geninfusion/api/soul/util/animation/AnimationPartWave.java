package seremis.geninfusion.api.soul.util.animation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import seremis.geninfusion.api.soul.IEntitySoulCustom;

/**
 * Animation with a cosine curve for rotation. Mostly used for arm and leg animation.
 */
public class AnimationPartWave extends AnimationPart {

    public String period;
    public String amplitude;
    public String offsetVert;
    public String offsetHor;

    /**
     * These variables should be modified when a method mutates.
     */
    public float periodModifier = 1.0F;
    public float amplitudeModifier = 1.0F;
    public float offsetVertModifier = 1.0F;
    public float offsetHorModifier = 1.0F;

    /**
     * The rotation axis this AnimationPart animates, 0 for x, 1 for y, 2 for z, 3 for x & y, 4 for x & z, 5 for y & z, 6 for every axis.
     */
    public short axis;

    /**
     * A helper class for animations.
     *
     * @param axis The rotation axis this AnimationPart animates, 0 for x, 1 for y, 2 for z, 3 for x & y, 4 for x & z, 5 for y & z, 6 for every axis
     * @param period The name of the variable (float) that corresponds with the period of the sine wave. If null it defaults to 1.0F.
     * @param amplitude The name of the variable (float) that corresponds with the amplitude of the sine wave. If null it defaults to 1.0F.
     * @param offsetVert The name of the variable (float) that corresponds with the vertical offset of the sine wave. If null it defaults to 1.0F.
     * @param offsetHor The name of the variable (float) that corresponds with the horizontal offset of the sine wave. If null it defaults to 1.0F.
     */
    public AnimationPartWave(int axis, String period, String amplitude, String offsetVert, String offsetHor) {
        super(EnumAnimationPartType.ANIMATION_PART_WAVE);
        this.period = period;
        this.amplitude = amplitude;
        this.offsetVert = offsetVert;
        this.offsetHor = offsetHor;
    }

    public AnimationPartWave(NBTTagCompound compound) {
        super(EnumAnimationPartType.ANIMATION_PART_WAVE);
        readFromNBT(compound);
    }

    @Override
    public void animate(IEntitySoulCustom entity) {
        super.animate(entity);

        float period = entity.getFloat(this.period);
        float amplitude = entity.getFloat(this.amplitude);
        float offsetVert = entity.getFloat(this.offsetVert);
        float offsetHor = entity.getFloat(this.offsetHor);

        switch(axis) {
            case 0:
                modelPart.rotateAngleX = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 1:
                modelPart.rotateAngleY = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 2:
                modelPart.rotateAngleZ = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 3:
                modelPart.rotateAngleX = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                modelPart.rotateAngleY = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 4:
                modelPart.rotateAngleX = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                modelPart.rotateAngleZ = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 5:
                modelPart.rotateAngleY = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                modelPart.rotateAngleZ = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
            case 6:
                modelPart.rotateAngleX = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                modelPart.rotateAngleY = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                modelPart.rotateAngleZ = getRotation(entity, period, amplitude, offsetVert, offsetHor);
                break;
        }
    }

    protected float getRotation(IEntitySoulCustom entity, float period, float amplitude, float offsetVert, float offsetHor) {
        return MathHelper.cos((2 * (float) Math.PI / (period * periodModifier)) + (offsetHor * offsetHorModifier))*amplitude*amplitudeModifier+offsetVert*offsetVertModifier;
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setShort("axis", axis);

        if(amplitudeModifier != 1.0F) compound.setFloat("amplitudeModifier", amplitudeModifier);
        if(periodModifier != 1.0F) compound.setFloat("periodModifier", periodModifier);
        if(offsetVertModifier != 1.0F) compound.setFloat("offsetVertModifier", offsetVertModifier);
        if(offsetHorModifier != 1.0F) compound.setFloat("offsetHorModifier", offsetHorModifier);

        if(amplitude != null) compound.setString("amplitude", amplitude);
        if(period != null) compound.setString("period", period);
        if(offsetVert != null) compound.setString("offsetVert", offsetVert);
        if(offsetHor != null) compound.setString("offsetHor", offsetHor);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        axis = compound.getShort("axis");

        if(compound.hasKey("amplitudeModifier")) amplitudeModifier = compound.getFloat("amplitudeModifier");
        if(compound.hasKey("periodModifier")) periodModifier = compound.getFloat("periodModifier");
        if(compound.hasKey("offsetVertModifier")) offsetVertModifier = compound.getFloat("offsetVertModifier");
        if(compound.hasKey("offsetHorModifier")) offsetHorModifier = compound.getFloat("offsetHorModifier");

        if(compound.hasKey("amplitude")) amplitude = compound.getString("amplitude");
        if(compound.hasKey("period")) period = compound.getString("period");
        if(compound.hasKey("offsetVert")) offsetVert = compound.getString("offsetVert");
        if(compound.hasKey("offsetHor")) offsetHor = compound.getString("offsetHor");
    }

    @Override
    public AnimationPart mutate() {
        if(!immutable) {
            amplitudeModifier = (float) (amplitudeModifier * ((rand.nextFloat() * 2 * 0.5) + 0.5));
            periodModifier = (float) (periodModifier * ((rand.nextFloat() * 2 * 0.5) + 0.5));
            offsetHorModifier = (float) (offsetHorModifier * ((rand.nextFloat() * 2 * 0.5) + 0.5));
            offsetVertModifier = (float) (offsetVertModifier * ((rand.nextFloat() * 2 * 0.5) + 0.5));
        }

        return this;
    }
}