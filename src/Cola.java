/**
 * Cola (FIFO) implementada con nodos enlazados.
 * Se mantienen referencias al primero (para desencolar) y al ultimo (para encolar),
 * de modo que ambas operaciones son O(1).
 *
 * @param <T> tipo de dato almacenado
 */
public class Cola<T> {
    private Nodo<T> primero; // Siguiente elemento a salir
    private Nodo<T> ultimo;  // Ultimo elemento en llegar
    private int tamano;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    /** ENQUEUE: añade un elemento al final de la cola. */
    public void enqueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = nuevo;            // Cola vacia: es primero y ultimo a la vez
        } else {
            ultimo.setSiguiente(nuevo); // Enlaza tras el ultimo actual
        }
        ultimo = nuevo;
        tamano++;
    }

    /** DEQUEUE: extrae y devuelve el primer elemento. Lanza excepcion si esta vacia. */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null; // Si se vacio, tambien se limpia el ultimo
        }
        tamano--;
        return dato;
    }

    /** ISEMPTY: true si no hay elementos. */
    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        return tamano;
    }

    /** Devuelve el contenido de la cola (del primero al ultimo) sin modificarla. */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[cola vacia]";
        }
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
