package Practica_2_2;
import java.text.ParseException;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        ColaP c = new ColaP();
        c.init(c);
        Scanner scann = new Scanner(System.in);
        int val = 0, prio = 0;
        String com = ""; 
        System.out.println("Formato PRIORIDAD - VALOR\n");
        while(prio == 1 || prio == 2 || prio == 3 || prio == 0){
            System.out.println("Inserte los datos de forma PRIORIDAD-VALOR");
            com = scann.nextLine();
            String[] parts = com.split("-");
            val = Integer.parseInt(parts[1]);
            prio = Integer.parseInt(parts[0]);
            c.add(c, val, prio);
        }
        for(int i = 0; i <= c.size; i++){
            c.print(c);
            c.peek(c);
        }
        return;
    }
}