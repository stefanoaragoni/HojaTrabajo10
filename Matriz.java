import java.util.Vector;

public class Matriz {

    private Vector<String> ciudades;
    private int[][] km;
    

    public Matriz(){
    
        ciudades = new Vector<String>();
        km = new int [30][30];

        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                if(i==j){
                    km[i][j]=0;
                }
                else{
                    km[i][j]=10000;
                }
            }
        }
    }

    public void Floyd(){
        for (int k = 0; k < 30; k++)
        {
            // Pick all vertices as source one by one
            for (int i = 0; i < 30; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (int j = 0; j < 30; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (km[i][k] + km[k][j] < km[i][j])
                        km[i][j] = km[i][k] + km[k][j];
                }
            }
        }
    }

    public void agregar(String cd1, String cd2, String cant) {
        
        if(!ciudades.contains(cd1)){
            ciudades.add(cd1);
        }
        if(!ciudades.contains(cd2)){
            ciudades.add(cd2);
        }

        int i = ciudades.indexOf(cd1);
        int j = ciudades.indexOf(cd2);        
        km[i][j]= Integer.parseInt(cant);
        
    }

    public void show(){
        for(int a=0;a<ciudades.size();a++){
            for(int b=0;b<ciudades.size();b++){
                System.out.print(""+km[a][b]+" ");
            }
            System.out.println("");
        }
    }

    public int getVertice(String cd1, String cd2){
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


