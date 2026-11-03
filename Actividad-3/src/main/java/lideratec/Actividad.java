package lideratec;

public class Actividad {

    static class Nodo{
        int dato;
        Nodo siguiente;

        Nodo(int dato){
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ListaEnlazada{
        Nodo cabeza;

        void insertarNodo(int dato){
            Nodo nuevo =new Nodo (dato);
            if (cabeza == null){
                cabeza = nuevo;
                return;
            }
            Nodo actual = cabeza;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }

        void mostrar(){
            Nodo actual = cabeza;
            while (actual != null){
                System.out.println(actual.dato + "");
                actual = actual.siguiente;
            }
        }

        Nodo buscar(int valor){
            Nodo actual = cabeza;
            while(actual != null){
                if (actual.dato == valor){
                    return actual;
                }
                actual = actual.siguiente;
            }return null;
        }

        boolean modificar (int valorBuscado, int nuevoValor){
            Nodo actual = cabeza;
            while (actual != null){
                if(actual.dato == valorBuscado){
                    actual.dato= nuevoValor;
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        boolean eliminar(int valorBuscando){
            Nodo actual = cabeza;
            Nodo anterior = null;
            while (actual != null){
                if(actual.dato == valorBuscando){
                    if(anterior == null){
                        cabeza = actual.siguiente;
                    }else {
                        anterior.siguiente = actual.siguiente;
                    }
                    return true;
                }
                anterior = actual;
                actual = actual.siguiente;
            }
            return false;
        }
    }

    public static void main(String[] args){
        ListaEnlazada lista =new ListaEnlazada();
        lista.insertarNodo(10);
        lista.insertarNodo(20);
        lista.insertarNodo(30);
        lista.mostrar();

        Nodo encontrado = lista.buscar(50);
        System.out.println(encontrado != null? "Encontrado " + encontrado.dato: "No encontrado");

        System.out.println(lista.modificar(30, 40));
        lista.mostrar();

        System.out.println(lista.eliminar(20));
        lista.mostrar();
    }
}
