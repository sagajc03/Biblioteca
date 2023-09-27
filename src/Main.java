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
                "7 - Salir";
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
                    System.out.println("Saliendo");
                    activo = false;
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