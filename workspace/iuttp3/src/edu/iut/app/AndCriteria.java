package edu.iut.app;

import java.util.ArrayList;

public class AndCriteria implements IExamEvent {
	private IExamEvent event;
	private IExamEvent otherEvent;
	
	public AndCriteria(IExamEvent event, IExamEvent otherEvent){
		this.event=event;
		this.otherEvent=otherEvent;
	}
	
	
	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvent, Object o) {
		ArrayList<ExamEvent> firstEvent = event.critere(examEvent, o);
		return otherEvent.critere(examEvent, o);
	}

}
