package comcave;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Datenbank {

    public boolean wohnungSpeichern(Wohnung wohnung) {
        try {
            String conString = "jdbc:mysql://localhost/wohnungsvermietung";
            String user = "root";
            String passwort = "";
            Connection connection = DriverManager.getConnection(conString, user, passwort);
            Statement statement = connection.createStatement();

            String sqlString = "INSERT INTO wohnung(stockwerk, bemerkungen, anzraeume, wohnflaeche, miete, nebenkosten, vermietet, anschrift_id) VALUES("
                    + "'" + wohnung.getStockwerk() + "', "
                    + "'" + wohnung.getBemerkungen() + "', "
                    + wohnung.getAnzRaeume() + ", "
                    + wohnung.getWohnflaeche() + ", "
                    + wohnung.getMiete() + ", "
                    + wohnung.getNebenkosten() +", "
                    + "0, "
                    + wohnung.getAnschrift().getId() + ");";
            statement.execute(sqlString);
            connection.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void anschriftSpeichern(Anschrift anschrift) {
        try {
            String conString = "jdbc:mysql://localhost/wohnungsvermietung";
            String user = "root";
            String passwort = "";
            Connection connection = DriverManager.getConnection(conString, user, passwort);
            Statement statement = connection.createStatement();
            String sqlString = "INSERT INTO anschrift(strasse, hausnr, plz, ort) "
                    + "VALUES('" + anschrift.getStrasse() + "', '"
                    + anschrift.getHausnr() + "', "
                    + anschrift.getPlz() + ", '"
                    + anschrift.getOrt() + "');";
            statement.execute(sqlString);
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Anschrift> getAnschriften() {
        ArrayList<Anschrift> anschriften = new ArrayList<Anschrift>();
        try {
            String conString = "jdbc:mysql://localhost/wohnungsvermietung";
            String user = "root";
            String passwort = "";
            Connection connection = DriverManager.getConnection(conString, user, passwort);
            Statement statement = connection.createStatement();
            String sqlString = "SELECT strasse, hausnr, plz, ort, id FROM anschrift ORDER BY strasse, hausnr;";
            ResultSet rs = statement.executeQuery(sqlString);
            while(rs.next()) {
                Anschrift anschrift = new Anschrift();
                anschriften.add(anschrift);
                anschrift.setStrasse(rs.getString(1));
                anschrift.setHausnr(rs.getString(2));
                anschrift.setPlz(rs.getInt(3) + "");
                anschrift.setOrt(rs.getString(4));
                anschrift.setId(rs.getInt(5));
            }
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return anschriften;
    }

}