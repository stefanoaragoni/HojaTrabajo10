import java.io.*;

public class Open{
    
    File archivo;
    FileReader varArchivo;
    BufferedReader varline;

    
    public Open(String direccion){
       archivo=new File(direccion);
       
    }  

    public void add(Matriz grafo) throws IOException{

        varArchivo = new FileReader (archivo);
        varline = new BufferedReader(varArchivo);
        String linea;

        while((linea=varline.readLine())!=null){
            String[] arrayS =linea.split(" ");
            grafo.agregar(arrayS[0], arrayS[1], arrayS[2]);
        }

    }

}
