/**
 * Importamos la libreria para hacer uso del Scanner en la clase Tienda
 */
import java.util.Scanner;
/*
 * Creacion de las variables que utilizaremos asi como nuestro arreglo de tipo Telefono
 */
public class Tienda {
    private String nombre = "Master-Phone";
    public int cantitadTelefonos = 0;
    Telefono tel[] = new Telefono[100];
    int o, i;
    /*
     * Declaramos nuestra variable de tipo Scanner para poder ocuparla a la hora de recibir valores por teclado
     */
    Scanner scann = new Scanner(System.in);
    /*
     * Creamos nuestra funcion para poder agregar datos a nuestro arreglo
     * Haciendo preguntas mediante un mensaje, recibiendo los datos mediante la variable scann
     * y almacenando los datos en cada variable que corresponda dependiendo su posicion en el arreglo
     */
    public void agregarTelefono(){
        int op;
        do{
            tel[cantitadTelefonos] = new Telefono();
            System.out.println("\nIngresa la Cantidad de la Memoria RAM: ");
            int ram = Integer.parseInt(scann.nextLine());
            tel[cantitadTelefonos].setCantMemRAM(ram);
            System.out.println("Ingresa la Marca del Procesador: ");
            String mp = scann.nextLine();
            tel[cantitadTelefonos].setMarcProse(mp);
            System.out.println("Ingresa la Cantidad de Almacenamiento: ");
            int alm = Integer.parseInt(scann.nextLine());
            tel[cantitadTelefonos].setCantAlm(alm);
            System.out.println("Ingresa la Capacidadd de la Batería: ");
            int cb = Integer.parseInt(scann.nextLine());
            tel[cantitadTelefonos].setCapBat(cb);
            System.out.println("Ingresa el Tamaño de la Pantalla: ");
            int tm = Integer.parseInt(scann.nextLine());
            tel[cantitadTelefonos].setTamPant(tm);
            System.out.println("Ingresa la Marca del dispositivo: ");
            String mar = scann.nextLine();
            tel[cantitadTelefonos].setMarca(mar);
            System.out.println("Ingresa el Modelo de tu "+tel[cantitadTelefonos].getMarca()+" : ");
            String mo = scann.nextLine();
            tel[cantitadTelefonos].setModelo(mo);
            System.out.println("Ingresa el Costo del "+tel[cantitadTelefonos].getMarca()+" "+tel[cantitadTelefonos].getModelo()+" : ");
            int pre = Integer.parseInt(scann.nextLine());
            tel[cantitadTelefonos].setPrecio(pre);
            System.out.println("\n \n Telefono Agregado Correctamente\n");
            /*
             * El contador de la cantidad de telefonos que hay aumentará en uno cada que se agregue un telefono
             */
            cantitadTelefonos++;
            /*
             * Pregunta si dese agregar otro telefono y registrara la respuesta y la evaluara
             * si la respuesta es si se repetiran la funcion y si es no saldra de la funcion
             */
            System.out.println("Desea agregar un nuevo telefono? 1. Si     2. No");
            op = Integer.parseInt(scann.nextLine());
            if(op == 1 && cantitadTelefonos<=99){
                o=0;
            }else{
                break;
            }
        }while(o == 0);
    }
    /*
     * Esta es la funcion que lo unico que hace es mediante un ciclo for mostrar solo la marca, modelo
     * y precio de cada uno de los telefonos que se encuentren en el arreglo
     */
    public void listarTelefonos(){
        for(i=0; i<cantitadTelefonos; i++){
            System.out.println("·············································································");
            System.out.println("\nTelefono "+(i+1)+":");
            System.out.println("Modelo del dispositivo: "+tel[i].getModelo());
            System.out.println("Marca del dispositivo: "+tel[i].getMarca());
            System.out.println("Costo del dispositivo: "+tel[i].getPrecio()+"\n");
        }
    }
    /*
     * esta funcion recibe el valor de la posicion del telefono que se desea vender, lo evalua y si esta
     * fuera de los limites la funcion no se ejecutara pero si esta fuera entra en funcion el ciclo for
    */
    public void venderTelefono(){
        System.out.println("Que telefono deseas vender?");
        int opc = Integer.parseInt(scann.nextLine());
        if(opc < 0 || opc > cantitadTelefonos){
            System.out.println("ERROR");
        }else{
            System.out.println("\n"+tel[opc-1].getMarca()+" "+tel[opc-1].getModelo()+" VENDIDO\n");
            for(i=opc-1; i <= cantitadTelefonos-1;i++){
                tel[i]=tel[i+1];
            }
            tel[cantitadTelefonos]=null;
            cantitadTelefonos--;
        }
    }
    /*
     * solo es el get para poder obtener el nombre de la tienda 
     */
    public String getNombre() {
        return nombre;
    }
}