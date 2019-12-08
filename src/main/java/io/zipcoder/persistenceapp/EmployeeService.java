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
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/API")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        this.jdbcTemplate.execute("INSERT INTO EMPLOYEE (EMPLOYEE_NUMBER, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL, HIRE_DATE, MANAGER, DEPARTMENT_NUMBER)" +
                "VALUES ('"+employee.getEmployeeNumber()+"', '"+employee.getFirstName()+"', '"+employee.getLastName()+"', '"+employee.getPhoneNumber()+"'" +
                ", '"+employee.getEmail()+"', '"+employee.getHireDate()+"', '"+employee.getManager()+"', '"+employee.getManager()+"', '"+employee.getDepartmentNumber()+"');");
                return new ResponseEntity<>(HttpStatus.OK);
    }
}
