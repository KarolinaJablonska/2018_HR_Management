package pl.coderslab.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "training")
@Proxy(lazy=false)
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private double costPerPerson;
	private double costStart;
	private double costPlanned;
	private double costFinal;
	private String quarter;
	private int year;
	
	@ManyToOne
	@JoinColumn(name = "unitBudget_id")
	private Unit unitBudget;

	@ManyToMany(mappedBy = "trainings", fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Employee> employees;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Unit> units;

	
	public Training() {}

	// setters & getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCostStart() {
		return costStart;
	}

	public void setCostStart(double costStart) {
		this.costStart = costStart;
	}

	public double getCostPlanned() {
		return costPlanned;
	}

	public void setCostPlanned(double costPlanned) {
		this.costPlanned = costPlanned;
	}

	public double getCostFinal() {
		return costFinal;
	}

	public void setCostFinal(double costFinal) {
		this.costFinal = costFinal;
	}

	public int getId() {
		return id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unit getUnitBudget() {
		return unitBudget;
	}

	public void setUnitBudget(Unit unitBudget) {
		this.unitBudget = unitBudget;
	}

	public double getCostPerPerson() {
		return costPerPerson;
	}

	public void setCostPerPerson(double costPerPerson) {
		this.costPerPerson = costPerPerson;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

}
