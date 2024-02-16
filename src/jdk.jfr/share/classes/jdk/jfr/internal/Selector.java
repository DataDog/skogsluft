package jdk.jfr.internal;

import jdk.jfr.MetadataDefinition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Selector {
    String NAME = "select";

    /**
     * Event selector.
     * Supported values are "all" and "if-context". More values may be added in the future.
     *
     * @return the selector; default is "all", not {@code null}
     */
    String value() default "all";
}
