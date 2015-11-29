package edu.iut.app;

import java.util.ArrayList;

public class OrCriteria implements IExamEvent {
	private IExamEvent event;
	private IExamEvent otherEvent;
	
	public OrCriteria(IExamEvent event, IExamEvent otherEvent){
		this.event=event;
		this.otherEvent=otherEvent;
	}
	
	
	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvent, Object o) {
		ArrayList<ExamEvent> firstEvent = event.critere(examEvent, o);
		ArrayList<ExamEvent> otherEvent = event.critere(examEvent, o);

		for(ExamEvent ee : otherEvent){
			if(!firstEvent.contains(o)){
				firstEvent.add(ee);
			}
		}
		return firstEvent;
	}
}
