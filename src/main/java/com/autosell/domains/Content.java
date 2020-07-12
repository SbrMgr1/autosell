package com.autosell.domains;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Content")
public class Content implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    @Id
    private String slug;
    private String name;
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
