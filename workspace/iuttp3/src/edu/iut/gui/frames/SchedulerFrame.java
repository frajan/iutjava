package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	protected void setupUI() {
		
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
	
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile , menuEdit , menuHelp, menuView;		
		JMenuItem menuItemLoad , menuItemSave , menuItemQuit, menuItemMonth, menuItemWeek, menuItemDay,menuItemDisplay,menuItemAbout;
		
		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/		
		//Menu file
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuItemLoad = new JMenuItem("Load");
		menuItemSave = new JMenuItem("Save");
		menuItemQuit = new JMenuItem("Quit");
		menuFile.add(menuItemLoad);
		menuFile.add(menuItemSave);
		menuFile.add(menuItemQuit);
		
		
		//Menu edit
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuView = new JMenu("View");
		menuItemMonth = new JMenuItem("Month");
		menuItemWeek = new JMenuItem("Week");
		menuItemDay = new JMenuItem("Day");
		menuView.add(menuItemMonth);
		menuView.add(menuItemWeek);
		menuView.add(menuItemDay);
		menuEdit.add(menuView);
		
		//Menu help
		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuItemDisplay = new JMenuItem("Display");
		menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemDisplay);
		menuHelp.add(menuItemAbout);
		
		class menuNext implements ActionListener{
		    //Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {      
				layerLayout.next(contentPane);	
			  } 
		  }	
		class unimplemented implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "En cours de construction", "Info", JOptionPane.INFORMATION_MESSAGE, null);
			}
			
		}
		
		//Evenement des boutons
		menuItemMonth.addActionListener(new menuNext());
		menuItemWeek.addActionListener(new menuNext());
		menuItemDay.addActionListener(new menuNext());
		
		menuItemLoad.addActionListener(new unimplemented());
		menuItemSave.addActionListener(new unimplemented());
		menuItemQuit.addActionListener(new unimplemented());
		menuItemLoad.addActionListener(new unimplemented());
		menuItemDisplay.addActionListener(new unimplemented());
		menuItemAbout.addActionListener(new unimplemented());
			

		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
	}
	
	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	
}
