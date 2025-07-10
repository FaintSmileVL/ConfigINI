package ru.property;

import java.io.IOException;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:40
 */
public interface IConfigStoreFormatter {
    /**
     * Adds property entry.
     *
     * @param key Entry key.
     * @param value Entry value.
     */
    public void addPair(String key, String value);

    /**
     * Generates configuration file text based on type of this store formatter.
     *
     * @return Generated configuration file.
     * @throws java.io.IOException Used to re-throw unusual exceptions during format.
     */
    public String generate() throws IOException;
}
