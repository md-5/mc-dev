package net.minecraft.server;

public class ItemWorldMapBase extends Item {

    protected ItemWorldMapBase(int i) {
        super(i);
    }

    public boolean m_() {
        return true;
    }

    public Packet c(ItemStack itemstack, World world, EntityHuman entityhuman) {
        return null;
    }
}
