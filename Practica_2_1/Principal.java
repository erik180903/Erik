package Practica_2_1;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Pila p = new Pila();
        Scanner scann = new Scanner(System.in);
        String exp = "";
        String value = "";
        System.out.println("Ingresa tu expresion \n");
        exp = scann.nextLine();
        String[] elemento = exp.split(" ");
        for(int i = 0; i < elemento.length; i++){
            System.out.print(elemento[i]);
            value = ""+value+""+ elemento[i];
        }
        for(int i = 0; i < elemento.length; i++){
            if(elemento[i].equals("(")){
                p.push(elemento[i]);
            }else{
                if(elemento[i].equals(")")){
                    if(p.vacia() == true){
                        System.out.println("ERROR");
                    }else{
                        p.pop();
                    }
                }
            }
        }
        if(p.vacia() == false){
            System.out.println("\nBalanceo de parentesis: INCORRECTO\n");
            System.exit(0);
        }else{
            System.out.println("\nBalanceo de parentesis: CORRECTO \n");
        }
        String postfijo = p.postfija(p, value);
        System.out.println("Notación Postfija: " + postfijo + "\n");
        float rpostfijo = p.calpost(p, postfijo);   
        System.out.println("Resultado Postfijo: " + rpostfijo + "\n");
        String prefijo = p.prefija(p, value);
        System.out.println("Notación Prefija: " + prefijo + "\n");
        float rprefijo = p.calpre(p, prefijo);
        System.out.println("Resultado Prefijo: " + rpostfijo + "\n");
    }
}