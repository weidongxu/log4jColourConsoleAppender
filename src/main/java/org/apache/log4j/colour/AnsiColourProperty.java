package org.apache.log4j.colour;

/**
 *
 */
public class AnsiColourProperty {

    private static final int FONT_COLOR_BASE = 30;

    private static final int BACK_COLOR_BASE = 40;

    public enum Attribute {
        NORMAL(0),
        BRIGHT(1),
        DIM(2),
        UNDERLINE(4),
        BLINK(5),
        REVERSE(7),
        //NONE(-1),
        HIDDEN(8);

        private String value;

        private Attribute(int value) {
            this.value = String.valueOf(value);
        }

        public String toString() {
            return "" + value;
        }
    }

    public enum Color {

        BLACK("0"),
        RED("1"),
        GREEN("2"),
        YELLOW("3"),
        BLUE("4"),
        MAGENTA("5"),
        CYAN("6"),
        WHITE("7"),
        NONE("");

        private final String _code;        //AnsiColourProperty escape code

        /**
         * Enum's constructor. Associates a code to a Background Color.
         *
         * @param code to associate
         */
        Color(String code) {
            _code = code;
        }

        /**
         * @return AnsiColourProperty escape code for that Foreground Color.
         */
        public String getCode() {
            return _code;
        }

        /**
         * @return The text representation of the enum (its code).
         */
        @Override
        public String toString() {
            return getCode();
        }

    }


    private static final String PREFIX = "\u001b["; //NOI18N
    private static final String SUFFIX = "m";
    private static final String SEPARATOR = ";";
    private static final String END = PREFIX + SUFFIX;


    public static String format(String text, Color foreground) {
        return format(text, null, foreground, null);
    }

    public static String format(String text, Color foreground,
                                Color background) {
        return format(text, null, foreground, background);
    }

    public static String format(String text, Attribute attr,
                                Color foreground, Color background) {
        StringBuilder buff = new StringBuilder();

        if (attr != null)
            buff.append(attr);

        if (foreground != null) {
            if (buff.length() > 0)
                buff.append(SEPARATOR);
            buff.append(FONT_COLOR_BASE + foreground.ordinal());
        }

        if (background != null) {
            if (buff.length() > 0)
                buff.append(SEPARATOR);
            buff.append(BACK_COLOR_BASE + background.ordinal());
        }

        buff.insert(0, PREFIX);
        buff.append(SUFFIX);
        buff.append(text);
        buff.append(END);
        return buff.toString();
    }


}