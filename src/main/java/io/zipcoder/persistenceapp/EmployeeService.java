package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class EmployeeService {
    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public Employee create(Employee employee){
        return repository.save(employee);
    }

    public Employee update( Integer id, Employee newEmployeeData){
        Employee originalEmployee = repository.findOne(id);
        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setEmail(newEmployeeData.getEmail());
        originalEmployee.setHireDate(newEmployeeData.getHireDate());
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setDepartmentId(newEmployeeData.getDepartmentId());
        return repository.save(originalEmployee);
    }

    //list of employees under particular manager
    public List<Employee> underManagement(Integer id){
        Iterable<Employee> employeeList = repository.findAll();
        List employeesUnderManager = new ArrayList();
        for (Employee employee : employeeList){
            if (employee.getManager().equals(id)){
                employeesUnderManager.add(employee);
            }
        }
        return employeesUnderManager;
    }

    //list of employees with no manager
    public List<Employee> noManager(){
        Iterable<Employee> employeeList = repository.findAll();
        List employeesNoManager = new ArrayList();
        for (Employee employee : employeeList){
            if (employee.getManager().equals(null)){
                employeesNoManager.add(employee);
            }
        }
        return employeesNoManager;
    }

    //list of employees in particular department
    public List<Employee> employeeDepartment(Integer id){
        Iterable<Employee> employeeList = repository.findAll();
        List departmentList = new ArrayList();
        for (Employee employee : employeeList){
            if (employee.getDepartmentId().equals(id)){
                departmentList.add(employee);
            }
        }
        return departmentList;
     }

     //remove all employees from particular department
    public Boolean removeFromDepartment(Integer id){
        List<Employee> employeesInDepartment = employeeDepartment(id);
        employeesInDepartment.clear();
        return true;
    }

    //remove all employees under particular manager
    public Boolean removeFromManager(Integer id){
        List<Employee> employeesUnderManagement = underManagement(id);
        employeesUnderManagement.clear();
        return true;
    }
}
