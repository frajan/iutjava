package edu.iut.app;

import java.util.ArrayList;

public class Classroom extends ArrayList<ExamEvent> implements IExamEvent{
	
	public Classroom() {
		classRoomNumber="not affected";
	}
	public Classroom(String classRoomNumber) {
		/* EX2: AFFECTATION */;
		this.setClassroomNumber(classRoomNumber);
	}
	
	public void setClassroomNumber(String number) {
		/* EX2: AFFECTATION */;
		this.classRoomNumber=number;
	}
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
	
	protected String classRoomNumber;

	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvents, Object o) {
		ArrayList <ExamEvent> salleExam = new ArrayList<ExamEvent>();
		if( o instanceof Classroom){
			for (ExamEvent ee: examEvents){
				if(ee.getClassroom() != null)
				salleExam.add(ee);	
			}
		}
		return salleExam;
	}
}
