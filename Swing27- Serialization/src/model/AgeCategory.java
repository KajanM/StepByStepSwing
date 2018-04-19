package model;

public enum AgeCategory {
	CHILD(0), ADULT(1), SENIOR(2);

	private int id;

	AgeCategory(int id) {
		this.id = id;
	}
	
	private int getId() {
		return id;
	}
	
	public static AgeCategory resolveAgeCategory(int id) {
		for(AgeCategory ageCat : AgeCategory.values()) {
			if(id == ageCat.getId()) {
				return ageCat;
			}
		}
		return null;
	}
	
}
