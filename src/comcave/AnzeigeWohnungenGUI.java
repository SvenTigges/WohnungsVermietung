package comcave;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AnzeigeWohnungenGUI extends JFrame {
	
	JComboBox status;
	JScrollPane scrollpane;
	JTable tabelle;
	DefaultTableModel model;
	AnzeigeWohnungenListener listener;
	
	// Singleton Pattern
	private static AnzeigeWohnungenGUI anzeigeWohnungenGUI = null;
	public static AnzeigeWohnungenGUI getInstance() {
		if(anzeigeWohnungenGUI == null)
			anzeigeWohnungenGUI = new AnzeigeWohnungenGUI();
		
		return anzeigeWohnungenGUI;
	}
	
	private AnzeigeWohnungenGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setLayout(null);
		setTitle("Wohnungsliste");
		
		status = new JComboBox();
		model = new DefaultTableModel();
		tabelle = new JTable(model);
		scrollpane = new JScrollPane(tabelle);
		
		add(status);
		add(scrollpane);
		
		status.setBounds(20, 20, 150, 25);
		scrollpane.setBounds(20, 55, 950, 700);
		
		status.addItem("nicht vermietet");
		status.addItem("vermietet");
		
		listener = new AnzeigeWohnungenListener(this);
		status.addItemListener(listener);
		
		listener.fillJTable();
	}
	
}
