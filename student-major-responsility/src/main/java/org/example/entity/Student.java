package org.example.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="Student")
public class Student {
    @Id
    @Column(name = "Id",columnDefinition = "char(10)")
    private String id;

    @Column(name = "Name",columnDefinition = "varchar(50)",nullable = false)
    private String name;

    @Column(name ="Year of birth")
    private int yob;

    @Column(name = "GPA")
    private double gpa;

}
