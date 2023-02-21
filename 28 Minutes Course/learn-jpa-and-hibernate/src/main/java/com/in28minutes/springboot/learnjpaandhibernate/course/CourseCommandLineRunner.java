package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
		repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));
		repository.deleteById(1l); // <- repository expects long, need to specify by adding 'l'
		
		System.out.println(repository.findById(2l)); // <- repository expects long, need to specify by adding 'l'
		System.out.println(repository.findById(3l)); // <- repository expects long, need to specify by adding 'l'
		
		System.out.println(repository.findAll()); // shows all courses in list
		System.out.println(repository.count()); // shows count
		
		System.out.println(repository.findByAuthor("in28minutes")); // custom method created in repository using field name, returns a list
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn Azure Jpa!")); // custom method created in repository using field name, returns a list
	}

}
