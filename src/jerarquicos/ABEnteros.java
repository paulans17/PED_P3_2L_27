package jerarquicos;

import modelos.I_ABEnteros;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LO QUE HACE O QUE ES: Implementación de un árbol binario con enteros
public class ABEnteros extends AB<Integer> implements I_ABEnteros {

    public ABEnteros() {
        super();
    }

    @Override
    public List<Integer> obtenerMinimosPorNivel() {
        List<Integer> minimos = new LinkedList<>();

        if (raiz == null) return minimos;

        Queue<NodoAB<Integer>> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();
            int minimoNivel = Integer.MAX_VALUE;

            for (int i = 0; i < nivelSize; i++) {
                NodoAB<Integer> actual = cola.poll();
                if (actual.dato < minimoNivel) {
                    minimoNivel = actual.dato;
                }
                if (actual.izquierdo != null) cola.offer(actual.izquierdo);
                if (actual.derecho != null) cola.offer(actual.derecho);
            }

            minimos.add(minimoNivel);
        }

        return minimos;
    }


}
