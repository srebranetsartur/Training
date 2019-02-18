package org.training.model.entities.datafields;

import java.util.*;

public class AllowedFields {
    public static final String PREFIX = "data.validator.";
    private AllowedFields() {}

    public static final Map<String, String> FIELD_REGEX = Collections.unmodifiableMap(
            new HashMap<>(convertResourceBundleToMap())
    );

    private static Map<String, String> convertResourceBundleToMap() {
        Map<String, String> fieldRegex = new LinkedHashMap<>();

        ResourceBundle regexBundle = ResourceBundle.getBundle("regex", Locale.getDefault());
        Enumeration<String> keys = regexBundle.getKeys();
        while(keys.hasMoreElements()) {
            String fullKey = keys.nextElement();
            String key = fullKey.substring(PREFIX.length());
            fieldRegex.put(key, regexBundle.getString(fullKey));
        }

        return Collections.unmodifiableMap(fieldRegex);
    }
}