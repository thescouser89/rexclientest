package org.jboss.pnc;

import io.quarkiverse.openapi.generator.OidcClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;

@ApplicationScoped
public class AuthenticationHeaderFactory implements ClientHeadersFactory {

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        result.add(AUTHORIZATION, "Bearer " + "1234");
        return result;
    }
}