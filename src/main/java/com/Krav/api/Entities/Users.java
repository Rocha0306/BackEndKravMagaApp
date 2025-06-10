package com.Krav.api.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String Nome;

    private String Password;

    private String Smartphone_Number;

    private String Email;

    private String Faixa;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="Users_Roles",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name="Role_Id"))
    private List<Roles> Roles;

    
}
