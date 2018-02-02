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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "units")
@Proxy(lazy=false)
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double trainingBudget;
	private double tBDistributed;
	private double tBLeft;
	private String unitType;
	private double costStartSum;
	private double costPlannedSum;
	private double costFinalSum;
	
	
	@ManyToOne
	@JoinColumn(name = "parentUnit_id")
	private Unit parentUnit;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	@OneToMany(mappedBy = "unit", fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Employee> employees;
	
	@ManyToMany(mappedBy = "units", fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Training> trainings;
		
	public Unit() {}

	//setters & getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTrainingBudget() {
		return trainingBudget;
	}

	public void setTrainingBudget(double trainingBudget) {
		this.trainingBudget = trainingBudget;
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

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unit getParentUnit() {
		return parentUnit;
	}

	public void setParentUnit(Unit parentUnit) {
		this.parentUnit = parentUnit;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public double gettBDistributed() {
		return tBDistributed;
	}

	public void settBDistributed(double tBDistributed) {
		this.tBDistributed = tBDistributed;
	}

	public double gettBLeft() {
		return tBLeft;
	}

	public void settBLeft(double tBLeft) {
		this.tBLeft = tBLeft;
	}


	public double getCostStartSum() {
		return costStartSum;
	}

	public void setCostStartSum(double costStartSum) {
		this.costStartSum = costStartSum;
	}

	public double getCostPlannedSum() {
		return costPlannedSum;
	}

	public void setCostPlannedSum(double costPlannedSum) {
		this.costPlannedSum = costPlannedSum;
	}

	public double getCostFinalSum() {
		return costFinalSum;
	}

	public void setCostFinalSum(double costFinalSum) {
		this.costFinalSum = costFinalSum;
	}

	@Override
	public String toString() {
		return "Unit [name=" + name + "]";
	}
	
		
}
