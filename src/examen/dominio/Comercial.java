package examen.dominio;

public class Comercial extends Empleado{

	private double ventas;
	
	public Comercial(String dni, String nombre, String apellidos, double sueldoBase) {
		super(dni, nombre, apellidos, sueldoBase);
	}
	
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	
	public double getSueldo(){
		return 3.12;
	}
}
