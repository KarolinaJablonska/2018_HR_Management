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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "employees")
@Proxy(lazy=false)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Unit unit;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Training> trainings;
	


	public Employee() {}

	// setters & getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastName=" + lastName + ", type=" + type + ", unit=" + unit
				+ ", trainings=" + trainings + "]";
	}

	
}
