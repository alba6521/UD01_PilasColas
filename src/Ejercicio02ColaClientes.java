/**EJERCICIO 02: simulacion de una fila de clientes atendidos por orden de llegada
 * usando una COLA. Menu: 1) Llegada 2) Atender 3) Mostrar cola 4) Salir.
 */
import java.util.Scanner;

public class Ejercicio02ColaClientes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cola<String> cola = new Cola<>();
        int opcion = 0;

        do {
            // Menu principal
            System.out.println("\n--- GESTION DE CLIENTES ---");
            System.out.println("1) Llegada");
            System.out.println("2) Atender");
            System.out.println("3) Mostrar cola");
            System.out.println("4) Salir");
            System.out.print("Opcion: ");

            // Leemos como texto para no romper el programa si se escribe algo no numerico
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0; // Opcion invalida, se mostrara el aviso en el default
            }

            switch (opcion) {
                case 1: // Llegada: se encola el nombre
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacio.");
                    } else {
                        cola.enqueue(nombre);
                        System.out.println(nombre + " se ha puesto en la cola.");
                    }
                    break;
                case 2: // Atender: se desencola y se muestra el atendido
                    if (cola.isEmpty()) {
                        System.out.println("No hay clientes esperando.");
                    } else {
                        System.out.println("Atendiendo a: " + cola.dequeue());
                    }
                    break;
                case 3: // Mostrar el estado de la cola sin modificarla
                    System.out.println("Clientes en espera (" + cola.size() + "): " + cola);
                    break;
                case 4:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
