package Proyecto_Final;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    private Hashtable<String, List<Node>> listaAdy;

    /**
     * Se inicializa una Hashtable q se utiliza para almacenar la lista de adyacencia del grafo.
     */
    public Dijkstra() {
        listaAdy = new Hashtable<String, List<Node>>();
    }

    /**
     * Pseudoclase donde se alamacenaran los datos del nodo.
     * @param d nodo o vertice destino
     * @param peso peso de la arista
     */
    static class Node implements Comparable<Node> {
        String d;
        int peso;

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
     * Función para añadir los vertices
     * @param s vertice a agregar
     */
    public void addVertice(String s) {
        listaAdy.put(s, new LinkedList<Node>());
    }

    /**
     * Función para añadir aristas
     * @param o nodo o vertice origen
     * @param d nodo o vertice destino
     * @param peso peso de la arista
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
     * Función para recorrer el grafo ponderado dirigido por medio del método de Dijkstra
     * @param o nodo o vertice origen
     * @param d nodo o vetice destino
     * @return regresa una lista de los vertices del recorrido mas corto
     */
    public List<Node> dijkstraM(String o, String d) {
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

        List<Node> recorrido = new LinkedList<>();
        String actual = d;
        while (actual != null) {
            recorrido.add(0, new Node(actual, dis.get(actual)));
            actual = prev.get(actual);
        }

        return recorrido;
    }

    public static void main(String[] args) throws Exception {
        Dijkstra grafo = new Dijkstra();
        String destino, orig;
        Scanner scann = new Scanner(System.in);

        //Linea 1 Rosa
        grafo.addVertice("observatorio");
        grafo.addVertice("tacubaya");
        grafo.addVertice("juanacatlan");
        grafo.addVertice("chapultepec");
        grafo.addVertice("sevilla");
        grafo.addVertice("insurgentes");
        grafo.addVertice("cuauhtemoc");
        grafo.addVertice("balderas");
        grafo.addVertice("salto del agua");
        grafo.addVertice("isabel catolica");
        grafo.addVertice("pino suarez");
        grafo.addVertice("merced");
        grafo.addVertice("candelaria");
        grafo.addVertice("san lazaro");
        grafo.addVertice("moctezuma");
        grafo.addVertice("balbuena");
        grafo.addVertice("boulevard puerto aereo");
        grafo.addVertice("gomez farias");
        grafo.addVertice("zaragoza");
        grafo.addVertice("pantitlan");

        //Linea 2 Azul Fuerte        
        grafo.addVertice("cuatro caminos");
        grafo.addVertice("panteones");
        grafo.addVertice("tacuba");
        grafo.addVertice("cuitlahuac");
        grafo.addVertice("popotla");
        grafo.addVertice("colegio militar");
        grafo.addVertice("normal");
        grafo.addVertice("san cosme");
        grafo.addVertice("revolucion");
        grafo.addVertice("hidalgo");
        grafo.addVertice("bellas artes");
        grafo.addVertice("allende");
        grafo.addVertice("zocalo");
        grafo.addVertice("san antonio abad");
        grafo.addVertice("chabacano");
        grafo.addVertice("viaducto");
        grafo.addVertice("xola");
        grafo.addVertice("villa de cortes");
        grafo.addVertice("nativitas");
        grafo.addVertice("portales");
        grafo.addVertice("ermita");
        grafo.addVertice("general anaya");
        grafo.addVertice("tasqueña");        
        
        //Linea 3 Verde indio
        grafo.addVertice("indios verdes");
        grafo.addVertice("deportivo 18 de marzo");
        grafo.addVertice("potrero");
        grafo.addVertice("la raza");
        grafo.addVertice("tlatelolco");
        grafo.addVertice("guerrero");
        grafo.addVertice("juarez");
        grafo.addVertice("niños heroes");
        grafo.addVertice("hospital general");
        grafo.addVertice("centro medico");
        grafo.addVertice("etiopia");
        grafo.addVertice("eugenia");
        grafo.addVertice("division del norte");
        grafo.addVertice("zapata");
        grafo.addVertice("coyoacan");
        grafo.addVertice("viveros");
        grafo.addVertice("miguel angel de quevedo");
        grafo.addVertice("copilco");
        grafo.addVertice("universidad");
        
        //Linea 4 verde aqua
        grafo.addVertice("martin carrera");
        grafo.addVertice("talisman");
        grafo.addVertice("bondojito");
        grafo.addVertice("consulado");
        grafo.addVertice("canal del norte");
        grafo.addVertice("morelos");
        grafo.addVertice("fray servando");
        grafo.addVertice("jamaica");
        grafo.addVertice("santa anita");
        
        //Linea 5 amarilla
        grafo.addVertice("politecnico");
        grafo.addVertice("instituto del petroleo");
        grafo.addVertice("autobuses del norte");
        grafo.addVertice("misterios");
        grafo.addVertice("valle gomez");
        grafo.addVertice("eduardo molina");
        grafo.addVertice("aragon");
        grafo.addVertice("oceania");
        grafo.addVertice("terminal aerea");
        grafo.addVertice("hangares");
                
        //Linea 6 roja
        grafo.addVertice("el rosario");
        grafo.addVertice("tezozomoc");
        grafo.addVertice("azcapotzalco");
        grafo.addVertice("ferreria");
        grafo.addVertice("norte 45");
        grafo.addVertice("vallejo");
        grafo.addVertice("lindavista");
        grafo.addVertice("la villa");
                
        //Linea 7 naranja
        grafo.addVertice("aquiles serdan");
        grafo.addVertice("camarones");
        grafo.addVertice("refineria");
        grafo.addVertice("san joaquin");
        grafo.addVertice("polanco");
        grafo.addVertice("auditorio");
        grafo.addVertice("constituyentes");
        grafo.addVertice("san pedro de los pinos");
        grafo.addVertice("san antonio");
        grafo.addVertice("mixcoac");
        grafo.addVertice("barranca del muerto");
                
        //Linea 8 verde fuerte
        grafo.addVertice("garibaldi");
        grafo.addVertice("san juan de letran");
        grafo.addVertice("doctores");
        grafo.addVertice("obrera");
        grafo.addVertice("la viga");
        grafo.addVertice("coyuya");
        grafo.addVertice("iztacalco");
        grafo.addVertice("apatlaco");
        grafo.addVertice("aculco");
        grafo.addVertice("escuadron 201");
        grafo.addVertice("atlalilco");
        grafo.addVertice("iztapalapa");
        grafo.addVertice("c de la estrella");
        grafo.addVertice("uam i");
        grafo.addVertice("constitucion de 1917");
                    
        //Linea 9 cafe
        grafo.addVertice("patriotismo");
        grafo.addVertice("chilpancingo");
        grafo.addVertice("lazaro cardenas");
        grafo.addVertice("mixiuhca");
        grafo.addVertice("velodromo");
        grafo.addVertice("ciudad deportiva");
        grafo.addVertice("puebla");
                
        //Linea A morada
        grafo.addVertice("agricola oriental");
        grafo.addVertice("canal de san juan");
        grafo.addVertice("tepalcates");
        grafo.addVertice("guelatao");
        grafo.addVertice("peñon viejo");
        grafo.addVertice("acatitla");
        grafo.addVertice("santa marta");
        grafo.addVertice("los reyes");
        grafo.addVertice("la paz");
             
        //Linea B verde/gris
        grafo.addVertice("buenavista");
        grafo.addVertice("lagunilla");
        grafo.addVertice("tepito");
        grafo.addVertice("flores magon");
        grafo.addVertice("romero rubio");
        grafo.addVertice("deportivo oceania");
        grafo.addVertice("bosque de aragon");
        grafo.addVertice("villa de aragon");
        grafo.addVertice("nezahualcoyotl");
        grafo.addVertice("impulsora");
        grafo.addVertice("rio de los remedios");
        grafo.addVertice("muzquiz");
        grafo.addVertice("ecatepec");
        grafo.addVertice("olimpica");
        grafo.addVertice("plaza aragon");
        grafo.addVertice("ciudad azteca");
        
        //Linea 12 verde chorro
        grafo.addVertice("insurgentes sur");
        grafo.addVertice("hospital 20 de noviembre");
        grafo.addVertice("parque de los venados");
        grafo.addVertice("eje central");
        grafo.addVertice("mexicaltzingo");
        grafo.addVertice("culhuacan");
        grafo.addVertice("san andres tomatlan");
        grafo.addVertice("lomas estrella");
        grafo.addVertice("calle 11");
        grafo.addVertice("periferico oriente");
        grafo.addVertice("tezonco");
        grafo.addVertice("olivos");
        grafo.addVertice("nopalera");
        grafo.addVertice("zapotitlan");
        grafo.addVertice("tlaltenco");
        grafo.addVertice("tlahuac");
        
        
        
        //Línea 1
        //De ida Direccion ( a )
        grafo.addArista("observatorio", "tacubaya", 4);
        grafo.addArista("tacubaya", "juanacatlan", 4);
        grafo.addArista("juanacatlan", "chapultepec", 4);
        grafo.addArista("chapultepec", "sevilla", 4);
        grafo.addArista("sevilla", "insurgentes", 4);
        grafo.addArista("insurgentes", "cuauhtemoc", 4);
        grafo.addArista("cuauhtemoc", "balderas", 4);
        grafo.addArista("balderas", "salto del agua", 3);
        grafo.addArista("salto del agua", "isabel catolica", 2);
        grafo.addArista("isabel catolica", "pino suarez", 3);
        grafo.addArista("pino suarez", "merced", 2);
        grafo.addArista("merced", "candelaria", 2);
        grafo.addArista("candelaria", "san lazaro", 2);
        grafo.addArista("san lazaro", "moctezuma", 2);
        grafo.addArista("moctezuma", "balbuena", 3);
        grafo.addArista("balbuena", "boulevard puerto aereo", 2);
        grafo.addArista("boulevard puerto aereo", "gomez farias", 2);
        grafo.addArista("gomez farias", "zaragoza", 3);
        grafo.addArista("zaragoza", "pantitlan", 3);

        //De regreso Direccion ( a )
        grafo.addArista("pantitlan", "zaragoza", 3);
        grafo.addArista("zaragoza", "gomez farias", 3);
        grafo.addArista("gomez farias", "boulevard puerto aereo", 2);
        grafo.addArista("boulevard puerto aereo", "balbuena", 2);
        grafo.addArista("balbuena", "moctezuma", 3);
        grafo.addArista("moctezuma", "san lazaro", 2);
        grafo.addArista("san lazaro", "candelaria", 2);
        grafo.addArista("candelaria", "merced", 2);
        grafo.addArista("merced", "pino suarez", 2);
        grafo.addArista("pino suarez", "isabel catolica", 3);
        grafo.addArista("isabel catolica", "salto del agua", 2);
        grafo.addArista("salto del agua", "balderas", 3);
        grafo.addArista("balderas", "cuauhtemoc", 4);
        grafo.addArista("cuauhtemoc", "insurgentes", 4);
        grafo.addArista("insurgentes", "sevilla", 4);
        grafo.addArista("sevilla", "chapultepec", 4);
        grafo.addArista("chapultepec", "juanacatlan", 4);
        grafo.addArista("juanacatlan", "tacubaya", 4);
        grafo.addArista("tacubaya", "observatorio", 4);

        
        //Linea 2
        //- De ida Direccion (  a  )
        grafo.addArista("cuatro caminos", "panteones",3);
        grafo.addArista("panteones", "tacuba",3);
        grafo.addArista("tacuba", "cuitlahuac",1);
        grafo.addArista("cuitlahuac", "popotla",2);
        grafo.addArista("popotla", "colegio militar",1);
        grafo.addArista("colegio militar", "normal",1);
        grafo.addArista("normal", "san cosme",1);
        grafo.addArista("san cosme", "revolucion",2);
        grafo.addArista("revolucion", "hidalgo",1);
        grafo.addArista("hidalgo", "bellas artes",1);
        grafo.addArista("bellas artes", "allende",1);
        grafo.addArista("allende", "zocalo",2);
        grafo.addArista("zocalo", "pino suarez",1);
        grafo.addArista("pino suarez", "san antonio abad",2);
        grafo.addArista("san antonio abad", "chabacano",1);
        grafo.addArista("chabacano", "viaducto",2);
        grafo.addArista("viaducto", "xola",1);
        grafo.addArista("xola", "villa de cortes",2);
        grafo.addArista("villa de cortes", "nativitas",1);
        grafo.addArista("nativitas", "portales",3);
        grafo.addArista("portales", "ermita",1);
        grafo.addArista("ermita", "general anaya",2);
        grafo.addArista("general anaya", "tasqueña",3);

        //- De regreso Direccion (  a  )
        grafo.addArista("tasqueña", "general anaya", 3);
        grafo.addArista("general anaya", "ermita", 2);
        grafo.addArista("ermita", "portales", 1);
        grafo.addArista("portales", "nativitas", 3);
        grafo.addArista("nativitas", "villa de cortes", 1);
        grafo.addArista("villa de cortes", "xola", 2);
        grafo.addArista("xola", "viaducto", 1);
        grafo.addArista("viaducto", "chabacano", 2);
        grafo.addArista("chabacano", "san antonio abad", 1);
        grafo.addArista("san antonio abad", "pino suarez", 2);
        grafo.addArista("pino suarez", "zocalo", 1);
        grafo.addArista("zocalo", "allende", 2);
        grafo.addArista("allende", "bellas artes", 1);
        grafo.addArista("bellas artes", "hidalgo", 1);
        grafo.addArista("hidalgo", "revolucion", 1);
        grafo.addArista("revolucion", "san cosme", 2);
        grafo.addArista("san cosme", "normal", 1);
        grafo.addArista("normal", "colegio militar", 1);
        grafo.addArista("colegio militar", "popotla", 1);
        grafo.addArista("popotla", "cuitlahuac", 1);
        grafo.addArista("cuitlahuac", "tacuba", 1);
        grafo.addArista("tacuba", "panteones", 3);
        grafo.addArista("panteones", "cuatro caminos", 3);



        //Linea 3
        //- De ida Direccion (  a  )
        grafo.addArista("indios verdes","deportivo 18 de marzo", 2);
        grafo.addArista("deportivo 18 de marzo", "potrero", 2);
        grafo.addArista("potrero", "la raza", 2);
        grafo.addArista("la raza", "tlatelolco", 2);
        grafo.addArista("tlatelolco", "guerrero", 2);
        grafo.addArista("guerrero", "hidalgo", 2);
        grafo.addArista("hidalgo", "juarez", 2);
        grafo.addArista("juarez", "balderas", 2);
        grafo.addArista("balderas", "niños heroes", 2);
        grafo.addArista("niños heroes", "hospital general", 2);
        grafo.addArista("hospital general", "centro medico", 2);
        grafo.addArista("centro medico", "etiopia", 2);
        grafo.addArista("etiopia", "eugenia", 2);
        grafo.addArista("eugenia", "division del norte", 2);
        grafo.addArista("division del norte", "zapata", 2);
        grafo.addArista("zapata", "coyoacan", 2);
        grafo.addArista("coyoacan", "viveros", 3);
        grafo.addArista("viveros", "miguel angel de quevedo", 2);
        grafo.addArista("miguel angel de quevedo", "copilco", 2);
        grafo.addArista("copilco", "universidad", 3);

//- De regreso Direccion (  a  )
        grafo.addArista("deportivo 18 de marzo", "indios verdes", 2);
        grafo.addArista("potrero", "deportivo 18 de marzo", 2);
        grafo.addArista("la raza", "potrero", 2);
        grafo.addArista("tlatelolco", "la raza", 2);
        grafo.addArista("guerrero", "tlatelolco", 2);
        grafo.addArista("hidalgo", "guerrero", 2);
        grafo.addArista("juarez", "hidalgo", 2);
        grafo.addArista("balderas", "juarez", 2);
        grafo.addArista("niños heroes", "balderas", 2);
        grafo.addArista("hospital general", "niños heroes", 2);
        grafo.addArista("centro medico", "hospital general", 2);
        grafo.addArista("etiopia", "centro medico", 2);
        grafo.addArista("eugenia", "etiopia", 2);
        grafo.addArista("division del norte", "eugenia", 2);
        grafo.addArista("zapata", "division del norte", 2);
        grafo.addArista("coyoacan", "zapata", 2);
        grafo.addArista("viveros","coyoacan",3);
        grafo.addArista("miguel angel de quevedo","viveros",2);
        grafo.addArista("copilco", "miguel angel de quevedo", 2);
        grafo.addArista("universidad", "copilco", 3);
        

        
        
        //Linea 4
        //- De ida Direccion (  a  )
        grafo.addArista("martin carrera", "talisman", 0);
        grafo.addArista("talisman", "bondojito", 0);
        grafo.addArista("bondojito", "consulado", 0);
        grafo.addArista("consulado", "canal del norte", 0);
        grafo.addArista("canal del norte", "morelos", 0);
        grafo.addArista("morelos", "candelaria", 0);
        grafo.addArista("candelaria", "fray servando", 0);
        grafo.addArista("fray servando", "jamaica", 0);
        grafo.addArista("jamaica", "santa anita", 0);

        //- De regreso Direccion (  a  )
        grafo.addArista("santa anita", "jamaica", 0);
        grafo.addArista("jamaica", "fray servando", 0);
        grafo.addArista("fray servando", "candelaria", 0);
        grafo.addArista("candelaria", "morelos", 0);
        grafo.addArista("morelos", "canal del norte", 0);
        grafo.addArista("canal del norte", "consulado", 0);
        grafo.addArista("consulado", "bondojito", 0);
        grafo.addArista("bondojito", "talisman", 0);
        grafo.addArista("talisman", "martin carrera", 0);


        //Linea 5
        //- De ida Direccion (  a  )
        grafo.addArista("politecnico", "instituto del petroleo", 2);
        grafo.addArista("instituto del petroleo", "autobuses del norte", 2);
        grafo.addArista("autobuses del norte", "la raza", 2);
        grafo.addArista("la raza", "misterios", 2);
        grafo.addArista("misterios", "valle gomez", 2);
        grafo.addArista("valle gomez", "consulado", 2);
        grafo.addArista("consulado", "eduardo molina", 2);
        grafo.addArista("eduardo molina", "aragon", 2);
        grafo.addArista("aragon", "oceania", 2);
        grafo.addArista("oceania", "terminal aerea", 3);
        grafo.addArista("terminal aerea", "hangares", 2);
        grafo.addArista("hangares", "pantitlan", 3);

        //- De regreso Direccion (  a )
        grafo.addArista("pantitlan", "hangares", 3);
        grafo.addArista("hangares", "terminal aerea", 2);
        grafo.addArista("terminal aerea", "oceania", 3);
        grafo.addArista("oceania", "aragon", 2);
        grafo.addArista("aragon", "eduardo molina", 2);
        grafo.addArista("eduardo molina", "consulado", 2);
        grafo.addArista("consulado", "valle gomez", 2);
        grafo.addArista("valle gomez", "misterios", 2);
        grafo.addArista("misterios", "la raza", 2);
        grafo.addArista("la raza", "autobuses del norte", 2);
        grafo.addArista("autobuses del norte", "instituto del petroleo", 2);
        grafo.addArista("instituto del petroleo", "politecnico", 2);



        //Linea 6
         //- De ida Direccion (  a  )
        grafo.addArista("el rosario", "tezozomoc", 2);
        grafo.addArista("tezozomoc", "azcapotzalco", 2);
        grafo.addArista("azcapotzalco", "ferreria", 2);
        grafo.addArista("ferreria", "norte 45", 2);
        grafo.addArista("norte 45", "vallejo", 2);
        grafo.addArista("vallejo", "instituto del petroleo", 2);
        grafo.addArista("instituto del petroleo", "lindavista", 2);
        grafo.addArista("lindavista", "deportivo 18 de marzo", 2);
        grafo.addArista("deportivo 18 de marzo", "la villa", 2);
        grafo.addArista("la villa", "martin carrera", 3);

        //- De regreso Direccion (  a  )
        grafo.addArista("martin carrera", "la villa", 3);
        grafo.addArista("la villa", "deportivo 18 de marzo", 2);
        grafo.addArista("deportivo 18 de marzo", "lindavista", 2);
        grafo.addArista("lindavista", "instituto del petroleo", 2);
        grafo.addArista("instituto del petroleo", "vallejo", 2);
        grafo.addArista("vallejo", "norte 45", 2);
        grafo.addArista("norte 45", "ferreria", 2);
        grafo.addArista("ferreria", "azcapotzalco", 2);
        grafo.addArista("azcapotzalco", "tezozomoc", 2);
        grafo.addArista("tezozomoc", "el rosario", 2);


        
          //Linea 7
         //- De ida Direccion (  a  )
        grafo.addArista("el rosario", "aquiles serdan", 2);
        grafo.addArista("aquiles serdan", "camarones", 2);
        grafo.addArista("camarones", "refineria", 2);
        grafo.addArista("refineria", "tacuba", 2);
        grafo.addArista("tacuba", "san joaquin", 2);
        grafo.addArista("san joaquin", "polanco", 2);
        grafo.addArista("polanco", "auditorio", 2);
        grafo.addArista("auditorio", "constituyentes", 2);
        grafo.addArista("constituyentes", "tacubaya", 2);
        grafo.addArista("tacubaya", "san pedro de los pinos", 2);
        grafo.addArista("san pedro de los pinos", "san antonio", 2);
        grafo.addArista("san antonio", "mixcoac", 2);
        grafo.addArista("mixcoac", "barranca del muerto", 3);

        //- De regreso Direccion (  a  )
        grafo.addArista("barranca del muerto", "mixcoac", 3);
        grafo.addArista("mixcoac", "san antonio", 2);
        grafo.addArista("san antonio", "san pedro de los pinos", 2);
        grafo.addArista("san pedro de los pinos", "tacubaya", 2);
        grafo.addArista("tacubaya", "constituyentes", 2);
        grafo.addArista("constituyentes", "auditorio", 2);
        grafo.addArista("auditorio", "polanco", 2);
        grafo.addArista("polanco", "san joaquin", 2);
        grafo.addArista("san joaquin", "tacuba", 2);
        grafo.addArista("tacuba", "refineria", 2);
        grafo.addArista("refineria", "camarones", 2);
        grafo.addArista("camarones", "aquiles serdan", 2);
        grafo.addArista("aquiles serdan", "el rosario", 2);


            //Linea 8
        //- De ida Direccion (  a  )
        grafo.addArista("garibaldi", "bellas artes", 0);
        grafo.addArista("bellas artes", "san juan de letran", 0);
        grafo.addArista("san juan de letran", "salto del agua", 0);
        grafo.addArista("salto del agua", "doctores", 0);
        grafo.addArista("doctores", "obrera", 0);
        grafo.addArista("obrera", "chabacano", 0);
        grafo.addArista("chabacano", "la viga", 0);
        grafo.addArista("la viga", "santa anita", 0);
        grafo.addArista("santa anita", "coyuya", 0);
        grafo.addArista("coyuya", "iztacalco", 0);
        grafo.addArista("iztacalco", "apatlaco", 0);
        grafo.addArista("apatlaco", "aculco", 0);
        grafo.addArista("aculco", "escuadron 201", 0);
        grafo.addArista("escuadron 201", "atlalilco", 0);
        grafo.addArista("atlalilco", "iztapalapa", 0);
        grafo.addArista("iztapalapa", "c de la estrella", 0);
        grafo.addArista("c de la estrella", "uam i", 0);
        grafo.addArista("uam i", "constitucion de 1917", 0);

        //- De regreso Direccion (  a  )
        grafo.addArista("constitucion de 1917", "uam i", 0);
        grafo.addArista("uam i", "c de la estrella", 0);
        grafo.addArista("c de la estrella", "iztapalapa", 0);
        grafo.addArista("iztapalapa", "atlalilco", 0);
        grafo.addArista("atlalilco", "escuadron 201", 0);
        grafo.addArista("escuadron 201", "aculco", 0);
        grafo.addArista("aculco", "apatlaco", 0);
        grafo.addArista("apatlaco", "iztacalco", 0);
        grafo.addArista("iztacalco", "coyuya", 0);
        grafo.addArista("coyuya", "santa anita", 0);
        grafo.addArista("santa anita", "la viga", 0);
        grafo.addArista("la viga", "chabacano", 0);
        grafo.addArista("chabacano", "obrera", 0);
        grafo.addArista("obrera", "doctores", 0);
        grafo.addArista("doctores", "salto del agua", 0);
        grafo.addArista("salto del agua", "san juan de letran", 0);
        grafo.addArista("san juan de letran", "bellas artes", 0);
        grafo.addArista("bellas artes", "garibaldi", 0);
            
 
     
        //Linea 9
        //- De ida Direccion (  a  )
        grafo.addArista("pantitlan", "puebla", 3);
        grafo.addArista("puebla", "ciudad deportiva", 2);
        grafo.addArista("ciudad deportiva", "velodromo", 2);
        grafo.addArista("velodromo", "mixiuhca", 2);
        grafo.addArista("mixiuhca", "jamaica", 2);
        grafo.addArista("jamaica", "chabacano", 2);
        grafo.addArista("chabacano", "lazaro cardenas", 2);
        grafo.addArista("lazaro cardenas", "centro medico", 2);
        grafo.addArista("centro medico", "chilpancingo", 2);
        grafo.addArista("chilpancingo", "patriotismo", 2);
        grafo.addArista("patriotismo", "tacubaya", 2);

        //- De regreso Direccion (  a  )
        grafo.addArista("tacubaya", "patriotismo", 2);
        grafo.addArista("patriotismo", "chilpancingo", 2);
        grafo.addArista("chilpancingo", "centro medico", 2);
        grafo.addArista("centro medico", "lazaro cardenas", 2);
        grafo.addArista("lazaro cardenas", "chabacano", 2);
        grafo.addArista("chabacano", "jamaica", 2);
        grafo.addArista("jamaica", "mixiuhca", 2);
        grafo.addArista("mixiuhca", "velodromo", 2);
        grafo.addArista("velodromo", "ciudad deportiva", 2);
        grafo.addArista("ciudad deportiva", "puebla", 2);
        grafo.addArista("puebla", "pantitlan", 3);


 
        //Linea A
        //- De ida Direccion (  a  )
        grafo.addArista("pantitlan", "agricola oriental", 0);
        grafo.addArista("agricola oriental", "canal de san juan", 0);
        grafo.addArista("canal de san juan", "tepalcates", 0);
        grafo.addArista("tepalcates", "guelatao", 0);
        grafo.addArista("guelatao", "peñon viejo", 0);
        grafo.addArista("peñon viejo", "acatitla", 0);
        grafo.addArista("acatitla", "santa marta", 0);
        grafo.addArista("santa marta", "los reyes", 0);
        grafo.addArista("los reyes", "la paz", 0);

        //- De regreso Direccion (  a  )
        grafo.addArista("la paz", "los reyes", 0);
        grafo.addArista("los reyes", "santa marta", 0);
        grafo.addArista("santa marta", "acatitla", 0);
        grafo.addArista("acatitla", "peñon viejo", 0);
        grafo.addArista("peñon viejo", "guelatao", 0);
        grafo.addArista("guelatao", "tepalcates", 0);
        grafo.addArista("tepalcates", "canal de san juan", 0);
        grafo.addArista("canal de san juan", "agricola oriental", 0);
        grafo.addArista("agricola oriental", "pantitlan", 0);

        //Linea B
        //- De ida Direccion (  a  )
        grafo.addArista("buenavista", "guerrero", 2);
        grafo.addArista("guerrero", "garibaldi", 2);
        grafo.addArista("garibaldi", "tepito", 2);
        grafo.addArista("tepito", "morelos", 2);
        grafo.addArista("morelos", "san lazaro", 2);
        grafo.addArista("san lazaro", "flores magon", 0);
        grafo.addArista("flores magon", "romero rubio", 0);
        grafo.addArista("romero rubio", "oceania", 0);
        grafo.addArista("oceania", "deportivo oceania", 0);
        grafo.addArista("deportivo oceania", "bosque de aragon", 3);
        grafo.addArista("bosque de aragon", "villa de aragon", 0);
        grafo.addArista("villa de aragon", "nezahualcoyotl", 3);
        grafo.addArista("nezahualcoyotl", "impulsora", 3);
        grafo.addArista("impulsora", "rio de los remedios", 0);
        grafo.addArista("rio de los remedios", "muzquiz", 2);
        grafo.addArista("muzquiz", "ecatepec", 2);
        grafo.addArista("ecatepec", "olimpica", 2);
        grafo.addArista("olimpica", "plaza aragon", 2);
        grafo.addArista("plaza aragon", "ciudad azteca", 2);

        //- De regreso Direccion (  a  )
        grafo.addArista("ciudad azteca", "plaza aragon", 0);
        grafo.addArista("plaza aragon", "olimpica", 0);
        grafo.addArista("olimpica", "ecatepec", 0);
        grafo.addArista("ecatepec", "muzquiz", 0);
        grafo.addArista("muzquiz", "rio de los remedios", 0);
        grafo.addArista("rio de los remedios", "impulsora", 0);
        grafo.addArista("impulsora", "nezahualcoyotl", 0);
        grafo.addArista("nezahualcoyotl", "villa de aragon", 0);
        grafo.addArista("villa de aragon", "bosque de aragon", 0);
        grafo.addArista("bosque de aragon", "deportivo oceania", 0);
        grafo.addArista("deportivo oceania", "oceania", 0);
        grafo.addArista("oceania", "romero rubio", 0);
        grafo.addArista("romero rubio", "flores magon", 0);
        grafo.addArista("flores magon", "san lazaro", 0);
        grafo.addArista("san lazaro", "morelos", 0);
                            

        //Linea 12
        //- De ida Direccion (  a  )
        grafo.addArista("mixcoac", "insurgentes sur", 2);
        grafo.addArista("insurgentes sur", "hospital 20 de noviembre", 2);
        grafo.addArista("hospital 20 de noviembre", "zapata", 1);
        grafo.addArista("zapata", "parque de los venados", 2);
        grafo.addArista("parque de los venados", "eje central", 3);
        grafo.addArista("eje central", "ermita", 3);
        grafo.addArista("ermita", "mexicaltzingo", 4);
        grafo.addArista("mexicaltzingo", "atlalilco", 5);
        grafo.addArista("atlalilco", "culhuacan", 4);
        grafo.addArista("culhuacan", "san andres tomatlan", 2);
        grafo.addArista("san andres tomatlan", "lomas estrella", 3);
        grafo.addArista("lomas estrella", "calle 11", 3);
        grafo.addArista("calle 11", "periferico oriente", 2);
        grafo.addArista("periferico oriente", "tezonco", 4);
        grafo.addArista("tezonco", "olivos", 2);
        grafo.addArista("olivos", "nopalera", 3);
        grafo.addArista("nopalera", "zapotitlan", 3);
        grafo.addArista("zapotitlan", "tlaltenco", 3);
        grafo.addArista("tlaltenco", "tlahuac", 3);

        //- De regreso Direccion (  a  )
        grafo.addArista("tlahuac", "tlaltenco", 3);
        grafo.addArista("tlaltenco", "zapotitlan", 3);
        grafo.addArista("zapotitlan", "nopalera", 3);
        grafo.addArista("nopalera", "olivos", 3);
        grafo.addArista("olivos", "tezonco", 2);
        grafo.addArista("tezonco", "periferico oriente", 4);
        grafo.addArista("periferico oriente", "calle 11", 2);
        grafo.addArista("calle 11", "lomas estrella", 3);
        grafo.addArista("lomas estrella", "san andres tomatlan", 3);
        grafo.addArista("san andres tomatlan", "culhuacan", 2);
        grafo.addArista("culhuacan", "atlalilco", 4);
        grafo.addArista("atlalilco", "mexicaltzingo", 5);
        grafo.addArista("mexicaltzingo", "ermita", 4);
        grafo.addArista("ermita", "eje central", 3);
        grafo.addArista("eje central", "parque de los venados", 3);
        grafo.addArista("parque de los venados", "zapata", 2);
        grafo.addArista("zapata", "hospital 20 de noviembre", 1);
        grafo.addArista("hospital 20 de noviembre", "insurgentes sur", 2);
        grafo.addArista("insurgentes sur", "mixcoac", 2);


        System.out.println("\n\n ::::::::::::::: R U T A   M A S   O P T I M A ::::::::::::::: \n\n ");
        System.out.println(" Ingrese la estacion de partida: ");
        orig = scann.nextLine();
        System.out.println(" Ingrese a la que desea llegar: ");
        destino = scann.nextLine();
        List<Node> caminoC = grafo.dijkstraM(orig.toLowerCase(), destino.toLowerCase());
        Thread.sleep(2000);

        int pesototal = 0;
        System.out.println("\n EL camino más corto desde ["+ orig +"] a [" + destino + "] es:\n");
        for (Node nodo : caminoC) {
            System.out.println(" -> [" + nodo.getD() + "]");
            pesototal = nodo.getPeso();
        }
        System.out.println("Llegaras en aproximadamente "+pesototal+".");
    }
}