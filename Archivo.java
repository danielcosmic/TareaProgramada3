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
                        buffWrite.write((tablero[i][j].getUsado())+",");
                    }
                    else{
                        //cuando se llega a la última columna se imprime un cambio de línea
                        buffWrite.write(Integer.toString(tablero[i][j].getValor())+",");
                        buffWrite.write((tablero[i][j].getUsado())+"\n");
                    }
                }//for con j que recorre las columnas
            }//for con i que recorre las filas
            buffWrite.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//fin guardarTablerotEnCSV

    public static int[][] cargarTableroGuardado(String nombreArchivo){
        try {
            int [][] matriz = new int [10][10];
            String linea;
            FileReader fileRead = new FileReader(nombreArchivo);
            BufferedReader buffRead = new BufferedReader(fileRead);
            String [] valoresLinea;
            int contador = 0;
            System.out.print("\nCargando datos del tablero guardado desde: "+nombreArchivo);
            while ((linea = buffRead.readLine()) != null) {
                valoresLinea = linea.split(",");
                for(int i=0; i<valoresLinea.length; i++){
                    matriz[contador][i] = Integer.parseInt(valoresLinea[i]);
                    //prueba de carga
                }//fin for
                contador++;
            }
            buffRead.close();
            System.out.println("Matriz cargada con éxito");
            return matriz;

        } catch (IOException ex) {
            System.out.println("Error al cargar la matriz:");
            System.out.println("Verifique que el archivo "+nombreArchivo+" exista");
            return null;
        }
    }//fin método cargarTableroGuardado

    public static void guardarListaEnBinario(ListaDoble lista){
        File archivo = new File("escrituraBinaria.dat");

        try {
            FileOutputStream lisb = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(lisb);

            escribir.writeObject(lista);
            escribir.close();
            lisb.close();
            
            System.out.println("¡Archivo guardado con éxito!");
        } catch (Exception e) {
            System.out.println("Error al guardar la lista");
        }
    }//Fin método guardarListaEnBinario

    public static void cargarListaBinaria(String nombreArchivo){
        File archivo = new File("nombreArchivo.dat");

        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream leer;
            leer = new ObjectInputStream(fis);

            System.out.println("Cargando lista...");
            while (fis.available()>0) {
                ListaDoble lista = (ListaDoble) leer.readObject();
                System.out.print(lista);
            }
            System.out.println("");
            leer.close();

        } catch (Exception e) {
            System.out.println("Error al cargar la lista");
        }
    }//fin método cargarListaBinaria

    
    

}//fin clase archivo
