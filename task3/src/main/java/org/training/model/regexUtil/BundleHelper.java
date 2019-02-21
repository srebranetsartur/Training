package org.training.model.regexUtil;

import java.util.ResourceBundle;

public final class BundleHelper {
    private static final String REGEX_BUNDLE_NAME = "regex";
    private static final String VALIDATOR_PREFIX = "data.validator.";

    private static ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME);

    public static String getFieldRegex(String fieldName) {
        return regexBundle.getString(VALIDATOR_PREFIX + fieldName);
    }
}
