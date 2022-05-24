package com.assingment6.studentregistration.repositories;

import com.assingment6.studentregistration.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
