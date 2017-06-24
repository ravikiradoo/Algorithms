import java.util.*;

class knapsack
{

public static void main(String args[])

{
Scanner scan = new Scanner(System.in);

System.out.println("Enter number of items ");

int n=scan.nextInt();

int weight[]=new int[n+1];
int value[]=new int[n+1];

System.out.println("Please Enter weight of an item and corresponding value of item ");

for(int j=1;j<=n;j++)
{
	weight[j]=scan.nextInt();
	value[j]=scan.nextInt();
}

System.out.println("Enter Macximum weight  ");


int W=scan.nextInt();

int table[][]=new int[n+1][W+1];

for(int i=0;i<=n;i++)
{
	for(int j=0;j<=W;j++)
	{
		if(j==0||i==0)
			table[i][j]=0;
		else
		{
			table[i][j]=table[i-1][j];
			if(weight[i]<=j)
			{
				table[i][j]=Math.max(value[i]+table[i-1][j-weight[i]],table[i-1][j]);
			}
		}
	}
}
String Ans="";
for(int i=1;i<=n;i++)
{
	for(int j=1;j<=W;j++)
	{
		System.out.print(table[i][j]+" ");
	}
	System.out.println();
}


}

}