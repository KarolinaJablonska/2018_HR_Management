package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

	Unit findOneByName(String name);
	List<Unit> findByUnitType(String unitType);

}
