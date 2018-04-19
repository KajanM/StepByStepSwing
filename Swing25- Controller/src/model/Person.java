package model;

public class Person {
	private static int count = 0;
	
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCatId;
	private EmploymentCategory empCategory;
	private boolean isSLCitizen;
	private String taxID;
	private Gender gender;
	
	public Person(String name, String occupation, AgeCategory ageCatId, EmploymentCategory empCategory,
			boolean isSLCitizen, String taxID, Gender gender) {
		super();
		this.name = name;
		this.occupation = occupation;
		this.ageCatId = ageCatId;
		this.empCategory = empCategory;
		this.isSLCitizen = isSLCitizen;
		this.taxID = taxID;
		this.gender = gender;
		
		this.id = count;
		count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public AgeCategory getAgeCatId() {
		return ageCatId;
	}

	public void setAgeCatId(AgeCategory ageCatId) {
		this.ageCatId = ageCatId;
	}

	public EmploymentCategory getEmpCategory() {
		return empCategory;
	}

	public void setEmpCategory(EmploymentCategory empCategory) {
		this.empCategory = empCategory;
	}

	public boolean isSLCitizen() {
		return isSLCitizen;
	}

	public void setSLCitizen(boolean isSLCitizen) {
		this.isSLCitizen = isSLCitizen;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", occupation=" + occupation + ", ageCatId=" + ageCatId
				+ ", empCategory=" + empCategory + ", isSLCitizen=" + isSLCitizen + ", taxID=" + taxID + ", gender="
				+ gender + "]";
	}
	
}
