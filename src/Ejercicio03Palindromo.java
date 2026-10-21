/**EJERCICIO 03: comprueba si una palabra o frase es palindroma usando a la vez
 * una PILA (lectura inversa) y una COLA (lectura directa).
 */
import java.text.Normalizer;
import java.util.Scanner;

public class Ejercicio03Palindromo {

    /** Normaliza: minusculas, sin tildes, y solo letras/digitos (quita espacios y signos). */
    static String normalizar(String texto) {
        String s = texto.toLowerCase();
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return s.replaceAll("[^a-z0-9]", "");
    }

    /** Devuelve true si el texto ya normalizado es palindromo. */
    static boolean esPalindromo(String normalizado) {
        Pila<Character> pila = new Pila<>();
        Cola<Character> cola = new Cola<>();

        // Mismo contenido en ambas estructuras: la pila lo devolvera al reves
        for (int i = 0; i < normalizado.length(); i++) {
            char c = normalizado.charAt(i);
            pila.push(c);
            cola.enqueue(c);
        }

        // Comparamos primer caracter (cola) con ultimo (pila), y asi sucesivamente
        while (!pila.isEmpty()) {
            if (!pila.pop().equals(cola.dequeue())) {
                return false; // Basta una diferencia para descartarlo
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra o frase: ");
        String original = sc.nextLine();

        String normalizado = normalizar(original);
        if (normalizado.isEmpty()) {
            System.out.println("No hay caracteres validos que comprobar.");
        } else if (esPalindromo(normalizado)) {
            System.out.println("\"" + original + "\" ES un palindromo.");
        } else {
            System.out.println("\"" + original + "\" NO es un palindromo.");
        }
        sc.close();
    }
}
