package examen.dominio;

public class Tecnico {

	private int categoria;

	public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
		super();
		this.categoria = categoria;
	}
	
	public double getSueldo(){
		return 3.12;
	}
}
