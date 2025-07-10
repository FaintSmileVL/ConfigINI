package ru.property;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:40
 */
public abstract class ConfigStoreFormatterImpl implements IConfigStoreFormatter {
    protected Map<String, String> pairs = new LinkedHashMap<>();

    @Override
    public void addPair(String key, String value) {
        if (!pairs.containsKey(key))
            pairs.put(key, value);
    }
}
