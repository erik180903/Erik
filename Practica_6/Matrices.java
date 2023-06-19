package Practica_6;
import java.util.Random;
public class Matrices {
    /**
     * Función para generar numeros aleatorios y rellenar una matriz
     * @param a matriz en la que se almacenan los valores
     * @return la matriz con los valores almacenados
     */
    public int[][] generar(int [][] a){
        Random rnd = new Random();
        int N = 100;
        for (int x=0; x < a.length; x++) {
            for (int y=0; y < a[x].length; y++) {
              a[x][y] = rnd.nextInt(N * 2) - N;
            }
         }
        return a;
    }
    /**
     * Función para imprimir una matriz
     * @param a matriz a imprimir
     */
    public void print(int [][] a){
        for (int x=0; x < a.length; x++) {
            for (int y=0; y < a[x].length; y++) {
              System.out.print(a[x][y] + " ");
            }
            System.out.println("");
         }
    }
    /**
     * Función para hacer la multiplicación de matrices por el metodo tradicional
     * @param a matriz a multiplicar
     * @param b matriz a multiplicar
     */
    public void tradicional(int [][] a, int [][] b){
        int n = a.length;
        int [][] c = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
                }
            }
        }
        print(c);
    }
    /**
     * Función para hacer la multiplicación de matrices por el metodo divide y venceras
     * @param a matriz a multiplicar
     * @param b matriz a multiplicar
     */
    public void divide(int [][] a, int [][] b){
        int n = a.length;
        int [][] c = new int [n][n];
            c[0][0] = (a[0][0] * b[0][0]) + (a[0][1] * b[1][0]);
            c[0][1] = (a[0][0] * b[0][1]) + (a[0][1] * b[1][1]);
            c[1][0] = (a[1][0] * b[0][0]) + (a[1][1] * b[1][0]);
            c[1][1] = (a[1][0] * b[0][1]) + (a[1][1] * b[1][1]);
        print(c);
    }
    /**
     * Función para hacer la multiplicación de matrices por el metodo de Strassen
     * @param a matriz a multiplicar
     * @param b matriz a multiplicar
     */
    public void strassen(int [][] a, int [][] b){
        int n = a.length;
        int [][] c = new int [n][n];
        int s1 = b[0][1] - b[1][1];
        int s2 = a[0][0] + a[0][1];
        int s3 = a[1][0] + a[1][1];
        int s4 = b[1][0] - b[0][0];
        int s5 = a[0][0] + a[1][1];
        int s6 = b[0][0] + b[1][1];
        int s7 = a[0][1] - a[1][1];
        int s8 = b[1][0] + b[1][1];
        int s9 = a[0][0] - a[1][0];
        int s10 = b[0][0] + b[0][1];

        int p1 = a[0][0] * s1;
        int p2 = s2 * b[1][1];
        int p3 = s3 * b[0][0];
        int p4 = a[1][1] * s4;
        int p5 = s5 * s6;
        int p6 = s7 * s8;
        int p7 = s9 * s10;

        c[0][0] = p5 + p4 - p2 + p6;
        c[0][1] = p1 + p2;
        c[1][0] = p3 + p4;
        c[1][1] = p5 + p1 - p3 - p7;
        
        print(c);
    }
}