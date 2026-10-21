/**Nodo generico reutilizado por Pila y Cola. Cada nodo guarda un dato y una referencia al siguiente nodo.
 *  @param <T> tipo de dato almacenado
 */
public class Nodo<T> {
    private T dato;          // Informacion almacenada
    private Nodo<T> siguiente; // Enlace al siguiente nodo (null si es el ultimo)

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
