package org.demo.models;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 80)
    private String userName;
    @Column(nullable = false, length = 80)
    private String email;
    @Column(nullable = false, length = 80)
    private String password;

    public Usuario() {
    }

    public void setId(long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario cliente)) return false;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getUserName(), cliente.getUserName()) && Objects.equals(getEmail(), cliente.getEmail()) && Objects.equals(getPassword(), cliente.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getEmail(), getPassword());
    }


}
