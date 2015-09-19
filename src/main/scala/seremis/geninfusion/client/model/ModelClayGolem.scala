package seremis.geninfusion.client.model

import net.minecraft.client.model.ModelBase
import net.minecraft.entity.EntityLiving
import org.lwjgl.opengl.GL11
import seremis.geninfusion.api.soul.lib.ModelPartTypes
import seremis.geninfusion.api.util.render.animation.AnimationCache
import seremis.geninfusion.api.util.render.model.{Model, ModelPart}
import seremis.geninfusion.entity.EntityClayGolem
import seremis.geninfusion.util.UtilModel

class ModelClayGolem extends ModelBase {

    val textureSize = 128
    textureWidth = textureSize
    textureHeight = textureSize

    val head = new ModelPart(this, ModelPartTypes.Head)
    head.setTextureSize(textureWidth, textureHeight)
    head.setRotationPoint(0.0F, -7.0F, -2.0F)
    head.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F)
    head.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F)

    val body = new ModelPart(this, ModelPartTypes.Body)
    body.setTextureSize(textureWidth, textureHeight)
    body.setRotationPoint(0.0F, -7.0F, 0.0F)
    body.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F)
    body.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F)

    val rightArm = new ModelPart(this, ModelPartTypes.ArmsRight)
    rightArm.setTextureSize(textureWidth, textureHeight)
    rightArm.setRotationPoint(0.0F, -7.0F, 0.0F)
    rightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F)

    val leftArm = new ModelPart(this, ModelPartTypes.ArmsLeft)
    leftArm.setTextureSize(textureWidth, textureHeight)
    leftArm.setRotationPoint(0.0F, -7.0F, 0.0F)
    leftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F)

    val leftLeg = new ModelPart(this, ModelPartTypes.LegsRight)
    leftLeg.setTextureSize(textureWidth, textureHeight)
    leftLeg.setRotationPoint(-4.0F, 11.0F, 0.0F)
    leftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F)

    val rightLeg = new ModelPart(this, ModelPartTypes.LegsLeft)
    rightLeg.setTextureSize(textureWidth, textureHeight)
    rightLeg.mirror = true
    rightLeg.setRotationPoint(5.0F, 11.0F, 0.0F)
    rightLeg.setTextureOffset(60, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F)

    val modelGolem = new Model(Array(head, body, rightArm, leftArm, leftLeg, rightLeg))

    def render(golem: EntityClayGolem) {
        if(golem.firstRenderTick) {
            golem.currentRenderModel = Some(modelGolem)
            golem.firstRenderTick = false
        }
        if(golem.isWaitingAfterTransformation) {
            golem.currentRenderModel = golem.getTransformationGoalModel
        }

        if((golem.isTransforming || golem.isWaitingAfterTransformation) && golem.getTransformationGoal.get.asInstanceOf[EntityLiving].isChild) {
            GL11.glPushMatrix()

            if(golem.currentRenderModel.get.getParts(ModelPartTypes.Head).nonEmpty) {
                GL11.glPushMatrix()

                val headScale = 1.0F + ((0.75F - 1.0F) / golem.getMaxTransformationTimer) * golem.getTransformationTimer
                GL11.glScalef(headScale, headScale, headScale)

                val headTranslateModifier = 16.0F / golem.getMaxTransformationTimer * golem.getTransformationTimer
                GL11.glTranslatef(0.0F, 0.0625F * headTranslateModifier, 0.0F)

                new Model(golem.currentRenderModel.get.getParts(ModelPartTypes.Head).get).render()
                GL11.glPopMatrix()
            }

            val scale = 1.0F + ((0.5F - 1.0F) / golem.getMaxTransformationTimer) * golem.getTransformationTimer
            GL11.glScalef(scale, scale, scale)

            val translateModifier = 24.0F / golem.getMaxTransformationTimer * golem.getTransformationTimer
            GL11.glTranslatef(0.0F, 0.0625F * translateModifier, 0.0F)

            golem.currentRenderModel.get.getParts(ModelPartTypes.Head).foreach(head => golem.currentRenderModel.get.getWholeModelExcept(head).render())

            GL11.glPopMatrix()
        } else {
            golem.currentRenderModel.get.render()
        }

        if(golem.isTransforming) {
            animateTransformation(golem)
        }
    }

    def animateTransformation(golem: EntityClayGolem) {
        val modelTo = golem.getTransformationGoalModel.get

        golem.currentRenderModel = Some(UtilModel.morphModel(modelGolem, modelTo, golem.getMaxTransformationTimer, golem.getTransformationTimer))
    }
}
