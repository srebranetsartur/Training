package org.training.model.entities.datafields;

import org.training.model.validator.Validator;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public abstract class AbstractDataField implements DataField {
    private String fieldName;
    private String value;
    private String regex;
    private Validator validator;

    public AbstractDataField(String name, String value) {
        this.fieldName = name;
        this.value = value;
        regex = initRegex(name);
        validator = String::matches;
    }

    public boolean isFieldValid() {
        return validator.validate(fieldName, regex);
    }

    private String initRegex(String propertySuffix) {
        return ResourceBundleHelper.getRegexFromProperty(propertySuffix);
    }

    private static class ResourceBundleHelper {
        private static String getRegexFromProperty(final String propertySuffix) {
            ResourceBundle regexResourceBundle = ResourceBundle.getBundle("regex", Locale.getDefault());
            String propertyName = createPropertyName(propertySuffix);
            return regexResourceBundle.getString(propertyName);
        }

        private static String createPropertyName(String propertySuffix) {
            return AllowedFields.PREFIX + propertySuffix.toLowerCase();
        }
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof DataField)) return false;
        DataField df = (DataField) obj;
        return value.equals(df.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, value);
    }

    @Override
    public String toString() {
        return getFieldName() + ": " + getValue();
    }
}
