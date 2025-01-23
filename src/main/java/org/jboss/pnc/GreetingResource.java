package org.jboss.pnc;

import io.quarkus.logging.Log;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.pnc.rex.client.api.TaskEndpointApi;
import org.jboss.pnc.rex.client.api.VersionEndpointApi;
import org.jboss.pnc.rex.client.model.TaskDTO;

import java.net.URI;
import java.util.Set;

@Path("/hello")
public class GreetingResource {

    @RestClient
    @Inject
    VersionEndpointApi api;

    @Inject
    TaskEndpointApi taskEndpointApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        Set<TaskDTO> tasks = taskEndpointApi.getAll(false, null, null);
        return tasks.toString();
    }
}
