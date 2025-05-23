package jerarquicos;

//LO QUE HACE O QUE ES: Representa un nodo de un árbol binario
public class NodoAB<T> {
    public T dato;
    public NodoAB<T> izquierdo;
    public NodoAB<T> derecho;

    public NodoAB(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
