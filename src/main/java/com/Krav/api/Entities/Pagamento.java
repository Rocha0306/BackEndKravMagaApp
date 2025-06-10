package com.Krav.api.Entities;


import jakarta.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;


    @OneToOne
    @JoinTable(name = "Users", joinColumns = @JoinColumn(name = "ID"))
    private Users user;

    /*

    Entendimento do conceito de relacionamento em:

   SQL --

   CREATE TABLE USER (


   )

   CREATE TABLE PAGAMENTO (
   ID INT PRIMARY KEY,
   METODO_PAGAMENTO VARCHAR(500) NOT NULL,
   USER_ID INT FOREGIN KEY (USER_ID) REFERENCES USER(ID)

   )



   JPA --

    public class User {


    }

    public class Pagamento {

    @OneToOne
    @JoinTable(name = "User", )
    private User user;

    }

     */

}
