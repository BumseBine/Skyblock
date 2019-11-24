package de.xenoncraft.bumsebine.functions;

import java.sql.*;

import de.xenoncraft.bumsebine.main.Variables;

public class SQL{
	static Connection con;
	
	public static void start() {
		initialze();
		create();
	}
	
	
	private static void initialze() {
		try {
			con = DriverManager.getConnection("jdbc:sqlite:" + Variables.folder.getAbsolutePath() + "\\database.db");
			
			if(con != null) {
				DatabaseMetaData meta = con.getMetaData();
				System.out.println("The driver name is" + meta.getDriverName());
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void exit() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void create() {
		String sql = "CREATE TABLE IF NOT EXISTS players (\n"
                + "UUID String NO NULL,\n"
				+ "Coins integer, \n"
                + "Password String \n"
				+ ");";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		} catch(Exception e) {
			
		}
				
	}
	public static void insert(String UUID, int Coins, String Password) {
		String sql = "INSERT INTO players(UUID, Coins) VALUES(\"" + UUID + "\", " + Coins + ")";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			System.out.println("inserted");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
