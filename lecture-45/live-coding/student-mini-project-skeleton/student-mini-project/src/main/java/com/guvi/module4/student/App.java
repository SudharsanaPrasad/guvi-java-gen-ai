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
        // 1) Create repo
        // 2) Create notifier
        // 3) Create studentService with constructor injection
        // 4) Create attendanceService with constructor injection
        // 5) Register a student
        // 6) Mark present
        // 7) Print list of students

        // This is the "wiring" place in plain Java.
        // Later, Spring will do this wiring for you.
    }
}
