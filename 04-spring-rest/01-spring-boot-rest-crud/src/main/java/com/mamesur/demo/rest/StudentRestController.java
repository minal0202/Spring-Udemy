package com.mamesur.demo.rest;

import com.mamesur.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Maria", "Rossi"));
        theStudents.add(new Student("Marry", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }
}
