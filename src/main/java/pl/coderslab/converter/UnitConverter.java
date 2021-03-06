package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Unit;
import pl.coderslab.repository.UnitRepository;

public class UnitConverter implements Converter<String, Unit> {
	
	@Autowired
	private UnitRepository unitRepo;

	@Override
	public Unit convert(String source) {
		//Unit unit = unitRepo.getOne(source);
		Unit unit = unitRepo.findById(Integer.parseInt(source));
		return unit;
	}
	
}
