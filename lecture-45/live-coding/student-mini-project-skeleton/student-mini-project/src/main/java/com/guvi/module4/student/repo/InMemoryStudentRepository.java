package com.guvi.module4.student.repo;

import com.guvi.module4.student.model.Student;

import java.util.*;

public class InMemoryStudentRepository implements StudentRepository {

    // TODO:
    // Pick one:
    // 1) Map<UUID, Student> store = new HashMap<>();
    // 2) List<Student> store = new ArrayList<>();

    @Override
    public void save(Student student) {
        // TODO: store the student
    }

    @Override
    public Optional<Student> findById(UUID id) {
        // TODO: return student if present
    }

    @Override
    public List<Student> findAll() {
        // TODO: return all students
    }
}
