package co.edu.uts.sistemas.pedidos_uts;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uts.sistemas.pedidos_uts.model.Cliente;
import co.edu.uts.sistemas.pedidos_uts.model.Producto;

public class Informacion {
    public final static String user="123";
    public final static String passws = "123";

    public final static ArrayList<Producto> productos = new ArrayList<>();
    public final static ArrayList<Cliente> clientes =  new ArrayList<>();
    //public final static ArrayList<Cliente> cliente = new ArrayList<>();

    public final static boolean existeProducto(String codigo) {
        boolean flag=false;
        for (Producto p:productos) {
            if (p.getCodigo().equals(codigo)) {
                flag=true;
                break;
            }
        }
        return flag;
    }
    public final static boolean existeCliente(String email) {
        boolean flagC=false;
        for (Cliente c:clientes) {
            if (c.getEmail().equals(email)) {
                flagC=true;
                break;
            }
        }
        return flagC;
    }

    public final static boolean existeProducto(String codigo, int posicion) {
        boolean flag=false;
        for (int i=0; i<productos.size(); i++) {
            Producto p=productos.get(i);
            if (p.getCodigo().equals(codigo) && posicion!=i) {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public final static boolean existeCliente(String email, int posicion) {
        boolean flagC=false;
        for (int i=0; i<clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getEmail().equals(email) && posicion!=i) {
                flagC=true;
                break;
            }
        }
        return flagC;
    }

    public final static void cargarProductos() {
        Producto producto = new Producto("PROD001","Computador Escritorio", 1800000);
        productos.add(producto);
    }
    public final static void cargarClientes() {
        Cliente cliente = new Cliente(010101,"brayan mezac", "dir","example@email.com",312332);
        clientes.add(cliente);
    }

}
