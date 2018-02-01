package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
		
	List<Employee> findByType(String type);
	Employee findOneByType(String type);
}
