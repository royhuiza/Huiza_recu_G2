package pe.edu.upeu.huiza.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.huiza.dao.AutoresDAO;
import pe.edu.upeu.huiza.daoimpl.AutoresDaoImpl;
import pe.edu.upeu.huiza.entity.Autores;

/**
 * Servlet implementation class AutoresController
 */
@WebServlet("/autores")
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoresDAO adao = new AutoresDaoImpl();
	private Gson gson = new Gson();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresController() {
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
			out.println(gson.toJson(adao.readAll()));
			break;
		case 2:
			int idc = Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(adao.read(idc)));
			break;
		case 3:
			Autores pel1 = new Autores();
			pel1.setNombres(request.getParameter("nombres"));
			pel1.setApellidos(request.getParameter("apellidos"));
			pel1.setPais(request.getParameter("pais"));
			pel1.setEstado(request.getParameter("estado"));
			out.println(gson.toJson(adao.create(pel1)));
			break;
		case 4:
			Autores fac2 = new Autores();
			fac2.setIdautores(Integer.parseInt(request.getParameter("id")));
			fac2.setNombres(request.getParameter("nombres"));
			fac2.setApellidos(request.getParameter("apellidos"));
			fac2.setPais(request.getParameter("pais"));
			fac2.setEstado(request.getParameter("estado"));
			out.println(gson.toJson(adao.update(fac2)));
			break;
		case 5:
			out.println(gson.toJson(adao.delete(Integer.parseInt(request.getParameter("id")))));
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
