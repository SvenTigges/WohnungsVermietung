package comcave;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainGUI extends JFrame {

	JMenuBar menuBar;
	JMenu menuWohnungen;
	JMenu menuMieter;
	JMenu menuBankdaten;
	JMenuItem menuItemWohnungNeu;
	JMenuItem menuItemWohnungenAnzeigen;
	JMenuItem menuItemMieterNeu;
	JMenuItem menuItemMieterAnzeigen;
	JMenuItem menuItemImport;
	JPanel contentPane;
	MainListener listener;
	
	
	public MainGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuWohnungen = new JMenu("Wohnungen");
		menuMieter = new JMenu("Mieter");
		menuBankdaten = new JMenu("Bankdaten");
		
		menuItemWohnungNeu = new JMenuItem("Neu");
		menuItemWohnungenAnzeigen = new JMenuItem("Anzeigen");
		
		menuItemMieterNeu = new JMenuItem("Neu");
		menuItemMieterAnzeigen = new JMenuItem("Anzeigen");
		menuItemImport = new JMenuItem("Import");
		
		menuBar.add(menuWohnungen);
		menuBar.add(menuMieter);
		menuBar.add(menuBankdaten);
		
		menuWohnungen.add(menuItemWohnungNeu);
		menuWohnungen.add(menuItemWohnungenAnzeigen);
		
		menuMieter.add(menuItemMieterNeu);
		menuMieter.add(menuItemMieterAnzeigen);

		menuBankdaten.add(menuItemImport);
		
		contentPane.setBackground(Color.white);
		try {
			contentPane.add(new JLabel(new ImageIcon(ImageIO.read(new File(".\\images\\wohnhaus.jpg")))));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		listener = new MainListener(this);
		menuItemWohnungenAnzeigen.addActionListener(listener);
		menuItemWohnungNeu.addActionListener(listener);
		menuItemMieterNeu.addActionListener(listener);
		menuItemMieterAnzeigen.addActionListener(listener);
		menuItemImport.addActionListener(listener);
	}

}
