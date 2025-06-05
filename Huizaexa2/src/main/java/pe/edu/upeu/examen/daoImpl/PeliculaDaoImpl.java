package pe.edu.upeu.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examen.dao.PeliculaDAO;
import pe.edu.upeu.examen.entity.Pelicula;

public class PeliculaDaoImpl implements PeliculaDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	@Override
	public int create(Pelicula t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO pelicula (titulo, genero, idioma) VALUES(?,?,?)";
		int x = 0;
		try {
			cx = pe.edu.upeu.examen.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getTitulo());
			ps.setString(2, t.getGenero());
			ps.setString(3, t.getIdioma());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return x;
	}

	@Override
	public int update(Pelicula t) {
		// TODO Auto-generated method stub
				String SQL = "UPDATE pelicula SET titulo=?, genero=?, idioma=?  WHERE idpelicula=?";
				int x = 0;
				try {
					cx = pe.edu.upeu.examen.config.Conexion.getConexion();
					ps = cx.prepareStatement(SQL);
					ps.setString(1, t.getTitulo());
					ps.setString(2, t.getGenero());
					ps.setString(3, t.getIdioma());
					ps.setInt(4, t.getIdpelicula());
					x = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("Error: " + e);
				}
				return x;
	}

	@Override
	public int delete(int id) {
		String SQL = "DELETE FROM pelicula WHERE idpelicula=?";
		int x = 0;
		try {
			cx = pe.edu.upeu.examen.config.Conexion.getConexion();
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
	public Pelicula read(int id) {
		String SQL = "SELECT * FROM pelicula WHERE idpelicula=?";
		int x = 0;
		Pelicula esc = new Pelicula();
		try {
			cx = pe.edu.upeu.examen.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				esc.setIdpelicula(rs.getInt("idpelicula"));
				esc.setTitulo(rs.getString("titulo"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return esc;
	}

	@Override
	public List<Pelicula> readAll() {
		String SQL = "SELECT * FROM pelicula ORDER BY idpelicula";
		int x = 0;
		List<Pelicula> lista = new ArrayList<>();
		try {
			cx = pe.edu.upeu.examen.config.Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Pelicula esc = new Pelicula();
				esc.setIdpelicula(rs.getInt("idpelicula"));
				esc.setTitulo(rs.getString("titulo"));
				esc.setGenero(rs.getString("genero"));
				esc.setIdioma(rs.getString("idioma"));
				lista.add(esc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return lista;
	}
}
