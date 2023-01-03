package com.example.superboutiquedelolback.dto;

public class UserDto {

    private Integer id;

    private String name;

    private String password;

    private String mail;

    private String role;

    private Boolean validateByAdmin;

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
}
