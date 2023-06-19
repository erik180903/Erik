package Practica_2_1;
import javax.lang.model.element.Element;
public class Pila {
    /**
     * Declaración del apuntador que utilizaremos
     * dentro de las funciones
     */
    private Nodo head;
    /**
     * Función de "agregar" un elemento a nuestra pila
     * @param val recibe los valores de esta variable
     */
    public void push(String val){
        Nodo nuevo = new Nodo(val);
        if(head == null) {
            head = nuevo;
            head.setNext(null);
        }else{
            nuevo.setNext(head);
            head=nuevo;
        }
    }
    /**
     * Función para "sacar" un elemento de nuesta pila
     */
    public void pop(){
        Nodo top = head;
        head = head.getNext();
        top = null;
    }
    /**
     * Función para evaluar si la pila esta vacia
     * @return true si está vacia y false si no está vacia
     */
    public boolean vacia(){
        if(head == null){
            return true;
        }else{
            return false;
        } 
    }
    /**
     * Función para sacar el elemento que se encuentre hasta "arriba" de nuestra pila
     * @return el valor que almacena el elemnto
     */
    public String sacartop(){
        String val = head.getVal();
        pop();
        return val;
    }
    /**
     * Función para "ver" lo que almacena nuestro elemento 
     * @return el valor que almacena el elemento
     */
    public String vertop(){
        return head.getVal();
    }
    /**
     * Función jerarquia, dentro de esta función asignamos la jerarquia de signos para poder hacer
     * nuestra conversión y evaluación en postfijo
     * @param caracter es el valor que recibirá para evaluarlo y asignarle su jerarquia
     * @return el valor jerarquico del caracter recibido
     */
    public int jerarquia(String caracter){
        int val= 0;
        if(caracter.equals(" ")){val = -1;}
        if(caracter.equals("(")){val = 1;}
        if(caracter.equals("+") || caracter.equals("-")){val = 2;}
        if(caracter.equals("*") || caracter.equals("/")){val = 3;}
        if(caracter.equals(")")){val = 4;}
        return val;
    }
    /**
     * Función jerarquia, dentro de esta función asignamos la jerarquia de signos para poder hacer
     * nuestra conversión y evaluación en prefijo
     * @param caracter es el valor que recibirá para evaluarlo y asignarle su jerarquia
     * @return el valor jerarquico del caracter recibido
     */
    public int jerarquia2(String caracter){
        int val = 0;
        if(caracter.equals(" ")){val = -1;}
        if(caracter.equals(")")){val = 1;}
        if(caracter.equals("+") || caracter.equals("-")){val = 2;}
        if(caracter.equals("*") || caracter.equals("/")){val = 3;}
        if(caracter.equals("(")){val = 4;}
        return val;
    }
    /**
     * Función para poder hacer la conversión de infijo a postfijo
     * @param p es la pila en la que se está almacenando
     * @param exp es la expresión matemática que convertiremos
     * @return la expresión matemática pero esta vex en postfijo
     */
    public String postfija(Pila p, String exp){
        String post = "";
        for(int i = 0; i < exp.length(); i++ ){
            if(jerarquia(String.valueOf(exp.charAt(i))) > 1){
                if(!p.vacia() && jerarquia(String.valueOf(exp.charAt(i))) == jerarquia(p.vertop())){
                    post += " "+p.sacartop();
                }
                if(!p.vacia() && jerarquia(String.valueOf(exp.charAt(i))) == jerarquia(")")){
                    while(!p.vacia()){
                        if(p.vertop().equals("(")){
                            p.pop();
                            break;
                        }else{
                            post += " "+p.sacartop();                         
                        }
                    }
                }else if(!p.vacia() && jerarquia(String.valueOf(exp.charAt(i))) < jerarquia(p.vertop())){
                  while(!p.vacia()){
                    post += " "+p.sacartop();
                  }  
                }
            }
            if(jerarquia(String.valueOf(exp.charAt(i))) == 0){post += exp.charAt(i);}
            if(jerarquia(String.valueOf(exp.charAt(i))) > 0 && jerarquia(String.valueOf(exp.charAt(i))) < 4){
                post = post + " ";
                p.push(String.valueOf(exp.charAt(i)));
            }
        }
        while(!p.vacia()){
            if(p.vertop().equals("(")){
                p.pop();
            }else{
                post += " " + p.sacartop();
            }
        }
        return post;
    }
    /**
     * Función para poder hacer la evaluación matemática de nuestra exprresión postfija
     * @param p es la pila en la que se está almacenando
     * @param exp es la expresión postfija que calcularemos
     * @return el resultado del calculo
     */
    public Float calpost(Pila p, String exp){
        float res = 0;
        String num = "";
        for(int i = 0; i < exp.length(); i++){
            if(jerarquia(String.valueOf(exp.charAt(i))) == 0){
                while(jerarquia(String.valueOf(exp.charAt(i))) == 0){
                    num += exp.charAt(i);
                    i++;
                }
                p.push(String.valueOf(num));
                num = "";
            }else if(jerarquia(String.valueOf(exp.charAt(i))) > 0){
                float numero2 = Float.valueOf(p.sacartop());
                float numero1 = Float.valueOf(p.sacartop());
                switch(exp.charAt(i)){
                    case '+' :
                        res = numero1 + numero2;
                    break;
                    case '-' :
                        res = numero1 - numero2;
                    break;
                    case '*' :
                        res = numero1 * numero2;
                    break;
                    case '/' :
                        res = numero1 / numero2;
                    break;
                }
                p.push(String.valueOf(res));
            }
        }
        return Float.valueOf(p.sacartop());
    }
    /**
     * Función para poder hacer la conversión de infijo a postfijo
     * @param p es la pila en la que se está almacenando
     * @param exp es la expresión matemática que convertiremos
     * @return la expresión matemática pero esta vex en postfijo
     */
    public String prefija(Pila p, String exp){
        String pre = "";
        for(int i = exp.length() - 1; i >= 0; i-- ){
            if(jerarquia2(String.valueOf(exp.charAt(i))) > 1){
                if(!p.vacia() && jerarquia2(String.valueOf(exp.charAt(i))) == jerarquia2(p.vertop())){
                    pre = p.sacartop() + " " + pre;
                }
                if(!p.vacia() && jerarquia2(String.valueOf(exp.charAt(i))) == jerarquia2("(")){
                    while(!p.vacia()){
                        if(p.vertop().equals(")")){
                            p.pop();
                            break;
                        }else{
                            pre = p.sacartop() + " " + pre;
                        }
                    }   
                }else if(!p.vacia() && jerarquia2(String.valueOf(exp.charAt(i))) < jerarquia2(p.vertop())){
                    while(!p.vacia()){
                        pre = p.vertop() + " " + pre;
                        p.pop();
                    }  
                }
            }
            if(jerarquia2(String.valueOf(exp.charAt(i))) == 0){pre = exp.charAt(i) + pre;}
            if(jerarquia2(String.valueOf(exp.charAt(i))) > 0 && jerarquia2(String.valueOf(exp.charAt(i))) < 4){
                pre = " " + pre;
                p.push(String.valueOf(exp.charAt(i)));
            }
        }
        while(!p.vacia()){
            if(p.vertop().equals(")")){
                p.pop();
            }else{
                pre = p.vertop() + " " + pre;
                p.pop();
            }
        }
        return pre;
    }
    /**
     * Función para poder hacer la evaluación matemática de nuestra exprresión postfija
     * @param p es la pila en la que se está almacenando
     * @param exp es la expresión postfija que calcularemos
     * @return el resultado del calculo
     */
    public float calpre(Pila p, String exp){
        float res = 0;
        String num = "";
        for(int i = exp.length()-1; i >= 0; i--){
            if(jerarquia(String.valueOf(exp.charAt(i))) == 0){
                while(jerarquia(String.valueOf(exp.charAt(i))) == 0){
                    num += exp.charAt(i);
                    i--;
                }
                p.push(String.valueOf(num));
                num = "";
            }else if(jerarquia(String.valueOf(exp.charAt(i))) > 0){
                float numero2 = Float.valueOf(p.sacartop());
                float numero1 = Float.valueOf(p.sacartop());
                switch(exp.charAt(i)){
                    case '+' :
                        res = numero1 + numero2;
                    break;
                    case '-' :
                        res = numero1 - numero2;
                    break;
                    case '*' :
                        res = numero1 * numero2;
                    break;
                    case '/' :
                        res = numero1 / numero2;
                    break;
                }
                p.push(String.valueOf(res));
            }
        }
        return Float.valueOf(p.sacartop());
    }
    /**
     * get del apuntador head
     * @return el nodo head
     */
    public Nodo getHead() {
        return head;
    }
    /**
     * set del apuntador head
     * @param head recibe el nodo
     */
    public void setHead(Nodo head) {
        this.head = head;
    }
}