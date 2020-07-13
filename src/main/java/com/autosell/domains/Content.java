package com.autosell.domains;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
public class Content implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;


    //@UniqueSlug
   // @NotEmpty
    //@NotNull
    @Id
    private String slug;
    //@NotEmpty
    //@Size(min = 5, max = 50)
    private String name;
    //@NotEmpty
    private String cont;

    public Content() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Content(String slug,String name, String cont){
        this.slug = slug;
        this.name=name;
        this.cont =cont;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getCont() {
        return cont;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCont(String content) {
        this.cont = content;
    }
}
