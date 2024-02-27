package org.demo.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
/*import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Mapping("id")
    @Id
    private long key;
    @Column(nullable = false, length = 80)
    private String userName;
    @Column(nullable = false, length = 80)
    private String email;

    public UsuarioVO() {
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioVO usuarioVO)) return false;
        if (!super.equals(o)) return false;
        return getKey() == usuarioVO.getKey() && Objects.equals(getUserName(), usuarioVO.getUserName()) && Objects.equals(getEmail(), usuarioVO.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getUserName(), getEmail());
    }
}
