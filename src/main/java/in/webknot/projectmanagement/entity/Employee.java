package in.webknot.projectmanagement.entity;



import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String techStack;
    private int yearsOfExperience;
    private int yearsOfExperienceInWebknot;

    @OneToMany(mappedBy = "employee")
    private List<ProjectAllocation> allocations;

    // getters and setters
}
