package Practica_6;
public class Principal {
    public static void main(String[] args) {
        int [][] mat1 = new int [2][2];
        int [][] mat2 = new int [2][2];
        Matrices m = new Matrices();
        mat1 = m.generar(mat1);
        mat2 = m.generar(mat2);
        System.out.println("► ► ► ► ► MULTIPLICACION DE MATRICES ◄ ◄ ◄ ◄ ◄\n");
        System.out.println("\nMatriz 1");
        m.print(mat1);  
        System.out.println("\nMatriz 2");
        m.print(mat2);  
        System.out.println("\nMetodo Tradicional");
        m.tradicional(mat1, mat2);
        System.out.println("\nMetodo divide y venceras (n potencia de 2)");
        m.divide(mat1, mat2);
        System.out.println("\nMetodo Strassen");
        m.strassen(mat1, mat2);
    }
}