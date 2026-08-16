package com.mycompany.biblioteca;

    public class Libro extends Material {

        private String autor;
        private boolean disponible;

        public Libro(String codigo, String titulo, String anioPublic,
                     String autor, boolean disponible) {

            super(codigo, titulo, anioPublic);
            this.autor = autor;
            this.disponible = disponible;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public boolean isDisponible() {
            return disponible;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return super.toString()
                    + " | Autor: " + autor
                    + " | Disponible: "
                    + (disponible ? "Sí" : "No");
        }
    }

