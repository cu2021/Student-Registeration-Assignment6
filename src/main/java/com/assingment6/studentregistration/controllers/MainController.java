package com.assingment6.studentregistration.controllers;

import com.assingment6.studentregistration.models.Student;
import com.assingment6.studentregistration.repositories.CourseRepository;
import com.assingment6.studentregistration.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String Index() {
        return String.format("%s", "JPA Useing Spring Boot");
    }

    @RequestMapping("/showAll")
    public String showAll() {                
        List<Student> students = studentRepository.findAll();
        String str = "";
        for (Student s : students) {
            str += s + "<br>";
        }
        return str;
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).get();
        String str = student.toString();

        return str;
    }

}
