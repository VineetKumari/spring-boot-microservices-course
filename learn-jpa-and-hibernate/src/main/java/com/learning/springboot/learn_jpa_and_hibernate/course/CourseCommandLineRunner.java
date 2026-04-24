package com.learning.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.springboot.learn_jpa_and_hibernate.course.jpa.CourseJPARepository;
import com.learning.springboot.learn_jpa_and_hibernate.course.jpa.CourseSpringJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	/*
	 * @Autowired private CourseJdbcRepository courseJdbcRepository;
	 */
	
	@Autowired
	private CourseJPARepository courseJPARepository;
	
	@Autowired
	private CourseSpringJPARepository courseSpringJPARepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * courseJdbcRepository.insert(new Course(1l,"AWS Learning","Ranga"));
		 * courseJdbcRepository.insert(new Course(2l,"Azure","Ranga"));
		 * courseJdbcRepository.insert(new Course(3l,"GCP","Ranga"));
		 * 
		 * courseJdbcRepository.deleteById(1L);
		 * 
		 * System.out.println(courseJdbcRepository.getById(2L));
		 */
		
		/*
		 * courseJPARepository.insert(new Course(1l,"AWS Learning New","Ranga"));
		 * courseJPARepository.insert(new Course(2l,"Azure New","Ranga"));
		 * courseJPARepository.insert(new Course(3l,"GCP New","Ranga"));
		 * 
		 * courseJPARepository.deleteById(1L);
		 * 
		 * System.out.println(courseJPARepository.getById(2L));
		 */
		
		courseSpringJPARepository.save(new Course(1l,"AWS Learning JPA","Ranga"));
		courseSpringJPARepository.save(new Course(2l,"Azure JPA","Ranga"));
		courseSpringJPARepository.save(new Course(3l,"GCP JPA","Ranga"));
		
		courseSpringJPARepository.deleteById(1l);
		
		System.out.println(courseSpringJPARepository.findById(2L).get());
		System.out.println(courseSpringJPARepository.findByName("GCP JPA"));
		
	}
	

}
