package ru.property;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:40
 */
public interface IPropertyListener {
    /**
     * When parsing of configuration file starts.
     *
     * @param path Path to configuration file.
     */
    public void onStart(String path);

    /**
     * When some property is missing.
     *
     * @param name Missed property name.
     */
    public void onPropertyMiss(String name);

    /**
     * When done parsing configuration file.
     *
     * @param path File path.
     */
    public void onDone(String path);

    /**
     * When property value casting is invalid.
     *
     * @param name Property name.
     * @param value Casted value.
     */
    public void onInvalidPropertyCast(String name, String value);
}
