package net.BukkitPE.network.protocol;

import net.BukkitPE.math.Vector3f;

public class MovePlayerPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.MOVE_PLAYER_PACKET;

    public static final byte MODE_NORMAL = 0;
    public static final byte MODE_RESET = 1;
    public static final byte MODE_ROTATION = 2;

    public long eid;
    public float x;
    public float y;
    public float z;
    public float yaw;
    public float headYaw;
    public float pitch;
    public byte mode = MODE_NORMAL;
    public boolean onGround;

    @Override
    public void decode() {
        eid = getEntityId();
        //Vector3f v = this.getVector3f();
        this.x = this.getFloat();
        this.y = this.getFloat();
        this.z = this.getFloat();
        pitch = getLFloat();
        yaw = getLFloat();
        headYaw = getLFloat();
        mode = (byte) getByte();
        onGround = getBoolean();
    }

    @Override
    public void encode() {
        reset();
        putEntityId(eid);
        //putVector3f(x, y, z);
        putFloat(x);
        putFloat(y);
        putFloat(z);
        putFloat(pitch);
        putFloat(yaw);
        putFloat(headYaw);
        putByte(mode);
        putBoolean(onGround);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}