import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in); //Entrada por teclado

        Open open = new Open("/Users/stefanoaragoni/Desktop/Lab10/guategrafo.txt");
        Matriz graph = new Matriz();

        open.add(graph);
        graph.Floyd();

        int menu1=1;
        int menu2; 
        boolean loop = true;

        while(loop){       
            System.out.println("\n\n----MENU PRINCIPAL----");
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. Centro del grafo *no implementado (bajo indicacion de Moises)*");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Mostrar grafo");
            System.out.println("5. Salir del programa");

            menu1 = scan.nextInt();
            
            if(menu1==1){
                
                System.out.println("\nNombre de la ciudad de salida: ");
                String ciudad1 = scan.next(); 
                System.out.println("Nombre de la ciudad de destino: ");
                String ciudad2 = scan.next();

                
                if(graph.contains(ciudad1,ciudad2)){

                    System.out.println("\n\nLa distancia minima es: "+graph.getVertice(ciudad1, ciudad2)+".");

                    if(graph.getVertice(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        //graph.mostrarIntermedias(graph.getIndex(ciudad1), graph.getIndex(ciudad2));
                        System.out.println(", "+ciudad2+"\n");
                    }

                }else{
                    System.out.println("\nNo se ha encontrado alguna (o ambas) de las ciudades ingresadas. Intentar de nuevo."); 
                }
            }
            if(menu1==2){
                System.out.println("\nBajo indicaciones de Moises, esta parte fue eliminada de la rubrica/tarea."); 
            }

            else if(menu1==3){
                System.out.println("\n\n----MODIFICAR GRAFO----");
                System.out.println("1. Hay interrupcion de trafico entre ciudades");
                System.out.println("2. Establecer nueva conexion");
                menu2 = scan.nextInt();

                if(menu2==1){
                    System.out.println("\nIngrese el nombre de la ciudad de salida: ");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino: ");
                    String ciudad2 = scan.next();

                    if(graph.contains(ciudad1,ciudad2)){
                        graph.agregar(ciudad1, ciudad2, "10000");
                    }
                }

                else if(menu2==2){
                    System.out.println("\nIngrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    String distancia = scan.next();

                    graph.agregar(ciudad1, ciudad2, distancia);
                    
                } 
                graph.Floyd();
            }

            if(menu1==4){
                graph.show();
            }

            if(menu1==5){
                loop = false;
                System.out.println("\nHasta luego..."); 
            }

        }
        
    }
}