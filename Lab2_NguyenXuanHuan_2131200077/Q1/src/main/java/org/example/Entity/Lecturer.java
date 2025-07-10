package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "Department", columnDefinition = "VARCHAR(50)")
    private String department;

    public Lecturer() {
    }

    public Lecturer(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter & Setter
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + " - " + name + " [" + department + "]";
    }
}

