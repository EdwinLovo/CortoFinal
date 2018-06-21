/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Producto {
    private int id,cantidad;
    private String codigo,nombre,tipo;
    private double precio;
    private boolean disponibilidad;

    public Producto() {
    }
//(`id`, `nombre`, `codigo`, `tipo`, `cantidad`, `precio`, `disponibilidad`) 
    public Producto(int id, String nombre,  String codigo,  String tipo, int cantidad, double precio, boolean disponibilidad) {
        this.id = id;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    public Producto( String nombre,  String codigo,  String tipo, int cantidad, double precio, boolean disponibilidad) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    public Producto( String nombre, int cantidad, String tipo, double precio, boolean disponibilidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    public Producto(  int cantidad, String tipo, double precio, boolean disponibilidad) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    public Producto(  String tipo, double precio, boolean disponibilidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
