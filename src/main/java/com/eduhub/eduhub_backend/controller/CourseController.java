package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.Student;
import com.eduhub.eduhub_backend.exception.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    static List<Course> courseList=new ArrayList<>();
    static {
        courseList.add(new Course("U23IT402","OS",3));
        courseList.add(new Course("U23IT401","CC",3));
        courseList.add(new Course("U23IT403","FSD",4));
        courseList.add(new Course("U23QM400","QM",3));
        courseList.add(new Course("U23MA382","Maths",4));
    }
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

    @GetMapping("/allcourse")
    public ResponseEntity<List<Course>> getAllCourse(){
        return new ResponseEntity<>(courseList, HttpStatus.OK);
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

    @GetMapping("/course/{code}")
    public ResponseEntity<Course> getCourse(@PathVariable String code){
        return courseList.stream().filter(c->c.getCourseCode().equals(code)).findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourseNotFoundException("Course","CourseCode",code));
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        courseList.add(course);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<Course> updateCourse(@PathVariable String code,@RequestBody Course updateCourse){
        Course course =courseList.stream().filter(c->c.getCourseCode().equalsIgnoreCase(code)).findFirst().orElseThrow(()-> new ResourseNotFoundException("Course","CourseCode",code));
        course.setCourseCode(updateCourse.getCourseCode());
        course.setSubjectName(updateCourse.getSubjectName());
        course.setCredits(updateCourse.getCredits());
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteCourse(@PathVariable String code){
        Course course =courseList.stream().filter(c->c.getCourseCode().equalsIgnoreCase(code)).findFirst().orElseThrow(()-> new ResourseNotFoundException("Course","CourseCode",code));
        courseList.remove(course);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/query/{code}")
    public String queryCourse(@PathVariable String code)throws Exception{
        if(code.startsWith("*")){
            throw new IllegalArgumentException("It is having a sepcial character");
        }
        else if(code.startsWith("*")){
            throw new Exception();
        }
        return code;
    }
}
