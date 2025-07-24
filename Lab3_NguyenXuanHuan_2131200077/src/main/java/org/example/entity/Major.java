package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    private String majorId;

    @Column(nullable = false, length = 100)
    private String majorName;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Student> students;

    public Major(String majorId, String majorName, School school) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.school = school;
    }

}
