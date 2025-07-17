package org.example.service;

import org.example.entity.School;
import org.example.repository.SchoolRepository;
import java.util.List;

public class SchoolService {
    private SchoolRepository repo;

    public SchoolService(SchoolRepository repo) {
        this.repo = repo;
    }

    public void create(School s) {
        repo.save(s);
    }

    public void update(School s) {
        repo.update(s);
    }

    public List<School> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.delete(id);
    }
}
