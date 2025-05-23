package modelos;

public interface I_AB<T> {

    //LO QUE HACE O QUE ES: Inserta un nuevo elemento en el árbol
    void insertar(T elemento);

    //LO QUE HACE O QUE ES: Devuelve un String con el recorrido InOrden
    String recorridoInOrden();

    //LO QUE HACE O QUE ES: Devuelve un String con el recorrido InOrden Inverso
    String recorridoInOrdenInverso();

    //LO QUE HACE O QUE ES: Devuelve un String con el recorrido PreOrden
    String recorridoPreOrden();

    //LO QUE HACE O QUE ES: Devuelve un String con el recorrido PostOrden
    String recorridoPostOrden();

    //LO QUE HACE O QUE ES: Devuelve un String con el recorrido por niveles
    String recorridoPorNiveles();

    //LO QUE HACE O QUE ES: Comprueba si este árbol es igual a otro
    boolean esIgual(I_AB<T> otro);

    //LO QUE HACE O QUE ES: Comprueba si el árbol es simétrico
    boolean esSimetrico();

    //LO QUE HACE O QUE ES: Devuelve el número de ascendientes de un nodo con valor x
    int contarAscendientes(T x);

    //LO QUE HACE O QUE ES: Devuelve el número de descendientes de un nodo con valor x
    int contarDescendientes(T x);

    //LO QUE HACE O QUE ES: Devuelve true si hay un camino cuya suma es igual a n
    boolean existeCaminoConSuma(T suma);
}
