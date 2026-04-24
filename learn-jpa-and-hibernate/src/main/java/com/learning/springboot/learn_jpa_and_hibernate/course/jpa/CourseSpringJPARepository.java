package com.learning.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringJPARepository extends JpaRepository<Course, Long>
{
public Course findByName(String name);

}

