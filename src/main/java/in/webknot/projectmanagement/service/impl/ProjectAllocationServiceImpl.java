package in.webknot.projectmanagement.service.impl;



import in.webknot.projectmanagement.entity.ProjectAllocation;
import in.webknot.projectmanagement.repository.ProjectAllocationRepository;
import in.webknot.projectmanagement.service.ProjectAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
    @Autowired
    private ProjectAllocationRepository projectAllocationRepository;

    @Override
    public ProjectAllocation allocateEmployeeToProject(ProjectAllocation allocation) {
        return projectAllocationRepository.save(allocation);
    }

    @Override
    public void removeEmployeeFromProject(Long allocationId) {
        projectAllocationRepository.deleteById(allocationId);
    }

    @Override
    public List<ProjectAllocation> getAllocationsByProject(Long projectId) {
        return projectAllocationRepository.findAll().stream()
                .filter(allocation -> allocation.getProject().getId().equals(projectId))
                .collect(Collectors.toList());
    }
}
