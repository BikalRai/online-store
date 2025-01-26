package raicod3.e_store.customer.dto;

import raicod3.e_store.address.model.Address;
import raicod3.e_store.customer.model.Customer;

public class CustomerResponseDTO {

    private int id;
    private String name;
    private Address address;
    private String phone;
    private String email;

    public CustomerResponseDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
