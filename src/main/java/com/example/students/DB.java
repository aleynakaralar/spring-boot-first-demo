package com.example.students;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DB {
    List<Student> studentList = new ArrayList<>();

    public void add(Student student) {
        studentList.add(student);
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

}
