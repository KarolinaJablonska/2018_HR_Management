package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Unit;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.UnitRepository;

@Controller
public class HomeController {

	@Autowired
	EmployeeRepository emplRepo;
	@Autowired
	UnitRepository unitRepo;

	@GetMapping("")
	public String home() {

		// initial settings
		List<Employee> employees = emplRepo.findAll();
		List<Unit> units = unitRepo.findAll();

		if (employees.isEmpty() && units.isEmpty()) {
			Employee employee = new Employee();
			employee.setName("Piotr");
			employee.setLastName("Kowalski");
			employee.setType("prezes");
			emplRepo.save(employee);

			Unit unit = new Unit();
			unit.setName("Zarząd");
			unit.setUnitType("zarząd");
			unit.setManager(emplRepo.findOneByType("prezes"));
			unitRepo.save(unit);

			Employee employeeNew = emplRepo.findOneByType("prezes");
			employeeNew.setUnit(unit);
			emplRepo.save(employeeNew);
		}
		return "index";
	}
}
