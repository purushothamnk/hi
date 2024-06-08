package in.webknot.projectmanagement.service.impl;



import in.webknot.projectmanagement.entity.Project;
import in.webknot.projectmanagement.repository.ProjectRepository;
import in.webknot.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long projectId, Project project) {
        Project existingProject = projectRepository.findById(projectId).orElseThrow();
        existingProject.setProjectType(project.getProjectType());
        existingProject.setSourceClient(project.getSourceClient());
        existingProject.setEndClient(project.getEndClient());
        existingProject.setProjectDescription(project.getProjectDescription());
        existingProject.setProjectStatus(project.getProjectStatus());
        existingProject.setAccountManager(project.getAccountManager());
        existingProject.setProjectManager(project.getProjectManager());
        return projectRepository.save(existingProject);
    }

    @Override
    public Project getProjectDetails(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow();
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}

