package com.Krav.api.Infra.Security;



import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsEntity implements UserDetails {

    private Usuarios user;

    public UserDetailsEntity(Usuarios user) {
        this.user = user;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         Collection<SimpleGrantedAuthority> unique_roles = new ArrayList<>();
         unique_roles.add(new SimpleGrantedAuthority(user.getRole()));
        return unique_roles;
    }


    @Override
    public String getPassword() {
        return user.getSenha();
    } // Retorna a credencial do usuário que criamos anteriormente

    @Override
    public String getUsername() {
        return user.getEmail();
    } // Retorna o nome de usuário do usuário que criamos anteriormente

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
