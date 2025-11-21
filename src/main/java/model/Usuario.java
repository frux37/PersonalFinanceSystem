/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;
    
    @Column(name = "usu_nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "usu_email", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "usu_senha", length = 255, nullable = false)
    private String senha;
    
    @Column(name = "usu_perfil", length = 20, nullable = false)
    private String perfil; // ADMIN, USUARIO

    // Construtores
    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters e Setters (ALT + INSERT)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}
