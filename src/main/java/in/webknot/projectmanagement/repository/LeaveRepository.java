package in.webknot.projectmanagement.repository;


import in.webknot.projectmanagement.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
