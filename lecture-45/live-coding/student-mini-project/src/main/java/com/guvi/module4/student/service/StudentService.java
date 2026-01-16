package com.guvi.module4.student.service;

import com.guvi.module4.student.model.Student;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.StudentRepository;

import java.util.List;
import java.util.UUID;

public class StudentService {

    // TODO:
    // 1) Add fields: StudentRepository repo, Notifier notifier
    // 2) Constructor injection: StudentService(StudentRepository repo, Notifier notifier)

    public UUID registerStudent(String name, String email) {
        // TODO:
        // 1) Create UUID -> UUID id = UUID.randomUUID();
        // 2) Create Student
        // 3) repo.save(student)
        // 4) notifier.send(email, welcomeMessage)
        // 5) return UUID
    }

    public List<Student> listStudents() {
        // TODO: return ALL Students
    }
}
