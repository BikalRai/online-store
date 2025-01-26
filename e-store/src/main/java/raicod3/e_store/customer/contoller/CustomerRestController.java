package raicod3.e_store.customer.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raicod3.e_store.customer.dto.CustomerRegisterRequestDTO;
import raicod3.e_store.customer.dto.CustomerResponseDTO;
import raicod3.e_store.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public ResponseEntity<CustomerResponseDTO> registerCustomer(@RequestBody CustomerRegisterRequestDTO customerRegReqDTO) {
        return new ResponseEntity<>(customerService.registerCustomer(customerRegReqDTO), HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<Customer> getCustomer() {
//
//    }

}
