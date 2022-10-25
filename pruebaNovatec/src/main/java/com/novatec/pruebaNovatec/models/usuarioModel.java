package com.novatec.pruebaNovatec.models;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class usuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String Nombre;
    private String tipoUsuario;
    private String email;

    public usuarioModel(Long id, String nombre, String tipoUsuario, String email) {
        this.id = id;
        this.Nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
    }

    public usuarioModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
