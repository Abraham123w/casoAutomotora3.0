package Model;

import Validadadores.ValidadorRut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Automotora {
	public ArrayList<Vehiculo> vehiculos;
	public ArrayList<Cliente> clientes;

	public Automotora() {
		this.vehiculos = new ArrayList<Vehiculo>();
		this.clientes=new ArrayList<Cliente>();
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Vehiculo> buscarAutoNombre(String nombre) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		for (Vehiculo auto : this.vehiculos) {
			if (auto.getNombre().equals(nombre)) {
				vehiculos.add(auto);
			}
		}
		return vehiculos;
	}

	public List<Vehiculo> buscarAutoMarca(String marca) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		for (Vehiculo auto : this.vehiculos) {
			if (auto.getMarca().equals(marca)) {
				vehiculos.add(auto);
			}
		}
		return vehiculos;
	}
	public Vehiculo añadirVehiculo(String modelo, int ano, double precio, int kilometrosRecorridos, String color, String marca){
		Vehiculo vehiculo= new Vehiculo(modelo,ano,precio,kilometrosRecorridos,color,marca);
		//String modelo, int ano, double precio, int kilometrosRecorridos, String color, String marca
		this.vehiculos.add(vehiculo);
		// GestorDatos.registrarDato(vehiculo,"vehiculos.txt");
		return vehiculo;
	}
	public boolean añadirCliente(String nombre, String rut, String direccion, String numeroTel, String correo) {
		// Verifica que el RUT ingresado sea válido y que no exista ya un cliente con ese RUT en la base de datos
		if (ValidadorRut.validarDigito(rut) && this.buscarCliente(rut)==null) {
			// Si el RUT es válido y no existe un cliente con ese RUT, crea un nuevo objeto "Cliente" con los datos ingresados y lo agrega a la lista de clientes
//String nombre, String rut, String direccion, String numeroTel, String correo
			Cliente cliente= new Cliente(nombre,rut,direccion,numeroTel,correo);
			this.clientes.add(cliente);
			// Retorna verdadero para indicar que el cliente fue añadido correctamente
			return true;
		} else {
			// Si el RUT es inválido o ya existe un cliente con ese RUT, retorna falso para indicar que el cliente no pudo ser añadido
			return false;
		}
	}
	public Persona buscarCliente(String rut) {
		// Se inicializa la variable "cliente" como nula
		Persona cliente = null;
		// Se recorre la lista de clientes de la automotora
		for (Cliente clienteAux : this.clientes) {
			// Si se encuentra un cliente con el RUT indicado, se asigna a la variable "cliente" y se detiene el ciclo
			if (clienteAux.getRut().equals(rut)) {
				cliente = clienteAux;
				break;
			}
		}


		// Se retorna el cliente encontrado (si lo hay) o nulo (si no se encontró)
		return cliente;
	}


	public  String[] obtenerModelosDeVehiculos() {
		Set<String> modelosSet = new HashSet<>();
		for (Vehiculo vehiculo : vehiculos) {
			modelosSet.add(vehiculo.getModelo());
		}
		String[] modelos = modelosSet.toArray(new String[0]);
		return modelos;
	}
	public  String[] obtenerMarcasDeVehiculos() {
		Set<String> mascasSet = new HashSet<>();
		for (Vehiculo vehiculo : vehiculos) {
			mascasSet.add(vehiculo.getMarca());
		}
		String[] marcas = mascasSet.toArray(new String[0]);
		return marcas;
	}
	public String[] obtenerModelosDeVehiculosPorMarca( String marca) {
		// Crear un HashSet para almacenar los modelos sin duplicados
		Set<String> modelos = new HashSet<String>();

		// Recorrer la lista de vehículos y agregar los modelos correspondientes a la marca al HashSet
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getMarca().equals(marca)) {
				modelos.add(vehiculo.getModelo());
			}
		}

		// Crear un array de cadenas a partir del HashSet y devolverlo
		return modelos.toArray(new String[modelos.size()]);
	}
	public List<Vehiculo> buscarVehiculosPorModelo( String modelo) {
		// Crear una lista para almacenar los vehículos encontrados
		List<Vehiculo> vehiculosEncontrados = new ArrayList<Vehiculo>();

		// Recorrer la lista de vehículos y agregar los vehículos correspondientes al modelo a la lista de vehículos encontrados
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getModelo().equals(modelo)) {
				vehiculosEncontrados.add(vehiculo);
			}
		}

		// Devolver la lista de vehículos encontrados
		return vehiculosEncontrados;
	}







		public void agregarVehiculoRecibiendoObjetoTipoVehiculo(Vehiculo vehiculo) {
			vehiculos.add(vehiculo);
		}


}