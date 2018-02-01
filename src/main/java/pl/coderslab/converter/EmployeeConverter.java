package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Employee;
import pl.coderslab.repository.EmployeeRepository;

public class EmployeeConverter implements Converter<Integer, Employee> {

	@Autowired
	private EmployeeRepository emplRepo;

	@Override
	public Employee convert(Integer source) {
		Employee employee = emplRepo.getOne(source);
		return employee;
	}
}
