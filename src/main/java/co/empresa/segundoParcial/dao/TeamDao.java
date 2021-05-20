package co.empresa.segundoParcial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.segundoParcial.modelo.Team;
import co.empresa.segundoParcial.util.Conexion;


public class TeamDao {
	private Conexion conexion;
	private static final String INSERT_TEAM_SQL = "INSERT INTO team (nombre,email,pais) VALUES (?,?,?)";
	private static final String DELETE_TEAM_ByID = "DELETE team WHERE id = ?";
	private static final String UPDATE_TEAM_SQL = "UPDATE team SET nombre = ?,email = ?, pais = ?";
	private static final String SELECT_TEAM_ByID = "SELECT * FROM team WHERE id = ? ";
	private static final String SELECT_ALL_USERS = "SELECT * FROM team";
	public TeamDao() {
		this.conexion = conexion.getConexion();
	}
	public void insertar(Team t) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(INSERT_TEAM_SQL);
			ps.setString(1, t.getName());
			ps.setString(2, t.getId_country());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(DELETE_TEAM_ByID);
			ps.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Team t) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(UPDATE_TEAM_SQL);
			ps.setString(1, t.getName());
			ps.setString(2, t.getId_country());
			ps.setString(3,t.getId());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Team> selectAll() throws SQLException{
		List<Team> lista = new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_ALL_USERS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String pais = rs.getString("id_country");
				lista.add(new Team(id,nombre,pais));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public Team selectUser(int id) throws SQLException{
		Team ans = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_Team_ByID);
			ps.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				ans = new Team(id,nombre,email,pais);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
	
}

