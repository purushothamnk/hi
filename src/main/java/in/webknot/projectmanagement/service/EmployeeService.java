package in.webknot.projectmanagement.service;


import in.webknot.projectmanagement.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    Employee createEmployee(Employee employee);
    List<Employee> importEmployees(MultipartFile file);
}

