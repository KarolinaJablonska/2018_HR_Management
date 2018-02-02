package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
	
	Unit findById(int id);
	
	Unit findOneByName(String name);
	List<Unit> findByUnitType(String unitType);
	
	@Query("Select u From Unit u where u.parentUnit = :parent")
	List<Unit> getChildren(@Param("parent") Unit parent);

}
