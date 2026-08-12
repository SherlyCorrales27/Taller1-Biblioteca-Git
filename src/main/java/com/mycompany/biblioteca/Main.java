package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
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
}
