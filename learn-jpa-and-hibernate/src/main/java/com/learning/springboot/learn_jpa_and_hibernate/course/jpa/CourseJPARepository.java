package com.learning.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {
	@Autowired
	private EntityManager em;

	public void insert(Course course) {
		em.merge(course);
	}

	public void deleteById(Long id) {
		em.remove(em.find(Course.class, id));
	}

	public Course getById(Long id) {
		return em.find(Course.class, id);
	}

}
