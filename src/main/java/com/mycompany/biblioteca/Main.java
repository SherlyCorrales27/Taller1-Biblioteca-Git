package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int option;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Crear libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Registrar préstamo");
            System.out.println("6. Registrar devolución");
            System.out.println("7. Listar préstamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {

                case 1:
                    createClient();
                    break;

                case 2:
                    listClients();
                    break;

                case 3:
                    createBook();
                    break;

                case 4:
                    listBooks();
                    break;

                case 5:
                    registerLoan();
                    break;

                case 6:
                    returnLoan();
                    break;

                case 7:
                    listLoans();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (option != 0);
    }

    static Client findClientById(String id) {

        for (Client client : clients) {

            if (client.getId().equalsIgnoreCase(id)) {
                return client;
            }
        }

        return null;
    }

    static void createClient() {

        System.out.println("\n--- CREAR CLIENTE ---");

        System.out.print("ID: ");
        String id = sc.nextLine();

        if (findClientById(id) != null) {
            System.out.println("Ya existe un cliente con este ID.");
            return;
        }

        System.out.print("Nombre: ");
        String name = sc.nextLine();

        System.out.print("Teléfono: ");
        String phone = sc.nextLine();

        System.out.print("Correo electrónico: ");
        String email = sc.nextLine();

        Client client = new Client(id, name, phone, email);

        clients.add(client);

        System.out.println("Cliente creado correctamente.");
    }

    static void listClients() {

        System.out.println("\n--- LISTA DE CLIENTES ---");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Client client : clients) {
            System.out.println(client);
        }
    }

    static void findClient() {

        System.out.print("Ingrese el ID del cliente: ");
        String id = sc.nextLine();

        Client client = findClientById(id);

        if (client != null) {
            System.out.println(client);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    static void updateClient() {

        System.out.print("Ingrese el ID del cliente que desea actualizar: ");
        String id = sc.nextLine();

        Client client = findClientById(id);

        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        client.setName(sc.nextLine());

        System.out.print("Nuevo teléfono: ");
        client.setPhone(sc.nextLine());

        System.out.print("Nuevo correo electrónico: ");
        client.setEmail(sc.nextLine());

        System.out.println("Cliente actualizado correctamente.");
    }

    static void deleteClient() {

        System.out.print("Ingrese el ID del cliente que desea eliminar: ");
        String id = sc.nextLine();

        Client client = findClientById(id);

        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clients.remove(client);

        System.out.println("Cliente eliminado correctamente.");
    }

    static Book findBookByCode(String code) {

        for (Book book : books) {

            if (book.getCode().equalsIgnoreCase(code)) {
                return book;
            }
        }

        return null;
    }

    static void createBook() {

        System.out.println("\n--- CREAR LIBRO ---");

        System.out.print("Código: ");
        String code = sc.nextLine();

        if (findBookByCode(code) != null) {
            System.out.println("Ya existe un libro con este código.");
            return;
        }

        System.out.print("Título: ");
        String title = sc.nextLine();

        System.out.print("Año de publicación: ");
        String publicationYear = sc.nextLine();

        System.out.print("Autor: ");
        String author = sc.nextLine();

        Book book = new Book(
                code,
                title,
                publicationYear,
                author,
                true
        );

        books.add(book);

        System.out.println("Libro creado correctamente.");
    }

    static void listBooks() {

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE LIBROS ---");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    static void registerLoan() {

        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");

        System.out.print("Ingrese el ID del préstamo: ");
        String loanId = sc.nextLine();

        System.out.print("Ingrese el ID del cliente: ");
        String clientId = sc.nextLine();

        Client client = findClientById(clientId);

        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el código del libro: ");
        String code = sc.nextLine();

        Book book = findBookByCode(code);

        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        Loan loan = new Loan(
                loanId,
                client,
                book,
                LocalDate.now(),
                "ACTIVO"
        );

        loans.add(loan);

        book.setAvailable(false);

        System.out.println("Préstamo registrado correctamente.");
    }

    static void returnLoan() {

        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");

        System.out.print("Ingrese el ID del préstamo: ");
        String loanId = sc.nextLine();

        for (Loan loan : loans) {

            if (loan.getLoanId().equalsIgnoreCase(loanId)) {

                if (loan.getStatus().equalsIgnoreCase("DEVUELTO")) {
                    System.out.println("Este préstamo ya fue devuelto.");
                    return;
                }

                loan.setStatus("DEVUELTO");

                loan.getBook().setAvailable(true);

                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }

    static void listLoans() {

        if (loans.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE PRÉSTAMOS ---");

        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}