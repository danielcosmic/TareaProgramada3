//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES - C26836
//RAQUEL ROJAS CASTILLO - C26766
public class NodoLista {

    public int valor;
    public NodoLista siguiente;
    public NodoLista anterior;

    public NodoLista(int valor){
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }//fin constructor

    public NodoLista(){
        this.valor = -1;
        this.siguiente = null;
        this.anterior = null;
    }//fin constructor por default
}