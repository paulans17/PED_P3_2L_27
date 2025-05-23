package utilidades;

import java.util.Scanner;

//CLASE DE APOYO PARA VALIDAR ENTRADAS DEL USUARIO
public class ValidadorEntrada {

    //LEE UN ENTERO EN UN RANGO DADO
    public static int leerEntero(Scanner sc, String mensaje, int minimo, int maximo) {
        int num;
        while (true) {
            System.out.print(mensaje);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= minimo && num <= maximo) {
                    return num;
                } else {
                    System.out.println("Número fuera de rango [" + minimo + " - " + maximo + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número entero.");
            }
        }
    }
}
