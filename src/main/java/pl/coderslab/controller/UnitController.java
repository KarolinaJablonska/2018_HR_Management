package pl.coderslab.controller;

import java.util.ArrayList;
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
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	UnitRepository unitRepo;
	@Autowired
	EmployeeRepository emplRepo;
	@Autowired
	UnitRepository parentRepo;

	// CRUD: CREATE - get
	@GetMapping("/add")
	public String create(Model model) {
		Unit unit = new Unit();
		model.addAttribute("unit", unit);

		// getting parents
		List<Unit> parentUnits = unitRepo.findAll();
		model.addAttribute("parentUnits", parentUnits);

		// getting managers
		List<Employee> managers = emplRepo.findByType("(kierownik)|(dyrektor)");
		model.addAttribute("managers", managers);

		// getting dictionary
		List<String> uniteTypes = (List<String>) DTO.uniteTypes();
		model.addAttribute("uniteTypes", uniteTypes);

		return "unit/unitForm";
	}

	// CRUD: CREATE - post -> with repository
	@PostMapping("/add")
	public String create(@ModelAttribute @Valid Unit unit, BindingResult result) {
		if (result.hasErrors()) {
			return "unit/unitForm";
		} else {
			Unit parent = unit.getParentUnit();
			System.out.println("TEST 0 " + parent.getName());
			System.out.println("TEST 1 " + parent.getId());
			List<Unit> parentChildren;	
			try {
				parentChildren = parent.getChildren();
				System.out.println("TEST 2 " + parentChildren.size());
			} catch (NullPointerException e) {
				parentChildren = new ArrayList<>();
				System.out.println("TEST 3 " + parentChildren.size());
			}
			System.out.println("TEST 4 " + parentChildren.size());
			System.out.println("TEST 5 " + unit.getId());
			parentChildren.add(unit);
			parentRepo.save(parent);
			System.out.println("TEST 6 " + parentChildren.size());
			System.out.println("TEST 7 " + parent.getName());
			unitRepo.save(unit);
			return "redirect:/unit/showAll";
		}
	}

	// CRUD: UPDATE - get
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable int id) {
		Unit unit = unitRepo.getOne(id);
		model.addAttribute("unit", unit);

		// getting parents
		List<Unit> parentUnits = unitRepo.findAll();
		model.addAttribute("parentUnits", parentUnits);

		// getting dictionary
		List<String> uniteTypes = (List<String>) DTO.uniteTypes();
		model.addAttribute("uniteTypes", uniteTypes);
		return "unit/unitForm";
	}

	// CRUD: UPDATE - from FORM
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute @Valid Unit unit, BindingResult result) {
		if (result.hasErrors()) {
			return "unit/unitForm";
		} else {
			Unit parent = unit.getParentUnit();
			List<Unit> parentChildren;	
			try {
				parentChildren = parent.getChildren();
			} catch (NullPointerException e) {
				parentChildren = new ArrayList<>();
			}
			parentChildren.add(unit);
			unitRepo.save(parent);
			unitRepo.save(unit);
			return "redirect:/unit/showAll";
		}
	}

	// CRUD: DELETE
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Unit unit = unitRepo.getOne(id);
		unitRepo.delete(unit);
		return "redirect:/unit/showAll";
	}

	// OTHER METHODS:

	// show all
	@GetMapping("/showAll")
	public String loadAll(Model model) {
		List<Unit> units = unitRepo.findAll();
		model.addAttribute("units", units);
		return "unit/details";
	}
}
