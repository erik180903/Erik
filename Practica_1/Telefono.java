/**
 * Importamos la libreria para hacer uso del Scanner en la clase Telefono
 */
import java.util.Scanner;

public class Telefono {
    /*
     * Declaracion de Variables
     */
    private int cantMemRAM;
    private String marcProse;
    private int cantAlm;
    private int capBat;
    private int tamPant;
    private String marca;
    private String modelo;
    private int precio;
    /*
     * Declaramos nuestra variable de tipo Scanner para poder ocuparla a la hora de recibir valores por teclado
     */
    Scanner scann = new Scanner(System.in);
    /*
     * Declaracion de Getters y Setters de cada variable declarada
     */
    public void setCantMemRAM(int cantMemRAM){
        this.cantMemRAM = cantMemRAM;
    }
    public int getCantMemRAM(){
        return cantMemRAM;
    }

    public void setMarcProse(String marcProse){
        this.marcProse = marcProse;
    }
    public String getMarcProse(){
        return marcProse;
    }

    public void setCantAlm(int cantAlm){
        this.cantAlm = cantAlm;
    }
    public int getCantAlm(){
        return cantAlm;
    }

    public void setCapBat(int capBat){
        this.capBat = capBat;
    }
    public int getCapBat(){
        return capBat;
    }

    public void setTamPant(int tamPant){
        this.tamPant = tamPant;
    }
    public int getTamPant(){
        return tamPant;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return modelo;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }

    /*
     * Creacion de metdos de las funciones que realizan los telefonos
     */
    public void hacerLlamada(){
        System.out.println("L L A M A N D O . . . . ");
    }

    public void enviarMensaje(){
        System.out.println("Escriba el mensaje que desea enviar: ");
        scann.nextLine();
        System.out.println("M E N S A J E  E N V I A D O");
    }

    public void instalarApp(){
        System.out.println("Que aplicacion desea instalar: ");
        scann.nextLine();
        System.out.println("I N S T A L A N D O . . . . ");
    }
    public void abrirApp(){
        System.out.println("Que aplicacion desea abrir: ");
        scann.nextLine();
        System.out.println("A B R I E N D O . . . . ");
    }
}