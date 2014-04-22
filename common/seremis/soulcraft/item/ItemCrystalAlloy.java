package seremis.soulcraft.item;

import seremis.soulcraft.core.lib.Items;
import net.minecraft.item.ItemStack;

public class ItemCrystalAlloy extends SCItem {

    private String[] subNames = {Items.CRYSTAL_ALLOY_META_0_UNLOCALIZED_NAME, Items.CRYSTAL_ALLOY_META_1_UNLOCALIZED_NAME, Items.CRYSTAL_ALLOY_META_2_UNLOCALIZED_NAME, Items.CRYSTAL_ALLOY_META_3_UNLOCALIZED_NAME};

    public ItemCrystalAlloy() {
        super();
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName(Items.CRYSTAL_ALLOY_UNLOCALIZED_NAME);
        setNumbersofMetadata(4);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
    }
}
