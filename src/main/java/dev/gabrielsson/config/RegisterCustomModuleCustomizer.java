package dev.gabrielsson.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Singleton

public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper mapper) {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(OffsetDateTime.class, OffsetDateTimeSerializer.INSTANCE);
        module.addSerializer(LocalDateTime.class, LocalDateTimeSerializer.INSTANCE);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(module);
    }
}