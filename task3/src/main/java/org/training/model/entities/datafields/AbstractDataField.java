package org.training.model.entities.datafields;

import org.training.model.validator.Validator;
import java.util.Objects;

public abstract class AbstractDataField implements DataField {
    private String fieldName;
    private String value;
    public static final Validator VALIDATOR = (fieldName, value) -> {
        String regex = AllowedFields.FIELD_REGEX.get(fieldName);
        return AllowedFields.FIELD_REGEX.containsKey(fieldName) && value.matches(regex);
    };

    public AbstractDataField(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
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
