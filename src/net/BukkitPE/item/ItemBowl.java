package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemBowl extends Item {

    public ItemBowl() {
        this(0, 1);
    }

    public ItemBowl(Integer meta) {
        this(meta, 1);
    }

    public ItemBowl(Integer meta, int count) {
        super(BOWL, 0, count, "Bowl");
    }
}