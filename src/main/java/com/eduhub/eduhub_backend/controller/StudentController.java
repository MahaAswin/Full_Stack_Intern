package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Maha","Aswin"));
        studentList.add(new Student(2,"hello","Ram"));
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
