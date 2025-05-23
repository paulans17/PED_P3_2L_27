package utilidades;

import jerarquicos.ABEnteros;

public class UtilidadesABEnteros {

    //LO QUE HACE O QUE ES: Crea los árboles AB1...AB5
    public static ABEnteros[] crearABEnteros() {
        ABEnteros[] arboles = new ABEnteros[5];
        for (int i = 0; i < arboles.length; i++) {
            arboles[i] = new ABEnteros();
        }

        // Ejemplo de inserción manual en algunos árboles:
        arboles[0].insertar(2);  // AB1
        arboles[0].insertar(1);
        arboles[0].insertar(3);

        arboles[2].insertar(2);  // AB3 (idéntico a AB1 para comparar)
        arboles[2].insertar(1);
        arboles[2].insertar(3);

        // arboles[1] vacío, arboles[3], arboles[4] puedes definirlos tú

        return arboles;
    }

    //LO QUE HACE O QUE ES: Vacía un árbol sin recorrerlo
    public static void vaciarArbolModo1(ABEnteros ab) {
        // En Java basta con hacer que la raíz sea null
        ab.raiz = null;
    }

    //LO QUE HACE O QUE ES: Vacía un árbol recorriéndolo (versión recursiva)
    public static void vaciarArbolModo2(ABEnteros ab) {
        vaciarRecursivo(ab.raiz);
        ab.raiz = null;
    }

    //LO QUE HACE O QUE ES: Recorre y "borra" cada nodo (aunque Java libera solo)
    private static void vaciarRecursivo(jerarquicos.NodoAB<Integer> nodo) {
        if (nodo == null) return;
        vaciarRecursivo(nodo.izquierdo);
        vaciarRecursivo(nodo.derecho);
        nodo.izquierdo = null;
        nodo.derecho = null;
    }
}
