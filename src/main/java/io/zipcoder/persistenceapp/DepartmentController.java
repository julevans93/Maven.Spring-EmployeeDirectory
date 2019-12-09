package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    @PostMapping("/api/department")
    public ResponseEntity<Department> create(@RequestBody Department department){
        return new ResponseEntity<>(service.create(department), HttpStatus.OK);
    }

    @PutMapping("/api/department/{id}")
    public ResponseEntity<Department> update(@RequestBody Integer id, @RequestBody Department department){
        return new ResponseEntity<>(service.update(id, department), HttpStatus.OK);
    }
}
