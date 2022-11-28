package dev.gabrielsson.service;

import dev.gabrielsson.repository.LiveMeasurementRepository;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.Map;

@Liveness
@ApplicationScoped  
public class SinkHealthCheck implements HealthCheck {

    @Inject
    LiveMeasurementRepository repository;

    @Override
    public HealthCheckResponse call() {
        long count = repository.count("timestamp > :timestamp",
                Map.of("timestamp", ZonedDateTime.now().minusMinutes(1)));
        if(count > 0) {
            return HealthCheckResponse.up("Recent timestamps");
        }

        return HealthCheckResponse.down("No recent timestamps");
    }
}