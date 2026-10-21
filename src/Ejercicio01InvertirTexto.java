/**
 * EJERCICIO 01: invierte un texto usando exclusivamente operaciones de una PILA
 * (push, pop e isEmpty). No se recorre la cadena hacia atras ni se usa reverse().
 */
import java.util.Scanner;

public class Ejercicio01InvertirTexto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = sc.nextLine();

        Pila<Character> pila = new Pila<>();

        // 1) Apilamos cada caracter en orden natural
        for (int i = 0; i < texto.length(); i++) {
            pila.push(texto.charAt(i));
        }

        // 2) Desapilamos hasta vaciar: salen en orden inverso (LIFO)
        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }

        System.out.println("Texto invertido: " + invertido);
        sc.close();
    }
}
