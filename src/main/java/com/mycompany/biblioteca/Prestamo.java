package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Prestamo {

    private String idPrestamo;
    private Cliente cliente;
    private Libro libro;
    private LocalDate fecha;
    private String estado;

    public Prestamo(String idPrestamo, Cliente cliente, Libro libro,
                    LocalDate fecha, String estado) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Préstamo: " + idPrestamo
                + " | Cliente: " + cliente.getNombre()
                + " | Libro: " + libro.getTitulo()
                + " | Fecha: " + fecha
                + " | Estado: " + estado;
    }
}
