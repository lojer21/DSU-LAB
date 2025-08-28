import java.util.*;
class prg4
{
   static int INF=9999;// Representing infinity
   //Distance Vector Routing Algorithm
   public static void distanceVector(int[][]graph)
   {
    int n=graph.length;
    int[][]dist=new int[n][n];
    //Initialize distance vector with graph itself
    for(int i=0;i<n;i++){
    dist[i]=Arrays.copyOf(graph[i],n);}
    //Update distance vectorusing neighbors
    for(int k=0;k<n;k++)
    //k is the intermediate node
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dist[i][k]+dist[k][j]<dist[i][j])
                dist[i][j]=dist[i][k]+dist[k][j];
            }
        }
    }
    //Print result 
    for(int i=0;i<n;i++)
    {
        System.out.println("Router "+i+" distance vector:"+Arrays.toString(dist[i]));
    }
}
public static void main(String[] aya)
{
    int[][]graph={
        {0,1,3,INF},
        {1,0,1,7},
        {3,1,0,2},
        {INF,7,2,0}
    };
    distanceVector(graph);
}
}
