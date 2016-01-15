package edu.iut.io;

import java.io.ObjectInputStream;

import edu.iut.app.ApplicationSession;


// EX3 Utiliser ObjectInputStream pour lire les object sauvegardé par AppStateWriter

public class AppStateReader {
	private ObjectInputStream input;
	
	public AppStateReader() {
		
	}
	/*public void load(java.io.File file) throws Exception {
        ApplicationSession.instance().setAgenda(XMLProjectReader.load(file));
    }*/
}
