package co.edu.uts.sistemas.pedidos_uts.model;

public class Cliente {
    //private int _id;
    private int documento;
    private String nombre;
    private String direccion;
    private String email;
    private int celular;

    //construtor

    public Cliente(final int documento, final String nombre, final String direccion, final String email, final int celular) {
        this.documento = documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
    }

    //get

    public int getDocumento() {
        return this.documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public int getCelular() {
        return this.celular;
    }

    //set


    public void setDocumento(final int documento) {
        this.documento = documento;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setCelular(final int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", celular=" + celular +
                '}';
    }
}
