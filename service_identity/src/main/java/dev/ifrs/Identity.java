package dev.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/identity")
public class Identity {
    @GET
    @Path("/jwt") //caminho do GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate() {
    return Jwt.issuer("http://localhost:8080") //issuer é o emissor do JWT, é quem enviou, não precisa ser um link, é uma string
            .upn("rodrigo@rpmhub.dev") //identificação do usuário
            .groups(new HashSet<>(Arrays.asList("User", "Admin"))) //groups = perfis das roles que a gente quer implementar
            .claim(Claims.full_name, "Rodrigo Prestes Machado") //Claim é um payload, é a carga de dados dados propriamente ditos que tu quer colcoar, a informação propiramente dita que está sendo trafegada
            .sign(); //no padrão do quarkus não consigo dar sign sem chaves
            //nota: as chaves públicas são criadas a partir das chaves privadas, depois converte para um dos formatos aceitados
            //para criar as chaves usar o programa openSSL, a chave pública é distribuída com os outros serviços
            //precisa fazer a propagação do JWT por todo o programa
            //sign serve para o processo de validação, para assinar ele, mostrar que o token é válido, usa a chave privada para assinar
            
}
}
