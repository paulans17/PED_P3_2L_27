package modelos;

public interface I_ABEnteros extends I_AB<Integer> {

    //LO QUE HACE O QUE ES: Devuelve una lista con el valor mínimo de cada nivel
    java.util.List<Integer> obtenerMinimosPorNivel();
}
