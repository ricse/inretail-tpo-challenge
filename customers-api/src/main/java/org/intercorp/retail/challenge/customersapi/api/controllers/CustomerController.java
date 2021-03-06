package org.intercorp.retail.challenge.customersapi.api.controllers;

import org.intercorp.retail.challenge.customersapi.api.dtos.CustomerDTO;
import org.intercorp.retail.challenge.customersapi.api.services.CustomerService;
import org.intercorp.retail.challenge.customersapi.domain.models.CustomerKpi;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public List<CustomerDTO> listCustomers(
            @RequestParam(required = false) Optional<Integer> limit,
            @RequestParam(required = false) Optional<Integer> offset) {
        return customerService.listCustomers(limit.orElse(10), offset.orElse(0));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/customers", method = RequestMethod.POST)
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @RequestMapping(value = "/customers/kpis",method = RequestMethod.GET)
    public CustomerKpi getCustomerKpi() {
        return customerService.getCustomerKpi();
    }

}
