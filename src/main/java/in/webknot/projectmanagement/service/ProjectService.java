package in.webknot.projectmanagement.service;



import in.webknot.projectmanagement.entity.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project updateProject(Long projectId, Project project);
    Project getProjectDetails(Long projectId);
    void deleteProject(Long projectId);
    List<Project> getAllProjects();
}
