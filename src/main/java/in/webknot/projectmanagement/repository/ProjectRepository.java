package in.webknot.projectmanagement.repository;

// repository/ProjectRepository.java


import in.webknot.projectmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
