package edu.iut.app;

import java.util.ArrayList;

public class Document extends ArrayList<ExamEvent> implements IExamEvent {
	protected String documentURI;
	
	public Document() {
		documentURI="";
	}
	public Document(String documentURI) {
		/* EX2 : Affectation */
		this.setDocumentURI(documentURI);
	}
	
	public void setDocumentURI(String number) {
		this.documentURI = number;
	}
	public String getDocumentURI() {
		return documentURI;
	}
	
	@Override
	public ArrayList<ExamEvent> critere(ArrayList<ExamEvent> examEvent, Object o) {
		ArrayList <ExamEvent> docExam = new ArrayList<ExamEvent>();
		if( o instanceof Document){
			for (ExamEvent ee: examEvent){
				if(ee.getStudent() != null)
				docExam.add(ee);	
			}
		}
		return docExam;
	}
}
