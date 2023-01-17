package com.example.superboutiquedelolback.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_role")
    private String role;

    @Column(name = "mail")
    private String mail;

    @Column(name = "validate_by_admin")
    private Boolean validateByAdmin;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "detail_id")
    private DetailEntity detailEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Boolean getValidateByAdmin() {
        return validateByAdmin;
    }

    public void setValidateByAdmin(Boolean validateByAdmin) {
        this.validateByAdmin = validateByAdmin;
    }

    public DetailEntity getDetailEntity() {
        return detailEntity;
    }

    public void setDetailEntity(DetailEntity detailEntity) {
        this.detailEntity = detailEntity;
    }
}
