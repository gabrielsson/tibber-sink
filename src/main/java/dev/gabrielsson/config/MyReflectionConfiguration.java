package dev.gabrielsson.config;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@RegisterForReflection(targets={ OffsetDateTime.class, ZonedDateTime.class})
public class MyReflectionConfiguration {
}