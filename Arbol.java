//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES C26836
//RAQUEL ROJAS CASTILLO C26766
public class Arbol{
    //puntero a la raíz del árbol
    private NodoArbol raiz;

    //constructor de la clase Arbol
    public Arbol() {
        this.raiz = null;
    }

    public void datoAInsertar(Matriz[][] matriz){
        int valor;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].getValor() % 2 == 0) {
                    valor = matriz[i][j].getValor();
                    insertar(valor);
                }
            }
        }//fin ciclos for
    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new NodoArbol(dato);
        } else{
            this.insertar(this.raiz, dato);
        }
    }//fin método insertar

    private void insertar(NodoArbol padre, int dato){
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new NodoArbol(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new NodoArbol(dato));
            } else{
                this.insertar(padre.getIzquierda(), dato);
            }
        }
        
    }//fin método insertar

    private void preOrder(NodoArbol n){
        if (n != null) {
            n.imprimirDato();
            preOrder(n.getIzquierda());
            preOrder(n.getDerecha());
        }
    }//fin método preOrder

    public void orden(NodoArbol n){
        if(n != null) {
            orden(n.getIzquierda());
            n.imprimirDato();
            orden(n.getDerecha());
        }
    }//fin método orden

    private void postOrden(NodoArbol n){
        if(n != null) {
            orden(n.getIzquierda());
            orden(n.getDerecha());
            n.imprimirDato();
        }
    }//fin método postOrden

    public void preOrder(){
        this.preOrder(this.raiz);
    }

    public void orden(){
        this.orden(this.raiz);
    }

    public void postOrden(){
        this.postOrden(this.raiz);
    }

    public int[] contadorNodos(Matriz[][] matriz, int[] contadorA){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].getValor() > 50) {
                    //cuenta los nodos de la derecha
                    contadorA[0]++;
                } else if (matriz[i][j].getValor() <= 50) {
                    //cuenta los nodos de la izquierda
                    contadorA[1]++;
                }
            }
        }//fin ciclos for
        return contadorA;
    }//fin método contadorNodos

    /*** 
    void contarNodosPreOrden(NodoArbol nodo, int[] contador) {
        if (nodo != null) {
            if (nodo.getIzquierda() != null) {
                contador[0]++;
                contarNodosPreOrden(nodo.getIzquierda(), contador);
            }
            if (nodo.getDerecha() != null) {
                contador[1]++;
                contarNodosPreOrden(nodo.getDerecha(), contador);
            }
        }
    }
    */

}//fin clase Arbol