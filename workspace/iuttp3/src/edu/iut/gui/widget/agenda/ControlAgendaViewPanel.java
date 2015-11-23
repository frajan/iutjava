package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		SpinnerNumberModel spinnerYear = new SpinnerNumberModel(Calendar.YEAR,Calendar.YEAR - 5,Calendar.YEAR + 5,1);
		JSpinner year = new JSpinner(spinnerYear);
		
		String[] month ={"January",""} ;

		JComboBox monthList = new JComboBox(month);
		monthList.setSelectedIndex(12);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(year,BorderLayout.LINE_START);
		contentPane.add(panel,BorderLayout.PAGE_START);
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
