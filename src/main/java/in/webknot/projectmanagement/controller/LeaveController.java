package in.webknot.projectmanagement.controller;



import in.webknot.projectmanagement.entity.Leave;
import in.webknot.projectmanagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/add")
    public Leave requestLeave(@RequestBody Leave leave) {
        return leaveService.requestLeave(leave);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Leave> getLeavesByEmployee(@PathVariable Long employeeId) {
        return leaveService.getLeavesByEmployee(employeeId);
    }
}
