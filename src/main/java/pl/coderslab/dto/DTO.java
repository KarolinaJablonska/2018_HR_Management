package pl.coderslab.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DTO {
	
	static public Collection<String> uniteTypes(){
		List<String> uniteTypes = new ArrayList<>();
		uniteTypes.add("jednostka");
		uniteTypes.add("wydział");
		uniteTypes.add("dział");
		return uniteTypes;
	}
	
	static public Collection<String> emplTypes(){
		List<String> emplTypes = new ArrayList<>();
		emplTypes.add("pracownik");
		emplTypes.add("kierownik");
		emplTypes.add("dyrektor");
		return emplTypes;
	}
	
	static public Collection<String> trainingTypes(){
		List<String> trainingTypes = new ArrayList<>();
		trainingTypes.add("obligatoryjne");
		trainingTypes.add("miękkie");
		trainingTypes.add("specjalistyczne");
		trainingTypes.add("szkoła");
		trainingTypes.add("rezerwa");
		trainingTypes.add("menedżerskie");
		return trainingTypes;
	}
	
	static public Collection<String> quarter(){
		List<String> quarters = new ArrayList<>();
		quarters.add("1");
		quarters.add("2");
		quarters.add("3");
		quarters.add("4");
		return quarters;
	}
	

}
