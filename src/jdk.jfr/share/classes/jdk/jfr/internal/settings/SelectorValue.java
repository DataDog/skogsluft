package jdk.jfr.internal.settings;

import jdk.jfr.internal.LogLevel;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;

public enum SelectorValue {
    ALL("all", (byte)0), CONTEXT("if-context", (byte)1), NONE("none", (byte)0xff);

    public final String key;
    public final byte value;

    SelectorValue(String key, byte value) {
        this.key = key;
        this.value = value;
    }

    public static SelectorValue of(String option) {
        option = option == null || option.isEmpty() ? ALL.name().toLowerCase() : option;
        if (option.equals(ALL.key)) {
            return ALL;
        } else if (option.equals(CONTEXT.key)) {
            return CONTEXT;
        } else if (option.equals(NONE.key)) {
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.WARN, option + " is not recommended for production use, using " + ALL.key + " instead");
            return ALL;
        } else {
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.WARN, "Unknown selection: " + option + ", using default value " + ALL.key);
            return ALL;
        }
    }
}
