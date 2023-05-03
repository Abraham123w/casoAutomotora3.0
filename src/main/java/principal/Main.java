package principal;

import Model.Automotora;
import Model.Vehiculo;
import controller.AutomotoraController;
import vista.VentanaBienvenida;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       //String modelo, int ano, double precio, int kilometrosRecorridos, String color, String marca
        Vehiculo v1= new Vehiculo("corolla",1994,150000,350,"rojo","Toyota");
        Vehiculo v2= new Vehiculo("Hilux",1995,15044400,0,"azul","Toyota");
        Vehiculo v3= new Vehiculo("bt-50",1999,15000000,50,"Blanco","Mazda");
        Vehiculo v4= new Vehiculo("Mazda 6",2000,1500001,30,"rojo","Mazda");
        Vehiculo v5= new Vehiculo("Acent",2005,15002000,355,"NEGRO","HIUNDAY");
        // Crear una ArrayList de Vehiculos y agregarlos a la lista
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);

        Automotora automotora= new Automotora();
        automotora.setVehiculos(vehiculos);
        automotora= AutomotoraController.cargaMasivaDatos(automotora);
        VentanaBienvenida ventana= new VentanaBienvenida(automotora);
        //automotora.buscarVehiculosPorModelo("Hilux");
       /* for (Vehiculo vehiculo : automotora.buscarVehiculosPorModelo("Hilux")) {
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Año: " + vehiculo.getAno());
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Precio: " + vehiculo.getPrecio());
            System.out.println("Kilómetros recorridos: " + vehiculo.getKilometrosRecorridos());
            System.out.println();
        }*/
    }
}