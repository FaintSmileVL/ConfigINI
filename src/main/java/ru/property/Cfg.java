package ru.property;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:39
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Alice
 * @date : 23.11.16
 * @time : 3:44
 * <p/>
 * desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface Cfg
{
    /**
     * Custom property name. Can be used when real property name differs from class field.
     */
    String value() default "";

    /**
     * Splitter that can be used for splitting settings into arrays & collections.
     */
    String splitter() default ";";

    /**
     * Should be set up to true if you with to ignore some field of class.
     */
    boolean ignore() default false;

    /**
     * Prefix of property name can be used for batch loading of property sets with prefixes
     * For example, let properties be: db.name, db.user, db.password
     * then we can load them by annotating class by {@link Cfg} annotation:
     * <pre>{@literal @}Cfg(prefix = "db.")
     * class MyDatabaseConfig
     * {
     *     // ...
     * }
     * </pre>
     */
    String prefix() default "";

    /**
     * Allows parametrization of properties.
     * Parametrization is pre-work of parser and it affects native string values from property file.
     * Property parameters is sequence: ${key}, where key is property name from configuration file.
     */
    boolean parametrize() default false;
}
