package com.example.jpaex2.services;

import com.example.jpaex2.entities.Role;
import com.example.jpaex2.entities.User;


public interface UserService {


    User addUser(User user); // methode pour ajouter un utilisateur

    Role addRole(Role role); // ajouter un role

    User findUserByUserName(String username); // chercher utiliateur par nom utilisateur

    Role findRoleByRoleName(String rolename); // chercher role pasr son nom

    void addRoletoUser(String username, String rolename); // affecter un role à un utilisateur

    User authenticate(String username, String password); // authentifier utilisateur
}
