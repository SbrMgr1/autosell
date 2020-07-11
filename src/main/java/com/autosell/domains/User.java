package com.autosell.domains;

import com.autosell.configs.RoleEnum;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    private boolean adminVerification;

    private Short userStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdminVerification() {
        return adminVerification;
    }

    public void setAdminVerification(boolean adminVerification) {
        this.adminVerification = adminVerification;
    }

    public Short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Short userStatus) {
        this.userStatus = userStatus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(RoleEnum roleEnum) {
        this.role = new Role(roleEnum);
    }
}
