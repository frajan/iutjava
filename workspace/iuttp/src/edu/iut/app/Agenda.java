package edu.iut.app;

import java.io.Serializable;
import java.util.LinkedList;

public class Agenda extends LinkedList<ExamEvent> implements Serializable {
	public Agenda() {		
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
