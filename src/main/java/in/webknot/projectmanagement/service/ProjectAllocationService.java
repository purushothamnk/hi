package in.webknot.projectmanagement.service;



import in.webknot.projectmanagement.entity.ProjectAllocation;

import java.util.List;

public interface ProjectAllocationService {
    ProjectAllocation allocateEmployeeToProject(ProjectAllocation allocation);
    void removeEmployeeFromProject(Long allocationId);
    List<ProjectAllocation> getAllocationsByProject(Long projectId);
}
