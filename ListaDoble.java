 //TAREA PROGRAMADA 1
//DANIEL ROJAS MORALES - C26836
//RAQUEL ROJAS CASTILLO - C26766
 class ListaDoble {

    Nodo inicio;
    Nodo fin;

    public ListaDoble(){
        inicio = null;
        fin = null;
    }

    //método que inserta al inicio solamente los valores impares de la matriz
    public void insertarInicio(Matriz[][] matriz){
        int valor=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].getValor() % 2 != 0) {
                    valor = matriz[i][j].getValor();
                    Nodo nuevo = new Nodo();
                    nuevo.valor = valor;
                    if (inicio == null) {
                       inicio = nuevo;
                       fin = nuevo;
                       inicio.siguiente = null;
                       inicio.anterior = null;
                    } else {
                        inicio.anterior = nuevo;
                        nuevo.siguiente = inicio;
                        inicio = nuevo;
                    }
                }
            }
        }//fin ciclos for
    }//fin método insertarInicio

    public void imprimirLista(){
        System.out.println("\nLos valores de la lista doble son:\n");
        if (inicio != null) {
            Nodo actual = inicio;
            while (actual != null) {
                System.out.print(actual.valor + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }//fin método imprimirLista

    //este método busca el elemento más grande de la lista
    public static int elementoGrande(ListaDoble lista){
        int maximo = lista.inicio.valor;
        Nodo actual = lista.inicio;

        while (actual != null) {
            if (actual.valor > maximo) {
                maximo = actual.valor;
            }
            actual = actual.siguiente;
        }
        return maximo;
        //System.out.println("\nEl elemento más grande de la lista es: "+maximo+"\n");
    }//fin método elementoGrande

    //este método busca el elemento más pequeño de la lista
    public static int elementoPequeno(ListaDoble lista){
        int minimo = lista.inicio.valor;
        Nodo actual = lista.inicio;

        while (actual != null) {
            if (actual.valor < minimo) {
                minimo = actual.valor;
            }
            actual = actual.siguiente;
        }
        return minimo;
    }//fin método elementoPequeño

    public static double promedio(ListaDoble lista) {
        int suma = 0;
        int contador = 0;
        Nodo actual = lista.inicio;

        while (actual != null) {
            suma += actual.valor;
            contador++;
            actual = actual.siguiente;
        }

        return (double) suma / contador;
    }

    //método auxiliar para determinar si un numero es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }//fin método esPrimo

    //método para contar la cantidad de primos
    public static int cantidadPrimos(ListaDoble lista) {
        int contador = 0;
        Nodo actual = lista.inicio;

        while (actual != null) {
            if (esPrimo(actual.valor)) {
                contador++;
            }
            actual = actual.siguiente;
        }

        return contador;
    }//fin método cantidadPrimos

}//fin clase Lista







