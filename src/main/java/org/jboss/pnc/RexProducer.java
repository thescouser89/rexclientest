package org.jboss.pnc;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.pnc.rex.client.api.TaskEndpointApi;

import java.net.URI;

@ApplicationScoped
public class RexProducer {

    @ConfigProperty(name = "quarkus.rest-client.rexclient.url")
    String rexUrl;

    @Inject
    AuthenticationHeaderFactory authenticationHeaderFactory;

    @Produces
    @ApplicationScoped
    public TaskEndpointApi taskEndpointApiProducer() {
        return QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(rexUrl))
                .clientHeadersFactory(authenticationHeaderFactory)
                .build(TaskEndpointApi.class);
    }
}
