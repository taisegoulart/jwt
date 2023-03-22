package dev.ifrs;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/primeiro")
public class Primeiro {
    @Inject
    @RestClient
    Segundo servico;

    @GET
    @Path("/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User")// para permitir diferentes roles no token esse comando é utilizado, caso tivesse mais de um, colocar {} dentro
    public int soma(@PathParam("a") int a, @PathParam("b") int b) {
        return a + b;
    }
}
