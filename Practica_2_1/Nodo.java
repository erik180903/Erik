package Practica_2_1;

public class Nodo {
    private String val;
    private Nodo next;
    
    public Nodo(String val) {
        this.val = val;
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    
}
