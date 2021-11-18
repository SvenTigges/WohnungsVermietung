package comcave;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Datenbank {
	Connection connection;
	Statement statement;

	public void bankdatenImport() {
		// Import Apache POI Bibliotheken
		// alle jar-files poi-5.0.0 + unterordenr "lib" jar-files + "ooxml-lib" alle jar-files
		try {
			String datei = ".\\files\\blz-liste.xlsx";
			File file;
			FileInputStream stream = new FileInputStream(datei);
			XSSFWorkbook workbook = new XSSFWorkbook(stream);
			XSSFSheet table = workbook.getSheet("Daten");
			int letzteZeile = table.getLastRowNum();
			System.out.println("Letze Zeile " + letzteZeile);
			XSSFRow zeile = table.getRow(1); // 0 ist erste Zeile == Überschriften
			int letzteSpalte = zeile.getLastCellNum();
			System.out.println("lete Spalte " + letzteSpalte);
			XSSFCell zelle = zeile.getCell(0);
			System.out.println(zelle.getStringCellValue());

			for(int x = 1; x <= letzteZeile; x++){
				XSSFRow aktuelleZeile = table.getRow(x);
				for(int y = 0; y < aktuelleZeile.getLastCellNum(); y++ ){
					XSSFCell aktuelleZelle = aktuelleZeile.getCell(y);
					System.out.println(aktuelleZelle.getStringCellValue() + "");
				}
				System.out.println();
			}
				// Daten lesen
			for(int x = 1; x <= letzteZeile; x++){
				XSSFRow row = table.getRow(x);
				int id = Integer.parseInt(row.getCell(4).getStringCellValue());
				String bic = row.getCell(3).getStringCellValue();
				String bez = row.getCell(1).getStringCellValue();
				String blz = row.getCell(0).getStringCellValue();

				String sqlString = "INSERT INTO bank VALUES(" + id + ", '" + bic + "', '" + bez + "', '" + blz + "';)";
				System.out.println(sqlString);
			}


			System.out.println("Datei gelesen");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private boolean verbindungStart() {
		try {
			String conString = "jdbc:mysql://localhost/wohnungsvermietung";
			String user = "root";
			String passwort = "";
			connection = DriverManager.getConnection(conString, user, passwort);
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean verbindungStop() {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Vermietung> getMieter() {
		ArrayList<Vermietung> vermietungsListe = new ArrayList<Vermietung>();
	
		if(verbindungStart()) {
			try {
				String sqlString = "SELECT * FROM mieter JOIN bank ON bank.id = mieter.bank_id JOIN vermietung ON mieter.id = vermietung.mieter_id JOIN wohnung ON wohnung.id = vermietung.wohnung_id JOIN anschrift ON anschrift.id = wohnung.anschrift_id;";
				ResultSet rs = statement.executeQuery(sqlString);
				while(rs.next()) {
					Vermietung vermietung = new Vermietung();
					vermietungsListe.add(vermietung);
					vermietung.setBeginn(rs.getDate("beginn"));
					Mieter mieter = new Mieter();
					vermietung.setMieter(mieter);
					mieter.setVorname(rs.getString("vorname"));
					mieter.setNachname(rs.getString("nachname"));
					BankKonto bankKonto = new BankKonto();
					mieter.setBankKonto(bankKonto);
					bankKonto.setIban(rs.getString("iban"));
					bankKonto.setBic(rs.getString("bic"));
					bankKonto.setBank(rs.getString("bemerkung"));
					Anschrift anschrift = new Anschrift();
					Wohnung wohnung = new Wohnung();
					vermietung.setWohnung(wohnung);
					wohnung.setAnschrift(anschrift);
					anschrift.setStrasse(rs.getString("strasse"));
					anschrift.setHausnr(rs.getString("hausnr"));
					anschrift.setPlz(rs.getInt("plz")+ "");
					anschrift.setOrt(rs.getString("ort"));
					wohnung.setStockwerk(rs.getString("stockwerk"));
					wohnung.setBemerkungen(rs.getString("bemerkung"));
					wohnung.setAnzRaeume(rs.getInt("anzraeume"));
					wohnung.setWohnflaeche(rs.getDouble("wonflaeche"));
					wohnung.setMiete(rs.getDouble("miete"));
					wohnung.setNebenkosten(rs.getDouble("nebenkosten"));
					wohnung.setVermietet(rs.getBoolean("vermietet"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				verbindungStop();
			}
		}
		return vermietungsListe;
		
	}
	
	public boolean mieterSpeichern(Vermietung vermietung) {
		Mieter mieter = vermietung.getMieter();
		BankKonto konto = mieter.getBankKonto();
		Wohnung wohnung = vermietung.getWohnung();
		if(verbindungStart()) {
			try {
				int lastId = 0;
				
				String sqlString = "INSERT INTO bank (bic, bezeichnung) VALUES('" + 
						konto.getBic() + "', '" + 
						konto.getBank() + "');";
				System.out.println(sqlString);
				statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs1 = statement.getGeneratedKeys();
				rs1.next();
				lastId = rs1.getInt(1);
				System.out.println(rs1.getInt(1));
				
				
				sqlString =	"INSERT INTO mieter (vorname, nachname, iban, bank_id) VALUES('" + 
						mieter.getVorname() + "', '" + 
						mieter.getNachname() + "', '" + 
						konto.getIban() + "', " +
					    lastId + ");";
				System.out.println(sqlString);
				statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs2 = statement.getGeneratedKeys();
				rs2.next();
				lastId = rs2.getInt(1);
				System.out.println(rs2.getInt(1));
				
				
				sqlString =	"INSERT INTO vermietung (beginn, wohnung_id, mieter_id) VALUES('" + 
						new SimpleDateFormat("yyyy-MM-dd").format(vermietung.getBeginn())
						+ "', " + 
						wohnung.getId() + 
						", " + 
						lastId + ");";
				System.out.println(sqlString);
				statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs3 = statement.getGeneratedKeys();
				rs3.next();
				System.out.println(rs3.getInt(1));
				
				
				connection.commit();
				return true;
			}catch(Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return false;
			}finally {
				System.out.println();
				verbindungStop();
			}
		}
		return false;
	}
	
	public boolean wohnungSpeichern(Wohnung wohnung) {
		if(verbindungStart()) {
			try {
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
				return true;
			}catch(Exception e) {
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
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				verbindungStop();
			}
		}
	}
	
	public ArrayList<Anschrift> getAnschriften() {
		ArrayList<Anschrift> anschriften = new ArrayList<Anschrift>();
		if(verbindungStart()) {
			try {
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
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				verbindungStop();
			}
		}
		return anschriften;
	}
	
	public ArrayList<Wohnung> getWohnungen(int vermietet){
		ArrayList<Wohnung> wohnungen = new ArrayList<Wohnung>();
		if(verbindungStart()) {
			// Alle Wohnungen inkl. Anschrift aus DB holen und in ArrayList speichern
			try {
				String sqlString = "SELECT wohnung.id, stockwerk, bemerkungen, anzraeume, wohnflaeche,"
						+ " miete, nebenkosten, vermietet,"
						+ " anschrift.id, strasse, hausnr, plz, ort"
						+ " FROM wohnung JOIN anschrift ON wohnung.anschrift_id = anschrift.id "
						+ " WHERE vermietet = " + vermietet
						+ " ORDER BY plz, strasse, hausnr;";
				ResultSet rs = statement.executeQuery(sqlString);
				while(rs.next()) {
					Wohnung wohnung = new Wohnung();
					wohnungen.add(wohnung);
					Anschrift anschrift = new Anschrift();
					wohnung.setAnschrift(anschrift);
					
					wohnung.setId(rs.getInt(1));
					wohnung.setStockwerk(rs.getString(2));
					wohnung.setBemerkungen(rs.getString(3));
					wohnung.setAnzRaeume(rs.getInt(4));
					wohnung.setWohnflaeche(rs.getDouble(5));
					wohnung.setMiete(rs.getDouble(6));
					wohnung.setNebenkosten(rs.getDouble(7));
					
					if(rs.getInt(8) == 0)
						wohnung.setVermietet(false);
					else
						wohnung.setVermietet(true);
						
					anschrift.setId(rs.getInt(9));
					anschrift.setStrasse(rs.getString(10));
					anschrift.setHausnr(rs.getString(11));
					anschrift.setPlz(Integer.toString(rs.getInt(12)));
					anschrift.setOrt(rs.getString(13));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				verbindungStop();
			}
			
		}
		return wohnungen;
	}
	
}
