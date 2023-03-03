//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES - C26836
//RAQUEL ROJAS CASTILLO - C26766
import java.io.*;
public class Archivo {

    public static void guardarTableroEnCSV(Matriz[][] tablero, String nombreArchivo){
        //
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);
            BufferedWriter buffWrite;
            buffWrite = new BufferedWriter(archivo);
            for (int i=0; i<tablero.length; i++){
                for (int j=0; j<tablero[i].length; j++){
                    if (j < tablero[i].length-1){
                        //validamos que no sea la última columna
                        buffWrite.write(Integer.toString(tablero[i][j].getValor())+",");
                        buffWrite.write((tablero[i][j].getUsado())+"-");
                    }
                    else{
                        //cuando se llega a la última columna se imprime un cambio de línea
                        buffWrite.write(Integer.toString(tablero[i][j].getValor())+",");
                        buffWrite.write((tablero[i][j].getUsado())+"\n");
                    }
                }//for con j que recorre las columnas
            }//for con i que recorre las filas
            System.out.println("\n Matriz guardada con éxito");
            buffWrite.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//fin guardarTablerotEnCSV

    public static Matriz[][] cargarTableroGuardado(String nombreArchivo){
        try {
            Matriz[][] matriz = new Matriz[6][6];
            String linea;
            FileReader fileRead = new FileReader(nombreArchivo);
            BufferedReader buffRead = new BufferedReader(fileRead);
            String [] valoresLinea;
            String [] obtenerValor_Usado;
            int contador = 0;
            System.out.print("\nCargando datos del tablero guardado desde: "+nombreArchivo);
            while ((linea = buffRead.readLine()) != null) {
                valoresLinea = linea.split("-");
                for(int i=0; i<valoresLinea.length; i++){
                    obtenerValor_Usado = valoresLinea[i].split(",");
                    matriz[contador][i] = new Matriz((Integer.parseInt(obtenerValor_Usado[0])),(Boolean.parseBoolean(obtenerValor_Usado[1])));
                }//fin for
                contador++;
            }
            buffRead.close();
            System.out.println("\n Matriz cargada con éxito");
            Matriz.imprimirMatriz(matriz);
            return matriz;

        } catch (IOException ex) {
            System.out.println("Error al cargar la matriz:");
            System.out.println("Verifique que el archivo "+nombreArchivo+" exista");
            return null;
        }
    }//fin método cargarTableroGuardado

    public static void guardarListaEnBinario(ListaDoble lista){
        File archivo = new File("listaBinario.dat");
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(fos);
            escribir.writeObject(lista);

            escribir.close();
            fos.close();

            System.out.println("¡Archivo guardado con éxito!");
        } catch (Exception e) {
            System.out.println("Error al guardar la lista");
        }
    }//Fin método guardarListaEnBinario

    public static void cargarListaBinaria(){
        File archivo = new File("escrituraBinaria.dat");

        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream leer;
            leer = new ObjectInputStream(fis);

            System.out.println("Cargando lista...");
            while (fis.available()>0) {
                ListaDoble lista = (ListaDoble) leer.readObject();
                lista.imprimirLista();
            }
            System.out.println("");
            leer.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la lista");
        }
    }//fin método cargarListaBinaria

    /*public static void guardarArbol(Arbol arbol, String nombreArchivo, Matriz[][] matriz, int[] contadorA){
        //
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);
            BufferedWriter buffWrite;
            buffWrite = new BufferedWriter(archivo);

            for (int i=0; i<arbol.contadorNodos(matriz, contadorA); i++){
                buffWrite.write(+"\n");
            }//for con i que recorre las filas
            buffWrite.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//fin guardarArbol*/
}//fin clase archivo