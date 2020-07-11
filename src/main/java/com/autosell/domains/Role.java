package com.autosell.domains;

import com.autosell.configs.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private RoleEnum roleName;

    public Role() {
    }
    public Role(RoleEnum roleName) {
        this.roleName = roleName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }
}
