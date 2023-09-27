import java.util.Vector;

public class Libro {
    public String autor;
    public String titulo;
    public int num_paginas = 0;
    public int pagina_actual = 0;
    public String categoria;
    public boolean secuela;
    public Vector<Hoja> paginas = new Vector<>();

    public Libro(String autor, String titulo, int num_paginas, String categoria, boolean secuela){
        this.autor = autor;
        this.titulo = titulo;
        this.num_paginas = num_paginas;
        this.categoria = categoria;
        this.secuela = secuela;
    }

    public String mostrarDetalles(){
        String detalles = "Autor: " + this.autor + "\n";
        detalles += "Titulo: " + this.titulo + "\n";
        detalles += "Numero de paginas: " + this.num_paginas + "\n";
        detalles += "Pagina actual: " + this.pagina_actual + "\n";
        detalles += "Categoria: " + this.categoria+ "\n";
        if (secuela) {
            detalles += "Es secuela \n";
        }
        return detalles;
    }

    public String corto(){
        return this.titulo + " - " + this.autor;
    }

    public void crearHoja(double interlineado, String texto, int capitulo){
        Hoja h = new Hoja(interlineado, texto, capitulo);
        this.paginas.add(h);
        this.num_paginas=paginas.size();
    }

    public String leerActual(){
        if (this.paginas.size()>0) {
            String res = "Capitulo: " + this.paginas.get(this.pagina_actual).capitulo + "\n";
            res += "Texto: \n" + this.paginas.get(this.pagina_actual).texto;
            return res;
        } else {
            return "No hay paginas para leer disponibles";
        }
    }

    public void pasarPagina(){
        if(pagina_actual < num_paginas - 1) {
            this.pagina_actual = this.pagina_actual + 1;
        }
    }


    public void regresarPagina(){
        if(pagina_actual > 0) {
            this.pagina_actual = this.pagina_actual - 1;
        }
    }

}
