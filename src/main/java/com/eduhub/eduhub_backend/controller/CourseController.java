package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/course")
    public ResponseEntity<List<Course>> getCourse(){
        List<Course> CourseList=new ArrayList<>();
        CourseList.add(new Course("U23IT402","OS",3));
        CourseList.add(new Course("U23IT401","CC",3));
        CourseList.add(new Course("U23IT403","FSD",4));
        CourseList.add(new Course("U23QM400","QM",3));
        CourseList.add(new Course("U23MA382","Maths",4));
        return new ResponseEntity<>(CourseList, HttpStatus.OK);
    }

    @GetMapping("course/{courseCode}/{subjectName}/{credits}")
    public ResponseEntity<Course> getCoursePar(@PathVariable("courseCode")String code,
                                              @PathVariable("subjectName")String subject,
                                              @PathVariable("credits")int credits){
        Course course =new Course(code,subject,credits);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/stdquery")
    public ResponseEntity<Course> studentRequestParam(@RequestParam String code,
                                                       @RequestParam String subject,
                                                       @RequestParam int credits){
        Course course =new Course(code,subject,credits);
        return ResponseEntity.ok(course);
    }
}
