package utilidades.cola;

//LO QUE ES: Implementación de una cola de enteros basada en nodos enlazados
public class ColaEnteros {
    private NodoCola primero;
    private NodoCola ultimo;

    //LO QUE HACE: Constructor que inicializa la cola vacía
    public ColaEnteros() {
        primero = null;
        ultimo = null;
    }

    //LO QUE HACE: Devuelve true si la cola está vacía
    public boolean estaVacia() {
        return primero == null;
    }

    //LO QUE HACE: Inserta un nuevo entero al final de la cola
    public void encolar(int dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    //LO QUE HACE: Elimina y devuelve el entero del frente de la cola
    public int desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        int dato = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        return dato;
    }

    //LO QUE HACE: Devuelve el entero del frente sin eliminarlo
    public int frente() {
        if (estaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        return primero.dato;
    }
}
