package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dto.DTO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Unit;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.UnitRepository;

@Controller
@RequestMapping("/empl")
public class EmployeeController {

	@Autowired
	EmployeeRepository emplRepo;
	@Autowired
	UnitRepository unitRepo;

	// CRUD: CREATE - get
	@GetMapping("/add")
	public String create(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		// getting parents
		List<Unit> allUnits = unitRepo.findAll();
		model.addAttribute("allUnits", allUnits);

		// getting dictionary for employees type
		List<String> emplTypes = (List<String>) DTO.emplTypes();
		model.addAttribute("emplTypes", emplTypes);

		return "empl/emplForm";
	}

	// CRUD: CREATE - post -> with repository
	@PostMapping("/add")
	public String create(Model model, @ModelAttribute @Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "empl/emplForm";
		} else {
			emplRepo.save(employee);
			return "redirect:/empl/showAll";
		}
	}

	// CRUD: UPDATE - get
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable int id) {
		Employee employee = emplRepo.getOne(id);
		model.addAttribute("employee", employee);

		// getting parents
		List<Unit> allUnits = unitRepo.findAll();
		model.addAttribute("allUnits", allUnits);

		// getting dictionary for employees type
		List<String> emplTypes = (List<String>) DTO.emplTypes();
		model.addAttribute("emplTypes", emplTypes);
		return "empl/emplForm";
	}

	// CRUD: UPDATE - from FORM
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute @Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "empl/emplForm";
		} else {
			emplRepo.save(employee);
			return "redirect:/empl/showAll";
		}
	}

	// CRUD: DELETE
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Employee empl = emplRepo.getOne(id);
		emplRepo.delete(empl);
		return "redirect:/empl/showAll";
	}

	// OTHER METHODS:

	// show all
	@GetMapping("/showAll")
	public String loadAll(Model model) {
		List<Employee> employees = emplRepo.findAll();
		model.addAttribute("employees", employees);
		return "empl/details";
	}

}
