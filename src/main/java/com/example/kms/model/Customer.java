package com.example.kms.model;

import com.example.kms.SpringJwt.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity  // This tells Hibernate to make a table out of this class */
@Table(name = "CUSTOMER")



public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;



    @JsonProperty("password")
    @NotBlank
    @Size(max = 120)
    private String password ;


    @JsonProperty("userName")
    @NotBlank
    @Size(max = 20)
    private String customerUserName;
    
    

    
    @JsonProperty("email")
    @NotBlank
    @Size(max = 50)
    @Email
    private String customerEmail;
    
    
    @OneToMany(mappedBy="customer")
    private Set<CryptoKey> cryptoKeys;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Customer(UUID id) {
        this.id = id;
    }

    public Customer() { } ;



    public Customer (String customerUserName, String customerEmail, String password) {

        this.customerUserName= customerUserName ;
        this.customerEmail = customerEmail ;
        this.password =password ;
    }


    public Customer(UUID id, String password, String customerUserName, String customerEmail, Set<CryptoKey> cryptoKeys, Set<Role> roles) {
        this.id = id;
        this.password = password;
        this.customerUserName = customerUserName;
        this.customerEmail = customerEmail;
        this.cryptoKeys = cryptoKeys;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
