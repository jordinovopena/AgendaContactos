import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("<==Agenda de Contactos==>");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar Contactos");
        System.out.println("3. Buscar Contacto");
        System.out.println("4. Salir");

       int opcion = sc.nextInt();
       switch (opcion) {
           case 1:
               System.out.println("-Nombre: ");
               System.out.println("-Telefono: ");
               break;
           case 2:
               System.out.println("<==Contactos Guardados==>");
               System.out.println("--No tienes ningun contacto guardado--");
               break;
           case 3:
               System.out.println("--Nombre: ");
               break;
           case 4:
               System.out.println("--Nos vemos JEFE!!--");
               break;
           default:
               System.out.println("--Tienes que elegir un numero del 1-4");






       }
    }
}
