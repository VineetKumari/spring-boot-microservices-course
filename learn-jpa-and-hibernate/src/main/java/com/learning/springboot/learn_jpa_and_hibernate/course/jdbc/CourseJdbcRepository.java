package com.learning.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String insert_sql = """
			insert into course ( id, name, author)
			values (?, ?, ?)
			""";

	private static String select_sql = """
			Select * from course where id=?
			""";

	private static String delete_sql = """
			delete from course where id=?
				""";

	public void insert(Course course) {
		jdbcTemplate.update(insert_sql, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(Long id) {
		jdbcTemplate.update(delete_sql, id);
	}
	
	public Course getById(Long id) {
		RowMapper<Course> rm=new BeanPropertyRowMapper<>(Course.class);
		return jdbcTemplate.queryForObject(select_sql, rm, id);
	}
}
