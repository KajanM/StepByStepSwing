import java.util.EventObject;

public class FormEvent extends EventObject {
	private static final long serialVersionUID = -6293008922586000503L;

	private String name;
	private String occupation;
	private int ageCatId;
	private String empCategory;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int id, String empCategory) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCatId = id;
		this.empCategory = empCategory;
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
}
