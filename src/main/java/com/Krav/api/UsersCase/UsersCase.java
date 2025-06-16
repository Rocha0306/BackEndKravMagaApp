package com.Krav.api.UsersCase;

import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;
import com.Krav.api.InterfaceAdapters.Database.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersCase extends CrudCases<Usuarios> {

    private UsersRepository usersRepository;

    private PasswordEncoder encoder;
    @Autowired
    public UsersCase(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.encoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void Registration(Usuarios users) {
        UUID uuid = UUID.randomUUID();
        users.setId(uuid);
       users.setSenha(encoder.encode(users.getSenha()));
       users.setRole("ALUNO");
        usersRepository.save(users);
    }

    @Override
    public List<Usuarios> Find() {
        return usersRepository.findAll();
    }

    @Override
    public Usuarios Delete(Usuarios usersparametro) {
        Usuarios usersdatabase = usersRepository.findByEmail(usersparametro.getEmail());
        if(usersdatabase == null) {
            throw new IllegalArgumentException("Nao ta no banco lixo");
        }
        usersparametro.setId(usersdatabase.getId());
        usersRepository.delete(usersdatabase);
        return usersdatabase;
    }

    @Override
    public Usuarios Update(Usuarios usersparametro) {
        Usuarios usersdatabase = usersRepository.findByEmail(usersparametro.getEmail());
        if(usersdatabase == null) {
            throw new IllegalArgumentException("Nao ta no banco lixo");
        }
        usersparametro.setId(usersdatabase.getId());
        usersRepository.save(usersdatabase);
        return usersdatabase;
    }

}
