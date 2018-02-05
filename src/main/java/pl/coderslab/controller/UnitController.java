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
		List<Employee> managers = emplRepo.findAll();
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

		// getting managers
		List<Employee> managers = emplRepo.findAll();
		model.addAttribute("managers", managers);

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

	// budget split
	@GetMapping("/budgetSplit")
	public String budget(Model model) {

		Unit board = unitRepo.findOneByName("Zarząd");
		model.addAttribute("units", getStructure(board));
		model.addAttribute("board", board);

		return "unit/budgetSplit";
	}

	// budget edit - > show form
	@GetMapping("/editUnitBudget/{id}")
	public String editUnitBudget(@PathVariable int id, Model model) {
		Unit unit = unitRepo.findById(id);
		model.addAttribute(unit);
		return "unit/editUnitBudget";
	}

	// budget edit - > show form
	@PostMapping("/editUnitBudget/{id}")
	public String editUnitBudget(@ModelAttribute Unit unitModel) {
		Unit unit = unitRepo.findById(unitModel.getId());

		if (!unit.getUnitType().equals("zarząd")) {
			Unit parent = unit.getParentUnit();
			double budget = unitModel.getTrainingBudget();
			double parentBudget = parent.getTrainingBudget();
			double newParentBudget = parentBudget - budget;

			unit.setTrainingBudget(budget);
			parent.setTrainingBudget(newParentBudget);

			List<Unit> children = unitRepo.getChildren(parent);
			double distributed = 0;
			for (Unit child : children) {
				distributed = distributed + child.getTrainingBudget() + budget;
			}
			parent.settBDistributed(distributed);
			parent.settBLeft(newParentBudget - distributed);
			unitRepo.save(parent);
		} else {
			unit.setTrainingBudget(unitModel.getTrainingBudget());
		}

		unitRepo.save(unit);
		return "redirect:/unit/budgetSplit";
	}

	/**
	 * By LESZEK SZTOKINIER
	 * @param parent
	 * @return
	 */
	// getting structure
	private List<Unit> getStructure(Unit parent) {
		List<Unit> result = new ArrayList<>();
		//unitRepo.getChildren(parent);
		List<Unit> tmpResult = new ArrayList<>();
		for (Unit unit : unitRepo.getChildren(parent)) {
			//tmpResult.addAll(unitRepo.getChildren(unit));
			tmpResult.add(unit);
			tmpResult.addAll(getStructure(unit));
		}
		result.addAll(tmpResult);
		return result;
	}

}