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
	private static final String INSERT_TEAM_SQL = "INSERT INTO team (name,id_country) VALUES (?,?)";
	private static final String DELETE_TEAM_ByID = "DELETE team WHERE id = ?";
	private static final String UPDATE_TEAM_SQL = "UPDATE team SET name = ?, id_country = ?";
	private static final String SELECT_TEAM_ByID = "SELECT * FROM team WHERE id = ? ";
	private static final String SELECT_ALL_TEAMS = "SELECT * FROM team";
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
	public void delete(String id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatment(DELETE_TEAM_ByID);
			ps.setString(1, id);
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
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_ALL_TEAMS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pais = rs.getString("id_country");
				lista.add(new Team(id, name, pais));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public Team selectTeam(String id) throws SQLException{
		Team ans = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatment(SELECT_TEAM_ByID);
			ps.setString(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String name = rs.getString("name");
				String pais = rs.getString("pais");
				ans = new Team(id,name,pais);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
	
}

