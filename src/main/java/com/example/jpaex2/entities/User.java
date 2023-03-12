package com.example.jpaex2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    private String id;

    @Column(name = "USER_NAME", unique = true, length = 20) // valeur de username ne peut pas avoir de doublons
    private String username;
    private String password;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER) // fetch eager permet de charger les roles des utilisateurs
    private List<Role> roles = new ArrayList<>(); // ArrayList afin d'eviter probleme de NullPointerException

}
