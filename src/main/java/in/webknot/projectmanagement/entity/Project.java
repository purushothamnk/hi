package in.webknot.projectmanagement.entity;
// entity/Project.java


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectType;
    private String sourceClient;
    private String endClient;
    private String projectDescription;
    private String projectStatus;

    @ManyToOne
    private Employee accountManager;

    @ManyToOne
    private Employee projectManager;

    @OneToMany(mappedBy = "project")
    private List<ProjectAllocation> allocations;

    // getters and setters
}
