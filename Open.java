/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Open.java 
* Autor: Stefano Aragoni 20261
*
********************************************************/

import java.io.*;

//clase que abre y manda a guardar las ciudades
public class Open{
    
    File archivo;
    FileReader varArchivo;
    BufferedReader varline;

    
    public Open(String direccion){
       archivo=new File(direccion);
       
    }  
    
    /** 
     * Manda a llamar a un grafo para guardar los valores en una matriz
     * @param grafo
     * @throws IOException
     */
    public void add(Matriz grafo) throws IOException{

        varArchivo = new FileReader (archivo);
        varline = new BufferedReader(varArchivo);
        String linea;

        while((linea=varline.readLine())!=null){
            String[] arrayS =linea.split(" ");
            grafo.add(arrayS[0], arrayS[1], arrayS[2]);
        }

    }

}
