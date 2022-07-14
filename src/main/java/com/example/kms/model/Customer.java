package com.example.kms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;


@Entity  // This tells Hibernate to make a table out of this class */
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;


    @JsonProperty("firstName")
    private String customerFirstName;
    
    
    @JsonProperty("lastName")
    private String customerLastName;
    
    
    @JsonProperty("email")
    private String customerEmail;
    
    
    @OneToMany(mappedBy="customer")
    private Set<CryptoKey> cryptoKeys;

    
    

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
