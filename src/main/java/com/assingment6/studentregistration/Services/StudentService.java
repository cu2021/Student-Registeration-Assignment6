/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assingment6.studentregistration.Services;

import com.assingment6.studentregistration.models.Student;
import com.assingment6.studentregistration.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> showAll() {
        return this.studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return this.studentRepository.findById(id).get();
    }

    public void addStudent(Student student) {
        this.studentRepository.save(student);
    }

}
