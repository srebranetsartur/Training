package org.training.model.entities.datafields;

import java.util.*;

public class AllowedFields {
    public static final String PREFIX = "data.validator.";
    private AllowedFields() {}

    public static final Set<String> FIELD = Collections.unmodifiableSet(
            new HashSet<>(getKeysFromBundle())
    );

    private static List<String> getKeysFromBundle() {
        List<String> keyList = new ArrayList<>();

        ResourceBundle regexBundle = ResourceBundle.getBundle("regex", Locale.getDefault());
        Enumeration<String> keys = regexBundle.getKeys();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement().substring(PREFIX.length()).toLowerCase();
            keyList.add(key);
        }

        return keyList;
    }
}