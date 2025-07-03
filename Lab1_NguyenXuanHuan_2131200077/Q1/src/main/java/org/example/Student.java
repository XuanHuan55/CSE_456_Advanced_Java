package org.example;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private double gpa;
}
