package edu.iut.io;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes;

import edu.iut.app.ExamEvent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// EX 1 Completer la classe

public class XMLProjectReader {
	public XMLProjectReader() {
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ExamEvent> load(java.io.File xmlfile) throws IOException {
		ArrayList<ExamEvent> data = new ArrayList<ExamEvent>();
		  
	    // code permettant d'ouvrir un decodeur de fichier xml
	    XMLDecoder decoder = new XMLDecoder(new FileInputStream(xmlfile));
	    try {
	        // deserialisation de l'objet
	        data = (ArrayList<ExamEvent>)decoder.readObject();
	    } finally {
	        // fermeture du decodeur
	        decoder.close();
	    }
		return data;
		
	}
	
	// ceci est une autre facon de faire sans la serialisation
	/*public ArrayList<ExamEvent> load(java.io.File xmlfile) throws IOException {
		ArrayList<ExamEvent> data = new ArrayList<ExamEvent>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document= builder.parse(xmlfile);
			// EX1: Lire un Document XML
			Element root = document.getDocumentElement();
			
			NodeList rootChildren = root.getElementsByTagName("Event");
			for(int i=0;i<rootChildren.getLength();i++){
				if(rootChildren.item(i).getNodeType()==Node.ELEMENT_NODE){
					Node child =(Element)rootChildren.item(i);
					if(child.hasAttributes()){
						NamedNodeMap attributes = child.getAttributes();
					
						for(int a = 0;a<attributes.getLength();a++){
							Attr attribute = (Attr)attributes.item(a);
						}
					}
				}
				
			}
			
			
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}*/
}
