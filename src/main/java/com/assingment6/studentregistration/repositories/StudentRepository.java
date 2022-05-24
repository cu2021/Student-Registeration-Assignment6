/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assingment6.studentregistration.repositories;

import com.assingment6.studentregistration.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
