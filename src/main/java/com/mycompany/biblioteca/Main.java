package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú más adelante
    }

    static Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        return null;
    }

    static void crearCliente() {

        System.out.println("\n--- CREAR CLIENTE ---");

        System.out.print("ID: ");
        String id = sc.nextLine();

        if (buscarClientePorId(id) != null) {
            System.out.println("Ya existe un cliente con ese ID.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(id, nombre, telefono, email);

        clientes.add(cliente);

        System.out.println("Cliente creado correctamente.");
    }

    static void listarClientes() {

        System.out.println("\n--- LISTA DE CLIENTES ---");

        if (clientes.isEmpty()) {
            System.out.println("No existen clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    static void buscarCliente() {

        System.out.print("Ingrese el ID del cliente: ");
        String id = sc.nextLine();

        Cliente cliente = buscarClientePorId(id);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    static void actualizarCliente() {

        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        cliente.setNombre(sc.nextLine());

        System.out.print("Nuevo teléfono: ");
        cliente.setTelefono(sc.nextLine());

        System.out.print("Nuevo email: ");
        cliente.setEmail(sc.nextLine());

        System.out.println("Cliente actualizado correctamente.");
    }
    static void eliminarCliente() {

        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clientes.remove(cliente);

        System.out.println("Cliente eliminado correctamente.");
    }

    static Libro buscarLibroPorCodigo(String codigo) {

        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }

        return null;
    }

    static void crearLibro() {

        System.out.println("\n--- CREAR LIBRO ---");

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        if (buscarLibroPorCodigo(codigo) != null) {
            System.out.println("Ya existe un libro con ese código.");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Año de publicación: ");
        String anio = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro libro = new Libro(codigo, titulo, anio, autor, true);

        libros.add(libro);

        System.out.println("Libro creado correctamente.");
    }

    static void crearPrestamo() {

        System.out.print("Ingrese ID del prestamo: ");
        String idPrestamo = sc.nextLine();

        System.out.print("Ingrese ID del cliente: ");
        String idCliente = sc.nextLine();

        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese codigo del libro: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibroPorCodigo(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no esta disponible.");
            return;
        }

        Prestamo prestamo = new Prestamo(
                idPrestamo,
                cliente,
                libro,
                LocalDate.now(),
                "ACTIVO"
        );

        prestamos.add(prestamo);
        libro.setDisponible(false);

        System.out.println("Prestamo registrado correctamente.");
    }
    static void devolverPrestamo() {

        System.out.print("Ingrese ID del prestamo: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getIdPrestamo().equalsIgnoreCase(idPrestamo)) {

                if (prestamo.getEstado().equalsIgnoreCase("DEVUELTO")) {
                    System.out.println("Este prestamo ya fue devuelto.");
                    return;
                }

                prestamo.setEstado("DEVUELTO");
                prestamo.getLibro().setDisponible(true);

                System.out.println("Devolucion registrada correctamente.");
                return;
            }
        }

        System.out.println("Prestamo no encontrado.");
    }
}
