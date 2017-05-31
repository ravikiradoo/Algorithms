import java.io.*;
import java.util.*;

class Edge
{
    int src;
    int dst;
}

class Graph{
    
    int V;
    int E;
    Edge Edges[];
    int parent[];
	Graph(int v,int e)
	{
	    V=v;
	    E=e;
	    Edges=new Edge[E];
	    parent=new int[V];
	    for(int i=0;i<E;i++)
	     Edges[i]=new Edge();
	 	for(int i=0;i<V;i++)
    	parent[i]=i;
	 
	}
	

	
	int find(int x)
	{
	    if(parent[x]!=x)
	    {
	        parent[x]=find(parent[x]);
	    }
	    return parent[x];
	}
	void union(int x,int y)
	{
	    int xroot=find(x);
	    int yroot=find(y);
	    parent[yroot]=xroot;
	       
	}
	
	int isCycle()
	{
	    for(int i=0;i<E;i++)
	    {int x=find(Edges[i].src);
	    int y=find(Edges[i].dst);
	    if(x==y)
	    return 1;
	    union(x,y);
	    }
	    return 0 ;
	}
	
}
class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        
        
        int n= scan.nextInt();
          int e=scan.nextInt();
        Graph graph=new Graph(n,e);

      
         
          for(int i=0;i<e;i++)
          {
             graph.Edges[i].src=scan.nextInt();
             graph.Edges[i].dst=scan.nextInt();
              
          }
          
          if(graph.isCycle()==1)
          System.out.println("cycle found");
          else
          System.out.println("cycle not found");
         
   }
        
    }
    
    
