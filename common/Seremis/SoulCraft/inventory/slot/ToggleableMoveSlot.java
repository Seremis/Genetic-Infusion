package Seremis.SoulCraft.inventory.slot;

import net.minecraft.inventory.IInventory;

public class ToggleableMoveSlot extends ToggleableSlot {

    private int srcX;
    private int srcY;

    public ToggleableMoveSlot(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
        srcX = x;
        srcY = y;
    }

    public void enable() {
        enabled = true;
        xDisplayPosition = srcX;
        yDisplayPosition = srcY;
    }

    public void disable() {
        enabled = false;
        xDisplayPosition = srcX + 1000;
        yDisplayPosition = srcY + 1000;
    }
}
