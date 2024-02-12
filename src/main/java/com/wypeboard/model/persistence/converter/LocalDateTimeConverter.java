package com.wypeboard.model.persistence.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.of("Europe/Copenhagen"));
        return Date.from(zdt.toInstant());

    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return LocalDateTime.ofInstant(dbData.toInstant(), ZoneId.of("Europe/Copenhagen"));
    }
}
