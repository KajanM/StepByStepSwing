package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JTable {
	private static final long serialVersionUID = -6326747653704529535L;
	
	private final JTable table;
	private final PersonTableModel personTableModel;
	
	public TablePanel() {
		personTableModel = new PersonTableModel();
		table = new JTable(personTableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setPeople(List<Person> people) {
		personTableModel.setPeople(people);
	}
	
	public void refresh() {
		personTableModel.fireTableDataChanged();
	}
	
}
