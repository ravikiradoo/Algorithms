import java.util.*;

class SegmentTree
{
    
     static int ST[];
    public static void main(String args[])
    
    {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int x=(int)Math.ceil(Math.log(n)/Math.log(2));
         int size=2*(int)Math.pow(2,x)-1;
        System.out.println(size);
      ST=new int[size];
        
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=scan.nextInt();
        }
        
        Create_Tree(arr,0,n-1,0);
        
       for(int i=0;i<size;i++)
       {
           System.out.println(i+" "+ST[i]);
       }
    }
    static int Create_Tree(int arr[],int start,int end,int index)
    {
        if(start==end)
        {
            ST[index]=arr[start];
        
            return ST[index];
        }
        int mid=(start+end)/2;
     
        ST[index]= Create_Tree(arr,start,mid,index*2+1)+Create_Tree(arr,mid+1,end,index*2+2);
        return ST[index];
    }
    
}
