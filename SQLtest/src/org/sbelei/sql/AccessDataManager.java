package org.sbelei.sql;

import java.sql.*; 

public class AccessDataManager {
	
	private Connection con;

	public static void main(String[] args) throws SQLException{
		String connectionString = null;
		String password = null;
		String userName = null;
		Connection con = DriverManager.getConnection( connectionString ,userName,password);
		Statement st = con.createStatement();
		String stSql = "SELECT * FROM Employees";
		ResultSet rs =st.executeQuery(stSql );
		con.close();
		AccessDataManager adm = new AccessDataManager();
		try {
			adm.initConnection();
			ResultSet rs = adm.select("SELECT * FROM Employees");
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i=1; i<=columns; i++){
				System.out.println(md.getColumnName(i)+"["+md.getColumnTypeName(i)+"]");
			}
			adm.closeConnection();
			
		}  catch (Exception e) { 
			System.out.println("Error: " + e);
		}
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public ResultSet select(String stSql) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(stSql);
		return rs;
	}
	/*
	 * jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=E:/PROJECTS/Sandbox/SQLtest/resources/Northwind.mdb;DriverID=22;READONLY=true}
	 */
	public void initConnection()
			throws ClassNotFoundException, SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // set this to a MS Access DB you have on your machine 
		String filename = "E:/PROJECTS/Sandbox/SQLtest/resources/Northwind.mdb"; 
		String connectionString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="; 
		connectionString+= filename.trim() + ";DriverID=22;READONLY=true}"; // add on to the end  // now we can get the connection from the DriverManager 
		String userName ="";
		String password ="";
		
		con = DriverManager.getConnection( connectionString ,userName,password);
	}

	public String[] composeHeaders(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		String[] result = new String[columns]; 
		for (int i=1; i<=columns; i++){
			result[i-1]=md.getColumnName(i)+"["+md.getColumnTypeName(i)+"]";
		}
		return result;
	}
	public String[][] composeRowData(ResultSet rs, int columnCount){
//		rs.get
//		rs.getString(i)
		return null;
		
	}
}
