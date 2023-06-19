package Practica_2;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        Scanner scann = new Scanner(System.in);
        int valor, posicion, value, sentido, nele, opcion, opcion2;
        String op="",op2="";
        do{
            System.out.println("Elige la opcion que desees: ");
            System.out.println("1. Insertar numeros\n2. Buscar numero\n3. Listar\n4. Salir");
            opcion = Integer.parseInt(scann.nextLine());
            switch(opcion){
                case 1:
                    System.out.println("1. Insertar numeros por teclado\n2. Insertar valores aleatorios");
                    opcion2 = Integer.parseInt(scann.nextLine());
                    if(opcion2 == 1){
                        do {
                            System.out.print("Digite un numero: ");
                            valor = Integer.parseInt(scann.nextLine());
                            lista.add(valor);
                            System.out.print("Desea agregar otro?[s/n] ");
                            op = scann.nextLine();
                        } while (op.toLowerCase().startsWith("s"));
                        System.out.println("Valores insertados");
                        lista.mostrar(1);
                        System.out.println("Deseas agregar un valor en un lugar especifico?[s/n]");
                        op2 = scann.nextLine();
                        if(op2.toLowerCase().startsWith("s")){
                            System.out.println("Ingresa el valor");
                            valor = Integer.parseInt(scann.nextLine());
                            System.out.println("Ingresa la posicion");
                            posicion = Integer.parseInt(scann.nextLine());
                            lista.add(valor, posicion);
                            lista.mostrar(1);
                        }
                      }else if(opcion2 == 2){
                        System.out.println("Ingresa el numero de elementos:");
                        nele = Integer.parseInt(scann.nextLine());
                        lista.aleatorios(nele);
                      }else{
                        break;
                      }
                break;
                case 2:
                    System.out.println("Introduce el valor a buscar:");
                    value = Integer.parseInt(scann.nextLine());
                    lista.buscar(value);
                break;
                case 3:
                    System.out.println("De que modo deseas ver la lista \n1. Primero al ultimo\n2. Ultimo al primero");
                    sentido = Integer.parseInt(scann.nextLine());
                    lista.mostrar(sentido);
                break;
            }
        }while(opcion != 4);
    }
}