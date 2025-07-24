package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dob;

    private double gpa;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major major;

    @ManyToOne
    @JoinColumn(name = "schoolId", nullable = false)
    private School school;

    @Column(nullable = false)
    private int enrollmentYear;

    public enum Gender {
        Male, Female, Other
    }


    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear, School school, Major major) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
        this.school = school;
        this.major = major;
    }
}
