package raicod3.e_store.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raicod3.e_store.customer.dto.CustomerRegisterRequestDTO;
import raicod3.e_store.customer.dto.CustomerResponseDTO;
import raicod3.e_store.customer.model.Customer;
import raicod3.e_store.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    // method for registering new customer / user
    public CustomerResponseDTO registerCustomer (CustomerRegisterRequestDTO customerRegisterRequestDTO) {


        // check if both email and phone number exists in the database
        if(customerRepo.existsByEmail(customerRegisterRequestDTO.getEmail())) {
            throw new RuntimeException("Email address already in use");
        }

        if(customerRepo.existsByPhone(customerRegisterRequestDTO.getPhone())) {
            throw new RuntimeException("Phone number already in use");
        }

        // create new customer and save in the database
        Customer newCustomer = new Customer();
        newCustomer.setEmail(customerRegisterRequestDTO.getEmail());
        newCustomer.setPhone(customerRegisterRequestDTO.getPhone());
        newCustomer.setPassword(customerRegisterRequestDTO.getPassword());
        newCustomer.setName(customerRegisterRequestDTO.getName());
        newCustomer.setAddress(customerRegisterRequestDTO.getAddress());



        return new CustomerResponseDTO(customerRepo.save(newCustomer));
    }

}
