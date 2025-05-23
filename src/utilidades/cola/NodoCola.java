package utilidades.cola;

//LO QUE ES: Nodo que almacena un valor entero y una referencia al siguiente nodo de la cola
public class NodoCola {
    int dato;
    NodoCola siguiente;

    //LO QUE HACE: Constructor que inicializa el nodo con un valor y sin siguiente
    public NodoCola(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
