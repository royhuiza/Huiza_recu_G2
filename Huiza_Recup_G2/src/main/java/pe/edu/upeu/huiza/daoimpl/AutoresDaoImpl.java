package pe.edu.upeu.huiza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.huiza.dao.AutoresDAO;
import pe.edu.upeu.huiza.entity.Autores;

public class AutoresDaoImpl implements AutoresDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	@Override
	public int create(Autores t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO autores (nombres, apellidos, pais, estado) VALUES(?,?,?,?)";
		int x = 0;
		try {
			cx = pe.edu.upeu.huiza.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombres());
			ps.setString(2, t.getApellidos());
			ps.setString(3, t.getPais());
			ps.setString(4, t.getEstado());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return x;
	}

	@Override
	public int update(Autores t) {
		// TODO Auto-generated method stub
				String SQL = "UPDATE autores SET nombres=?, apellidos=?, pais=?, estado=? WHERE idautores=?";
				int x = 0;
				try {
					cx = pe.edu.upeu.huiza.config.Conexion.getConexion();
					ps = cx.prepareStatement(SQL);
					ps.setString(1, t.getNombres());
					ps.setString(2, t.getApellidos());
					ps.setString(3, t.getPais());
					ps.setString(4, t.getEstado());
					ps.setInt(5, t.getIdautores());
					x = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("Error: " + e);
				}
				return x;
	}

	@Override
	public int delete(int id) {
		String SQL = "DELETE FROM autores WHERE idautores=?";
		int x = 0;
		try {
			cx = pe.edu.upeu.huiza.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return x;
	}

	@Override
	public Autores read(int id) {
		String SQL = "SELECT * FROM autores WHERE idautores=?";
		int x = 0;
		Autores esc = new Autores();
		try {
			cx = pe.edu.upeu.huiza.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				esc.setIdautores(rs.getInt("idautores"));
				esc.setNombres(rs.getString("nombres"));
				esc.setApellidos(rs.getString("apellidos"));
				esc.setPais(rs.getString("pais"));
				esc.setEstado(rs.getString("estado"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return esc;
	}

	@Override
	public List<Autores> readAll() {
		String SQL = "SELECT * FROM autores ORDER BY idautores";
		int x = 0;
		List<Autores> lista = new ArrayList<>();
		try {
			cx = pe.edu.upeu.huiza.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Autores esc = new Autores();
				esc.setIdautores(rs.getInt("idautores"));
				esc.setNombres(rs.getString("nombres"));
				esc.setApellidos(rs.getString("apellidos"));
				esc.setPais(rs.getString("pais"));
				esc.setEstado(rs.getString("estado"));
				lista.add(esc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return lista;
	}
}
