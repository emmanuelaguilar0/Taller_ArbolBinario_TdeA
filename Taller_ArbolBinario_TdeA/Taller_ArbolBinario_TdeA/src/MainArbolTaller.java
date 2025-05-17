import java.util.Scanner;

// Clase principal que contiene el menú para interactuar con el árbol binario
public class MainArbolTaller {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        arbolbin arbol = new arbolbin(); // se crea una instancia del árbol
        int opcion, valor;

        // Menú interactivo
        do {
            System.out.println("\n//////MENÚ ÁRBOL BINARIO //////");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Recorrido PreOrden");
            System.out.println("3. Recorrido InOrden");
            System.out.println("4. Recorrido PostOrden");
            System.out.println("5. Buscar nodo");
            System.out.println("6. Altura del árbol");
            System.out.println("7. Contar nodos hoja");
            System.out.println("8. Eliminar nodo");
            System.out.println("9. Vaciar árbol");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    valor = entrada.nextInt();
                    arbol.insertar(valor);
                    break;
                case 2:
                    System.out.print("PreOrden: ");
                    arbol.mostrarPreOrden();
                    break;
                case 3:
                    System.out.print("InOrden: ");
                    arbol.mostrarInOrden();
                    break;
                case 4:
                    System.out.print("PostOrden: ");
                    arbol.mostrarPostOrden();
                    break;
                case 5:
                    System.out.print("Valor a buscar: ");
                    valor = entrada.nextInt();
                    if (arbol.contiene(valor)) {
                        System.out.println("El valor existe en el árbol.");
                    } else {
                        System.out.println("El valor no fue encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Altura: " + arbol.obtenerAltura());
                    break;
                case 7:
                    System.out.println("Cantidad de nodos hoja: " + arbol.contarHojas());
                    break;
                case 8:
                    System.out.print("Valor a eliminar: ");
                    valor = entrada.nextInt();
                    arbol.eliminar(valor);
                    break;
                case 9:
                    arbol.limpiar();
                    System.out.println("Árbol vaciado.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        entrada.close(); // se cierra el escáner
    }
}
