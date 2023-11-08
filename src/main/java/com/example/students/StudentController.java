package com.example.students;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student-list")
    public List numberOfStudents() {

        return studentService.getStudents();
    }

    @GetMapping("/student-list/{age}")
    public List numberOfStudents(@PathVariable("age") int age) {

        return studentService.studentDetailsByAge(age);
    }

    @PostMapping("/add-students")
    public void addStudents(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @PutMapping("/update-student/{name}")
    public void updateStudent(@RequestBody Student student, @PathVariable String name) {
        studentService.updateExistingStudent(name, student);
    }

    @GetMapping("/by-age/{targetAge}")
    public List<Student> getStudentsByAge(@PathVariable int targetAge){
        return studentService.getStudentsByOverAge(targetAge);
    }
}
