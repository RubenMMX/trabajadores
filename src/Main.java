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
            System.out.println("6- Mostrar los trabajadores");
            System.out.println("7- Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {

                    System.out.println();
                    System.out.println("Introduzca el dni  de un trabajador");
                    dni = sc.nextLine();

                    System.out.println("Introduzca su nombre ");
                    nombre = sc.nextLine();

                    System.out.println("introduzca sus apellidos");
                    apellidos = sc.nextLine();



                    if (!trabajadores.containsKey(dni)) {
                        Trabajadores trabajador = new Trabajadores(nombre,apellidos,dni);
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


                        System.out.println("Nombre del trabajador: " + trabajadores.get(dni).getNombre());
                    } else {
                        System.out.println("No se encontró al trabajador con NIF: " + dni);
                    }


                }
                case 3 -> {

                    System.out.println();
                    System.out.println("Introduzca el nombre del trabajador a buscar");
                    nombre = sc.nextLine();
                    boolean encontrado = false;

                  for(Trabajadores trabajador :trabajadores.values()){
                      if (trabajador.getNombre().equals(nombre)) {
                          System.out.println("NIF del trabajador: " + trabajador.getDni());
                          encontrado = true;
                      }
                  }
                  if (!encontrado) {
                      System.out.println("No existe un trabajador con ese nombre");
                  }


                }
                case 4 -> {
                    System.out.println();
                    System.out.println("Introduzca el NIF del trabajador a modificar");
                    dni = sc.nextLine();
                    if (trabajadores.containsKey(dni)) {
                        trabajadores.remove(dni);
                        System.out.println("introduzca los nuevos datos");
                        System.out.println();
                        System.out.println("Introduzca el dni  de un trabajador");
                        dni = sc.nextLine();
                        System.out.println("Introduzca su nombre ");
                        nombre = sc.nextLine();
                        System.out.println("introduzca sus apellidos");
                        apellidos = sc.nextLine();
                        Trabajadores trabajador = new Trabajadores(nombre,apellidos,dni);

                    } else {
                        System.out.println("Este trabajador no existe");
                    }
                }
                case 5 -> {

                    System.out.println();
                    System.out.println("Introduzca el NIF del trabajador a borrar");
                    dni = sc.nextLine();
                    trabajadores.remove(dni);
                }
                case 6 ->{
                    System.out.println(trabajadores);
                }
                case 7 ->{
                    System.out.println("Has elegido salir");

                }


            }


            System.out.println();
        } while (opcion !=6);

    }


}
