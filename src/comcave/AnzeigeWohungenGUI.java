package comcave;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AnzeigeWohungenGUI extends JFrame{

    JComboBox status;
    JScrollPane scrollpane;
    JTable tabelle;
    DefaultTableModel model;
    AnzeigeWohnungenListener listener;

    public AnzeigeWohungenGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(null);
        setTitle("Wohnungsliste");


        status = new JComboBox();
        scrollpane = new JScrollPane(tabelle);
        model = new DefaultTableModel();
        tabelle = new JTable(model);
        listener = new AnzeigeWohnungenListener();

        add(status);
        add(scrollpane);

        status.setBounds(20,20,150,25);
        scrollpane.setBounds(20,55,960,700);

        status.addItem("nicht Vermietet");
        status.addItem("Vermietet");


        status.addItemListener(listener);

    }
}
