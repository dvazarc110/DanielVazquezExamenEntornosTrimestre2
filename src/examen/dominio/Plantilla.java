package examen.dominio;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {
	private List<Empleado> empleados;
	
	public Plantilla() {
		this.empleados = new ArrayList<>();
	}
	
	public void agregarEmpleado(Empleado empleado) {
		(this.empleados).add(empleado);
	}
	
	public List<Empleado> getEmpleadosPorNombre(String filtroNombre){
		return empleados;
	}
}
