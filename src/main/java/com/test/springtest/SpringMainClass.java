
package com.test.springtest;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.springtest.model.Employee;
import com.test.springtest.repository.EmployeeRepository;

public class SpringMainClass {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.springtest");
		context.refresh();

		EmployeeRepository repository = context.getBean(EmployeeRepository.class);

		// store
		repository.store(new Employee(1, "Pankaj", "CEO"));
		repository.store(new Employee(2, "Anupam", "Editor"));
		repository.store(new Employee(3, "Meghna", "CFO"));

		// retrieve
		Employee emp = repository.retrieve(1);
		System.out.println(emp);

		// search
		Employee cfo = repository.search("Meghna");
		System.out.println(cfo);

		// delete
		Employee editor = repository.delete(2);
		System.out.println(editor);

		// close the spring context
		context.close();
	}

}
