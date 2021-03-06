package comcave;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ErfassungMieterGUI extends JFrame{
	
	JTextField tfVorname;
	JTextField tfNachname;
	JTextField tfIban;
	JTextField tfBic;
	JTextField tfBank;
	JTextField tfMietBeginn;
	JTextField tfWohnungID;
	JButton btnSpeichern;
	
	JLabel lblVorname;
	JLabel lblNachname;
	JLabel lblIban;
	JLabel lblBic;
	JLabel lblBank;
	JLabel lblMietBeginn;
	JLabel lblWohnungID;
	
	private ErfassungMieterListener listener;
		
	private static ErfassungMieterGUI erfassungMieterGUI = null;
	public static ErfassungMieterGUI getInstance() {
		if(erfassungMieterGUI == null)
			erfassungMieterGUI = new ErfassungMieterGUI();
		
		return erfassungMieterGUI;
	}
	
	private ErfassungMieterGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setLayout(null);
		setTitle("Neuen Mieter erfassen");
		
		lblVorname = new JLabel("Vorname");
		lblNachname = new JLabel("Nachname");
		lblIban = new JLabel("IBAN");
		lblBic = new JLabel("BIC");
		lblBank = new JLabel("Bank");
		lblMietBeginn = new JLabel("Beginn");
		lblWohnungID = new JLabel("Wohnung-ID");
		
		tfVorname = new JTextField();
		tfNachname = new JTextField();
		tfIban = new JTextField();
		tfBic = new JTextField();
		tfBank = new JTextField();
		tfMietBeginn = new JTextField();
		tfWohnungID = new JTextField();
		btnSpeichern = new JButton("Speichern");
		
		add(lblVorname);
		add(lblNachname);
		add(lblIban);
		add(lblBic);
		add(lblBank);
		add(lblMietBeginn);
		add(lblWohnungID);
		add(tfVorname);
		add(tfNachname);
		add(tfIban);
		add(tfBic);
		add(tfBank);
		add(tfMietBeginn);
		add(tfWohnungID);
		add(btnSpeichern);
		
		lblVorname.setBounds(20,20,100,25);
		lblNachname.setBounds(20,55,100,25);
		lblIban.setBounds(20,90,100,25);
		lblBic.setBounds(20,125,100,25);
		lblBank.setBounds(20,160,100,25);
		lblMietBeginn.setBounds(20,195,100,25);
		lblWohnungID.setBounds(20,230,100,25);
		
		tfVorname.setBounds(150,20,150,25);
		tfNachname.setBounds(150,55,150,25);
		tfIban.setBounds(150,90,200,25);
		tfBic.setBounds(150,125,100,25);
		tfBank.setBounds(150,160,150,25);
		tfMietBeginn.setBounds(150,195,100,25);
		tfWohnungID.setBounds(150,230,100,25);
		btnSpeichern.setBounds(150,265,100,25);
	
		listener = new ErfassungMieterListener(this);
		btnSpeichern.addActionListener(listener);
	}
	
}
