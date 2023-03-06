/**
 * Importamos la libreria para hacer uso del Scanner en la clase Princial
 */
import java.util.Scanner;

public class Principal{
    /*
     * declaracion de las variables que utilizaremos y de nuestro objeto de tipo Tienda
     */
    public static void main(String[] args) {
        Tienda t1 = new Tienda();
        Scanner scann = new Scanner(System.in);
        int opcm;
        boolean salir = false;
        /*
         * Nombre de la tienda
         */
        System.out.println("·········· "+t1.getNombre()+" ··········");
        /*
         * Ciclo para mostrar el menu
         */
        do{
           System.out.println("Que deseas hacer?\n1.AGREGAR TELEFONO\n2.MOSTRAR TELEFONOS\n3.VENDER TELEFONO\n4.SALIR"); 
           opcm = Integer.parseInt(scann.nextLine());
           if(opcm == 1){
            t1.agregarTelefono();
           }else if(opcm == 2){
            t1.listarTelefonos();
           }else if(opcm == 3){
            t1.venderTelefono();
           }else if(opcm == 4){
            salir = true;
           }
        }while(salir == false);
    }   
}