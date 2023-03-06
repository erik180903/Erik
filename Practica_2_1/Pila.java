package Practica_2_1;
public class Pila {
    private Nodo head;
    private int tam;
    
    public void inicializa(Pila p){
        p.head = null;
        p.tam = 0;
    }
    public String push(Pila p, String val){
        Nodo nodo = new Nodo(val);
        if(nodo == null) return "ERROR";
        nodo.setVal(val);
        nodo.setNext(p.head);
        p.head = nodo;
        p.tam++;
        return "OK";
    }
    public String pop(Pila p){
        String val = "";
        Nodo top = p.head;
        if(p.head == null)return "ERROR";
        val = p.head.getVal();
        p.head = p.head.getNext();
        top = null;
        p.tam--;
        return val;
    }
    public int tamanio(Pila p){
        return p.tam;
    }
    public int vacia(Pila p){
        if(p.head == null){
            return 1;
        }else{
            return 0;
        }
    }
    public String top(Pila p){
        if(p.head == null){
            return "ERROR";
        }else{
            return p.head.getVal();
        }
    }
    public void imprimir(Pila p){
        Nodo current = p.head;
        while(current != null){
            System.out.print(current.getVal());
            current = current.getNext();
        }
        System.out.println("NULL\n");
    }
    public Nodo getHead() {
        return head;
    }
    public void setHead(Nodo head) {
        this.head = head;
    }
    public int getTam() {
        return tam;
    }
    public void setTam(int tam) {
        this.tam = tam;
    }
}
