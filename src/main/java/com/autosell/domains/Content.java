package com.autosell.domains;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
@Table(name = "Content")
public class Content implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;


    //@UniqueSlug
    @NotEmpty
    @NotNull
    @Id
    private String slug;
    @NotEmpty
    @Size(min = 5, max = 50, message = "{Size.name.validation}")
    private String name;
    @NotEmpty
    private String content;

    public Content() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Content(String slug,String name, String content){
        this.slug = slug;
        this.name=name;
        this.content =content;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
