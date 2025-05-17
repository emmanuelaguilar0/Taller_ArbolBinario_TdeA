public class arbolbin {
    private Nodo raiz; // nodo raíz del árbol

    // Constructor del árbol 
    public arbolbin() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    // Inserta recursivamente un nuevo nodo 
    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.getDato()) {
            actual.setIzquierdo(insertarRec(actual.getIzquierdo(), valor));
        } else if (valor > actual.getDato()) {
            actual.setDerecho(insertarRec(actual.getDerecho(), valor));
        }

        return actual;
    }

    // Métodos de recorrido del árbol
    public void mostrarPreOrden() {
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    public void mostrarInOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inOrden(nodo.getDerecho());
        }
    }

    public void mostrarPostOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.getIzquierdo());
            postOrden(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }

    // Método para buscar si un valor existe en el árbol
    public boolean contiene(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (nodo.getDato() == valor) return true;

        return valor < nodo.getDato()
            ? buscar(nodo.getIzquierdo(), valor)
            : buscar(nodo.getDerecho(), valor);
    }

    // Calcula la altura del árbol
    public int obtenerAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) return 0;

        int altIzq = calcularAltura(nodo.getIzquierdo());
        int altDer = calcularAltura(nodo.getDerecho());

        return 1 + Math.max(altIzq, altDer);
    }

    // Cuenta cuántos nodos hoja  hay en el árbol
    public int contarHojas() {
        return contarNodosHoja(raiz);
    }

    private int contarNodosHoja(Nodo nodo) {
        if (nodo == null) return 0;

        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        }

        return contarNodosHoja(nodo.getIzquierdo()) + contarNodosHoja(nodo.getDerecho());
    }

    // Elimina un nodo del árbol
    public void eliminar(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }

    private Nodo eliminarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(eliminarNodo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(eliminarNodo(nodo.getDerecho(), valor));
        } else {
            // Caso con uno o ningún hijo
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();

            // buscar el mínimo del subárbol derecho
            int minimo = obtenerMinimo(nodo.getDerecho());
            nodo.setDato(minimo);
            nodo.setDerecho(eliminarNodo(nodo.getDerecho(), minimo));
        }

        return nodo;
    }

    // Encuentra el valor más pequeño del subárbol
    private int obtenerMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo.getDato();
    }

    // Vacía completamente el árbol
    public void limpiar() {
        raiz = null;
    }
}
