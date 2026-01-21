package com.guvi.module4.student.service;

import com.guvi.module4.student.model.Student;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.StudentRepository;

import java.util.List;
import java.util.UUID;

// Thirumani
public class StudentService {

    private final StudentRepository repo;
    private final Notifier notifier;

    // Constructor injection
    public StudentService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public UUID registerStudent(String name, String email) {
        UUID id = UUID.randomUUID();
        Student student = new Student(id, name, email);
        repo.save(student);

        String welcomeMessage = "Welcome " + name + "your data stored successfully.";
        notifier.send(email, welcomeMessage);

        return id;
    }

    public List<Student> listStudents() {
        return repo.findAll();
    }
}

