package Practica_3;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ABB abb = new ABB(); 
        AVL avl = new AVL();
        Random rnd = new Random();
        int lost;
        boolean found1 = false, found2 = false;
        long t1, t2, t3, t4, t5, t6, t7, t8, et1, et2, et3, et4;

        //2.1 Generar 1,000,000 de numero pseudoaleatorios entre 1 y 2,000,000 y hacer 50 busquedad con ABB
        /*final int Max = 10000;
        System.out.println("GENERANDO . . . . . . ");
        for(int i = 0; i <= 5000; i++){
            int num = rnd.nextInt((Max * 2) - Max);
            abb.insertar(num);
            avl.insertar(num);
            //System.out.println(num);
        }
        System.out.println("\n\n\n");
        for(int i = 0; i < 50; i++){
            lost = rnd.nextInt((Max * 2) - Max);
            //System.out.println(lost);
            t1 = System.nanoTime();
            found1 = abb.buscar(lost) == null ? false:true;
            t2 = System.nanoTime();
            et1 = t2-t1;
            System.out.println("Busqueda del numero |"+lost+"| ABB: " + et1*1E-6 + " ms, Resultado: " + found1);
        }*/

        //2.2 Generar 1,000,000 de numero pseudoaleatorios entre 1 y 2,000,000 y hacer 50 busquedad con AVL
        /*final int Max = 10000;
        System.out.println("GENERANDO . . . . . . ");
        for(int i = 0; i <= 5000; i++){
            int num = rnd.nextInt((Max * 2) - Max);
            abb.insertar(num);
            avl.insertar(num);
            //System.out.println(num);
        } 
        System.out.println("\n\n\n");
        for(int i = 0; i < 50; i++){
            t3 = System.nanoTime();
            found2 = avl.buscar(lost) == null ? false:true;
            t4 = System.nanoTime();
            et2 = t4-t3;
            System.out.println("Busqueda del numero |"+lost+"| AVL: " + et2*1E-6 + " ms, Resultado: " + found2);
        }*/

        //2.3 Generar 10,000 consecutivos desde 1,000,000 hasta 1, insertarlos en los arboles ABB y AVL
        //y hacer 50 busquedas obtener el tiempo en milisegundos
        final int Max = 20000;
        System.out.println("GENERANDO . . . . . . ");
        t1 = System.nanoTime();
        for(int i = 10000; i > 0; i--){
            abb.insertar(i);
        }
        t2 = System.nanoTime();
        et1 = t2 - t1;
        System.out.println("Valores insertados en el árbol ABB    ->     Tiempo: "+et1*1E-6+" ms");
        System.out.println("GENERANDO . . . . . . ");
        t3 = System.nanoTime();
        for(int i = 10000; i > 0; i--){
            avl.insertar(i);
        }
        t4 = System.nanoTime();
        et2 = t4 - t3;
        System.out.println("Valores insertado en el árbol AVL    ->     Tiempo: "+et2*1E-6+" ms");

        System.out.println("\n\n\n");
        for(int i = 0; i < 50; i++){
            lost = rnd.nextInt((Max * 2) - Max);
            //System.out.println(lost);
            t5 = System.nanoTime();
            found1 = abb.buscar(lost) == null ? false:true;
            t6 = System.nanoTime();
            et3 = t6 - t5;
            System.out.println("Busqueda del numero |"+lost+"| ABB: " + et3*1E-6 + " ms, Resultado: " + found1);

            t7 = System.nanoTime();
            found2 = avl.buscar(lost) == null ? false:true;
            t8 = System.nanoTime();
            et4 = t8 - t7;
            System.out.println("Busqueda del numero |"+lost+"| AVL: " + et4*1E-6 + " ms, Resultado: " + found2);
        }
        System.out.println("\n\nEl valor minimo en ABB es: "+abb.minimo(abb));
        System.out.println("\n\nEl valor maximo en ABB es: "+abb.maximo(abb));
        System.out.println("\n\nEl valor minimo en AVL es: "+avl.minimo(avl));
        System.out.println("\n\nEl valor maximo en AVL es: "+avl.maximo(avl));
        
        
        
        //Codigo para verificar que las funciones del Arbol AVL funcionen correctamente
        /*avl.insertar(8);
        avl.insertar(9);
        avl.insertar(10);
        avl.insertar(2);
        avl.insertar(1);
        avl.insertar(5);
        avl.insertar(3);
        avl.insertar(6);
        avl.insertar(4);
        avl.insertar(7);
        avl.insertar(11);
        avl.insertar(12);*/

        
        /*avl.insertar(15);
        avl.insertar(6);
        avl.insertar(18);
        avl.insertar(3);
        avl.insertar(8);
        avl.insertar(17);
        avl.insertar(20);
        avl.insertar(2);
        avl.insertar(4);
        avl.insertar(7);
        avl.insertar(13);
        avl.insertar(21);
        avl.insertar(9);
        avl.inorden();
        Scanner scann = new Scanner(System.in);
        System.out.println("\n\n\n");
        avl.desbalances();
        System.out.println("\n\nEl valor minimo es: "+avl.minimo(avl));
        System.out.println("\n\nEl valor maximo es: "+avl.maximo(avl));
        System.out.println("\n\nIngresa el numero que deseas buscar");
        int buscar = Integer.parseInt(scann.nextLine());
        if(avl.buscar(buscar) == null){
            System.out.println("Valor no encontrado");
        }else{
            System.out.println("Valor encontrado");
        }
        System.out.println("\n\nIngresa el numero del que deseas saber su predecesor y sucesor");
        int pys = Integer.parseInt(scann.nextLine());
        System.out.println("\n\nEl predecesor del numero "+pys+" es: "+avl.predecesor(pys));
        System.out.println("\n\nEl sucesor del numero "+pys+" es: "+avl.sucesor(pys));
        System.out.println("\n\nIngresa el numero que deseas eliminar");
        int del = Integer.parseInt(scann.nextLine());
        avl.eliminar(del);
        avl.inorden();*/
    }
}