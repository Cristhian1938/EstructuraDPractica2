package com.unl.hola.base.Practica1;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import reactor.netty.resources.LoopResources;


public class ProArreglo {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        try (InputStream input = LoopResources.class.getClassLoader().getResourceAsStream("data.txt")) {
            if (input == null) {
                System.err.println("No se encontró el archivo en resources");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            // Leer todas las líneas y contarlas
            String line;
            int[] numerosTemp = new int[15000]; // asumiendo máximo 15000 líneas
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    numerosTemp[count++] = Integer.parseInt(line.trim());
                }
            }

            // Copiar solo los elementos leídos a un arreglo del tamaño exacto
            int[] numeros = new int[count];
            System.arraycopy(numerosTemp, 0, numeros, 0, count);

            // Inicializar contador de repeticiones
            int[] contador = new int[count];
            for (int j = 0; j < count; j++) contador[j] = 0;

            // Buscar elementos repetidos (sin usar HashMap)
            for (int j = 0; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    if (numeros[j] == numeros[k]) {
                        contador[j]++;
                        numeros[k] = Integer.MIN_VALUE; // Marcamos como usado
                    }
                }
            }

            // Contar cuántos son realmente repetidos
            int repetidosCount = 0;
            for (int j = 0; j < count; j++) {
                if (contador[j] > 0 && numeros[j] != Integer.MIN_VALUE) {
                    repetidosCount++;
                }
            }

            // Guardar los repetidos
            int[] repetidos = new int[repetidosCount];
            int idx = 0;
            for (int j = 0; j < count; j++) {
                if (contador[j] > 0 && numeros[j] != Integer.MIN_VALUE) {
                    repetidos[idx++] = numeros[j];
                }
            }

            // Imprimir resultados
            System.out.println("Se leyeron " + count + " números");
            System.out.print("Elementos repetidos: ");
            for (int i = 0; i < repetidos.length; i++) {
                System.out.print(repetidos[i]);
                if (i < repetidos.length - 1) System.out.print(", ");
            }

            System.out.println("\nCantidad de elementos repetidos dentro de la data: " + repetidosCount);

            long endTime = System.nanoTime();
            System.out.println("Tiempo de ejecución del arreglo es: " + (endTime - startTime) + " ns");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
