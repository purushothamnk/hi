package in.webknot.projectmanagement.service.impl;



import in.webknot.projectmanagement.entity.Leave;
import in.webknot.projectmanagement.repository.LeaveRepository;
import in.webknot.projectmanagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public Leave requestLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getLeavesByEmployee(Long employeeId) {
        return leaveRepository.findAll().stream()
                .filter(leave -> leave.getEmployee().getId().equals(employeeId))
                .collect(Collectors.toList());
    }
}
