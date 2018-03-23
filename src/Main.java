import Clases.Caballero;
import Clases.Heroe;
import Clases.Piromantico;
import Lista.LinkedList;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int i = 0, num = 0;

        Scanner scan = new Scanner(System.in);

        LinkedList<Heroe> pj = new LinkedList<>();

        //El jugador escoge la clase y da el nombre al Heroe
        while (num < 2){
            System.out.println("Que clase quiere ser el jugador "+ (num + 1) +": 1 - Caballero\n"
                    + "                                   2 - Piromantico");
            int clase = scan.nextInt();

            System.out.println("Dale un nombre al Heroe: ");
            String nombre = scan.next();
            System.out.println();

            if (clase == 1){
                //Instancia
                //Aplica polimorfismo porque la instancia la trata como Heroe pero es un Caballero.
                Heroe caballero = new Caballero(nombre);
                pj.add(caballero);
                num++;
            }
            else if (clase == 2){
                //Instancia
                //Aplica polimorfismo porque la instancia la trata como Heroe pero es un Piromantico.
                Heroe piromantico = new Piromantico(nombre);
                pj.add(piromantico);
                num++;
            } else{
                System.out.println("Introduca un numero valido.");
            }
        }

        System.out.println("Comandos:  1 - Atacar\n" +
                           "           2 - Pocion\n");

        System.out.println("----------------------------------------------------------");

        while (pj.get(0).getCondicion() && pj.get(0).getCondicion()){
            System.out.println("Turno de " + pj.get(i % 2).getNombre());
            int accion = scan.nextInt();

            switch (accion){
                case 1:
                    pj.get(i % 2).hacerAtaque(pj.get((i + 1) % 2));
                    break;
                case 2:
                    double n = Math.random() * 4;
                    if (n < 2) {
                        pj.get(i % 2).pocion();
                    } else{
                        pj.get(i % 2).pocion(n);
                    }
                    break;
                default:
                    System.out.println("Debe ingresar alguno de los comandos:  1 - Atacar\n" +
                                       "                                       2 - Pocion\n");
                    break;
            }
            i++;
            System.out.println("----------------------------------------------------------");
        }
        System.out.println("Fin del Juego");
        scan.close();
    }
}
