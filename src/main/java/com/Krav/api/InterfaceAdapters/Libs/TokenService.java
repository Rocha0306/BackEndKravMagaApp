package com.Krav.api.InterfaceAdapters.Libs;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Elements.JWT;

@Service
public class TokenService {
    public String generateToken() {
        Algorithm chave = Algorithm.HMAC256("Chave Secreta");
        String Token = com.auth0.jwt.JWT.create()


    }

    public boolean verifyToken(String token) {

    }
}
