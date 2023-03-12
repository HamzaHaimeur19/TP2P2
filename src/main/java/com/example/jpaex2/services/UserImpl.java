package com.example.jpaex2.services;

import com.example.jpaex2.entities.Role;
import com.example.jpaex2.entities.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.jpaex2.repositories.RoleRepository;
import com.example.jpaex2.repositories.UserRepository;

import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class UserImpl implements UserService {

    //injection des dependances via constructeur


    private UserRepository userrepository;
    private RoleRepository rolerepository;


    @Override
    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString()); // génerer un user Id aleatoirement et le convertir en String
        return userrepository.save(user); // ajouter et commiter utilisateur
    }

    @Override
    public Role addRole(Role role) {
        return rolerepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userrepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String rolename) {
        return rolerepository.findByRoleName(rolename);
    }

    @Override
    public void addRoletoUser(String username, String rolename) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(rolename);

        if (user.getRoles() != null) {
            user.getRoles().add(role); // ajouter role à l'utilisateur à l'aide du getter de l'utilisateur
            role.getUsers().add(user);
        } else {
            throw new RuntimeException("L'utilisateur n'a aucun role");
        }

    }

    @Override
    public User authenticate(String username, String password) {
        User user = userrepository.findByUsername(username);
        if (user == null) throw new RuntimeException("infos erronés!");
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("infos erronés!");
        }
    }
}
