package Practica_2_1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Pila p = new Pila();
        Scanner scann = new Scanner(System.in);
        String exp = "";
        String res = "s";
        String value = "";
        p.inicializa(p);
        System.out.println("Ingresa tu expresion");
        exp = scann.nextLine();
        String[] elemento = exp.split(" ");
        for(int i = 0; i < elemento.length; i++){
            System.out.print(elemento[i]);
        }
        for(int i = 0; i < elemento.length; i++){
            if(elemento[i].equals("(")){
                p.push(p, elemento[i]);
            }else{
                if(elemento[i].equals(")")){
                    if(p.vacia(p)  == 1){
                        System.out.println("ERROR");
                    }else{
                        p.pop(p);
                    }
                }
            }
        }
        if(p.vacia(p) == 0){
            System.out.println("Balanceo de parentesis: INCORRECTO");
            System.exit(0);
        }else{
            System.out.println("Balanceo de parentesis: CORRECTO");
        }
        
        for(int i = 0; i < elemento.length; i++){
            if(elemento[i].equals("+") || elemento[i].equals("-") || elemento[i].equals("*") || elemento[i].equals("/")){
                while(p.vacia(p) != 1){
                    
                }
            }
        }



        /*res = "s";
        while(res.toLowerCase().startsWith("s")){
            value = p.pop(p);
            if(value == ""){
                System.out.println("La lista esta vacia");
                break;
            }
            System.out.println("El valor obtenido es: "+value);
            System.out.println("Sacar otro? [s/n]");
            res = scann.nextLine();
        }
        p.imprimir(p);
        if(p.top(p) == ""){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("El top es: "+p.top(p));
        }
        p.imprimir(p);
        return;*/
    }
}
