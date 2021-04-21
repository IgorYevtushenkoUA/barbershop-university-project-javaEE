package com.example.barbershop;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class StringToInstantConverter implements Converter<String, Instant> {

    @Override
    public Instant convert(@NonNull String s) {
        var formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("UTC"));
        return OffsetDateTime.parse(s, formatter).toInstant();
    }
}

class InstantToStringConverter implements Converter<Instant, String> {
    @Override
    public String convert(@NonNull Instant instant) {
        var formatter = DateTimeFormatter
                .ISO_OFFSET_DATE_TIME
                .withZone(ZoneId.of("UTC"));

        return formatter.format(instant);
    }
}

public class InstantJsonSerializer extends StdSerializer<Instant> {

    public InstantJsonSerializer() {
        this(Instant.class);
    }

    public InstantJsonSerializer(Class<Instant> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        var formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.of("UTC"));
        var str = formatter.format(instant);
        jsonGenerator.writeString(str);
    }
}