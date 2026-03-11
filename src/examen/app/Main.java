package examen.app;

import examen.dominio.Plantilla;

public class Main {

	public static void main(String[] args) {

		IEntradaSalida consola = null;
		Plantilla plantilla = null;
		GestorEmpleados gestorEmpleados = new GestorEmpleados(plantilla, consola);
		
		gestorEmpleados.ejecutar();
		
	}
}