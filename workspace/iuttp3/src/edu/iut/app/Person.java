package edu.iut.app;

import java.util.ArrayList;

public class Person extends ArrayList<ExamEvent> implements IExamEvent {
	
	protected PersonFunction personFunction;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String phone;
	
	public enum PersonFunction{
		/* EX2 : Internationalisation */
		NONE("None"),
		JURY("Jury"),
		STUDENT("Student");
		
		private String personFunction;
		
		PersonFunction(String personFunction) {
			this.personFunction = personFunction;
		}
		
		public String toString() {
			return personFunction;
		}		
	}
	
	public Person() {
		personFunction = PersonFunction.NONE;
	}
	
	public Person(PersonFunction personFunction,String firstname,String lastname,String email,String phone) {
		/* EX2: initialisation */
		this.setFunction(personFunction);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setPhone(phone);
		
	}
	
	
	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvents, Object o) {
		ArrayList <ExamEvent> personExam = new ArrayList<ExamEvent>();
		if( o instanceof Person){
			for (ExamEvent ee: examEvents){
				if(ee.getStudent() != null)
				personExam.add(ee);	
			}
		}
		return personExam;
	}	
	
	
	public void setFunction(PersonFunction function) {
		this.personFunction = function;
	}
	public PersonFunction getFunction() {
		return personFunction;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getFirstname() {
		return firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}

	


	

}
