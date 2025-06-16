package com.Krav.api.Infra.Security;


import com.Krav.api.InterfaceAdapters.Libs.TokenService;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private ServiceUserDetails serviceUserDetails;

    @Autowired
    public AuthenticationFilter(TokenService tokenService, ServiceUserDetails serviceUserDetails) {
        this.tokenService = tokenService;
        this.serviceUserDetails = serviceUserDetails;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.startsWith("/Auth") ||
                uri.startsWith("/Users") ||
                uri.startsWith("/swagger-ui") ||
                uri.startsWith("/v3/api-docs") ||
                uri.startsWith("/swagger-resources") ||
                uri.startsWith("/webjars")) {

            filterChain.doFilter(request, response);
            return;
        }


        else {
            String Header = request.getHeader("Authorization");
            if(Header == null) {
                throw new JWTVerificationException("Cade o token filho da puta");
            }

            String Token = Header.replace("Bearer", "").trim();

            String Email = tokenService.verifyToken(Token);

            UserDetails userDetails = serviceUserDetails.loadUserByUsername(Email);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);

        }
    }
}
