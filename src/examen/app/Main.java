package examen.app;

import examen.dominio.Plantilla;

public class Main {

	public static void main(String[] args) {

		IEntradaSalida consola = new Consola();
		Plantilla plantilla = new Plantilla();
		GestorEmpleados gestorEmpleados = new GestorEmpleados(plantilla, consola);
		
		gestorEmpleados.ejecutar();
		
	}
}