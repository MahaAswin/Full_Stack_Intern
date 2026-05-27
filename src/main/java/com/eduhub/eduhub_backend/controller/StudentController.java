package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //@PathVariable is used to extract the value directly from the URL itself.
    @GetMapping("{id}/{firstname}/{lastname}")
    public ResponseEntity<Student> getStudentPath(@PathVariable("id") int studentId,
                                 @PathVariable("firstname") String firstname,
                                 @PathVariable("lastname") String lastname){
        Student student =new Student(studentId,firstname,lastname);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //http://localhost:8080/query?id=1&firstname=Maha&lastname=Aswin
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int studentid,
                                                       @RequestParam String firstname,
                                                       @RequestParam String lastname){
        Student student =new Student(studentid,firstname,lastname);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}/update")
    public ResponseEntity updateStudent(@PathVariable("id")int studentid,
                                        @RequestBody Student student){
        return ResponseEntity.accepted().body(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable("id") int studentid){
        return ResponseEntity.accepted().body("Deleted successfully");
    }
}
