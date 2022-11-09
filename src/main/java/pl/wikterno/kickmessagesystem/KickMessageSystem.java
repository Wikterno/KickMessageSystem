package pl.wikterno.kickmessagesystem;

import dev.simplix.protocolize.api.Protocolize;
import net.md_5.bungee.api.plugin.Plugin;
import pl.wikterno.kickmessagesystem.listeners.KickPacketListener;
import pl.wikterno.kickmessagesystem.utils.ColorUtil;

public final class KickMessageSystem extends Plugin {


    @Override
    public void onEnable() {

        // Cast utils
        ColorUtil colorUtil = new ColorUtil();

        // Register listener
        Protocolize.listenerProvider().registerListener(new KickPacketListener(colorUtil));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
