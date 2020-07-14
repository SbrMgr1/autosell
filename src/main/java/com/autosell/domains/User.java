package com.autosell.domains;

import com.autosell.annotations.EmailUnique;
import com.autosell.annotations.UserNameUnique;
import com.autosell.configs.RoleEnum;
import org.apache.tomcat.jni.Address;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4,max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 4,max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 4,max = 50)
    @UserNameUnique
    private String userName;

    @NotBlank
    @Size(min = 4)
    private String password;


    @NotBlank
    @Email
    @EmailUnique
    private String email;

    private Short adminVerification = 0;

    private Short userStatus = 0;

    private Long points = 0l;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Authority> authorities;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BillingAddress> billingAddress;

    public User() {
        authorities = new ArrayList<Authority>();
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
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

    public Short getAdminVerification() {
        return adminVerification;
    }

    public void setAdminVerification(Short adminVerification) {
        this.adminVerification = adminVerification;
    }

    public Short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Short userStatus) {
        this.userStatus = userStatus;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(RoleEnum roleEnum) {
        this.authorities.add(new Authority(this,roleEnum));
    }

    public List<ShippingAddress> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public List<BillingAddress> getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(List<BillingAddress> billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
