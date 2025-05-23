package utilidades;

import jerarquicos.ABEnteros;

public class UtilidadesABEnteros {

    //LO QUE HACE O QUE ES: Crea los árboles AB1...AB5
    public static ABEnteros[] crearABEnteros() {
        ABEnteros[] arboles = new ABEnteros[5];

        for (int i = 0; i < 5; i++) {
            arboles[i] = new ABEnteros();
        }

        // AB1
        arboles[0].insertar(2);
        arboles[0].insertar(1);
        arboles[0].insertar(3);

        // AB2 → vacío

        // AB3 (igual a AB1)
        arboles[2].insertar(2);
        arboles[2].insertar(1);
        arboles[2].insertar(3);

        // AB4
        arboles[3].insertar(5);
        arboles[3].insertar(4);
        arboles[3].insertar(8);
        arboles[3].insertar(1);
        arboles[3].insertar(7);
        arboles[3].insertar(9);

        // AB5 simétrico
        arboles[4].insertar(10);
        arboles[4].insertar(5);
        arboles[4].insertar(15);
        arboles[4].insertar(2);
        arboles[4].insertar(7);
        arboles[4].insertar(13);
        arboles[4].insertar(18);

        return arboles;
    }

    //LO QUE HACE O QUE ES: Vacía un árbol sin recorrerlo
    public static void vaciarArbolModo1(ABEnteros ab) {
        // En Java basta con hacer que la raíz sea null
        ab.vaciar();
    }

    //LO QUE HACE O QUE ES: Vacía un árbol recorriéndolo (versión recursiva)
    public static void vaciarArbolModo2(ABEnteros ab) {
        vaciarRecursivo(ab.obtenerRaiz());
        ab.vaciar();
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
