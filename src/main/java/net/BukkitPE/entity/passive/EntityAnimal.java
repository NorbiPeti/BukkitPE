package net.BukkitPE.entity.passive;

import net.BukkitPE.Player;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.EntityAgeable;
import net.BukkitPE.entity.EntityCreature;
import net.BukkitPE.entity.data.ByteEntityData;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;
import net.BukkitPE.network.protocol.AddEntityPacket;

public abstract class EntityAnimal extends EntityCreature implements EntityAgeable {
    public EntityAnimal(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public boolean isBaby() {
        return this.getDataFlag(DATA_FLAGS, Entity.DATA_FLAG_BABY);
    }

    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.type = this.getNetworkId();
        pk.eid = this.getId();
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = (float) this.motionX;
        pk.speedY = (float) this.motionY;
        pk.speedZ = (float) this.motionZ;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }
}