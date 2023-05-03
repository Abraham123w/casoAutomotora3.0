package Model;

public class Persona {
	private String nombre;
	private String rut;

	public Persona(String nombre, String rut) {
		this.nombre = nombre;
		this.rut = rut;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String aRut) {
		this.rut = aRut;
	}
}