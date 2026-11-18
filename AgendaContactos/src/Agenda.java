import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    static class Contacto {
        private final String nombre;
        private final String telefono;

        Contacto(String nombre, String telefono) {
            this.nombre = nombre;
            this.telefono = telefono;
        }

        String getNombre() {
            return nombre;
        }

        String getTelefono() {
            return telefono;
        }

        @Override
        public String toString() {
            return nombre + " - " + telefono;
        }
    }

    private static final ArrayList<Contacto> contactos = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    anadirContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Elige un número del 1 al 4.");
            }
        } while (opcion != 4);
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== AGENDA DE CONTACTOS =====");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void anadirContacto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine().trim();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            System.out.println("El nombre y el teléfono no pueden estar vacíos.");
            return;
        }
        contactos.add(new Contacto(nombre, telefono));
        System.out.println("Contacto añadido correctamente.");
    }

    private static void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("\n--- Lista de contactos ---");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i));
        }
    }

    private static void buscarContacto() {
        System.out.print("Nombre a buscar: ");
        String busqueda = sc.nextLine().trim().toLowerCase();
        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(busqueda)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }
}