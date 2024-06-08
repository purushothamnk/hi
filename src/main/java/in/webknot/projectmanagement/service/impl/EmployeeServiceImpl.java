package in.webknot.projectmanagement.service.impl;

import in.webknot.projectmanagement.entity.Employee;
import in.webknot.projectmanagement.repository.EmployeeRepository;
import in.webknot.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public List<Employee> importEmployees(MultipartFile file) {
        List<Employee> importedEmployees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Assuming CSV format with comma-separated values

                // Create Employee object from CSV data
                Employee employee = new Employee();
                employee.setName(data[0]);
                employee.setEmail(data[1]);
                employee.setTechStack(data[2]);
                employee.setYearsOfExperience(Integer.parseInt(data[3]));
                employee.setYearsOfExperienceInWebknot(Integer.parseInt(data[4]));

                // Save employee to database
                importedEmployees.add(employeeRepository.save(employee));
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle error or logging as needed
        }

        return importedEmployees;
    }




    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


}
