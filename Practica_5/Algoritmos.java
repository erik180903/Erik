package Practica_5;
import java.util.Random;
public class Algoritmos {
    /**
     * Función para generar los valores aleatorios y alamacenarlos en el arreglo
     * @param size tamaño del arreglo
     * @return el arreglo con los datos ingresados
     */
    public int[] generar(int size){
        int arr[] = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt((size * 2) - size);
        }
        return arr;
    }
    /**
     * Función para imprimir el arreglo
     * @param arr Arreglo que imprimirá
     * @param size tamaño del arreglo
     */
    public void print(int arr[], int size){
        for (int i = 0; i < size; i++) {
            System.out.print("►"+arr[i]+" ");
        }
    }
    /**
     * Función para el algoritmo BUBBLE-SORT
     * @param arrb Arreglo a ordenar
     * @param size tamaño del arreglo
     */
    public void bubble(int arrb[], int size){
        int aux;
        boolean swap = true;
        for (int i = 0; i < (size - 1); i++) {
            if(!swap){
                break;
            }else{
                swap = false;
            }
            for (int j = 0; j < (size - 1 - i); j++) {
                if(arrb[j] > arrb[j + 1]){
                    aux = arrb[j];
                    arrb[j] = arrb[j + 1];
                    arrb[j + 1] = aux;
                    swap = true;
                }
            }
        }
    }
    /**
     * Función para el algoritmo SELECTION-SORT
     * @param arrs Arreglo a ordenar
     * @param size tamaño del arreglo
     */
    public void selection(int arrs[], int size){
        int idxmaschi, aux;
        for (int i = 0; i < size; i++) {
            idxmaschi = i;
            for (int j = i; j < size; j++) {
                if(arrs[j] < arrs[idxmaschi]){
                    idxmaschi = j;
                }
            }
            if(idxmaschi != i){
                aux = arrs[idxmaschi];
                arrs[idxmaschi] = arrs[i];
                arrs[i] = aux;
            } 
        }
    }
    /**
     * Función para el algoritmo SELECTION-SORT
     * @param arri Arreglo a ordenar
     * @param size tamaño del arreglo
     */
    public void insertion(int arri[], int size){
        int valor, j;
        for (int i = 1; i < size; i++) {
            valor = arri[i];
            for (j = i - 1; j > 0; j--) {
                if(arri[j] > valor){
                    arri[j + 1] = arri[j];
                }else{
                    break;
                }
            }
            arri[j + 1] = valor;
        }
    }
    /**
     * Función para la recursividad del algoritmo MERGE-SORT
     * @param arrm Arreglo a ordenar
     * @param l lado izquierdo
     * @param m mitad
     * @param r lado derecho
     */
    public void merge(int arrm[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int arrL[] = new int[n1];
        int arrR[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            arrL[i] = arrm[l + i];
        }
        for (int i = 0; i < n2; i++) {
            arrR[i] = arrm[m + i + 1];
        }
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(arrL[i] <= arrR[j]){
                arrm[l] = arrL[i];
                i++;
            }else{
                arrm[l] = arrR[j];
                j++;
            }
            l++;
        }
        while(i < n1){
            arrm[l] = arrL[i];
            i++;
            l++;
        }
        while(j < n2){
            arrm[l] = arrR[j];
            j++;
            l++;
        }
    }
    /**
     * Función para el algoritmo MERGE-SORT
     * @param arr Arreglo a ordenar
     * @param l lado derecho del arreglo
     * @param r lado izquierdo del arreglo
     * @param size tamaño del arreglo
     */ 
    public void mergeSortI(int arr[], int l, int r, int size){
        for (int m = 1; m <= r - 1; m = 2 * m) {
            for (int i = l; i < r; i+= 2 * m) {
                int nl = i;
                int mid = i + m - 1;
                int nr;
                if((i + 2 * m - 1) < r){
                    nr = i + 2 * m - 1;
                }else{
                    nr = r;
                }
                if(mid <= nr){
                    merge(arr, nl, mid, nr);
                }
            }
        }
    }
    /**
     * Función para el algoritmo QUICK-SORT
     * @param arrq Arreglo a ordenar
     * @param l lado izquierdo del arreglo
     * @param r lado derecho del arreglo
     */
    public void quick(int arrq[], int l, int r){
        if(l < r){
            int piv = arrq[l];
            int i = l + 1, j = l + 1;
            int aux = 0;
            for (; j <= r; j++) {
                if(arrq[j] <= piv){
                    aux = arrq[j];
                    arrq[j] = arrq[i];
                    arrq[i] = aux;
                    i++;
                }
            }
            arrq[l] = arrq[i - 1];
            arrq[i - 1] = piv;
            quick(arrq, l, i - 2);
            quick(arrq, i, r); 
        }
    }
    /**
     * Función para el algoritmo COUNTING-SORT
     * @param arrc Arreglo a ordenar
     * @param size tamaño del arreglo
     */
    public void counting(int arrc[], int size){
        int max = arrc[0];
        int aux[] = new int[arrc.length];
        for(int i = 0; i < arrc.length; i++){
            if(max < arrc[i]){
                max = arrc[i];
            }
        }
        int arr[] = new int[max + 1];
        for(int i = 0; i < arrc.length; i++){
            arr[arrc[i]] = arr[arrc[i]] + 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i + 1] + arr[i];
        }
        for (int i = 0; i < arrc.length; i++) {
            aux[arr[arrc[i]]-1] = arrc[i];
        }
    }
    /**
     * Función para poder poner al valor mas grande como raiz
     * @param arrh Arreglo a ordenar
     * @param size tamaño del arreglo
     * @param x valor en el que inicia para encontar al mas grande
     */
    public void heap(int arrh[], int size, int x){
        int mayor = x;
        int hI = 2 * x + 1; 
        int hD = 2 * x + 2;
        if(hI < size && arrh[hI] > arrh[mayor]){
            mayor = hI;
        }
        if(hD < size && arrh[hD] > arrh[mayor]){
            mayor = hD;
        }
        if(mayor != x){
            int aux = arrh[x];
            arrh[x] = arrh[mayor];
            arrh[mayor] = aux;
            heap(arrh, size, mayor);
        }
    }
    /** 
     * Función para el algoritmo HEAP-SORT
     * @param arr arreglo a ordenar
     */
    public void heapSort(int arr[]){
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            heap(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int aux = arr[0];
            arr[0] = arr[i];
            arr[i] = aux;
            heap(arr, i, 0);            
        }
    }
}