//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES - C26836
//RAQUEL ROJAS CASTILLO - C26766
public class Matriz{

    private int valor;
    private boolean usado;

    //método constructor
    public Matriz(int valor, boolean usado) {
        this.valor = valor;
        this.usado = usado;
    }

    //método constructor por default
    public Matriz(){
        this.valor = -1;
        this.usado = false;
    }

    //setters and getters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean getUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public static Matriz[][] crearTablero(){
        Matriz[][] tablero = new Matriz[6][6];
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                tablero[i][j] = new Matriz((int) Math.abs(Math.random()*100), false);
            }
        }
        return tablero;
    }// fin método crearTablero

    //método para verififcar que la matriz tenga la misma cantidad de pares e impares (50 y 50)
    public static boolean verificarMatriz(Matriz[][] matriz){
        boolean flag = true;
        int pares=0, impares=0, num=0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                num = matriz[i][j].getValor();
                if (num%2!=0) {
                    impares++;
                }else{
                    pares++;
                }
            }
        }// fin bucle de fors
        if (Math.abs(pares-impares)<=0) {
            flag = false;
        }
        return flag;
    }//fin método verificarMatriz

    public static void imprimirMatriz(Matriz[][] matriz){
        System.out.println("Tablero de juego:\n"); //esto si quiere lo quita, solo agregro cosas para que parezca que avancé algo xd
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.printf("%4d", matriz[i][j].getValor());
                //System.out.print(matriz[i][j].getUsado());
            }
            System.out.println();
        }
    }//fin método imprimirMatriz

    //método prueba para verificar que los pares e impares tengan la misma cantidad
    public static void prueba(Matriz[][] matriz){
        int pares=0, impares=0, valor = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                valor = matriz[i][j].getValor();
                if (valor%2!=0) {
                    impares++;
                }else{
                    pares++;
                }
            }
        }
        System.out.println(impares);
        System.out.println(pares);
    }

    

}// fin clase