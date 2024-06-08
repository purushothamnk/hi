package in.webknot.projectmanagement.entity;

// entity/ProjectAllocation.java


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ProjectAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectRole;
    private int allocationPercentage;
    private int durationWeeks;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;

    // getters and setters
}
