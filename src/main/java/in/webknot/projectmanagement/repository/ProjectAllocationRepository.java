package in.webknot.projectmanagement.repository;



import in.webknot.projectmanagement.entity.ProjectAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectAllocationRepository extends JpaRepository<ProjectAllocation, Long> {
}
