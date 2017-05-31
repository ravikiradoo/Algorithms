import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>
{
    int src;
    int dst;
    int weight;
    public int compareTo(Edge x)
    {
        return this.weight-x.weight;
    }
}

class Graph{
    
    int V;
    int E;
    Edge Edges[];
    int parent[];
    int rank[];
    Edge result[];
	Graph(int v,int e)
	{
	    V=v;
	    E=e;
	    Edges=new Edge[E];
	    parent=new int[V];
	    rank=new int[V-1];
	    result=new Edge[v-1];
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
	    if(xroot==yroot)
	    return;
	    
	    if(rank[xroot]<rank[yroot])
	    {
	        parent[xroot]=yroot;
	    }
	    else if(rank[xroot]>rank[yroot])
	    {
	        parent[yroot]=xroot;
	    }
	   else
	   {
	       parent[yroot]=xroot;
	       rank[xroot]++;
	   }
	}
	

	void kurskal()
	{
	      Arrays.sort(Edges);
          
          int e=0;
         int  i=0;
          while(e<V-1)
          {
        int x=find(Edges[i].src);
	    int y=find(Edges[i].dst);
	    
	    if(x!=y)
	    {
	    result[e]=Edges[i];
	    e++;
	    i++;
	    union(x,y);
	    }
	    else
	    {
	        i++;
	    }
	    
	    
	    }
	  
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
             graph.Edges[i].weight=scan.nextInt();
              
          }
          graph.kurskal();
          for(int i=0;i<n-1;i++)
          {
              System.out.println(graph.result[i].src+"->"+graph.result[i].dst);
          }

          }
          
        
         
   }
        
    
    
    
