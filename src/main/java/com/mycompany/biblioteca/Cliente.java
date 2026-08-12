package com.mycompany.biblioteca;

public class Cliente extends Persona {

        private String email;

        public Cliente(String id, String nombre, String telefono, String email) {
            super(id, nombre, telefono);
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return super.toString() + " | Email: " + email;
        }

}
