package com.mycompany.biblioteca;

public class Material {




        private String codigo;
        private String titulo;
        private String anioPublic;

        public Material(String codigo, String titulo, String anioPublic) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.anioPublic = anioPublic;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAnioPublic() {
            return anioPublic;
        }

        public void setAnioPublic(String anioPublic) {
            this.anioPublic = anioPublic;
        }

        @Override
        public String toString() {
            return "Código: " + codigo +
                    " | Título: " + titulo +
                    " | Año: " + anioPublic;
        }

}
