package pe.edu.upeu.examen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import pe.edu.upeu.examen.entity.Pelicula;
import pe.edu.upeu.examen.dao.PeliculaDAO;
import pe.edu.upeu.examen.daoImpl.PeliculaDaoImpl;

/**
 * Servlet implementation class PeliculaController
 */
@WebServlet("/pelicula")
public class PeliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeliculaDAO pdao = new PeliculaDaoImpl();
	private Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));

		switch (op) {
		case 1:
			out.println(gson.toJson(pdao.readAll()));
			break;
		case 2:
			int idc = Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(pdao.read(idc)));
			break;
		case 3:
			Pelicula pel1 = new Pelicula();
			pel1.setTitulo(request.getParameter("titulo"));
			pel1.setGenero(request.getParameter("genero"));
			pel1.setIdioma(request.getParameter("idioma"));
			out.println(gson.toJson(pdao.create(pel1)));
			break;
		case 4:
			Pelicula fac2 = new Pelicula();
			fac2.setIdpelicula(Integer.parseInt(request.getParameter("id")));
			fac2.setTitulo(request.getParameter("titulo"));
			fac2.setGenero(request.getParameter("genero"));
			fac2.setIdioma(request.getParameter("idioma"));
			out.println(gson.toJson(pdao.update(fac2)));
			break;
		case 5:
			out.println(gson.toJson(pdao.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
