import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class graph {
    Scanner input = new Scanner(System.in);
    int edge=0;
    int u,v,vertex;
    int arah;
    int diagonal =0;
    int simetris =0;
    public final int[][] graph = new int[100][100];
    List<Integer> coba[] = new LinkedList[100];
    public graph(){
        System.out.print("Masukkan banyak vertex :");
        vertex = input.nextInt();
        System.out.print("Masukkan jenis graph, tidak berarah/berarah (0/1) :");
        arah = input.nextInt();
        for (int i=0;i<vertex;i++){
            for (int j=0;j<vertex;j++){
                graph[i][j] = 0; //reset element of matrix
                coba[i] = new LinkedList<>();
            }
        }

    }

    public void masukanadjlist(){
        for (int i = 0; i < vertex; i++) {

            System.out.println("Vertex ke-" + i);
            System.out.print("Connected to vertex (pisah \',\') : ");

            if (arah == 0) {
                for (int j = i; j >= 0; j--) {
                    if (i != 0 && coba[j].contains(i)) {
                        System.out.print(j + ",");

                    }
                }
            }

            String masukan = input.next();
            StringTokenizer st = new StringTokenizer(masukan, ",");
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if (arah == 0 && temp != i) {
                    coba[temp].add(i);
                }
                coba[i].add(temp);


            }
        }
    }

    public void tampiladjlist(){
        System.out.println("Tampilkan adjancency list : ");
        for (int k = 0; k < vertex; k++) {
            System.out.println(k + " : " + coba[k]);
            edge += coba[k].size();
        }

    }



    public void inputgraph(){
        for (int k=0;k<vertex;k++){
            for (int l=0;l<coba[k].size();l++){
                //if (arah == 1 )
                graph[k][coba[k].get(l)]++;
                //}
                /*else if (arah ==0 ){
                    graph[k][coba[k].get(l)]++;
                    graph[coba[k].get(l)][k]++;
                }*/
            }
        }
    }

    public void tampilgraph(){
        System.out.println("Ini adalah tampilan matrixnya");
        for (int l=0;l<vertex;l++){
            if (graph[l][l] == 0){
                diagonal++;
            }
            for (int m=0;m<vertex;m++){
                System.out.print(graph[l][m]+" ");
                if(graph[l][m] == graph[m][l] && graph[l][m] <2){
                    simetris++;
                }
            }
            System.out.println();
        }
        if(simetris == vertex*vertex && diagonal==vertex && arah == 0){
            System.out.println("Ini adalah graph sederhana");
        }
        else if (diagonal == vertex && arah == 1 ){
            System.out.println("Ini adalah graph sederhana");
        }
        else {
            System.out.println("Ini bukanlah graph sederhana");
        }

    }

}
