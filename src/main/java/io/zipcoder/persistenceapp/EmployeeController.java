package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/api/employee")
    public ResponseEntity<Employee> create(Employee employee){
        return new ResponseEntity<>(service.create(employee), HttpStatus.OK);
    }

    @PutMapping("/api/employee/{id}")
    public ResponseEntity<Employee> update(Integer id, Employee employee){
        return new ResponseEntity<>(service.update(id, employee), HttpStatus.OK);
    }
}
