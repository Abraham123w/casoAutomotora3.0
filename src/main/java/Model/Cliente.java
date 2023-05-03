package Model;

public class Cliente extends Persona {
	private String direccion;
	private String numeroTel;
	private String correo;

	public Cliente(String nombre, String rut, String direccion, String numeroTel, String correo) {
		super(nombre, rut);
		this.direccion = direccion;
		this.numeroTel = numeroTel;
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getNumeroTel() {
		return this.numeroTel;
	}

	public void setNumeroTel(String aNumeroTel) {
		this.numeroTel = aNumeroTel;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String aCorreo) {
		this.correo = aCorreo;
	}
}