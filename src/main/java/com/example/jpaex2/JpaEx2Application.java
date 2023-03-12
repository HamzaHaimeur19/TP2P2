package com.example.jpaex2;

import com.example.jpaex2.entities.Role;
import com.example.jpaex2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.example.jpaex2.services.UserService;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEx2Application implements CommandLineRunner {
    //injection des dependances
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JpaEx2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setUsername("Hamza12");
        u.setPassword("123");
        userService.addUser(u);

        User u2 = new User();
        u2.setUsername("Hamid12");
        u2.setPassword("123");
        userService.addUser(u2);

        Stream.of("STUDENT", "ADMIN").forEach(s -> {
            Role r = new Role();
            r.setRoleName(s);
            userService.addRole(r);
        });

        userService.addRoletoUser("Hamid12", "ADMIN");
        userService.addRoletoUser("Hamza12", "STUDENT");

        User user = userService.authenticate("Hamid12", "123");
        System.out.println(user.getId());
        user.getRoles().forEach(r -> {
            System.out.println(r.getRoleName());
        });
        System.out.println(user.getUsername());
    }
}
