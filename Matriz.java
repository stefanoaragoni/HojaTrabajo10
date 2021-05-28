/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Matriz.java 
* Autor: Stefano Aragoni 20261
*
********************************************************/

import java.util.Collection;
import java.util.Vector;

import java.util.Collections;

//clase que guarda las matrices utilizadas
public class Matriz {

    //se crea un vector con la lista de ciudades
    private Vector<String> ciudades;

    //se crean dos matrices. de distancia y de rutas
    private int[][] km;
    private int[][] rutas;
    

    /** 
     * Metodo principal. Instancia las listas y las matrices
     */
    public Matriz(){
    
        ciudades = new Vector<String>();
        km = new int [30][30];
        rutas = new int [30][30];

        //se llenan las matrices con infinitos
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                if(i==j){
                    km[i][j]=0;
                }
                else{
                    km[i][j]=10000;
                }

                rutas[i][j] = 10000;
                
            }
        }
    }

    /** 
     * Organiza las matrices y busca las rutas mas cortas
     */
    public void Floyd(){
        for (int k = 0; k<ciudades.size(); k++)
        {
            //recorre las filas i
            for (int i = 0; i<ciudades.size(); i++)
            {
                //recorre las columnas j
                for (int j = 0; j<ciudades.size(); j++)
                {
                    //verifica que no sea infinito
                    if (km[i][k] == 10000 || km[k][j] == 10000)
                        continue;
                    
                    //algoritmo de floyd
                    if (km[i][k] + km[k][j] < km[i][j]){
                        //se cambia la distancia en la matriz de distancia
                        km[i][j] = km[i][k] + km[k][j];
                        //se cambia las rutas
                        rutas[i][j] = rutas[i][k];
                    }
                        
                }
            }
        }
    }

    /** 
     * Calcula de cada columna el valor maximo. Compara los valores y el minimo es el centro
     */
    public void middle(){

        //nuevo vector
        Vector<Integer> middleV = new Vector<Integer>(); 

        //verifica cada valor de las matrices. 
        for (int i = 0; i<ciudades.size(); i++){
            int max = 0;

            for (int j = 0; j<ciudades.size(); j++)
            {
                if(max < km[i][j]){
                    max = km[i][j];
                }
            }
            //almacena el valor mas grande de cada columna
            middleV.add(max);
        }

        //se encuentra el valor minimo
        int a = Collections.min(middleV);
        //se encuentra el index del centro del grafo
        int index = middleV.indexOf(a);

        System.out.println("\nEl centro del grafo es: "+ciudades.elementAt(index)+". Tiene la excentricidad mas pequeña, con... "+a); 
    }

    
    /** 
     * Llama a otro metodo para encontrar las ciudades en el camino
     * @param cd1
     * @param cd2
     */
    public void between(String cd1, String cd2) {
        //se encuentran los indexes de las ciudades
        int i = ciudades.indexOf(cd1);
        int j = ciudades.indexOf(cd2);        
        
        //se llama al metodo privado recursivo
        printCities(i,j);
        
    }

    
    /** 
     * Se agrega mas informacion a la matriz
     * @param cd1
     * @param cd2
     * @param cant
     */
    public void add(String cd1, String cd2, String cant) {
        
        //verifica si las canciones ya existen
        if(!ciudades.contains(cd1)){
            ciudades.add(cd1);
        }
        if(!ciudades.contains(cd2)){
            ciudades.add(cd2);
        }

        //recolecta los indexes de las ciudades
        int i = ciudades.indexOf(cd1);
        int j = ciudades.indexOf(cd2);        
        km[i][j]= Integer.parseInt(cant);

        //se guarda en la matriz el valor de la distancia
        if(cant == "10000"){
            rutas[i][j] = 10000;
        }else{
            rutas[i][j] = j;
        }
        
    }

    /** 
     * Metodo para imprimir matrices
     */
    public void show(){
        System.out.println("\n--MATRIZ DE DISTANCIAS ENTRE NODOS (KM)--\n");
        for(int a=0;a<ciudades.size();a++){
            for(int b=0;b<ciudades.size();b++){
                System.out.print(""+km[a][b]+" ");
            }
            System.out.println("");
        }

        System.out.println("\n--MATRIZ DE CAMINOS--\n");
        for(int a=0;a<ciudades.size();a++){
            for(int b=0;b<ciudades.size();b++){
                System.out.print(""+rutas[a][b]+" ");
            }
            System.out.println("");
        }
    }

    //------------------METODOS EXTRA-----------------------


    /** 
     * Calcula la distancia entre dos puntps
     * @param cd1
     * @param cd2
     * @return int
     */
    public int distance(String cd1, String cd2){
        return km[ciudades.indexOf(cd1)][ciudades.indexOf(cd2)];
    }

    
    /** 
     * Verifica si una ciudad existe
     * @param cd1
     * @return boolean
     */
    public boolean contains(String cd1){
        return ciudades.contains(cd1);
    }

    
    /** 
     * verifica su dos ciudades existen
     * @param cd1
     * @param cd2
     * @return boolean
     */
    public boolean contains(String cd1, String cd2){
        boolean status = false;
        if(ciudades.contains(cd1) && ciudades.contains(cd2)){
            status = true;
        }
        return status;
    }

    
    /** 
     * Imprime las ciudades entre dos.
     * @param i
     * @param j
     */
    private void printCities(int i, int j) {
        //nuevo vector

        Vector<String> path = new Vector<String>();
        //se gurda la ciudad de salida
        path.add("-> "+ciudades.get(i));

        //se verifica que la ciudad si tenga recorrido a la otra ciudad
        if (km[i][j] == 10000 || km[i][j] == 0){
            System.out.println("No hay camino. Hay una interrupcion o el camino es muy largo.\n"); 
        }else{
            
            //almacena el camino en el vector
            while (i != j)
            {
                i = rutas[i][j];
                path.add(ciudades.get(i));
            }

        }

        //se imprime todo
        int n = path.size();
        for(int l = 0; l < n - 1; l++)
        System.out.print(path.get(l) + " -> ");
        System.out.print(path.get(n - 1) + "\n");
    }

    
}


