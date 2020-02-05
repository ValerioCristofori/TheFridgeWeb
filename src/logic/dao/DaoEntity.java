package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoEntity {
	private static DaoEntity instance = null; 
	protected static String user = "root";
	protected static String pass = "zurigo70";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/TheFridgeDB";
	protected static String driverClassName = "com.mysql.cj.jdbc.Driver";
	protected static String databaseName = "TheFridgeDB";
	protected Statement stmt;
	protected Connection conn;
	
	private DaoEntity() {
		// STEP 1: dichiarazioni
        this.stmt = null;
        this.conn = null;
		try {
			// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	protected static synchronized DaoEntity getSingletonInstance() {
		if (DaoEntity.instance == null)
			DaoEntity.instance = new DaoEntity();		
		return instance;
	}
}
