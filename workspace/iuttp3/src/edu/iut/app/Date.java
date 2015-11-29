package edu.iut.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Date extends ArrayList<ExamEvent> implements IExamEvent {

	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvents,Object o) {
		ArrayList <ExamEvent> dateExam = new ArrayList<ExamEvent>();
		if( o instanceof Date){
			for (ExamEvent ee: examEvents){
				if(ee.getClassroom() != null)
				dateExam.add(ee);	
			}
		}
		return dateExam;
	}
	
}

	
