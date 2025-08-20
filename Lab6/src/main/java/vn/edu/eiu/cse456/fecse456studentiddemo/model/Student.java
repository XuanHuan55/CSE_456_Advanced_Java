package vn.edu.eiu.cse456.fecse456studentiddemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    // Initialize mapping ORM
    @Id
    @Column(name = "ID", columnDefinition = "CHAR(5)")
    // Initialize validator
    @Size(min = 5, max = 5, message = "Length of ID must be exactly 5 characters.")
    @NotBlank(message = "ID must not be blank.")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(100)", nullable = false)
    //Validate
    @NotNull(message = "")
    @Size(min = 5, max = 100, message = "Length of the name must be between 5 and 100.")
    @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Each word must start with an uppercase letter"
    )
    private String name;


    @Column(name = "Year of Birth", nullable = false)
    @Max(value = 2200, message = "Must be born before 2006.")
    @Min(value = 1990, message = "Must be born after 2000.")
    private int yob;

    @Column(name = "GPA", nullable = false)
    @Max(value = 200, message = "Must be lower or equal to 200.")
    @Min(value = 0, message = "Must be greater than 0.")
    private double gpa;

    @ManyToOne()
    @JoinColumn(name = "MajorID") // the name of the foreign key ( col )
    private Major major;

    //Build a constructor without major because when instantiating a new student, we dont have the info of her major.
    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }
}
