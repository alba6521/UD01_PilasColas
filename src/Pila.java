/** Pila (LIFO) implementada con nodos enlazados.
 * Solo se mantiene una referencia a la cima: se apila y desapila por ahi.
 * @param <T> tipo de dato almacenado
 */
public class Pila<T> {
    private Nodo<T> cima; // Ultimo elemento apilado
    private int tamano;

    public Pila() {
        this.cima = null;
        this.tamano = 0;
    }

    /** PUSH: inserta un elemento en la cima. */
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(cima); // El nuevo apunta a la antigua cima
        cima = nuevo;             // Y pasa a ser la nueva cima
        tamano++;
    }

    /** POP: extrae y devuelve la cima. Lanza excepcion si la pila esta vacia. */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente(); // La cima baja al siguiente nodo
        tamano--;
        return dato;
    }

    /** ISEMPTY: true si no hay elementos. */
    public boolean isEmpty() {
        return cima == null;
    }

    public int size() {
        return tamano;
    }
}
