package io.zipcoder.persistenceapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository repository){
        this.departmentRepository = repository;
    }

    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public Department update(Integer id, Department newDepartmentData){
        Department originalDepartment = departmentRepository.findOne(id);
        originalDepartment.setDepartmentManager(newDepartmentData.getDepartmentManager());
        originalDepartment.setDepartmentName(newDepartmentData.getDepartmentName());
        return departmentRepository.save(originalDepartment);
    }
}
