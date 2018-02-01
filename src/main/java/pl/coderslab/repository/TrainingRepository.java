package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Training;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
	
	
}
