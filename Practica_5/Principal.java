package Practica_5;
public class Principal {
    public static void main(String[] args) {
        Algoritmos al = new Algoritmos();
        int N = 15;
        long t1, t2, tt;
        int arr1[] = new int[N];
        int arr2[] = new int[N];
        int arr3[] = new int[N];
        System.out.println("\n► ► ► ► ► Mejor de los Casos ◄ ◄ ◄ ◄ ◄");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        //al.print(arr1, N);
        System.out.println("\n\n▬▬▬▬▬▬▬▬▬▬ Bubble Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.bubble(arr1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Selection Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.selection(arr1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Insertion Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.insertion(arr1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Merge Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.mergeSortI(arr1, 0, N-1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Quick Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.quick(arr1, 0, N-1);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Counting Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.counting(arr1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Heap Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.heapSort(arr1);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;


        System.out.println("\n\n► ► ► ► ► Peor de los Casos ◄ ◄ ◄ ◄ ◄");
        int j = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[j] = i;
            j++;
        }
        //al.print(arr2, j);
        System.out.println("\n\n▬▬▬▬▬▬▬▬▬▬ Bubble Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.bubble(arr2, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Selection Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.selection(arr2, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Insertion Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.insertion(arr2, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Merge Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.mergeSortI(arr2, 0, N-1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Quick Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.quick(arr2, 0, N-1);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Counting Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.counting(arr2, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Heap Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.heapSort(arr2);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;


        System.out.println("\n\n► ► ► ► ► Caso Promedio ◄ ◄ ◄ ◄ ◄");
        arr3 = al.generar(N);
        //al.print(arr3, N);
        System.out.println("\n\n▬▬▬▬▬▬▬▬▬▬ Bubble Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.bubble(arr3, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Selection Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.selection(arr3, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Insertion Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.insertion(arr3, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Merge Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.mergeSortI(arr3, 0, N-1, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Quick Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.quick(arr3, 0, N-1);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Counting Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.counting(arr3, N);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬ Heap Sort ▬▬▬▬▬▬▬▬▬▬");
        t1 = System.nanoTime();
        al.heapSort(arr3);
        t2 = System.nanoTime();
        tt = t2 - t1;
        System.out.println("Tiempo en ordenar: "+tt*1E-6+" ms");
        t1 = 0; t2 = 0; tt = 0;
    }
}
