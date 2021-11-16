package comcave;
import java.sql.*;
import java.util.ArrayList;

public class Datenbank {
    Connection connection;
    Statement statement;

    private boolean verbindungStart(){
        try {
            String conString = "jdbc:mysql://localhost/wohnungsvermietung";
            String user = "root";
            String passwort = "";
            connection = DriverManager.getConnection(conString, user, passwort);
            statement = connection.createStatement();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean verbindungStop(){
        try {
            connection.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean wohnungSpeichern(Wohnung wohnung) {
        if (verbindungStart()) {
            try {
                String sqlString = "INSERT INTO wohnung(stockwerk, bemerkungen, anzraeume, wohnflaeche, miete, nebenkosten, vermietet, anschrift_id) VALUES("
                        + "'" + wohnung.getStockwerk() + "', "
                        + "'" + wohnung.getBemerkungen() + "', "
                        + wohnung.getAnzRaeume() + ", "
                        + wohnung.getWohnflaeche() + ", "
                        + wohnung.getMiete() + ", "
                        + wohnung.getNebenkosten() + ", "
                        + "0, "
                        + wohnung.getAnschrift().getId() + ");";
                statement.execute(sqlString);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }finally {
                System.out.println();
                verbindungStop();
            }
        }
        return false;
    }


    public void anschriftSpeichern(Anschrift anschrift) {
        if(verbindungStart()) {
            try {
                String sqlString = "INSERT INTO anschrift(strasse, hausnr, plz, ort) "
                        + "VALUES('" + anschrift.getStrasse() + "', '"
                        + anschrift.getHausnr() + "', "
                        + anschrift.getPlz() + ", '"
                        + anschrift.getOrt() + "');";
                statement.execute(sqlString);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                verbindungStop();
            }
        }
    }

    public ArrayList<Anschrift> getAnschriften() {
        ArrayList<Anschrift> anschriften = new ArrayList<Anschrift>();
        if (verbindungStart()){
            try {
                String sqlString = "SELECT strasse, hausnr, plz, ort, id FROM anschrift ORDER BY strasse, hausnr;";
                ResultSet rs = statement.executeQuery(sqlString);
                while (rs.next()) {
                    Anschrift anschrift = new Anschrift();
                    anschriften.add(anschrift);
                    anschrift.setStrasse(rs.getString(1));
                    anschrift.setHausnr(rs.getString(2));
                    anschrift.setPlz(rs.getInt(3) + "");
                    anschrift.setOrt(rs.getString(4));
                    anschrift.setId(rs.getInt(5));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                verbindungStop();
            }
        }
        return anschriften;
    }

    public  ArrayList<Wohnung> getWohnungen(int vermietet){
    ArrayList<Wohnung> wohnungen = new ArrayList<Wohnung>();
    // Alle Wohungen inkl. anschrift aus der DB holen und in die ArrayList speichern
        if(verbindungStart()) {
            try {
                String sqlString = "SELECT wohnung.id, stockwerk, bemerkung, anzraeume, wohnflaeche,"
                        + " miete, nebenkosten, vermietet,"
                        + " anschrift.id, strasse, hausnr, plz, ort"
                        + " FROM wohnung JOIN anschrift ON wohnung.anschrift_id = anschrift.id "
                        + "WHERE vermietet = " + vermietet
                        + " ORDER BY plz, strasse, hausnr;";
                ResultSet rs = statement.executeQuery(sqlString);
                while (rs.next()) {
                    Wohnung wohnung = new Wohnung();
                    wohnungen.add(wohnung);
                    wohnung.setId(rs.getInt(1));
                    wohnung.setStockwerk(rs.getString(2));
                    wohnung.setBemerkungen(rs.getString(3));
                    wohnung.setAnzRaeume(rs.getInt(4));
                    wohnung.setWohnflaeche(rs.getDouble(5));
                    wohnung.setMiete(rs.getDouble(6));
                    wohnung.setNebenkosten(rs.getDouble(7));

                    Anschrift anschrift = new Anschrift();
                    wohnung.setAnschrift(anschrift);
                    if (rs.getInt(8) == 0)
                        wohnung.setVermietet(false);
                    else
                        wohnung.setVermietet(true);
                    anschrift.setId(rs.getInt(9));
                    anschrift.setStrasse(rs.getString(10));
                    anschrift.setHausnr(rs.getString(11));
                    anschrift.setPlz(Integer.toString(rs.getInt(12)));
                    anschrift.setOrt(rs.getString(13));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                verbindungStop();
            }
        }
        return wohnungen;
        }

    }

