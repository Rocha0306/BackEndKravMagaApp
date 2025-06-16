package com.Krav.api.InterfaceAdapters.Libs;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.auth0.jwt.RegisteredClaims.ISSUER;
import static javax.crypto.Cipher.SECRET_KEY;
import static org.springframework.security.config.Elements.JWT;

@Service
public class TokenService {
    public String generateToken(String username) {

        //Define o algoritmo HMAC SHA256 para criar a assinatura do token passando a chave secreta definida
            Algorithm algorithm = Algorithm.HMAC256("secret");
            Instant tempo_expiracao = Instant.now().plusSeconds(1800);
            String Token = com.auth0.jwt.JWT.create().
                    withIssuer("Auth").withAudience("BackEndKravMaga").
                    withExpiresAt(tempo_expiracao)
                    .withSubject(username)
                    .sign(algorithm);

            return Token;

    }

    public String verifyToken(String token) throws JWTVerificationException {

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier jwtVerifier = com.auth0.jwt.JWT.require(algorithm).acceptExpiresAt(1800).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTDecodeException e) {
            throw new JWTDecodeException("Algum problema na decodificaçao do token, tu tá tentando invadir arrombado?");
        }


    }
}
