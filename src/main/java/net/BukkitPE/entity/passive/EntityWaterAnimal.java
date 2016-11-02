package net.BukkitPE.entity.passive;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.EntityAgeable;
import net.BukkitPE.entity.EntityCreature;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;

public abstract class EntityWaterAnimal extends EntityCreature implements EntityAgeable {
    public EntityWaterAnimal(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public boolean isBaby() {
        return this.getDataFlag(DATA_FLAGS, Entity.DATA_FLAG_BABY);
    }
}