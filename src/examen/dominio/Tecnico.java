package examen.dominio;

public class Tecnico extends Empleado{

	private int categoria;

	public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
		super(dni, nombre, apellidos, sueldoBase);
		this.categoria = categoria;
	}
	
	public double getSueldo(){
		double sueldo = (this.getSueldoBase()) + (double)((this.categoria)*100);
		return sueldo;
	}
}
