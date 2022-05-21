package com.example.kms.Service;

import com.example.kms.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService {
    private int customerIdCount =1;
    private List <Customer> customerList= new ArrayList<>() ;
    public Customer addCustomer(@NotNull Customer customer) {
        customer.setCustomerId(customerIdCount);
        customerList.add(customer) ;
        customerIdCount++ ;
        return customer ;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    public Customer getCustomer (int customerId ) {

        return customerList.stream().filter(c->c.getCustomerId()==customerId).findFirst().get() ;
    }
    public Customer updateCustomer (int customerId, Customer customer ) {

        customerList.stream()
                .forEach(c->{ if ( c.getCustomerId() == customerId ) {

                    c.setCustomerFirstName(customer.getCustomerFirstName());
                    c.setCustomerLastName(customer.getCustomerLastName());
                    c.setCustomerEmail(customer.getCustomerEmail()); }

                });
        return customerList.stream().filter(c->c.getCustomerId()==customerId).findFirst().get() ;
    }

    public void deleteCustomer (int customerID) {

        customerList.stream().forEach(c->{if(c.getCustomerId() == customerID ) {
            customerList.remove(c) ; }
        });
    }
}
