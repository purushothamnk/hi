package in.webknot.projectmanagement.repository;

// repository/EmployeeRepository.jav
import in.webknot.projectmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
