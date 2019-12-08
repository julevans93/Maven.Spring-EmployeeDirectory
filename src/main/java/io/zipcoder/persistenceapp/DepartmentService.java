package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class DepartmentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/API")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        this.jdbcTemplate.execute("INSERT INTO DEPARTMENT (DEPARTMENT_NUMBER, DEPARTMENT_NAME, DEPARTMENT_MANAGER)" +
                "VALUES ('"+department.getDepartmentNumber()+"', '"+department.getDepartmentName()+"', '"+department.getDepartmentManager()+"';)");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
