package com.example.kms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity  // This tells Hibernate to make a table out of this class */
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("id")
    private int customerId;

    @JsonProperty("firstName")
    private String customerFirstName;
    @JsonProperty("lastName")

    private String customerLastName;
    @JsonProperty("email")
    private String customerEmail;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
