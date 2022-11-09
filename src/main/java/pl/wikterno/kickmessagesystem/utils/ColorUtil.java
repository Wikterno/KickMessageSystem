package pl.wikterno.kickmessagesystem.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ColorUtil {

    public Component formatColor(String s){
        return MiniMessage.miniMessage().deserialize(replaceLegacyChar(s));
    }

    private String replaceLegacyChar(String s){
        int pos = s.indexOf("&");
        String legacyChar;
        while(pos != -1){
            legacyChar = s.substring(pos-1, pos+2);
            s = s.replaceFirst(legacyChar, "<"+LegacyChar.getLegacyByChar(legacyChar).name()+">");
            pos = s.indexOf("&");
        }
        return s;
    }
}
