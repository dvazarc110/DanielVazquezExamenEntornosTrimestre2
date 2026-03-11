package examen.app;

import java.util.List;
import examen.dominio.Empleado;
import examen.dominio.Plantilla;

public class GestorEmpleados {
	private Plantilla plantilla;
	private IEntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantila, IEntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}
	
	public void ejecutar() {
		int opcion;
		do {
			(this.consola).mostrarMenu();
			(this.consola).imprimirLinea("Escribe el número de la opción del menú.");
			opcion = ((Consola) this.consola).readIntInRange(1, 4);
			switch (opcion) {
				case 1 -> contratarEmpleado();
				case 2 -> listarTodos();
				case 3 -> listarPorFiltro();
				case 4 -> (this.consola).imprimirLinea("¡Hasta luego!");
				default -> (this.consola).imprimirLinea("Opción no válida, inténtalo de nuevo.");
			};

		}while(opcion != 4);

		//consola.cerrar();

	}
	
	private void contratarEmpleado(){
		
	}
	
	private void listarTodos() {
		
	}
	
	private void listarPorFiltro() {
		
	}
	
	private void listarEmpleados() {
		
	}
	
	private void ordenarPorNombre(List<Empleado> empleados) {
		
	}
}
