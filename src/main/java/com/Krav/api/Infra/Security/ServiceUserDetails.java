package com.Krav.api.Infra.Security;

import com.Krav.api.Entities.Users;
import com.Krav.api.InterfaceAdapters.Database.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public abstract class ServiceUserDetails implements UserDetailsService {



    private UsersRepository usersRepository;

    @Autowired
    public ServiceUserDetails(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findbySmartPhoneNumber(username);
        Objects.requireNonNull(user, "User Not Found"); //se for nulo aqui ele lanca um NullPointerException
        return new UserDetailsEntity(user);
    }
}
