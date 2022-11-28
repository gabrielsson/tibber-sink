package dev.gabrielsson.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.ZonedDateTime;

@RegisterForReflection
public record LiveMeasurement(
    ZonedDateTime timestamp,
    Float power,
    Float lastMeterConsumption,
    Float accumulatedConsumption,
    Float accumulatedProduction,
    Float accumulatedConsumptionLastHour,
    Float accumulatedProductionLastHour,
    Float accumulatedCost,
    Float accumulatedReward,
    String currency,
    Float minPower,
    Float averagePower,
    Float maxPower,
    Float powerProduction,
    Float powerReactive,
    Float powerProductionReactive,
    Float minPowerProduction,
    Float maxPowerProduction,
    Float lastMeterProduction,
    Float powerFactor,
    Float voltagePhase1,
    Float voltagePhase2,
    Float voltagePhase3,
    Float currentL1,
    Float currentL2,
    Float currentL3,
    Integer signalStrength) {
}


