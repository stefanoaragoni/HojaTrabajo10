/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Main.java 
* Autor: Stefano Aragoni 20261
*
********************************************************/

import java.io.IOException;
import java.util.Scanner;

public class Main {

    
    /** 
     * Clase principal.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        
        //Entrada por teclado
        Scanner scan = new Scanner(System.in); 

        //Se abre el archivo
        Open open = new Open("/Users/stefanoaragoni/Desktop/Lab10/src/guategrafo.txt");
        
        //Se crea la matriz
        Matriz graph = new Matriz();

        //Se agrega la informacion del archivo en la matriz
        open.add(graph);

        int menu1=1;
        int menu2; 
        boolean loop = true;

        //loop
        while(loop){   

            //se ordena la matriz con el algoritmo de floyd
            graph.Floyd();
            
            //menu principal
            System.out.println("\n\n----MENU PRINCIPAL----");
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Mostrar grafo");
            System.out.println("5. Salir del programa");

            menu1 = scan.nextInt();
            
            //si se quiere buscar la ruta mas corta
            if(menu1==1){
                
                //se ingresan los nombres de dos ciudades
                System.out.println("\nNombre de la ciudad de salida: ");
                String ciudad1 = scan.next(); 
                System.out.println("Nombre de la ciudad de destino: ");
                String ciudad2 = scan.next();

                //se verifica que las ciudades existan
                if(graph.contains(ciudad1,ciudad2)){

                    //se llama a la matriz para indicar la distancia entre nodos
                    System.out.println("\n\nLa distancia minima es: "+graph.distance(ciudad1, ciudad2)+".");

                    //se imprime las ciudades que hay que pasar para llegar de un punto al otro
                    graph.between(ciudad1, ciudad2);
                    
                //si no existen las ciudades
                }else{
                    System.out.println("\nNo se ha encontrado alguna (o ambas) de las ciudades ingresadas. Intentar de nuevo."); 
                }
            }

            //centro del grafo
            if(menu1==2){
                //se llama a la matriz para calcular el centro del grafo
                graph.middle();
            }

            //modificar grafo
            else if(menu1==3){
                //menu de modificar grafo
                System.out.println("\n\n----MODIFICAR GRAFO----");
                System.out.println("1. Hay interrupcion de trafico entre ciudades");
                System.out.println("2. Establecer nueva conexion");
                menu2 = scan.nextInt();

                //se quiere interrumpir la conexion entre dos ciudades
                if(menu2==1){
                    //se ingresan dos ciudades
                    System.out.println("\nIngrese el nombre de la ciudad de salida: ");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino: ");
                    String ciudad2 = scan.next();

                    //se agrega la ciudad y se coloca una distancia infinita. esto forza buscar otra ruta
                    if(graph.contains(ciudad1,ciudad2)){
                        graph.add(ciudad1, ciudad2, "10000");
                    //si no existen las ciudades
                    }else{
                        System.out.println("Una o ambas ciudades no exiten en el sistema."); 
                    }
                }
                //se quiere agregar nueva conexion o ciudades
                else if(menu2==2){
                    //se ingresa nombres de ciudades y kilometros entre ellas
                    System.out.println("\nIngrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    String distancia = scan.next();

                    //se agrega la informacion al grafo
                    graph.add(ciudad1, ciudad2, distancia);
                    
                } 
            }

            //se muestran los dos grafos
            if(menu1==4){
                graph.show();
            }

            //se sale del programa
            if(menu1==5){
                loop = false;
                System.out.println("\nHasta luego..."); 
            }

        }
        
    }
}