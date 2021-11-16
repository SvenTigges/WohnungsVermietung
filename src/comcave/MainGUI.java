package comcave;



import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;



public class MainGUI extends JFrame {

    JMenuBar menuBar;
    JMenu menuWohnungen;
    JMenu menuMieter;
    JMenuItem menuItemWohnungNeu;
    JMenuItem menuItemWohnungenAnzeigen;
    JMenuItem menuItemMieterNeu;
    JMenuItem menuItemMieterAnzeigen;
    JPanel contentPane;
    MainListener listener;

    public MainGUI(String titel) {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);

        contentPane = new JPanel();
        setContentPane(contentPane);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuWohnungen = new JMenu("Wohnungen");
        menuMieter = new JMenu("Mieter");

        menuItemWohnungNeu = new JMenuItem("Neu");
        menuItemWohnungenAnzeigen = new JMenuItem("Anzeigen");

        menuItemMieterNeu = new JMenuItem("Neu");
        menuItemMieterAnzeigen = new JMenuItem("Anzeigen");

        menuBar.add(menuWohnungen);
        menuBar.add(menuMieter);

        menuWohnungen.add(menuItemWohnungNeu);
        menuWohnungen.add(menuItemWohnungenAnzeigen);

        menuMieter.add(menuItemMieterNeu);
        menuMieter.add(menuItemMieterAnzeigen);

        contentPane.setBackground(Color.white);

        try {
            contentPane.add(new JLabel(new ImageIcon(ImageIO.read(new File(".\\images\\wohnhaus.jpg")))));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        listener = new MainListener(this);
        menuItemWohnungenAnzeigen.addActionListener(listener);
        menuItemWohnungNeu.addActionListener(listener);
        menuItemMieterNeu.addActionListener(listener);
        menuItemMieterAnzeigen.addActionListener(listener);
    }
}
