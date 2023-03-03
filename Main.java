//TAREA PROGRAMADA 3
//DANIEL ROJAS MORALES C26836
//RAQUEL ROJAS CASTILLO C26766
import java.util.Scanner;
public class Main {
    public static void main (String args[]){

        Scanner scanner = new Scanner(System.in);
        int opcion;

        //inicialización de variables y objetos
        Matriz[][] matriz = new Matriz[6][6];
        matriz = null;
        ListaDoble lista = new ListaDoble();
        Arbol arbol = new Arbol();
        //se predefine la raiz del arbol en 50
        arbol.insertar(50);
        int[] contador = new int[2];

        do {

            System.out.println("\n*** Menú Principal ***\n");
            System.out.println("1. MATRIZ");
            System.out.println("2. LISTA ENLAZADA DOBLE");
            System.out.println("3. ÁRBOL BINARIO");
            System.out.println("\n00. SALIR\n");
            opcion = scanner.nextInt();
            int subOpcion;

            switch (opcion) {
                case 1: // OPCION 1: MATRIZ
                    do {
                        System.out.println("\n--- MENU MATRIZ: ---\n");
                        System.out.println("1. Crear nueva matriz");
                        System.out.println("2. Guardar matriz en archivo CSV");
                        System.out.println("3. Cargar matriz desde archivo");
                        System.out.println("\n00. Volver al menú principal\n");
                        subOpcion = scanner.nextInt();
                        switch (subOpcion) {
                            case 1: //SUBOPCION 1.1: crear nueva matriz
                                do {
                                    matriz = Matriz.crearTablero();
                                } while (Matriz.verificarMatriz(matriz));
                                Matriz.imprimirMatriz(matriz);
                                //
                                break;// fin case 1
                            case 2: //SUBOPCION 1.2: guardar matriz en archivo CSV
                                try {
                                    Archivo.guardarTableroEnCSV(matriz, "matrizCSV");
                                } catch (Exception e) {
                                    System.out.println("\n*** Debe crear o cargar una matriz antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 2
                            case 3: //SUBOPCION 1.3: cargar matriz desde archivo
                                try {
                                    matriz = Archivo.cargarTableroGuardado("matrizCSV");
                                } catch (Exception e) {
                                    System.out.println("\n*** Debe crear una matriz antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 3
                            default:
                                System.out.println("\n--- Opción inválida ---\n");
                                break;// fin default
                        }
                    } while (subOpcion != 00);
                    break; //fin OPCION 1: MATRIZ

                case 2: //OPCION 2: LISTA ENLAZADA DOBLE
                    do {
                        System.out.println("\n--- MENU LISTA ENLAZADA DOBLE: ---\n");
                        System.out.println("1. Crear nueva lista enlazada doble");
                        System.out.println("2. Obtener elemento más grande");
                        System.out.println("3. Obtener elemento más pequeño");
                        System.out.println("4. Obtener el promedio");
                        System.out.println("5. Obtener cuántos números primos tiene la lista");
                        System.out.println("6. Guardar elementos en un archivo binario");
                        System.out.println("7. Cargar elementos de un archivo binario a nueva lista");
                        System.out.println("\n00. Volver al menú principal\n");
                        subOpcion = scanner.nextInt();
                        switch (subOpcion) {
                            case 1: //SUBOPCION 2.1: Crear nueva lista enlazada doble
                                if(matriz != null){
                                    lista.insertarInicio(matriz);
                                    lista.imprimirLista();
                                }else {
                                    System.out.println("\n*** Debe crear o cargar una matriz antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 1
                            case 2: //SUBOPCION 2.2: Obtener elemento más grande
                                if (lista.inicio != null) {
                                    System.out.println("\nEl elemento más grande de la lista es: "+ListaDoble.elementoGrande(lista)+"\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar una lista antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 2
                            case 3: //SUBOPCION 2.3: Obtener elemento más pequeño
                                if (lista.inicio != null) {
                                    System.out.println("\nEl elemento más pequeño de la lista es: "+ListaDoble.elementoPequeno(lista)+"\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar una lista antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 3
                            case 4: //SUBOPCION 2.4: Obtener el promedio
                                if (lista.inicio != null) {
                                    System.out.println("\nEl promedio de la lista es: "+ListaDoble.promedio(lista)+"\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar una lista antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 4
                            case 5: //SUBOPCION 2.5: Obtener cuántos números primos tiene la lista
                                if (lista.inicio != null) {
                                    System.out.println("\nHay "+ListaDoble.cantidadPrimos(lista)+" números primos en la lista\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar una lista antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 5
                            case 6: //SUBOPCION 2.6: Guardar elementos en un archivo binario
                                if (lista.inicio != null) {
                                    Archivo.guardarListaEnBinario(lista);
                                } else {
                                    System.out.println("\n*** Debe crear o cargar una lista antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 6
                            case 7: //SUBOPCION 2.7: Cargar elementos de un archivo binario a nueva lista
                                Archivo.cargarListaBinaria();
                                break;// fin case 7
                            default:
                                System.out.println("\n--- Opción inválida ---\n");
                                break;// fin default
                        }//fin switch

                    } while (subOpcion != 00);
                    break; //fin OPCION 2: LISTA ENLAZADA DOBLE

                case 3: //OPCION 3: ÁRBOL BINARIO
                    do {
                        System.out.println("\n--- MENU ÁRBOL BINARIO: ---\n");
                        System.out.println("1. Crear árbol binario");
                        System.out.println("2. Obtener cantidad de nodos a la izquierda de la raíz del árbol");
                        System.out.println("3. Obtener cantidad de nodos a la derecha de la raíz del árbol");
                        System.out.println("4. Guardar cada recorrido del árbol en archivos de texto");
                        System.out.println("5. Cargar los datos del archivo recorrido PreOrder");
                        System.out.println("\n00. Volver al menú principal\n");
                        subOpcion = scanner.nextInt();
                        switch (subOpcion) {
                            case 1: //SUBOPCION 3.1: Crear árbol binario
                                if(matriz != null){
                                    arbol.datoAInsertar(matriz);
                                    System.out.println("\nMostrando árbol en Recorrido Order:");
                                    arbol.orden();
                                    System.out.println("");
                                }else {
                                    System.out.println("\n*** Debe crear o cargar una matriz antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 1
                            case 2: //SUBOPCION 3.2: Obtener cantidad de nodos a la izquierda de la raíz del árbol
                                if (arbol != null) {
                                    contador = arbol.contadorNodos(matriz, contador);
                                    System.out.println("La cantidad de nodos a la izquierda de la raíz es: "+contador[1]+"\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar un árbol antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 2
                            case 3: //SUBOPCION 3.2: Obtener antidad de nodos a la derecha de la raíz del árbol
                                if (arbol != null) {
                                    contador = arbol.contadorNodos(matriz, contador);
                                    System.out.println("La cantidad de nodos a la derecha de la raíz es: "+contador[0]+"\n");
                                } else {
                                    System.out.println("\n*** Debe crear o cargar un árbol antes de utilizar esta opción ***\n");
                                }
                                break;// fin case 3
                            case 4: //SUBOPCION 3.4: Guardar cada recorrido del árbol en archivos de texto
                                //
                                break;// fin case 4
                            case 5: //SUBOPCION 3.5: Cargar los datos del archivo recorrido PreOrder
                                //
                                break;// fin case 5
                            default:
                                System.out.println("\n--- Opción inválida ---\n");
                                break;// fin default
                        }//fin switch
                    } while (subOpcion != 00);
                    break; //fin OPCION 3: submenu de ÁRBOL BINARIO

                default:
                    if (opcion != 00) {
                        System.out.println("\n--- Opción inválida ---\n");
                    } else{
                        System.out.println("\n** ¡Adiós! **\n");
                    }
                    break;
            }
        } while (opcion != 00); //fin do-while del menu principal
        scanner.close();
    }//fin main
}//fin clase main