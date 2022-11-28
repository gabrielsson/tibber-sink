package dev.gabrielsson.service;

import dev.gabrielsson.model.LiveMeasurement;
import dev.gabrielsson.model.LiveMeasurementEntity;
import dev.gabrielsson.repository.LiveMeasurementRepository;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.graphql.client.Response;
import io.smallrye.mutiny.Uni;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MeasurementPersister {
    @Inject
    LiveMeasurementRepository repository;

    @Transactional
    @Blocking
    public void persist(Response r) {
        toEntity(r).ifPresent(repository::persist);
    }

    private Optional<LiveMeasurementEntity> toEntity(Response r) {
        try {
            LiveMeasurement liveMeasurement = r.getObject(LiveMeasurement.class, "liveMeasurement");
            return Optional.of(toLiveMeasurementEntity(liveMeasurement));
        } catch (NoSuchElementException e){
            return Optional.empty();
        }
    }

    private LiveMeasurementEntity toLiveMeasurementEntity(LiveMeasurement liveMeasurement) {
        LiveMeasurementEntity liveMeasurementEntity = new LiveMeasurementEntity();
        liveMeasurementEntity.setAccumulatedConsumption(liveMeasurement.accumulatedConsumption());
        liveMeasurementEntity.setAccumulatedCost(liveMeasurement.accumulatedCost());
        liveMeasurementEntity.setAccumulatedConsumptionLastHour(liveMeasurement.accumulatedConsumptionLastHour());
        liveMeasurementEntity.setAccumulatedProduction(liveMeasurement.accumulatedProduction());
        liveMeasurementEntity.setCurrency(liveMeasurement.currency());
        liveMeasurementEntity.setAccumulatedReward(liveMeasurement.accumulatedReward());
        liveMeasurementEntity.setAveragePower(liveMeasurement.averagePower());
        liveMeasurementEntity.setPower(liveMeasurement.power());
        liveMeasurementEntity.setCurrentL1(liveMeasurement.currentL1());
        liveMeasurementEntity.setCurrentL2(liveMeasurement.currentL2());
        liveMeasurementEntity.setCurrentL3(liveMeasurement.currentL3());
        liveMeasurementEntity.setLastMeterConsumption(liveMeasurement.lastMeterConsumption());
        liveMeasurementEntity.setLastMeterProduction(liveMeasurement.lastMeterProduction());
        liveMeasurementEntity.setMaxPower(liveMeasurement.maxPower());
        liveMeasurementEntity.setMinPower(liveMeasurement.minPower());
        liveMeasurementEntity.setMaxPowerProduction(liveMeasurement.maxPowerProduction());
        liveMeasurementEntity.setMinPowerProduction(liveMeasurement.minPowerProduction());
        liveMeasurementEntity.setPowerFactor(liveMeasurement.powerFactor());
        liveMeasurementEntity.setPowerProduction(liveMeasurement.powerProduction());
        liveMeasurementEntity.setPowerProductionReactive(liveMeasurement.powerProductionReactive());
        liveMeasurementEntity.setSignalStrength(liveMeasurement.signalStrength());
        liveMeasurementEntity.setTimestamp(liveMeasurement.timestamp());
        liveMeasurementEntity.setVoltagePhase1(liveMeasurement.voltagePhase1());
        liveMeasurementEntity.setVoltagePhase2(liveMeasurement.voltagePhase2());
        liveMeasurementEntity.setVoltagePhase3(liveMeasurement.voltagePhase3());
        return liveMeasurementEntity;
    }
}
