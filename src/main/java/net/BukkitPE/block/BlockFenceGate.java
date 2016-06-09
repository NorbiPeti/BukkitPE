package net.BukkitPE.block;

import net.BukkitPE.Player;
import net.BukkitPE.event.block.DoorToggleEvent;
import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.level.sound.DoorSound;
import net.BukkitPE.math.AxisAlignedBB;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/11/23 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockFenceGate extends BlockTransparent {

    public BlockFenceGate() {
        this(0);
    }

    public BlockFenceGate(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return FENCE_GATE_OAK;
    }

    @Override
    public String getName() {
        return "Oak Fence Gate";
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    protected AxisAlignedBB recalculateBoundingBox() {
        if ((this.getDamage() & 0x04) > 0) {
            return null;
        }
        int i = this.getDamage() & 0x03;
        if (i == 2 || i == 0) {
            return new AxisAlignedBB(
                    x,
                    y,
                    z + 0.375,
                    x + 1,
                    y + 1.5,
                    z + 0.625
            );
        } else {
            return new AxisAlignedBB(
                    x + 0.375,
                    y,
                    z,
                    x + 0.625,
                    y + 1.5,
                    z + 1
            );
        }
    }

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz, Player player) {
        int[] faces = new int[]{3, 0, 1, 2};
        this.meta = faces[(player != null) ? player.getDirection() : 0] & 0x03;
        this.getLevel().setBlock(block, this, true, true);

        return true;
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[][]{
                {this.getId(), 0, 1}
        };
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        if (player == null) {
            return false;
        }

        if (!this.toggle(player)) {
            return false;
        }

        this.getLevel().setBlock(this, this, true);
        this.getLevel().addSound(new DoorSound(this));

        return true;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }

    public boolean toggle(Player player) {
        DoorToggleEvent event = new DoorToggleEvent(this, player);
        this.getLevel().getServer().getPluginManager().callEvent(event);

        if (event.isCancelled()) {
            return false;
        }

        player = event.getPlayer();

        if (player == null) {
            return false;
        }

        double yaw = player.yaw;
        double rotation = (yaw - 90) % 360;

        if (rotation < 0) {
            rotation += 360.0;
        }

        int originDirection = this.getDamage() & 0x01;
        int direction;

        if (originDirection == 0) {
            if (rotation >= 0 && rotation < 180) {
                direction = 2;
            } else {
                direction = 0;
            }
        } else {
            if (rotation >= 90 && rotation < 270) {
                direction = 3;
            } else {
                direction = 1;
            }
        }

        this.setDamage(direction | ((~this.getDamage()) & 0x04));
        return true;
    }

    public boolean isOpen() {
        return (this.meta & 0x04) > 0;
    }

}
