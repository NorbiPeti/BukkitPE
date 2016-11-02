package net.BukkitPE.network.protocol;

import net.BukkitPE.entity.data.EntityMetadata;
import net.BukkitPE.utils.Binary;
import net.BukkitPE.utils.RuleData;

public class GameRulesChangedPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.GAME_RULES_CHANGED_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public RuleData[] ruleDatas = new RuleData[0];

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putVarInt(this.ruleDatas.length);
        for (RuleData rule: this.ruleDatas) {
            this.putString(rule.name);
            this.putBoolean(rule.unknown1);
            this.putBoolean(rule.unknown2);
        }
    }
}