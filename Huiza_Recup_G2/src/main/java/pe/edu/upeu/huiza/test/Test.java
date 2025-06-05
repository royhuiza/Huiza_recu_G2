package pe.edu.upeu.huiza.test;

import pe.edu.upeu.huiza.config.Conexion;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(Conexion.getConexion()!=null) {
			System.out.println("Conectado");
		}
	}

}
