package com.lideratec;

public class Actividad2 {

    private int[] elementos;
    private int frente;
    private int cantidad;
    private int capacidad;

    public Actividad2(int capacidad) {
        this.capacidad = capacidad;
        elementos = new int[capacidad];
        frente = 0;
        cantidad = 0;
    }

    // Encolar: agregar un elemento al final
    public void encolar(int elemento) {
        if (cantidad == capacidad) {
            System.out.println("La cola está llena.");
            return;
        }

        int finalCola = (frente + cantidad) % capacidad;
        elementos[finalCola] = elemento;
        cantidad++;

        System.out.println("Elemento encolado: " + elemento);
    }

    // Desencolar: retirar el elemento del frente
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }

        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        cantidad--;

        System.out.println("Elemento desencolado: " + elemento);
        return elemento;
    }

    // Consultar el elemento del frente
    public int verFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }

        return elementos[frente];
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return cantidad == 0;
    }

    // Mostrar los elementos de la cola
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Elementos de la cola:");

        for (int i = 0; i < cantidad; i++) {
            int posicion = (frente + i) % capacidad;
            System.out.println(elementos[posicion]);
        }
    }
}
