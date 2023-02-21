package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext // better than autowired for entity manager - more specific
	private EntityManager entityManager;
	
	
	// insert course into table
	public void insert(Course course) {
		// mapping already created with annotations
		entityManager.merge(course);
	}
	
	// find course in table
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	// delete course from table
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
