import java.util.*;

class fenwik
{
    static int[] BITree;
    public static void main(String args[])
    
    {
    
    Scanner scan = new Scanner(System.in);
    
    int n=scan.nextInt();
    
    int[] input=new int[n];
    
    BITree=new int[n+1];
    
    for(int i=0;i<n;i++)
    {
        input[i]=scan.nextInt();
    }
    
    for(int i=1;i<=n;i++)
    {
        int val=input[i-1];
        int j=i;
     
        while(j<=n)
        {
            BITree[j]=BITree[j]+val;
            j=j+(j &(-j));
        }

    }

    int q=scan.nextInt();
    for(int i=0;i<q;i++)
    {int sum=0;
    int j=scan.nextInt();
    while(j>0)
    {
        sum=sum+BITree[j];
        j=j-(j &(-j));
        
    }
    System.out.println(sum);
    }
        
        
    }
    
}
