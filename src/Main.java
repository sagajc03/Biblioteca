import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Libro> libros = new HashMap<>();
    public static void menuA(){
        /*
        * Funcion de la logica del programa
        * */
        Scanner sc = new Scanner(System.in);
        String aux;
        boolean activo = true;
        int opc;
        String texto_opcion = "1 - Agregar libros\n" +
                "2 - Eliminar libros\n" +
                "3 - Buscar libro por título\n" +
                "4 - Buscar libro por autor\n" +
                "5 - Buscar libro por categoría\n" +
                "6 - Ver todos los libros\n" +
                "7 - Lista de libros\n" +
                "8 - Salir";
        while (activo){
            System.out.println(texto_opcion);
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    agregarLibros();
                    break;
                case 2:
                    eliminarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    visualizarLibros();
                    break;
                case 7:
                    listaLibros();
                    break;
                case 8:
                    System.out.println("Saliendo");
                    activo = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    private static void listaLibros() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Libro>  lista = new HashMap<>();
        String opc;
        int i = 1;

        for (Libro libro : libros.values()) {
            lista.put(i +"",libro);
            System.out.println(i + "> " + libro.corto());
            i++;
        }
        System.out.println("\n");
        System.out.println("Escribe el numero del libro a manegar ('n' regrasar)");
        opc = sc.nextLine();
        if (opc.equalsIgnoreCase("n")){
            return;
        }
        menuLibro(lista.get(opc));
    }

    private static void menuLibro(Libro libro) {
        Scanner sc = new Scanner(System.in);
        int opc;
        String texto_opcion = "1 - Crear Hoja\n" +
                "2 - Leer pagina actual\n" +
                "3 - Pasar pagina\n" +
                "4 - Regresar pagina\n" +
                "5 - Salir";
        boolean activoLibro = true;
        while (activoLibro){
            System.out.println(texto_opcion);
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:
                    String texto;
                    int capitulo;
                    try {
                        System.out.println("Numero de capitulo> ");
                        capitulo = Integer.parseInt(sc.nextLine());
                        System.out.println("Texto de la pagina> ");
                        texto = sc.nextLine();
                        libro.crearHoja(1, texto, capitulo);
                        System.out.println("no_pag_actual: " + (libro.pagina_actual + 1));
                        System.out.println("no_pags: " + libro.num_paginas);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println(libro.leerActual());
                    System.out.println("no_pag_actual: " + (libro.pagina_actual+1));
                    System.out.println("no_pags: " + libro.num_paginas);
                    break;
                case 3:
                    libro.pasarPagina();
                    System.out.println("no_pag_actual: " + (libro.pagina_actual+1));
                    System.out.println("no_pags: " + libro.num_paginas);
                    break;
                case 4:
                    libro.regresarPagina();
                    System.out.println("no_pag_actual: " + (libro.pagina_actual+1));
                    System.out.println("no_pags: " + libro.num_paginas);
                    break;
                case 5:
                    System.out.println("Saliendo");
                    activoLibro = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }

    }

    private static void buscarLibro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el libro a buscar");
        String aux = sc.nextLine();
        if(libros.containsKey(aux)){
            System.out.println(libros.get(aux).mostrarDetalles());
        }else {
            System.out.println("No se encontro el libro");
        }
    }

    public static void agregarLibros(){
        /*
        * Agrega libros al HashMap
        * */
        try {
            Scanner sc = new Scanner(System.in);
            String esono;
            String autor;
            String titulo;
            int num_paginas = 0;
            String categoria;
            boolean secuela = false;

            System.out.println("Titulo> ");
            titulo = sc.nextLine();

            System.out.println("Autor> ");
            autor = sc.nextLine();

            System.out.println("Numero de paginas> ");
            num_paginas = Integer.parseInt(sc.nextLine());

            System.out.println("Categoria> ");
            categoria = sc.nextLine();

            System.out.println("Es secuela (s/n)> ");
            esono = sc.nextLine();
            if (esono.equalsIgnoreCase("s")) {
                secuela = true;
            }

            Libro l = new Libro(autor, titulo, num_paginas, categoria, secuela);
            libros.put(titulo, l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarLibros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el libro a eliminar");
        String aux = sc.nextLine();
        libros.remove(aux);
        System.out.println("Se elimino " + aux);
    }

    public static void visualizarLibros(){
        /*
        * Pasa por todos los libros del HashMap
        * */
        for (Libro libro : libros.values()) {
            System.out.println(libro.mostrarDetalles());
        }
    }

    public static void main(String[] args) {
        menuA();
    }
}