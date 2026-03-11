package examen.dominio;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {
	private List<Empleado> empleados;
	
	public Plantilla() {
		this.empleados = new ArrayList<>();
	}
	
	public List<Empleado> getEmpleados() {
		return this.empleados;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		(this.empleados).add(empleado);
	}
	
	public List<Empleado> getEmpleadosPorNombre(String filtroNombre){
		if(filtroNombre.isBlank()) {
			return empleados;
		}else {		
			List<Empleado> found = new ArrayList<>();
			for (Empleado emp : this.empleados) {
				if((((emp.getNombre()).toUpperCase()).contains(filtroNombre.subSequence(0, filtroNombre.length()-1)))||(((emp.getApellidos()).toUpperCase()).contains(filtroNombre.subSequence(0, filtroNombre.length()-1)))) {
					found.add(emp);
				}
			}
			return found;
		}
	}
}
