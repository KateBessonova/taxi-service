package mappers;

import models.Customer;

import java.util.List;

public interface CustomerMapper {

    Customer selectCustomerById(int id);
    List<Customer> selectCustomerAll();
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
