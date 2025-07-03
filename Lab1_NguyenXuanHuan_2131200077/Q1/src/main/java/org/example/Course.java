package org.example;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hours;
}
