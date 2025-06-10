package com.Krav.api.InterfaceAdapters.Database;


import com.Krav.api.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Users findbySmartPhoneNumber(String smartPhoneNumber);
}
