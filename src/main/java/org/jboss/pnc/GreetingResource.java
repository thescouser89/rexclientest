package org.jboss.pnc;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.pnc.rex.client.api.TaskEndpointApi;
import org.jboss.pnc.rex.client.api.VersionEndpointApi;
import org.jboss.pnc.rex.client.model.TaskSetResponse;

@Path("/hello")
public class GreetingResource {

    @RestClient
    @Inject
    VersionEndpointApi api;

    @RestClient
    @Inject
    TaskEndpointApi taskEndpointApi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        TaskSetResponse response = taskEndpointApi.getAll(false, null, null);
        return response.toString();
//        return "here";
    }
}
