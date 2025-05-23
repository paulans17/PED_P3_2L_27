import jerarquicos.ABEnteros;
import utilidades.UtilidadesABEnteros;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ABEnteros[] arboles = null;
        boolean creados = false;

        int opcion;

        do {
            System.out.println("\n--- MENÚ AB de enteros ---");
            System.out.println("1. Crear los AB de enteros");
            System.out.println("2. Listado de claves en InOrden");
            System.out.println("3. Listado de claves en InOrden Converso");
            System.out.println("4. Listado de claves en PreOrden");
            System.out.println("5. Listado de claves en PostOrden");
            System.out.println("6. Listado de claves por Niveles");
            System.out.println("7. Comprobar si dos árboles son iguales");
            System.out.println("8. Comprobar Simetría de un AB");
            System.out.println("9. Comprobar Parientes");
            System.out.println("10. Valor mínimo de cada nivel");
            System.out.println("11. Comprobar suma de claves");
            System.out.println("12. Vaciar Árbol Modo 1");
            System.out.println("13. Vaciar Árbol Modo 2");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            opcion = sc.nextInt();

            if ((opcion >= 2 && opcion <= 13) && !creados) {
                System.out.println("¡Primero debes crear los árboles! (Opción 1)");
                continue;
            }

            switch (opcion) {
                case 1:
                    arboles = UtilidadesABEnteros.crearABEnteros();
                    creados = true;
                    System.out.println("Árboles creados correctamente.");
                    break;

                case 2:
                    int arbol2 = pedirArbol(sc);
                    System.out.println("Recorrido en INORDEN:");
                    System.out.println(arboles[arbol2].recorridoInOrden());
                    break;

                case 3:
                    int arbol3 = pedirArbol(sc);
                    System.out.println("Recorrido en INORDEN CONVERSO:");
                    System.out.println(arboles[arbol3].recorridoInOrdenInverso());
                    break;

                case 4:
                    int arbol4 = pedirArbol(sc);
                    System.out.println("Recorrido en PREORDEN:");
                    System.out.println(arboles[arbol4].recorridoPreOrden());
                    break;

                case 5:
                    int arbol5 = pedirArbol(sc);
                    System.out.println("Recorrido en POSTORDEN:");
                    System.out.println(arboles[arbol5].recorridoPostOrden());
                    break;

                case 6:
                    int arbol6 = pedirArbol(sc);
                    System.out.println("Recorrido por NIVELES:");
                    System.out.println(arboles[arbol6].recorridoPorNiveles());
                    break;

                case 7:
                    System.out.print("Indica el primer árbol (1..5): ");
                    int a1 = sc.nextInt() - 1;
                    System.out.print("Indica el segundo árbol (1..5): ");
                    int a2 = sc.nextInt() - 1;

                    if (arboles[a1] == null || arboles[a2] == null) {
                        System.out.println("Uno de los árboles está vacío.");
                    }

                    boolean iguales = arboles[a1].esIgual(arboles[a2]);
                    System.out.println("Los árboles AB" + (a1+1) + " y AB" + (a2+1) + " son " + (iguales ? "IGUALES" : "DISTINTOS"));
                    break;

                case 8:
                    int arbol8 = pedirArbol(sc);
                    boolean simetrico = arboles[arbol8].esSimetrico();
                    System.out.println("El árbol AB" + (arbol8+1) + (simetrico ? " SÍ es SIMÉTRICO" : " NO es SIMÉTRICO"));
                    break;

                case 9:
                    int arbol9 = pedirArbol(sc);
                    System.out.print("Introduce la clave a analizar (entero positivo): ");
                    int clave = sc.nextInt();

                    int asc = arboles[arbol9].contarAscendientes(clave);
                    int desc = arboles[arbol9].contarDescendientes(clave);

                    System.out.println("Ascendientes: " + asc);
                    System.out.println("Descendientes: " + desc);
                    if (asc == desc) {
                        System.out.println("En el árbol AB" + (arbol9+1) + ", el nodo " + clave + " SÍ tiene el mismo número de ascendientes y descendientes.");
                    } else {
                        System.out.println("En el árbol AB" + (arbol9+1) + ", el nodo " + clave + " NO tiene el mismo número de ascendientes y descendientes.");
                    }
                    break;

                case 10:
                    System.out.print("¿Qué árbol deseas considerar? (1..5): ");
                    int arbol10 = sc.nextInt();
                    List<Integer> minimos = arboles[arbol10 - 1].obtenerMinimosPorNivel();
                    System.out.println("Mínimos por nivel: ");
                    for (int min : minimos) {
                        System.out.print(min + " ");
                    }
                    System.out.println();
                    break;

                case 11:
                    int arbol11 = pedirArbol(sc);
                    System.out.print("Introduce un número entero positivo: ");
                    int suma = sc.nextInt();

                    boolean existeCamino = arboles[arbol11].existeCaminoConSuma(suma);
                    if (existeCamino) {
                        System.out.println("SÍ existe un camino cuya suma de claves sea igual a " + suma);
                    } else {
                        System.out.println("NO existe ningún camino cuya suma de claves sea igual a " + suma);
                    }
                    break;

                case 12:
                    int arbol12 = pedirArbol(sc);
                    utilidades.UtilidadesABEnteros.vaciarArbolModo1(arboles[arbol12]);
                    System.out.println("Árbol AB" + (arbol12+1) + " vaciado correctamente (modo 1).");
                    break;

                case 13:
                    int arbol13 = pedirArbol(sc);
                    utilidades.UtilidadesABEnteros.vaciarArbolModo2(arboles[arbol13]);
                    System.out.println("Árbol AB" + (arbol13+1) + " vaciado correctamente (modo 2).");
                    break;

                case 0:
                    System.out.println("Gracias por utilizar nuestro TAD ABEnteros.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    private static int pedirArbol(Scanner sc) {
        int num;
        do {
            System.out.print("Indica el número del árbol (1..5): ");
            num = sc.nextInt();
        } while (num < 1 || num > 5);
        return num - 1; // índice del array
    }

}
