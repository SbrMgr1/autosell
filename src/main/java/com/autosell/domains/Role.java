package com.autosell.domains;

import com.autosell.configs.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    @Id
    private Integer id;

    @Size(max = 12)
    private String roleName;

    public Role() {
    }
    public Role(RoleEnum roleName) {

        if(this.roleName.equals(RoleEnum.ROLE_ADMIN)){
            this.id = 1;
            this.roleName = "ROLE_ADMIN";
        }else if(this.roleName.equals(RoleEnum.ROLE_SELLER)){
            this.id = 2;
            this.roleName = "ROLE_SELLER";
        }else{
            this.id = 3;
            this.roleName = "ROLE_BUYER";
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }
}
