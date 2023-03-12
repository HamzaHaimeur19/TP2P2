package com.example.jpaex2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String roleName;

    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude // exclure cette objet de toString pour eviter l'exception de null
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // eviter probleme de boucle infinie
    private List<User> users = new ArrayList<>();
}
