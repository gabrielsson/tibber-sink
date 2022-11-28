package dev.gabrielsson;

import dev.gabrielsson.service.MeasurementPersister;
import dev.gabrielsson.service.TibberSubscriptionService;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Startup
@ApplicationScoped
public class TibberSink {

    private static final Logger log = Logger.getLogger(TibberSink.class);

    @Inject
    TibberSubscriptionService sub;

    @Inject
    MeasurementPersister persister;

    public void onStart(@Observes StartupEvent ev) {
        sub.sub().emitOn(Infrastructure.getDefaultExecutor()).subscribe().with(persister::persist, this::error);
    }

    private void error(Throwable f) {
        log.error("err", f);
    }

}
