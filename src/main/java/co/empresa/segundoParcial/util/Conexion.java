package co.empresa.segundoParcial.util;

import java.sql.*;


public class Conexion {
	
	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedStatment;
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String dbName="prueba";
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String userName="root";
	private static final String password="";
	
	private Conexion() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void cerrarConexion() {
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet query() throws SQLException{
		ResultSet res = preparedStatment.executeQuery();
		return res;
	}
	public int execute() throws SQLException{
		int result = preparedStatment.executeUpdate();
		return result;
	}
	public Connection getCon() {
		return this.con;
	}
	public Conexion getConexion() {
		if(db == null) {
			db = new Conexion();
		}
		return db;
	}
	public PreparedStatement setPreparedStatment(String sql) throws SQLException {
		this.preparedStatment = con.prepareStatement(sql);
		return this.preparedStatment;
	}
}
