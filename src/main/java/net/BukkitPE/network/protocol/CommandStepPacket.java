package net.BukkitPE.network.protocol;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class CommandStepPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.COMMAND_STEP_PACKET;

    /*
    public String command;
    public String overload;
    public uvarint1;
    public uvarint2;
    public boolean bool;
    public uvarint64;
    public SimpleConfig args; //JSON formatted command arguments
    public String string4;*/

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode(){
        /*  TODO
        this.command = this.getString();
        this.overload = this.getString();
        this.uvarint1 = this.getUnsignedVarInt();
        this.uvarint2 = this.getUnsignedVarInt();
        this.bool = this.getBoolean();
        this.uvarint64 = this.getUnsignedVarInt(); //TODO: varint64
        this.args = new Gson().fromJson(this.getString(), SimpleConfig.class);
        this.string4 = this.getString();
        while(!this.feof()){
            this.getByte(); //prevent assertion errors. TODO: find out why there are always 3 extra bytes at the end of this packet.
        }
        */
    }

    @Override
    public void encode(){}

}