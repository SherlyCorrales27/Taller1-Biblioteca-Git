package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {

    private String loanId;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status;

    public Loan(String loanId, Client client, Book book,
                LocalDate date, String status) {
        this.loanId = loanId;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = status;
    }

    public String getLoanId() {
        return loanId;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Préstamo: " + loanId
                + " | Cliente: " + client.getName()
                + " | Libro: " + book.getTitle()
                + " | Fecha: " + date
                + " | Estado: " + status;
    }
}