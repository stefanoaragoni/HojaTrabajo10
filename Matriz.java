import java.util.Vector;

public class Matriz {

    private Vector<String> ciudades;
    private int[][] km;
    private int[][] ciudades2;
    

    public Matriz(){
    
        ciudades = new Vector<String>();
        km = new int [30][30];
        ciudades2 = new int [30][30];

        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                if(i==j){
                    km[i][j]=0;
                }
                else{
                    km[i][j]=10000;
                }

                ciudades2[i][j] = 10000;
                
            }
        }
    }

    public void Floyd(){
        for (int k = 0; k<ciudades.size(); k++)
        {

            for (int i = 0; i<ciudades.size(); i++)
            {

                for (int j = 0; j<ciudades.size(); j++)
                {

                    if (km[i][k] == 10000 || km[k][j] == 10000)
                        continue;
            
                    if (km[i][k] + km[k][j] < km[i][j]){
                        km[i][j] = km[i][k] + km[k][j];
                        ciudades2[i][j] = ciudades2[i][k];
                    }
                        
                }
            }
        }
    }

    public void between(String cd1, String cd2) {
        int i = ciudades.indexOf(cd1);
        int j = ciudades.indexOf(cd2);        
        
        printCities(i,j);
        
    }

    private void printCities(int i, int j) {
        Vector<String> path = new Vector<String>();
        path.add("-> "+ciudades.get(i));

        if (km[i][j] == 10000 || km[i][j] == 0){
            System.out.println("No hay camino. Hay una interrupcion o el camino es muy largo.\n"); 
        }else{
            
            while (i != j)
            {
                i = ciudades2[i][j];
                path.add(ciudades.get(i));
            }

        }

        int n = path.size();
        for(int l = 0; l < n - 1; l++)
        System.out.print(path.get(l) + " -> ");
        System.out.print(path.get(n - 1) + "\n");
    }


    public void add(String cd1, String cd2, String cant) {
        
        if(!ciudades.contains(cd1)){
            ciudades.add(cd1);
        }
        if(!ciudades.contains(cd2)){
            ciudades.add(cd2);
        }

        int i = ciudades.indexOf(cd1);
        int j = ciudades.indexOf(cd2);        
        km[i][j]= Integer.parseInt(cant);

        if(cant == "10000"){
            ciudades2[i][j] = 10000;
        }else{
            ciudades2[i][j] = j;
        }
        
    }

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
                System.out.print(""+ciudades2[a][b]+" ");
            }
            System.out.println("");
        }
    }

    //------------------METODOS EXTRA-----------------------

    public int distance(String cd1, String cd2){
        return km[ciudades.indexOf(cd1)][ciudades.indexOf(cd2)];
    }

    public boolean contains(String cd1){
        return ciudades.contains(cd1);
    }

    public boolean contains(String cd1, String cd2){
        boolean status = false;
        if(ciudades.contains(cd1) && ciudades.contains(cd2)){
            status = true;
        }
        return status;
    }
    
}


