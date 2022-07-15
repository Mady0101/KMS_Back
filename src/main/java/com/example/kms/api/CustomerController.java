package com.example.kms.api;

import com.example.kms.Service.CustomerService;
import com.example.kms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService ;
    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer) {

        return customerService.addCustomer(customer );
    }
    // return all the costumers
    @GetMapping
    public List<Customer> getCustomers () {
        return customerService.getCustomerList() ;
    }
    // return specific customer by id
    @GetMapping (value = "/{customerID}")
    public Customer getCustomer (@PathVariable("customerID")UUID customerID) {

        return customerService.getCustomer(customerID) ;
    }
    // update-customer


    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer ) {
        return customerService.updateCustomer(customer) ;


    }

    @DeleteMapping(value = "/{customerID}")

    public void deleteCustomer (@PathVariable("customerID") UUID customerID )  {
        customerService.deleteCustomer(customerID);
    }



}

