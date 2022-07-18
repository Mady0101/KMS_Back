package com.example.kms.Service;

import com.example.kms.dao.CustomerRepository;
import com.example.kms.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerService {
    /*private UUID customerIdCount =1;
    private List <Customer> customerList= new ArrayList<>() ;
    public Customer addCustomer(@NotNull Customer customer) {
        customer.setId(customerIdCount);
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
    }*/
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(@NotNull Customer customer) {
       customerRepository.save(customer);
       return customer;
    }
	
	 public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
	 
	public Customer getCustomer (UUID id ) {
		return customerRepository.getById(id);
	}
	
	public Customer updateCustomer (@NotNull Customer customer) {
		if(customerRepository.existsById(customer.getId())) {
			customerRepository.save(customer);
			return customer;
		}
		return null;
	}
	
	
	public void deleteCustomer (UUID id) {
		customerRepository.deleteById(id);
		
	}
	
}
