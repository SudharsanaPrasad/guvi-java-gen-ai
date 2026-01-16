package com.guvi.module4.student;

import com.guvi.module4.student.notify.ConsoleNotifier;
import com.guvi.module4.student.notify.Notifier;
import com.guvi.module4.student.repo.InMemoryStudentRepository;
import com.guvi.module4.student.repo.StudentRepository;
import com.guvi.module4.student.service.AttendanceService;
import com.guvi.module4.student.service.StudentService;

import java.time.LocalDate;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        // TODO:
        // 1) Create repo   <-- dependencies
        // Manage data -> talk to a database
        StudentRepository repo = new InMemoryStudentRepository();
        // 2) Create notifier   <-- dependencies
        Notifier notifier = new ConsoleNotifier();
        // 3) Create studentService with constructor injection
        // Write logic
        StudentService studentService = new StudentService(repo, notifier);
        // 4) Create attendanceService with constructor injection
        AttendanceService attendanceService = new AttendanceService(repo, notifier);
        // 5) Register a student
        UUID id = studentService.registerStudent("Ashik", "ashik@gmail.com");
        // 6) Mark present
        attendanceService.markPresent(id, LocalDate.now());
        // 7) Print list of students
        System.out.println(studentService.listStudents());

        UUID id2 = studentService.registerStudent("Tuvesh", "tuvesh@gmail.com");
        attendanceService.markPresent(id2, LocalDate.now());
        System.out.println(studentService.listStudents());

        // This is the "wiring" place in plain Java.
        // Later, Spring will do this wiring for you.
    }
}
