package com.Krav.api.Infra.Exceptions;


import com.Krav.api.Infra.Notifications.Emails;
import com.Krav.api.InterfaceAdapters.DTOs.ExceptionDTO;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ExceptionalHandler {


    private final HttpServletResponse httpServletResponse;

    @Autowired
    private Emails mail;

    public ExceptionalHandler(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @ExceptionHandler
    public ExceptionDTO HandleDecodeJWT(JWTDecodeException jwtException) {
        httpServletResponse.setStatus(400);
        return new ExceptionDTO("Exception mapeada safe", "algum problema no token amigao, nulo, tu tentou quebrar sla", 400, "", "");
    }

    @ExceptionHandler
    public ExceptionDTO HandleExceptionsNotMapped(Exception ex) {
        httpServletResponse.setStatus(500);
        List<String> emails = List.of("l.m.p.rocha2005@gmail.com", "albertstanley927@gmail.com");
         mail.SendEmail(emails, ex.getMessage(), Arrays.toString(ex.getStackTrace()));

        return new ExceptionDTO("Exception nao mapeada, ih rapaz", ex.getMessage(), 500, Arrays.toString(ex.getStackTrace()), ex.toString());
    }

    @ExceptionHandler
    public ExceptionDTO HandleVerificationJWT(JWTVerificationException ex) {
        httpServletResponse.setStatus(400);
        return new ExceptionDTO("Exception mapeada safe", "Token invalido ou já expirou", 400, "", "");

    }

    @ExceptionHandler
    public ExceptionDTO HandleDadosDuplicados(DataIntegrityViolationException ex) {
        httpServletResponse.setStatus(400);
        return new ExceptionDTO("Exception mapeada safe", "Isso já existe no banco", 400, "", "");
    }


}
