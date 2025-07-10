package org.example.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Date_of_birth") // hoặc columnDefinition = "INT" nếu cần
    private int yob;

    @Column(name = "GPA")
    private double gpa;

    // Constructors
    public Student() {}

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }
    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
