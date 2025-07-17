package org.example.service;

import org.example.entity.Major;
import org.example.repository.MajorRepository;
import java.util.List;

public class MajorService {
    private MajorRepository repo;

    public MajorService(MajorRepository repo) {
        this.repo = repo;
    }

    public void create(Major m) {
        repo.save(m);
    }

    public void update(Major m) {
        repo.update(m);
    }

    public List<Major> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.delete(id);
    }
}
