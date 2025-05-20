package com.unl.hola.base.Practica1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


import com.unl.hola.base.controller.data_struct.list.LinkedList;

public class ProListaEnlazada {
    private BufferedReader abrirArchivo(String nombreArchivo) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo);
        if (inputStream == null) {
            throw new Exception("Archivo '" + nombreArchivo + "' no encontrado en recursos");
        }
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public void procesarDatos() {
        long tiempoInicio = System.nanoTime();

        LinkedList<Integer> listaNumeros = new LinkedList<>();

        try (BufferedReader lector = abrirArchivo("data.txt")) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String texto = linea.trim();
                if (!texto.isEmpty()) {
                    listaNumeros.add(Integer.parseInt(texto));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo data: " + e.getMessage());
            return;
        }

        int cantidadRepetidos = contarRepetidos(listaNumeros);
        long tiempoFin = System.nanoTime();
        long duracion = tiempoFin - tiempoInicio;

        mostrarLista(listaNumeros);
        System.out.println("Cantidad de elementos repetidos dentro de la data es: " + cantidadRepetidos);
        System.out.println("Tiempo de ejecución de la lista enlazada: " + duracion + " ns");
    }

    public int contarRepetidos(LinkedList<Integer> lista) {
        HashMap<Integer, Integer> contador = new HashMap<>();
        for (int i = 0; i < lista.getLength(); i++) {
            Integer valor = lista.get(i);
            contador.put(valor, contador.getOrDefault(valor, 0) + 1);
        }
        int totalRepetidos = 0;
        for (int veces : contador.values()) {
            if (veces > 1) {
                totalRepetidos++;
            }
        }
        return totalRepetidos;
    }

    public void mostrarLista(LinkedList<Integer> lista) {
        System.out.print(lista.print());
    }

    public static void main(String[] args) {
        ProListaEnlazada list = new ProListaEnlazada();
        list.procesarDatos();
    }
}
