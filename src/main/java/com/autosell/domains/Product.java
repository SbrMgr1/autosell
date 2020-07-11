package com.autosell.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank()
    @Size(min = 4, max = 50, message = "{Size.name.validation}")
    String name;
    @NotBlank
    Float price;
    @NotBlank
    Float tax;
    @NotBlank
    Long cat_id;
    String description;
    String product_image;
    @NotNull
    Long added_by;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Long getAdded_by() {
        return added_by;
    }

    public void setAdded_by(Long added_by) {
        this.added_by = added_by;
    }
}
