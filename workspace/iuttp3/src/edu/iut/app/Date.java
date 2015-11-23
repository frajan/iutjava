package edu.iut.app;

import java.util.ArrayList;

public class Date extends ArrayList<ExamEvent> implements IExamEvent {

	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvents) {
		ArrayList <ExamEvent> dateExam = new ArrayList<ExamEvent>();
		
		for(ExamEvent ee : examEvents ){
			if(ee.getExamDate()!= null){
				
			}
		}
		
		
		
		
		
		
		
		
		return null;
	}

	
}
