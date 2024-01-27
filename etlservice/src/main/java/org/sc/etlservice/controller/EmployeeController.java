package org.sc.etlservice.controller;

import org.sc.etlservice.exceptions.BadRequestException;
import org.sc.etlservice.exceptions.DataNotFoundException;
import org.sc.etlservice.model.Employee;
import org.sc.etlservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Mono<String> createEmp(Employee employee) {
        try {
            Employee ob = employeeRepository.save(employee);
            return Mono.just(ob.getId()+"")
                    .onErrorReturn("Error with input data");

        } catch (BadRequestException e) {
            return Mono.error(e);
        }
    }

    @GetMapping
    public Flux<List<Employee>> getAllEmployee() {
        return Flux.just(employeeRepository.findAll())
                .switchIfEmpty(Mono.error(DataNotFoundException::new));
    }

}
