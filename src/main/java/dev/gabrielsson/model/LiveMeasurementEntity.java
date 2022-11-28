package dev.gabrielsson.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "LiveMeasurement")
public class LiveMeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    ZonedDateTime timestamp;
    Float power;
    Float lastMeterConsumption;
    Float accumulatedConsumption;
    Float accumulatedProduction;
    Float accumulatedConsumptionLastHour;
    Float accumulatedProductionLastHour;
    Float accumulatedCost;
    Float accumulatedReward;
    String currency;
    Float minPower;
    Float averagePower;
    Float maxPower;
    Float powerProduction;
    Float powerReactive;
    Float powerProductionReactive;
    Float minPowerProduction;
    Float maxPowerProduction;
    Float lastMeterProduction;
    Float powerFactor;
    Float voltagePhase1;
    Float voltagePhase2;
    Float voltagePhase3;
    Float currentL1;
    Float currentL2;
    Float currentL3;
    Integer signalStrength;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Float getLastMeterConsumption() {
        return lastMeterConsumption;
    }

    public void setLastMeterConsumption(Float lastMeterConsumption) {
        this.lastMeterConsumption = lastMeterConsumption;
    }

    public Float getAccumulatedConsumption() {
        return accumulatedConsumption;
    }

    public void setAccumulatedConsumption(Float accumulatedConsumption) {
        this.accumulatedConsumption = accumulatedConsumption;
    }

    public Float getAccumulatedProduction() {
        return accumulatedProduction;
    }

    public void setAccumulatedProduction(Float accumulatedProduction) {
        this.accumulatedProduction = accumulatedProduction;
    }

    public Float getAccumulatedConsumptionLastHour() {
        return accumulatedConsumptionLastHour;
    }

    public void setAccumulatedConsumptionLastHour(Float accumulatedConsumptionLastHour) {
        this.accumulatedConsumptionLastHour = accumulatedConsumptionLastHour;
    }

    public Float getAccumulatedProductionLastHour() {
        return accumulatedProductionLastHour;
    }

    public void setAccumulatedProductionLastHour(Float accumulatedProductionLastHour) {
        this.accumulatedProductionLastHour = accumulatedProductionLastHour;
    }

    public Float getAccumulatedCost() {
        return accumulatedCost;
    }

    public void setAccumulatedCost(Float accumulatedCost) {
        this.accumulatedCost = accumulatedCost;
    }

    public Float getAccumulatedReward() {
        return accumulatedReward;
    }

    public void setAccumulatedReward(Float accumulatedReward) {
        this.accumulatedReward = accumulatedReward;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getMinPower() {
        return minPower;
    }

    public void setMinPower(Float minPower) {
        this.minPower = minPower;
    }

    public Float getAveragePower() {
        return averagePower;
    }

    public void setAveragePower(Float averagePower) {
        this.averagePower = averagePower;
    }

    public Float getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Float maxPower) {
        this.maxPower = maxPower;
    }

    public Float getPowerProduction() {
        return powerProduction;
    }

    public void setPowerProduction(Float powerProduction) {
        this.powerProduction = powerProduction;
    }

    public Float getPowerReactive() {
        return powerReactive;
    }

    public void setPowerReactive(Float powerReactive) {
        this.powerReactive = powerReactive;
    }

    public Float getPowerProductionReactive() {
        return powerProductionReactive;
    }

    public void setPowerProductionReactive(Float powerProductionReactive) {
        this.powerProductionReactive = powerProductionReactive;
    }

    public Float getMinPowerProduction() {
        return minPowerProduction;
    }

    public void setMinPowerProduction(Float minPowerProduction) {
        this.minPowerProduction = minPowerProduction;
    }

    public Float getMaxPowerProduction() {
        return maxPowerProduction;
    }

    public void setMaxPowerProduction(Float maxPowerProduction) {
        this.maxPowerProduction = maxPowerProduction;
    }

    public Float getLastMeterProduction() {
        return lastMeterProduction;
    }

    public void setLastMeterProduction(Float lastMeterProduction) {
        this.lastMeterProduction = lastMeterProduction;
    }

    public Float getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Float powerFactor) {
        this.powerFactor = powerFactor;
    }

    public Float getVoltagePhase1() {
        return voltagePhase1;
    }

    public void setVoltagePhase1(Float voltagePhase1) {
        this.voltagePhase1 = voltagePhase1;
    }

    public Float getVoltagePhase2() {
        return voltagePhase2;
    }

    public void setVoltagePhase2(Float voltagePhase2) {
        this.voltagePhase2 = voltagePhase2;
    }

    public Float getVoltagePhase3() {
        return voltagePhase3;
    }

    public void setVoltagePhase3(Float voltagePhase3) {
        this.voltagePhase3 = voltagePhase3;
    }

    public Float getCurrentL1() {
        return currentL1;
    }

    public void setCurrentL1(Float currentL1) {
        this.currentL1 = currentL1;
    }

    public Float getCurrentL2() {
        return currentL2;
    }

    public void setCurrentL2(Float currentL2) {
        this.currentL2 = currentL2;
    }

    public Float getCurrentL3() {
        return currentL3;
    }

    public void setCurrentL3(Float currentL3) {
        this.currentL3 = currentL3;
    }

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Integer signalStrength) {
        this.signalStrength = signalStrength;
    }
}



