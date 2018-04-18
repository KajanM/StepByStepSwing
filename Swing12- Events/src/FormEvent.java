import java.util.EventObject;

public class FormEvent extends EventObject {
	private static final long serialVersionUID = -6293008922586000503L;
	
	private String name;
	private String occupation;	
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation) {
		super(source);
		this.name = name;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}
	
}
