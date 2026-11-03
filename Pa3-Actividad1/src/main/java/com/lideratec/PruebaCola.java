
package com.lideratec;

public class PruebaCola {

    public static void main(String[] args) {

        // Crear una cola con capacidad para 5 elementos
        Actividad2 cola = new Actividad2(5);

        // 1. ENCOLAR
        System.out.println("=== ENCOLAR ELEMENTOS ===");
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        // 2. MOSTRAR LA COLA
        System.out.println("\n=== MOSTRAR COLA ===");
        cola.mostrar();

        // 3. VISUALIZAR EL FRENTE
        System.out.println("\n=== VER FRENTE ===");
        System.out.println("Frente: " + cola.verFrente());

        // 4. DESENCOLAR
        System.out.println("\n=== DESENCOLAR ===");
        cola.desencolar();

        // 5. MOSTRAR COLA ACTUALIZADA
        System.out.println("\n=== COLA ACTUALIZADA ===");
        cola.mostrar();

        // 6. VERIFICAR SI ESTÁ VACÍA
        System.out.println("\n=== VERIFICAR COLA ===");
        System.out.println("¿Está vacía?: " + cola.estaVacia());
    }
}
