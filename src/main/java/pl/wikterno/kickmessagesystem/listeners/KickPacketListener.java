package pl.wikterno.kickmessagesystem.listeners;

import dev.simplix.protocolize.api.Direction;
import dev.simplix.protocolize.api.listener.AbstractPacketListener;
import dev.simplix.protocolize.api.listener.PacketReceiveEvent;
import dev.simplix.protocolize.api.listener.PacketSendEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.protocol.packet.Kick;
import pl.wikterno.kickmessagesystem.utils.ColorUtil;

public class KickPacketListener extends AbstractPacketListener<Kick> {

    private ColorUtil colorUtil;

    public KickPacketListener(ColorUtil colorUtil) {
        super(Kick.class, Direction.UPSTREAM, 0);
        this.colorUtil = colorUtil;
    }

    @Override
    public void packetReceive(PacketReceiveEvent<Kick> packetReceiveEvent) {
        // Packet receive
    }

    @Override
    public void packetSend(PacketSendEvent<Kick> event) {

        // Cast packet and MiniMessage
        Kick kickPacket = event.packet();
        MiniMessage miniMessage = MiniMessage.miniMessage();

        // Cast kickMessage
        Component kickMessageComponent = GsonComponentSerializer.gson().deserialize(kickPacket.getMessage());

        // Format kickMessage
        String kickMessage = LegacyComponentSerializer.legacyAmpersand().serialize(kickMessageComponent);
        kickMessage = GsonComponentSerializer.gson().serialize(colorUtil.formatColor(kickMessage));

        // Modify packet
        event.packet().setMessage(kickMessage);
    }
}
