import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Trabajadores> trabajadores = new HashMap<>();
        int opcion = 0;
        String dni;
        String nombre;
        String apellidos;


        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("INTRODUZCA UNA OPCION !");
            System.out.println("1- Introduzca un trabajador");
            System.out.println("2- Busca un trabajador por NIF");
            System.out.println("3- Busca un trabajador por nombre ");
            System.out.println("4- Modifica un trabajador");
            System.out.println("5- Borrar un trabajador");
            opcion = sc.nextInt();
            sc.nextLine();
            Trabajadores trabajador = new Trabajadores();
            switch (opcion) {

                case 1 -> {

                    System.out.println();
                    System.out.println("Introduzca el dni  de un trabajador");
                    dni = sc.nextLine();
                    trabajador.setDni(dni);
                    System.out.println("Introduzca su nombre ");
                    nombre = sc.nextLine();
                    trabajador.setNombre(nombre);
                    System.out.println("introduzca sus apellidos");
                    apellidos = sc.nextLine();
                    trabajador.setApellidos(apellidos);

                    if (!trabajadores.containsKey(dni)) {
                        trabajadores.put(dni, trabajador);
                    } else {
                        System.out.println("Este trabajador ya existe");
                    }
                }

                case 2 -> {

                    System.out.println();
                    System.out.println("Introduzca NIF del trabajador a buscar");
                    dni = sc.nextLine();
                    if (trabajadores.containsKey(dni)) {
                        trabajador = trabajadores.get(dni);
                        System.out.println("Nombre del trabajador: " + trabajador.getNombre());
                    } else {
                        System.out.println("No se encontró al trabajador con NIF: " + dni);
                    }


                }
                case 3 -> {

                    System.out.println();
                    System.out.println("Introduzca el nombre del trabajador a buscar");
                    nombre = sc.nextLine();

                    Iterator<Trabajadores> it = trabajadores.values().iterator();
                    trabajador = trabajadores.get(trabajador.getNombre());
                    if (trabajadores.containsValue(trabajador)) {

                    } else {
                        System.out.println("El trabajador no existe");
                    }


                }
                case 4 -> {
                    System.out.println();
                    System.out.println("Introduzca el NIF del trabajador a modificar");
                    dni = sc.nextLine();
                    if (trabajadores.containsKey(dni)) {
                        Main.borrar(dni, trabajadores);
                        System.out.println("introduzca los nuevos datos");
                        System.out.println();
                        System.out.println("Introduzca el dni  de un trabajador");
                        dni = sc.nextLine();
                        trabajador.setDni(dni);
                        System.out.println("Introduzca su nombre ");
                        nombre = sc.nextLine();
                        trabajador.setNombre(nombre);
                        System.out.println("introduzca sus apellidos");
                        apellidos = sc.nextLine();
                        trabajador.setApellidos(apellidos);


                    } else {
                        System.out.println("Este trabajador no existe");
                    }
                }
                case 5 -> {

                    System.out.println();
                    System.out.println("Introduzca el NIF del trabajador a borrar");
                    dni = sc.nextLine();
                    Main.borrar(dni, trabajadores);
                }


            }


            System.out.println();
        } while (opcion >= 1 && opcion <= 5);

    }

    public static void borrar(String dni, HashMap trabajadores) {

        trabajadores.remove(dni);

    }
}