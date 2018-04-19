package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;;

public class PersonTableModel extends AbstractTableModel {
	
	private List<Person> people;
	
	private String[] colNames = {"ID", "Name", "Occupation", "Age Category", "Employment Category", "SL Citizen", "Tax ID", "Gender"};
	
	public PersonTableModel() {
	}
	
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return people.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Person person = people.get(row);
		switch (col) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCategory();
		case 5:
			return person.isSLCitizen();
		case 6:
			return person.getTaxID();
		case 7:
			return person.getGender();
		}
		
		return null;
	}
	
}
