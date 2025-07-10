package ru.property;

import java.util.Map;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:41
 */
public class ConfigStoreFormatterIni extends ConfigStoreFormatterImpl {
    @Override
    public String generate() {
        String lineSeparator = System.getProperty("line.separator");
        boolean isFirstField = true;
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> pair : pairs.entrySet()) {
            if (isFirstField)
                isFirstField = false;
            else
                builder.append(lineSeparator).append(lineSeparator);

            builder.append(pair.getKey()).append(" = ").append(pair.getValue());
        }

        return builder.toString();
    }
}
