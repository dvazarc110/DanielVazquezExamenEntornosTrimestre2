package examen.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import examen.dominio.Comercial;
import examen.dominio.Empleado;
import examen.dominio.Plantilla;
import examen.dominio.Tecnico;

public class GestorEmpleados {
	private Plantilla plantilla;
	private IEntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}
	
	public void ejecutar() {
		int opcion;
		do {
			(this.consola).mostrarMenu();
			(this.consola).imprimirLinea("Escribe el número de la opción del menú.");
			opcion = ((Consola) this.consola).readIntInRange(1, 4);
			if(opcion == 1) {
				contratarEmpleado();
			}else if(opcion == 2) {
				if((this.plantilla) == null) {
					(this.consola).imprimirLinea("Introduza primero a un Empleado.");
					contratarEmpleado();
				}else {
					listarTodos();
				}
			}else if(opcion == 3) {
				if((this.plantilla) == null) {
					(this.consola).imprimirLinea("Introduza primero a un Empleado.");
					contratarEmpleado();
				}else {
					listarPorFiltro();
				}
			}else {
				(this.consola).imprimirLinea("¡Hasta luego!");
			}

		}while(opcion != 4);

		((Consola) this.consola).cerrar();

	}
	
	private void contratarEmpleado(){
		Empleado empleado;
		String dni = ""; 
		String nombre = ""; 
		String apellidos = "";
		double sueldoBase = 0.00;
		int opcion;
		
		(this.consola).imprimirLinea("Que tipo de empleado quiere contratar: \n1 - Técnico\n2 - Comercial");
		opcion = ((Consola) this.consola).readIntInRange(1, 2);
		if(opcion == 1) {
			int categoria = 0;
			(this.consola).imprimirLinea("Introduzca el Dni, Nombre, Apellidos, Sueldo Base y Categoría de su nuevo empleado.");
			dni = (this.consola).leerTexto("DNI: ");
			nombre = (this.consola).leerTexto("Nombre:");
			apellidos = (this.consola).leerTexto("Apellidos:");
			sueldoBase = (this.consola).leerImporte("Sueldo Base:");
			categoria = (this.consola).leerEntero("Categoría:");
			empleado = new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
		}else {
			(this.consola).imprimirLinea("Introduzca el Dni, Nombre, Apellidos, Sueldo Base y Ventas de su nuevo empleado.");
			dni = (this.consola).leerTexto("DNI: ");
			nombre = (this.consola).leerTexto("Nombre:");
			apellidos = (this.consola).leerTexto("Apellidos:");
			sueldoBase = (this.consola).leerImporte("Sueldo Base:");
			double ventas = (this.consola).leerImporte("Ventas:");
			empleado = new Comercial(dni, nombre, apellidos, sueldoBase);
			((Comercial) empleado).setVentas(ventas);
		}
		(this.plantilla).agregarEmpleado(empleado);;
	}
	
	private void listarTodos() {
		if((this.plantilla) == null) {
			(this.consola).imprimirLinea("Introduza primero a un Empleado.");
			contratarEmpleado();
		}
		listarEmpleados((this.plantilla).getEmpleadosPorNombre(""));
	}
	
	private void listarPorFiltro() {
		if((this.plantilla) == null) {
			(this.consola).imprimirLinea("Introduza primero a un Empleado.");
			contratarEmpleado();
		}
		String filtro = (this.consola).leerTexto("Introduzca el filtro a usar:");
		listarEmpleados((this.plantilla).getEmpleadosPorNombre(filtro));
	}
	
	private void listarEmpleados(List<Empleado> empleados) {
		ordenarPorNombre(empleados);
		int cont = 1;
		for(Empleado emp : empleados) {
			(this.consola).imprimirLinea(String.format("%d - %s %s: %.2f€", cont, emp.getNombre(), emp.getApellidos(), emp.getSueldo()));
			cont++;
		}
	}
	
	private void ordenarPorNombre(List<Empleado> empleados) {
		Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
	}
}
