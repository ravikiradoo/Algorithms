import java.io.*;
import java.util.*;


class Graph
{
    
static int graph[][];
static int dst[][];
public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
          int n= scan.nextInt();
        graph=new int[n][n];
        dst=new int [n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j]=scan.nextInt();
                dst[i][j]=graph[i][j];
            }
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dst[i][k]+dst[k][j]<dst[i][j])
                    dst[i][j]=dst[i][k]+dst[k][j];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dst[i][j]==1000000)
                System.out.print("INF\t");
                else
                   System.out.print(dst[i][j]+"\t");
            }
            System.out.println();
            
        }
      
        

 
          }
          
	
}

        
    
    
    
