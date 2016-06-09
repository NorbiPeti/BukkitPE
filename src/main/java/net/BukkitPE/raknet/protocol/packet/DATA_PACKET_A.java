package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.DataPacket;
import net.BukkitPE.raknet.protocol.Packet;

/**

 * BukkitPE Project
 */
public class DATA_PACKET_A extends DataPacket {
    public static byte ID = (byte) 0x8a;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new DATA_PACKET_A();
        }

    }

}
