package com.jotasantos.springbootcrud.springbootcrud.core.entities;

import com.jotasantos.springbootcrud.springbootcrud.enums.EnumStatusUsuario;
import com.jotasantos.springbootcrud.springbootcrud.utils.DataUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private EnumStatusUsuario statusUsuario;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Usuario() {
    }

    public Usuario(String nome, String email, EnumStatusUsuario statusUsuario) {
        this.nome = nome;
        this.email = email;
        this.statusUsuario = statusUsuario;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumStatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(EnumStatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isSuspenso() {
        return EnumStatusUsuario.SUSPENSO.getDescricao().equalsIgnoreCase(getStatusUsuario().getDescricao());
    }

    public boolean isInativo() {
        return EnumStatusUsuario.INATIVO.getDescricao().equalsIgnoreCase(getStatusUsuario().getDescricao());
    }

    public boolean isAtivo() {
        return EnumStatusUsuario.ATIVO.getDescricao().equalsIgnoreCase(getStatusUsuario().getDescricao());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", statusUsuario=" + statusUsuario +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
