package org.example.bluemoon.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role != null ? role.getRoleVN() : null;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (Role role : Role.values()) {
            if (role.getRoleVN().equals(dbData)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Giá trị không hợp lệ: " + dbData);
    }
}
