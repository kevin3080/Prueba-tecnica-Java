package pruebatecnica;

import java.util.Scanner;

public class PruebaTecnica {

    public static void main(String[] args) {
        /* 1era Parte:
           Suponer un sistema de reserva de asientos para un anfiteatro. El teatro
        cuenta con 10 filas de 10 asientos cada una. Se necesita desarrollar un sistema
        (sin uso de base de datos. Únicamente majeno de datos de forma lógica) que permita
        llevar a cabo lo siguiente:
        
        1. Cargar el "mapa" de las filas y asientos. Indicado con una "X" los asientos
        ocupados y con una "L" los asientos libres. Al iniciar el programa. Todos los
        asientos deben estar libres.
        
        2. Manejar la reserva de asientos contemplando que un asiento SOLO PUEDE SER
        RESERVADO si se encuentra en estado "L", en caso de que esté en un estado "X",
        se deberá pasar automáticamente al estado "X".
        
        3. Para finalizar el programa se deberá ingresar un valor en particular. Contemplar
        que no existe una cantidad exacta de veces que el programa se pueda ejecutar.
        
        4. Contemplar que SOLO EXISTEN 10 FILAS Y 10 ASIENTOS. No se pueden vender asientos
        fuera de esas numeraciones. No se permite "sobreventa".
        
        -Consideraciones: No es necesaria implementacion ni de GUI ni de BD. Se evaluará 100%
        el manejo logico del desarrollo de la aplicación.
        
        -Extra: En caso de que un cliente solicite visualizar cúales son los asientos libres.
        el sistema debe permitir mostrar de forma gráfica el mapa de asientos. No utilizar GUI
        para este caso. Utilizar ÚNICAMENTE logica y la salida por consola.
         */

        // declaración de variables
        char asientos[][] = new char[10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila = 0, asiento = 0;
        String respuesta;
        String verMapa;

        // 1.
        // Cargamos la matriz de asientos
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos.length; c++) {
                asientos[f][c] = 'L'; // iniciamos todas las filas y col en 'L'

            }
        }

        // bienvenida al sistema
        System.out.println("----------BIENVENIDO AL SISTEMA DE RESERVAS----------");

        // 3. Controlamos el bucle con 
        // reserva de asientos
        while (bandera != true) {
            // Extra.
            // Visualización de mapa
            System.out.println("¿Desea ver los asientos disponibles? S: si. Cualquier otra cosa: no.");
            // acá vamos a llamar al método.
            verMapa = teclado.next();

            if (verMapa.equalsIgnoreCase("S")) {
                dibujarMapa(asientos);
            }

            // reserva
            boolean estaOk = false;
            while (estaOk != true) {
                System.out.println("\n Ingrese Fila y Asiento a reservar");
                // 4.
                System.out.print("Fila (entre 0 y 9) ");
                fila = teclado.nextInt();
                System.out.print("asiento (entre 0 y 9) ");
                asiento = teclado.nextInt();

                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        estaOk = true;
                    } else {
                        System.out.println("El numero de asiento no es valido");
                    }
                } else {
                    System.out.println("El numero de fila no es valido");
                }
            }

            // 2.
            // en Java para comprobar cadena de caracteres se utliza .equals("")
            /* char no es un objeto, pero String si es un objeto, entonces usamos: */
            if (asientos[fila][asiento] == 'L') {
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
            } else {
                System.out.println("El asiento está ocupado. Por favor elija otro");

            }
            // 3.
            System.out.println(" ¿Desea finalizar la reverva? S: si. Cualquier otra letra: No");
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("S")) {
                bandera = true;
            }

        }
    }

    // colocamos void porque es un procedimiento, no es una funcion que retorne nada
    // con static compartes este procedimiento con toda la clase, tambien significa que
    // No va a cambiar
    static void dibujarMapa(char asientos[][]) {
        for (int f = 0; f < asientos.length; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < asientos.length; c++) {
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }
                
    }
}
