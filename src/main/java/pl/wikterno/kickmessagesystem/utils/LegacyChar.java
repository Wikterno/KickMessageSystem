package pl.wikterno.kickmessagesystem.utils;



public enum LegacyChar {
    BLACK("&0"),
    DARK_BLUE("&1"),
    DARK_GREEN("&2"),
    DARK_AQUA("&3"),
    DARK_RED("&4"),
    DARK_PURPLE("&5"),
    GOLD("&6"),
    GRAY("&7"),
    DARK_GRAY("&8"),
    BLUE("&9"),
    GREEN("&a"),
    AQUA("&b"),
    RED("&c"),
    LIGHT_PURPLE("&d"),
    YELLOW("&e"),
    WHITE("&f"),
    RESET("&r"),
    BOLD("&l"),
    ITALIC("&r"),
    STRIKETHROUGH("&m"),
    UNDERLINE("&n"),
    OBFUSCATED("&k");

    private String legacyChar;

    LegacyChar(String legacyChar) {
        this.legacyChar = legacyChar;
    }

    public static LegacyChar getLegacyByChar(String s){
        s = s.trim().replace("\n", "");
        for(LegacyChar legacyChar : LegacyChar.values()){
            if(legacyChar.getLegacyChar().equals(s)) return legacyChar;
        }
        return null;
    }

    private String getLegacyChar(){
        return this.legacyChar;
    }
}
