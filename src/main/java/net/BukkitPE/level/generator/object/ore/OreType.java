package net.BukkitPE.level.generator.object.ore;

import net.BukkitPE.block.Block;

/**

 * BukkitPE Project
 */
public class OreType {
    public Block material;
    public int clusterCount;
    public int clusterSize;
    public int maxHeight;
    public int minHeight;

    public OreType(Block material, int clusterCount, int clusterSize, int minHeight, int maxHeight) {
        this.material = material;
        this.clusterCount = clusterCount;
        this.clusterSize = clusterSize;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
    }
}
