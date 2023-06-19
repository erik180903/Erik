package Practica_7;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    /**
     * Declaración de la tabla de adyacencia
     */
    private Hashtable<String, List<Node>> listaAdy;
    public Dijkstra() {
        listaAdy = new Hashtable<String, List<Node>>();
    }
    /**
     * Clase para la creación de nodos (vertices)
     */
    static class Node implements Comparable<Node> {
        String d;
        int peso;
        /**
         * Constructor por defecto
         * @param d distancia guardada en el nodo
         * @param peso peso de la arista del nodo
         */
        public Node(String d, int peso) {
            this.d = d;
            this.peso = peso;
        }
        public String getD() {
            return d;
        }
        public int getPeso() {
            return peso;
        }
        public int compareTo(Node other) {
            return Integer.compare(peso, other.getPeso());
        }
    }
    /**
     * Función para agregar un vertice
     * @param s valor que almacena el vertice
     */
    public void addVertice(String s) {
        listaAdy.put(s, new LinkedList<Node>());
    }
    /**
     * Función para agregar una arista
     * @param o vertice del que sale
     * @param d vertice al que llega
     * @param peso de la arista
     * @throws Exception en caso de que la arista ya exista 
     */
    public void addArista(String o, String d, int peso) throws Exception {
        if (!listaAdy.containsKey(o))
            throw new Exception("Vertice de origen no válido.");
        if (!listaAdy.containsKey(d))
            throw new Exception("Vertice de destino no válido.");
        List<Node> nodes = listaAdy.get(o);
        for (Node node : nodes) {
            if (node.getD().equals(d)) {
                throw new Exception("La arista ya existe.");
            }
        }
        Node newN = new Node(d, peso);
        nodes.add(newN);
    }
    /**
     * Función para aplicar el algoritmo de Dijkstra
     * @param o vertice de inicio
     * @param d vertice final
     * @return cada vertice por el que pasa para formar el camino mas corto
     */
    public List<String> dijkstraM(String o, String d) {
        PriorityQueue<Node> colaP = new PriorityQueue<>();
        Hashtable<String, Integer> dis = new Hashtable<>();
        Hashtable<String, String> prev = new Hashtable<>();
        for (String vertice : listaAdy.keySet()) {
            dis.put(vertice, Integer.MAX_VALUE);
        }
        dis.put(o, 0);
        colaP.add(new Node(o, 0));
        while (!colaP.isEmpty()) {
            Node u = colaP.poll();
            if (u.getD().equals(d)) {
                break;
            }
            List<Node> nAdy = listaAdy.get(u.getD());
            for (Node ady : nAdy) {
                int nDis = dis.get(u.getD()) + ady.getPeso();
                if (dis.get(ady.getD()) > nDis) {
                    dis.put(ady.getD(), nDis);
                    prev.put(ady.getD(), u.getD());
                    colaP.add(new Node(ady.getD(), nDis));
                }
            }
        }
        List<String> caminoMasCorto = new ArrayList<>();
        String verticeActual = d;
        while (verticeActual != null) {
            caminoMasCorto.add(0, verticeActual);
            verticeActual = prev.get(verticeActual);
        }
        return caminoMasCorto;
    }
    public static void main(String[] args) throws Exception {
        Dijkstra grafo = new Dijkstra();
        Scanner scann = new  Scanner(System.in);
        String vi, vf;
        /**
         * Inserción de vertices
         */
        grafo.addVertice("s");
        grafo.addVertice("t");
        grafo.addVertice("y");
        grafo.addVertice("x");
        grafo.addVertice("z");

        /**
         * Asignación de aristas 
         */
        grafo.addArista("s", "t", 10);
        grafo.addArista("s", "y", 5);
        grafo.addArista("t", "y", 2);
        grafo.addArista("t", "x", 1);
        grafo.addArista("y", "t", 3);
        grafo.addArista("y", "x", 9);
        grafo.addArista("y", "z", 2);
        grafo.addArista("x", "z", 4);
        grafo.addArista("z", "x", 6);
        grafo.addArista("z", "s", 7);

        System.out.println(" \n→ → → → → Camino mas Corto ← ← ← ← ← \n\n");
        System.out.println("Los vertices en el grafo son: s, t, y, x, z\n");
        System.out.println("Ingrese el vertice inicial: ");
        vi = scann.nextLine();
        System.out.println("Ingrese el vertice Final: ");
        vf = scann.nextLine();
        System.out.println("\n");
        /**
         * Camino mas corto
         */
        List<String> camino = grafo.dijkstraM(vi, vf);
        System.out.println("Camino más corto: " + camino);
    }
}