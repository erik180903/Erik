package Practica_4;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception{
        /**
         * Declaración de las variables a utilizar
         */
        Lista_Adya G = new Lista_Adya();
        Scanner scann = new  Scanner(System.in);
        String nodo, ver, vi, vf, oaddv, oadda, arista;
        boolean salir = false, dadd = false, aadd = false;
        System.out.println("♦ ♦ ♦ ♦ ♦ GRAFOS ♦ ♦ ♦ ♦ ♦");

        /**
         * Ciclo para agregar vertices
         */
        while(!dadd){
            System.out.println("Ingresa el vertice: ");
            ver = scann.nextLine();
            G.addVertice(ver.toLowerCase());
            System.out.println("Deseas agregar otro vertice? s/n");
            oaddv = scann.nextLine();
            if(oaddv.toLowerCase().equals("n")){
                dadd = true;
            }
        }
        System.out.println("\n\n");

        /**
         * Ciclo para agregar las aristas
         */
        while(!aadd){
            System.out.println("Ingresa la arista (verticeinicial verticefinal):");
            arista = scann.nextLine();
            String[] vert = arista.split(" ");
            vi = vert[0].toLowerCase();
            vf = vert[1].toLowerCase(); 
            G.addArista(vi, vf);
            System.out.println("Deseas agregar otra arista? s/n");
            oadda = scann.nextLine();
            if(oadda.toLowerCase().equals("n")){
                aadd = true;
            }
        }
        System.out.println("\n\n");

        /**
         * Menu para escoger el tipo de recorrido
         */
        while(!salir){
            System.out.println("\n Seleccione el tipo de recorrido que desea realiza: ");
            System.out.println("1. Recorrido en Anchura.\n2. Recorrido en Profundidad.\n3. Salir");
            String opc = scann.nextLine();
            int opc2 = Integer.parseInt(opc);
            if(opc2 == 1){
                System.out.println("► ► ► ► ► Recorrido en Anchura ◄ ◄ ◄ ◄ ◄\n");
                System.out.println("Apartir de que nodo deseas iniciar el recorrido:");
                nodo = scann.nextLine();
                G.anchura(nodo.toLowerCase());
                System.out.println("\n");
            }else if(opc2 == 2){
                System.out.println("► ► ► ► ► Recorrido en Profundidad ◄ ◄ ◄ ◄ ◄\n");
                System.out.println("Apartir de que nodo deseas iniciar el recorrido:");
                nodo = scann.nextLine();
                G.profundidad(nodo.toLowerCase());
                System.out.println("\n");
            }else if(opc2 == 3){
                salir =  true;
            }
        }
    }
}