
import java.util.*;

class Graph
{
   static  int V;
   static int graph[][];
   static int m;
   static int color[];
  public static void main(String args[]) 
   
   { 
    
    Scanner scan=new Scanner(System.in);
     V=scan.nextInt();
     graph = new int[V][V];
     m=scan.nextInt();
    color=new int[V];
    
    for(int i=0;i<V;i++)
    {
        for(int j=0;j<V;j++)
        {
            graph[i][j]=scan.nextInt();
        }
    }
    if(GraphColoring(0)==true)
    {
        for(int i=0;i<V;i++)
        {
           System.out.println(color[i]); 
        }
    }
    else
    {
        System.out.println("Coloring Not Possible");
    }
    
   }
  static boolean GraphColoring(int v)
   {
       if(v==V)
       return true;
       
       
       for(int c=1;c<=m;c++)
       {
           if(isSafe(v,c))
           {
               color[v]=c;
               
               if(GraphColoring(v+1))
               return true;
             
             color[v]=0;
               
           }
       }
       return false;
   }
   
   static boolean isSafe(int v,int c)
   {
       for(int i=0;i<V;i++)
       {
           if(graph[i][v]==1 && c==color[i])
           return false;
          
       }
       return true;
   }
    
}
