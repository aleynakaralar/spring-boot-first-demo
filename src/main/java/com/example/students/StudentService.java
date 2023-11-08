package com.example.students;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final DB db;

    public List<Student> getStudents() {


        Student student1 = new Student(UUID.randomUUID().toString(), "aleyna", 24);
        Student student2 = new Student(UUID.randomUUID().toString(), "kutay", 15);
        db.add(student1);
        db.add(student2);

        return db.getAllStudent();

    }

    public List<Student> studentDetailsByAge(int age) {
        List<Student> studentsByAge = new ArrayList<>();
        List<Student> studentList = getStudents();
        for (Student student : studentList) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

    public void addNewStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        db.add(student);

    }

    public void updateExistingStudent(String name, Student student) {
        List<Student> allStudents = db.getAllStudent();
        for (Student studentTemp : allStudents) {
            if (studentTemp.getName().equals(name)) {
                int i = allStudents.indexOf(studentTemp);
                allStudents.set(i, student);
            }
        }

    }

    public List<Student> getStudentsByOverAge(int targetAge) {
        List<Student> allStudents = db.getAllStudent();
        List<Student> result = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getAge() > targetAge) {
                result.add(student);
            }
        }
        return result;
    }


}
