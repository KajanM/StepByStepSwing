import java.util.EventObject;

public class FormEvent extends EventObject {
	private static final long serialVersionUID = -6293008922586000503L;

	private String name;
	private String occupation;
	private int ageCatId;
	private String empCategory;
	private boolean isSLCitizen;
	private String taxID;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int id, String empCategory, boolean isSLCitizen,
			String taxID) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCatId = id;
		this.empCategory = empCategory;
		this.isSLCitizen = isSLCitizen;
		this.taxID = taxID;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public int getAgeCatId() {
		return ageCatId;
	}

	public String getEmpCategory() {
		return empCategory;
	}

	public boolean isSLCitizen() {
		return isSLCitizen;
	}

	public String getTaxID() {
		return taxID;
	}

}
