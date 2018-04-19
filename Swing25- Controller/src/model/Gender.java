package model;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender resolveGender(String text) {
		for(Gender gender : Gender.values()) {
			if(text.equalsIgnoreCase(gender.toString())) {
				return gender;
			}
		}
		
		return null;
	}

}
