package org.training.model.entities;

import org.training.model.entities.datafields.DataField;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represent a single user record
 */
public class UserRecord {
    private Set<DataField> dataFields;

    private UserRecord(Builder builder) {
        dataFields = builder.dataFields;
    }

    public static class Builder {
        private Set<DataField> dataFields;

        public Builder() {
            dataFields = new LinkedHashSet<>();
        }

        public Builder addDataField(DataField dataField) {
            if(dataField.isFieldValid()) {
                dataFields.add(dataField);
                return this;
            }

            throw new IllegalArgumentException(dataField.getFieldName() +" has incorrect value: " + dataField.getValue());
        }

        public UserRecord build() {
            return new UserRecord(this);
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(DataField field: dataFields) {
            stringBuilder.append(field).append("\n");
        }

        return stringBuilder.toString();
    }
}
