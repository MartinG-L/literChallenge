package com.example.literchallenge.literchallenge.principal;

import com.example.literchallenge.literchallenge.model.Autor;
import com.example.literchallenge.literchallenge.model.DatosLibros;
import com.example.literchallenge.literchallenge.model.Libro;
import com.example.literchallenge.literchallenge.repository.AutorRepository;
import com.example.literchallenge.literchallenge.repository.LibroRepository;
import com.example.literchallenge.literchallenge.service.ConsumirAPI;
import com.example.literchallenge.literchallenge.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumirAPI consumirAPI = new ConsumirAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos convertir = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresPorAnho();
                    break;
                case 5:
                    listarPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el titulo");
        var libroTitulo = teclado.nextLine().replace(" ", "%20");
        String json = consumirAPI.obtenerDatos(URL_BASE + libroTitulo);
        DatosLibros librosEncontrados = convertir.obtenerDatos(json, DatosLibros.class);

       if(librosEncontrados.count() != 0){
           Libro libroEncontrado = new Libro(librosEncontrados.results().get(0));
           Autor autor = new Autor(librosEncontrados.results().get(0).authors().get(0));
           libroEncontrado.setAutor(autor);
           System.out.println(librosEncontrados);

           // Verificar si ya existe autor y libro antes de intentar guardarlo en la DB
           Autor existeAutor = autorRepository.findByAutor(autor.getAutor());
           Libro existeLibro = libroRepository.findByTitle(libroEncontrado.getTitle());

           if(existeAutor != null && existeLibro == null){
               libroEncontrado.setAutor(existeAutor);
               libroRepository.save(libroEncontrado);
           } else if (existeLibro == null && existeAutor == null) {
               autorRepository.save(autor);
               libroEncontrado.setAutor(autor);
               libroRepository.save(libroEncontrado);
           }

           System.out.println(libroEncontrado);

       } else {
           System.out.println("No se encontraron libros");
       }
    }

    private void listarAutoresPorAnho() {
        System.out.println("Escribe el año por el que deseas filtrar");
        var inputUsuario = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autorList = autorRepository.findAuthorsAliveInYear(inputUsuario);
        autorList.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autorList = autorRepository.findAll();
        autorList.forEach(System.out::println);
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }


    private void listarPorIdioma() {
        System.out.println("Escribe el idioma por el que deseas filtrar los libros");
        System.out.println("es | eng ");
        var inputUsuario = teclado.nextLine().toLowerCase().trim();
        List<Libro> libroList = libroRepository.findByLanguages(inputUsuario);

        libroList.forEach(System.out::println);
    }


}