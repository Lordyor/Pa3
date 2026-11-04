package com.lideratec;

public class Actividad1 {

    static class Nodo{
        int dato;
        Nodo siguiente;

        Nodo(int dato){
            this.dato = dato;
            this.siguiente =null;
        }
    }

    static class PilaLista{
        private Nodo cima;

        public PilaLista(){
            cima = null;
        }

        public boolean estaVacia(){
            if (cima == null) return true;
            else return false;
        }

        public void apilar(int dato){
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cima;
            cima = nuevo;
        }

        public int desapilar(){
            if (estaVacia()) throw new IllegalStateException();
            int dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }

        public int verCima(){
            if (estaVacia()) throw new IllegalStateException();
            return cima.dato;
        }

        public void mostrar(){
            Nodo actual = cima;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }

    }

    public static void main(String[] args){
        PilaLista pila = new PilaLista();
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
        pila.apilar(40);

        pila.mostrar();

        System.out.println("Aca termina la primera apilacion");

        pila.desapilar();

        pila.mostrar();

        System.out.println("Termina la primera desapilacion");

        System.out.println("La cima de la pila es: " + pila.verCima());

        System.out.println("Se ve la cima");

        pila.apilar(50);

        pila.mostrar();

        System.out.println("Se muestra tras una nueva apilacion");
    }
}
