package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "Credits", columnDefinition = "INT")
    private int credits;

    public Subject() {
    }

    public Subject(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + credits + " credits)";
    }
}

