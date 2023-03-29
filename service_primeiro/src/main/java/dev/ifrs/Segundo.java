package dev.ifrs;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;



@RegisterRestClient(baseUri = "http://localhost:8445/segundo")
@AccessToken // isso aqui está dizendo que quando chegar uma requisição manda outro pro outro serviço

public interface Segundo { //aqui a interface faz apenas a conexão

    @GET
    @Path("/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User")// para permitir diferentes roles no token esse comando é utilizado, caso tivesse mais de um, colocar {} dentro
    int soma(@PathParam("a") int a, @PathParam("b") int b);
    
}
