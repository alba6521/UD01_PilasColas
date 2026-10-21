/**EJERCICIO 04: convierte un entero decimal positivo a binario usando una PILA.
 * Se apilan los restos de dividir entre 2 y al desapilar se obtiene el binario.
 */
import java.util.Scanner;

public class Ejercicio04DecimalBinario {

    static String aBinario(int numero) {
        if (numero == 0) {
            return "0"; // Caso especial: el bucle no apilaria nada
        }
        Pila<Integer> pila = new Pila<>();

        // Los restos salen del bit menos significativo al mas significativo
        while (numero > 0) {
            pila.push(numero % 2);
            numero = numero / 2;
        }

        // Al desapilar, el orden queda invertido: del mas al menos significativo
        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        return binario.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un entero positivo: ");
        try {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n < 0) {
                System.out.println("El numero debe ser positivo.");
            } else {
                System.out.println(n + " en binario es " + aBinario(n));
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no valida: introduce un numero entero.");
        }
        sc.close();
    }
}
