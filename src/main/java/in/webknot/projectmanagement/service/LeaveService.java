package in.webknot.projectmanagement.service;

// service/LeaveService.java


import in.webknot.projectmanagement.entity.Leave;
import java.util.List;

public interface LeaveService {
    Leave requestLeave(Leave leave);
    List<Leave> getLeavesByEmployee(Long employeeId);
}
