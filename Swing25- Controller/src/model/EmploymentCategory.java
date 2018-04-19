package model;

public enum EmploymentCategory {
	EMPLOYED("employed"), SELFEMPLOYED("self-employed"), UNEMPLOYED("unemployed"), OTHER;
	
	private String description;
	
	EmploymentCategory() {
	}
	
	EmploymentCategory(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public static EmploymentCategory resolveEmploymentCategory(String text) {
		for(EmploymentCategory empCat : EmploymentCategory.values()) {
			if(text.equalsIgnoreCase(empCat.getDescription())) {
				return empCat;
			}
		}
		
		return EmploymentCategory.OTHER;
	}
}
