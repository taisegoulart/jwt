package dev.ifrs;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/segundo")
public class Segundo {

    @GET
    @Path("/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User")// para permitir diferentes roles no token esse comando é utilizado, caso tivesse mais de um, colocar {} dentro
    public int soma(@PathParam("a") int a, @PathParam("b") int b) {
        System.out.println("Taíse esteve aqui");
        return a + b;
    }
}