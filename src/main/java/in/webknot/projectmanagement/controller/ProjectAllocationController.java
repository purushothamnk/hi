package in.webknot.projectmanagement.controller;



import in.webknot.projectmanagement.entity.ProjectAllocation;
import in.webknot.projectmanagement.service.ProjectAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ProjectAllocationController {
    @Autowired
    private ProjectAllocationService projectAllocationService;

    @PostMapping("/add")
    public ProjectAllocation allocateEmployeeToProject(@RequestBody ProjectAllocation allocation) {
        return projectAllocationService.allocateEmployeeToProject(allocation);
    }

    @DeleteMapping("/{allocationId}")
    public void removeEmployeeFromProject(@PathVariable Long allocationId) {
        projectAllocationService.removeEmployeeFromProject(allocationId);
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectAllocation> getAllocationsByProject(@PathVariable Long projectId) {
        return projectAllocationService.getAllocationsByProject(projectId);
    }
}
