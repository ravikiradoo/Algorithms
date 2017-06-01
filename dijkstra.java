import java.io.*;
import java.util.*;

class Edge
{
    int dst;
    int weight;
 
}

class Graph{
    
    int V;
    int E;
    ArrayList<Edge> Edges[];
    int parent[];
    Edge result[];
    boolean mstSet[];
    int dst[];
	Graph(int v)
	{
	    V=v;
	    Edges=new ArrayList[V];
	    parent=new int[V];
	    mstSet=new boolean[V];
	    result=new Edge[V];
	    dst=new int[V];
	 	for(int i=0;i<V;i++)
    	{
    	Edges[i]=new ArrayList<Edge>();
    	parent[i]=i;
    	mstSet[i]=false;
    	dst[i]=Integer.MAX_VALUE;
    	}
    	dst[0]=0;
    	parent[0]=-1;
	 
	}
	void AddEdges(int a,int b,int c)
	{
	   Edge edge=new Edge();
	   edge.dst=b;
	   edge.weight=c;
	   Edges[a].add(edge);
	   
	     edge=new Edge();
	   edge.dst=a;
	   edge.weight=c;
	   Edges[b].add(edge);
	}
	
void dijkstra()
{

    
    for(int i=0;i<V-1;i++)
    {
            int u=mindst();
          System.out.println(u);
        mstSet[u]=true;
        for(int j=0;j<Edges[u].size();j++)
        {
            if(mstSet[Edges[u].get(j).dst]==false && dst[u]+Edges[u].get(j).weight<dst[Edges[u].get(j).dst])
            {
              
                dst[Edges[u].get(j).dst]=dst[u]+Edges[u].get(j).weight;
            }
        }
        
    }
    
}
int mindst()
{
    int min=Integer.MAX_VALUE;
    int index=-1;
    for(int i=0;i<V;i++)
    {
        if(mstSet[i]==false && dst[i]<min)
        {
            min=dst[i];
            index=i;
        }
        
    }
    return index;
}

	
}
class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        
        
        int n= scan.nextInt();
        Graph graph=new Graph(n);
        int e=scan.nextInt();
        
      for(int i=0;i<e;i++)
      {
          graph.AddEdges(scan.nextInt(),scan.nextInt(),scan.nextInt());
      }

       graph.dijkstra();
          for(int i=0;i<n;i++)
          {
              System.out.println(i+" "+graph.dst[i]);
          }

          }
          
        
         
   }
        
    
    
    
