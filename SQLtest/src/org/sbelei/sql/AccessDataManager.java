package org.sbelei.sql;

import java.sql.*; 

public class AccessDataManager {
	
	private Connection con;

	public static void main(String[] args){
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

	public void initConnection()
			throws ClassNotFoundException, SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // set this to a MS Access DB you have on your machine 
		String filename = "E:/PROJECTS/Sandbox/SQLtest/resources/Northwind.mdb"; 
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="; 
		database+= filename.trim() + ";DriverID=22;READONLY=true}"; // add on to the end  // now we can get the connection from the DriverManager 
		
		con = DriverManager.getConnection( database ,"","");
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
