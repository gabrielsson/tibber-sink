package dev.gabrielsson.service;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.Response;
import io.smallrye.graphql.client.core.Document;
import io.smallrye.graphql.client.core.Field;
import io.smallrye.graphql.client.core.OperationType;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClientBuilder;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static io.smallrye.graphql.client.core.Argument.arg;
import static io.smallrye.graphql.client.core.Argument.args;
import static io.smallrye.graphql.client.core.Document.document;
import static io.smallrye.graphql.client.core.Field.field;
import static io.smallrye.graphql.client.core.Operation.operation;

@ApplicationScoped
public class TibberSubscriptionService {

    @ConfigProperty(name = "tibber.home")
    String home;

    @Inject
    @GraphQLClient("tibber-dynamic")
    DynamicGraphQLClient dynamicClient;

    @Blocking
    public Multi<Response> sub() {
        Field[] collect = Arrays.asList("timestamp",
            "power",
            "lastMeterConsumption",
            "accumulatedConsumption",
            "accumulatedProduction",
            "accumulatedConsumptionLastHour",
            "accumulatedProductionLastHour",
            "accumulatedCost",
            "accumulatedReward",
            "currency",
            "minPower",
            "averagePower",
            "maxPower",
            "powerProduction",
            "powerReactive",
            "powerProductionReactive",
            "minPowerProduction",
            "maxPowerProduction",
            "lastMeterProduction",
            "powerFactor",
            "voltagePhase1",
            "voltagePhase2",
            "voltagePhase3",
            "currentL1",
            "currentL2",
            "currentL3",
            "signalStrength").stream()
                .map(Field::field).toList().toArray(new Field[0]);

        Document b = document(operation(
                OperationType.SUBSCRIPTION, field("liveMeasurement",
                    args(arg("homeId", home)),
                    collect)
                ));
        return dynamicClient.subscription(b);
    }
}