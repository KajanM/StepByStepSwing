package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {
	private static Logger log = LogManager.getLogger(Controller.class);

	private final Database database;

	public Controller() {
		database = new Database();
	}

	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAgeCatId();
		String empCategoryStr = ev.getEmpCategory();
		boolean isSLCitizen = ev.isSLCitizen();
		String taxID = ev.getTaxID();
		String genderStr = ev.getGender();

		AgeCategory ageCat = AgeCategory.resolveAgeCategory(ageCatId);
		EmploymentCategory empCat = EmploymentCategory.resolveEmploymentCategory(empCategoryStr);
		Gender gender = Gender.resolveGender(genderStr);
		
		Person person = new Person(name, occupation, ageCat, empCat, isSLCitizen, taxID, gender);

		log.debug(person);
		database.addPerson(person);
	}
}
