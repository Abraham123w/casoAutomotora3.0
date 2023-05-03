package Model;

public class Vehiculo {
	private String modelo;
	private int ano;
	private double precio;
	private int kilometrosRecorridos;
	private String color;
	private String marca;



	public Vehiculo(String modelo, int ano, double precio, int kilometrosRecorridos, String color, String marca) {
		this.modelo = modelo;
		this.ano = ano;
		this.precio = precio;
		this.kilometrosRecorridos = kilometrosRecorridos;
		this.color = color;
		this.marca = marca;
	}
	public Vehiculo(){
		this.modelo="Sin datos";
		this.color=null;
		this.marca=null;
		this.ano=0;
		this.precio=0;
		this.kilometrosRecorridos=0;
	}

	public String getNombre() {
		throw new UnsupportedOperationException();
	}

	public void setNombre(String aNombre) {
		throw new UnsupportedOperationException();
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int aAno) {
		this.ano = aAno;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double aPrecio) {
		this.precio = aPrecio;
	}

	public int getKilometrosRecorridos() {
		return this.kilometrosRecorridos;
	}

	public void setKilometrosRecorridos(int aKilometrosRecorridos) {
		this.kilometrosRecorridos = aKilometrosRecorridos;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String aColor) {
		this.color = aColor;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String aMarca) {
		this.marca = aMarca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}