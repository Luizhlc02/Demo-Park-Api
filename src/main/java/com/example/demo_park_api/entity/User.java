package com.example.demo_park_api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
//@Data (gerar getters, setters, construtores e tostring's)
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "usermane", nullable = false,unique = true, length = 100)
    private String username;
    @Column(name = "password", nullable = false, length = 200)
    private String password; 
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 25)
    private Role Role;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @Column(name = "data_modificao")
    private LocalDateTime dataModificao;
    @Column(name = "criado_por")
    private String criadoPor;
    @Column(name = "modificado_por")
    private String modificadoPor;


    public enum Role{
        ROLE_ADMIN,ROLE_CLIENTE
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);

    }
    @Override 
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}