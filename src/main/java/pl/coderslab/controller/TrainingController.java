package pl.coderslab.controller;

import java.util.List;
import java.util.ListIterator;

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
import pl.coderslab.entity.Training;
import pl.coderslab.entity.Unit;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.repository.UnitRepository;

@Controller
@RequestMapping("training")
public class TrainingController {

	@Autowired
	TrainingRepository trainingRepo;
	@Autowired
	EmployeeRepository emplRepo;;
	@Autowired
	UnitRepository unitRepo;

	// CRUD: CREATE - get
	@GetMapping("/add")
	public String create(Model model) {
		Training training = new Training();
		model.addAttribute("training", training);

		// getting dictionaries
		List<String> trainingTypes = (List<String>) DTO.trainingTypes();
		model.addAttribute("trainingTypes", trainingTypes);
		List<String> quarters = (List<String>) DTO.quarter();
		model.addAttribute("quarters", quarters);

		// getting units
		List<Unit> units = unitRepo.findAll();
		model.addAttribute("units", units);

		return "training/trainingForm";
	}

	// CRUD: CREATE - post -> with repository
	@PostMapping("/add")
	public String create(@ModelAttribute @Valid Training training, BindingResult result) {
		if (result.hasErrors()) {
			return "training/trainingForm";
		} else {
			trainingRepo.save(training);
			return "redirect:/training/showAll";
		}
	}

	// CRUD: UPDATE - get
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable int id) {
		Training training = trainingRepo.getOne(id);
		model.addAttribute("training", training);

		// getting dictionaries
		List<String> trainingTypes = (List<String>) DTO.trainingTypes();
		model.addAttribute("trainingTypes", trainingTypes);
		List<String> quarters = (List<String>) DTO.quarter();
		model.addAttribute("quarters", quarters);

		// getting units
		List<Unit> units = unitRepo.findAll();
		model.addAttribute("units", units);

		return "training/trainingForm";
	}

	// CRUD: UPDATE - from FORM
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @ModelAttribute @Valid Training training, BindingResult result) {
		if (result.hasErrors()) {
			return "training/trainingForm";
		} else {
			trainingRepo.save(training);
			return "redirect:/training/showAll";
		}
	}

	// CRUD: DELETE
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Training training = trainingRepo.getOne(id);
		trainingRepo.delete(training);
		return "redirect:/training/showAll";
	}

	// OTHER METHODS:

	// show all
	@GetMapping("/showAll")
	public String loadAll(Model model) {
		List<Training> trainings = trainingRepo.findAll();
		model.addAttribute("trainings", trainings);
		return "training/details";
	}

	// registration -> part 1: show participants
	@GetMapping("/registration/{id}")
	public String registrationEmployees(@PathVariable int id, Model model) {
		Training training = trainingRepo.getOne(id);
		model.addAttribute("training", training);

		// delete employees with this training on their lists
		List<Employee> employees = emplRepo.findAll();
		ListIterator<Employee> emplIt = employees.listIterator();
		while (emplIt.hasNext()) {
			List<Training> trainings = emplIt.next().getTrainings();
			ListIterator<Training> trainIt = trainings.listIterator();
			while (trainIt.hasNext()) {
				Training training2 = (Training) trainIt.next();
				if (training2.getId() == id) {
					emplIt.remove();
					break;
				}
			}
		}
		model.addAttribute("employees", employees);

		int emplListSize = training.getEmployees().size();
		if (emplListSize == 0) {
			model.addAttribute("emplListSize", "brak uczestników");
		} else {
			model.addAttribute("emplListSize", emplListSize);
		}
		return "training/registration";
	}

	// registration -> part 2
	@GetMapping("/registration/add/{emplId}/{trainingId}")
	public String registrationActivate(@PathVariable int emplId, @PathVariable int trainingId) {
		// employee id and training entity
		Training training = trainingRepo.getOne(trainingId);
		Employee employee = emplRepo.getOne(emplId);

		List<Employee> employees = training.getEmployees();
		employees.add(employee);
		training.setEmployees(employees);
		trainingRepo.save(training);

		List<Training> trainings = employee.getTrainings();
		trainings.add(training);
		employee.setTrainings(trainings);
		emplRepo.save(employee);
		return "redirect:/training/registration/" + trainingId;
	}

	// show all participants of one training
	@GetMapping("/participants/{id}")
	public String participants(@PathVariable int id, Model model) {
		Training training = trainingRepo.getOne(id);
		List<Employee> employees = training.getEmployees();
		model.addAttribute("training", training);
		model.addAttribute("employees", employees);
		return "training/participants";
	}

	// show all participants of one training
	@GetMapping("/participants/delete/${emplId}/${trainingId}")
	public String participantsDelete(@PathVariable int emplId, @PathVariable int trainingId) {
		Training training = trainingRepo.getOne(trainingId);
		Employee employee = emplRepo.getOne(emplId);

		List<Employee> employees = training.getEmployees();
		training.getEmployees().remove(employee);
		employees.remove(employee);
		training.setEmployees(employees);
		trainingRepo.save(training);

		List<Training> trainings = employee.getTrainings();
		trainings.remove(training);
		employee.setTrainings(trainings);
		emplRepo.save(employee);

		return "redirect:training/participants/" + trainingId;
	}

	// budget split
	@GetMapping("/budgetSplit")
	public String budget(Model model) {
		List<Unit> units = unitRepo.findByUnitType("jednostka");
		Unit board = unitRepo.findOneByName("Zarząd");
		model.addAttribute("units", units);
		model.addAttribute("board", board);
		return "training/budgetSplit";
	}

	// show main training table
	@GetMapping("/table")
	public String table(Model model) {
		List<Training> trainings = trainingRepo.findAll();
		model.addAttribute("trainings", trainings);
		return "training/trainingManager";
	}

}
