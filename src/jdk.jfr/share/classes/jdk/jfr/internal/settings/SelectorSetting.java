package jdk.jfr.internal.settings;

import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.SettingControl;
import jdk.jfr.internal.JVM;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;

import java.util.Objects;
import java.util.Set;

@MetadataDefinition
@Label("Selector")
@Name(Type.SETTINGS_PREFIX + "Selector")
public final class SelectorSetting extends JDKSettingControl {

    private final PlatformEventType eventType;
    private SelectorValue value;

    public SelectorSetting(PlatformEventType eventType) {
        this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public void setValue(String value) {
        this.value = SelectorValue.of(value);
        eventType.setSelector(this.value.ordinal());
    }

    @Override
    public String combine(Set<String> values) {
        SelectorValue combined = SelectorValue.NONE;
        return values.stream().map(SelectorValue::of).reduce(combined, (a, b) -> {
            if (a == SelectorValue.NONE) {
                return b;
            } else {
                // simplified check - only "all" and "if-context" values are supported for now
                return a == SelectorValue.ALL || b == SelectorValue.ALL ? SelectorValue.ALL : SelectorValue.CONTEXT;
            }
        }).key;
    }

    @Override
    public String getValue() {
        return value.key;
    }

    public boolean isSelected() {
        return switch (value) {
            case ALL -> true;
            case CONTEXT -> JVM.hasContext();
            case NONE -> false;
        };
    }
}