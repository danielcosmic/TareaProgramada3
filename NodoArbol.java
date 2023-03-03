//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES - C26836
//RAQUEL ROJAS CASTILLO - C26766
public class NodoArbol {

    private int dato;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    //constructor
    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    //getters y setters
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
    //fin getters y setters

    public void imprimirDato(){
        System.out.print(this.getDato()+" ");
    }
}//fin clase NodoArbol