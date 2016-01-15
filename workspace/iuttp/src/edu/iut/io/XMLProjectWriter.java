package edu.iut.io;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.iut.app.ExamEvent;

//EX 1 Completer la classe 

public class XMLProjectWriter {
	
	public XMLProjectWriter() {		
	}
	
	//serialisation 
	public void save(ArrayList<ExamEvent> data, java.io.File xmlfile) {
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(new FileOutputStream(xmlfile));
			encoder.writeObject(data);
	        encoder.flush();
	        encoder.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	// ceci est une autre facon de faire sans la serialisation
		/*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element agenda = document.createElement("agenda");
			for(int i=0;i<data.size();i++){
				if (data.get(i) != null) {
					String s_date =df.format(data.get(i).getDate());
						Element date = document.createElement("ExamDate") ; 
						date.setAttribute("date",s_date);
						Element event = document.createElement("Event") ; 
						event.setAttribute("nomEtudiant", data.get(i).getStudent().getFirstname()); 
						event.setAttribute("prenomEtudiant", data.get(i).getStudent().getLastname()) ; 
						event.setAttribute("telEtudiant", data.get(i).getStudent().getPhone()) ; 
						event.setAttribute("emailEtudiant",data.get(i).getStudent().getEmail()) ; 
						event.setAttribute("nombreJury",Integer.toString(data.get(i).getJury().size())) ;  
						event.setAttribute("salle", data.get(i).getClassroom().getClassRoomNumber());
						event.setAttribute("document", data.get(i).getDocuments().get(i).getDocumentURI());
						date.appendChild(event) ; 
						agenda.appendChild(date) ; 
					}	
			}

			document.appendChild(agenda) ; 
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance() ; 
			try {
				Transformer transformer = transformerFactory.newTransformer() ; 
				DOMSource source = new DOMSource(document) ; 
				StreamResult output = new StreamResult(xmlfile) ; 
				transformer.setOutputProperty(OutputKeys.INDENT,"yes") ; 
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2") ; 
				transformer.transform(source,output); 
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}*/
	}
}
