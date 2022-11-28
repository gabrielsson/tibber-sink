package dev.gabrielsson.repository;

import dev.gabrielsson.model.LiveMeasurementEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LiveMeasurementRepository implements PanacheRepository<LiveMeasurementEntity> {
}