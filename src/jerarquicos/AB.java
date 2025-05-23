package jerarquicos;

import modelos.I_AB;

import java.util.LinkedList;
import java.util.Queue;

//LO QUE HACE O QUE ES: Implementación genérica de un árbol binario
public class AB<T> implements I_AB<T> {

    protected NodoAB<T> raiz;

    public AB() {
        this.raiz = null;
    }

    @Override
    public void insertar(T elemento) {
        if (raiz == null) {
            raiz = new NodoAB<>(elemento);
        } else {
            insertarRecursivo(raiz, elemento);
        }
    }

    private void insertarRecursivo(NodoAB<T> nodo, T elemento) {
        // Por defecto: inserta por la izquierda si está vacía, sino por la derecha
        if (nodo.izquierdo == null) {
            nodo.izquierdo = new NodoAB<>(elemento);
        } else if (nodo.derecho == null) {
            nodo.derecho = new NodoAB<>(elemento);
        } else {
            // Alternar para evitar que siempre crezca solo hacia un lado
            // Aquí vamos insertando en el hijo izquierdo recursivamente
            insertarRecursivo(nodo.izquierdo, elemento);
        }
    }

    @Override
    public String recorridoInOrden() {
        StringBuilder resultado = new StringBuilder();
        inOrdenRecursivo(raiz, resultado);
        return resultado.toString().trim();
    }

    //LO QUE HACE O QUE ES: Recorre el árbol en InOrden (Izquierda, Raíz, Derecha)
    private void inOrdenRecursivo(NodoAB<T> nodo, StringBuilder resultado) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo, resultado);
            resultado.append(nodo.dato).append(" ");
            inOrdenRecursivo(nodo.derecho, resultado);
        }
    }

    @Override
    public String recorridoInOrdenInverso() {
        StringBuilder resultado = new StringBuilder();
        inOrdenInversoRecursivo(raiz, resultado);
        return resultado.toString().trim();
    }

    //LO QUE HACE O QUE ES: Recorre el árbol en InOrden inverso (Derecha, Raíz, Izquierda)
    private void inOrdenInversoRecursivo(NodoAB<T> nodo, StringBuilder resultado) {
        if (nodo != null) {
            inOrdenInversoRecursivo(nodo.derecho, resultado);
            resultado.append(nodo.dato).append(" ");
            inOrdenInversoRecursivo(nodo.izquierdo, resultado);
        }
    }

    @Override
    public String recorridoPreOrden() {
        StringBuilder resultado = new StringBuilder();
        preOrdenRecursivo(raiz, resultado);
        return resultado.toString().trim();
    }

    //LO QUE HACE O QUE ES: Recorre el árbol en PreOrden (Raíz, Izquierda, Derecha)
    private void preOrdenRecursivo(NodoAB<T> nodo, StringBuilder resultado) {
        if (nodo != null) {
            resultado.append(nodo.dato).append(" ");
            preOrdenRecursivo(nodo.izquierdo, resultado);
            preOrdenRecursivo(nodo.derecho, resultado);
        }
    }

    @Override
    public String recorridoPostOrden() {
        StringBuilder resultado = new StringBuilder();
        postOrdenRecursivo(raiz, resultado);
        return resultado.toString().trim();
    }

    //LO QUE HACE O QUE ES: Recorre el árbol en PostOrden (Izquierda, Derecha, Raíz)
    private void postOrdenRecursivo(NodoAB<T> nodo, StringBuilder resultado) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.izquierdo, resultado);
            postOrdenRecursivo(nodo.derecho, resultado);
            resultado.append(nodo.dato).append(" ");
        }
    }

    @Override
    public String recorridoPorNiveles() {
        StringBuilder resultado = new StringBuilder();
        if (raiz == null) return "";

        Queue<NodoAB<T>> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            NodoAB<T> actual = cola.poll();
            resultado.append(actual.dato).append(" ");
            if (actual.izquierdo != null) cola.offer(actual.izquierdo);
            if (actual.derecho != null) cola.offer(actual.derecho);
        }

        return resultado.toString().trim();
    }

    @Override
    public boolean esIgual(I_AB<T> otro) {
        if (!(otro instanceof AB)) return false;
        AB<T> otroAB = (AB<T>) otro;
        return sonIguales(this.raiz, otroAB.raiz);
    }

    //LO QUE HACE O QUE ES: Método recursivo para comparar dos nodos (estructura y dato)
    private boolean sonIguales(NodoAB<T> n1, NodoAB<T> n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (!n1.dato.equals(n2.dato)) return false;
        return sonIguales(n1.izquierdo, n2.izquierdo) && sonIguales(n1.derecho, n2.derecho);
    }

    @Override
    public boolean esSimetrico() {
        return esSimetricoRec(raiz, raiz);
    }

    //LO QUE HACE O QUE ES: Compara el árbol consigo mismo en espejo
    private boolean esSimetricoRec(NodoAB<T> a, NodoAB<T> b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (!a.dato.equals(b.dato)) return false;
        return esSimetricoRec(a.izquierdo, b.derecho) && esSimetricoRec(a.derecho, b.izquierdo);
    }

    @Override
    public int contarAscendientes(T x) {
        return buscarYContarAscendientes(raiz, x, 0);
    }

    //LO QUE HACE O QUE ES: Devuelve el número de padres hasta llegar a x
    private int buscarYContarAscendientes(NodoAB<T> nodo, T x, int nivel) {
        if (nodo == null) return -1;
        if (nodo.dato.equals(x)) return nivel;

        int izquierda = buscarYContarAscendientes(nodo.izquierdo, x, nivel + 1);
        if (izquierda != -1) return izquierda;

        return buscarYContarAscendientes(nodo.derecho, x, nivel + 1);
    }

    @Override
    public int contarDescendientes(T x) {
        NodoAB<T> nodoX = buscarNodo(raiz, x);
        if (nodoX == null) return 0;
        return contarNodos(nodoX) - 1; // quitamos el propio nodo
    }

    //LO QUE HACE O QUE ES: Busca un nodo con valor x
    private NodoAB<T> buscarNodo(NodoAB<T> nodo, T x) {
        if (nodo == null) return null;
        if (nodo.dato.equals(x)) return nodo;

        NodoAB<T> izq = buscarNodo(nodo.izquierdo, x);
        if (izq != null) return izq;

        return buscarNodo(nodo.derecho, x);
    }

    //LO QUE HACE O QUE ES: Cuenta nodos en el subárbol con raíz en nodo
    private int contarNodos(NodoAB<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }

    @Override
    public boolean existeCaminoConSuma(T suma) {
        if (!(suma instanceof Integer)) return false;
        int objetivo = (Integer) suma;
        return existeSumaRecursivo(raiz, objetivo);
    }

    //LO QUE HACE O QUE ES: Comprueba si hay un camino cuya suma da el número
    private boolean existeSumaRecursivo(NodoAB<T> nodo, int sumaRestante) {
        if (nodo == null) return false;

        int valor = (Integer) nodo.dato;
        sumaRestante -= valor;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            return sumaRestante == 0;
        }

        return existeSumaRecursivo(nodo.izquierdo, sumaRestante) || existeSumaRecursivo(nodo.derecho, sumaRestante);
    }

    public void vaciar() {
        this.raiz = null;
    }

    public NodoAB<T> obtenerRaiz() {
        return this.raiz;
    }
}
