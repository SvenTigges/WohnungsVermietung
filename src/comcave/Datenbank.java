package comcave;
import java.sql.*;
import java.util.ArrayList;

public class Datenbank {

    public void wohnungSpeichern(Wohnung wohnung) {
        try {
            String conString = "jdbc:mysql://localhost/wohnungsvermietung";
            String user = "root";
            String passwort = "";
            Connection connection = DriverManager.getConnection(conString, user, passwort);
            Statement statement = connection.createStatement();
            int vermietet = 0;
            if(wohnung.isVermietet())
                vermietet = 1;
            String sqlString = "INSERT INTO wohnung(stockwerk, bemerkungen, anzraeume, wohnflaeche, miete, nebenkosten, vermietet, anschrift_id) VALUES("
                    + "'" + wohnung.getStockwerk() + "', "
                    + "'" + wohnung.getBemerkung() + "', "
                    + wohnung.getAnzRaeume() + ", "
                    + wohnung.getWohnflaeche() + ", "
                    + wohnung.getMiete() + ", "
                    + wohnung.getNebenkosten() +", "
                    + vermietet + ", "
                    + "???);";
            statement.execute(sqlString);
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
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
            String sqlString = "SELECT strasse, hausnr, plz, ort FROM anschrift ORDER BY strasse, hausnr;";
            ResultSet rs = statement.executeQuery(sqlString);
            while(rs.next()) {
                Anschrift anschrift = new Anschrift();
                anschriften.add(anschrift);
                anschrift.setStrasse(rs.getString(1));
                anschrift.setHausnr(rs.getString(2));
                anschrift.setPlz(rs.getInt(3) + "");
                anschrift.setOrt(rs.getString(4));
                anschrift
            }
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return anschriften;
    }

}