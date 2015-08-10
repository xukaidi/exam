package com.hand.EXAM_1;

class A
{
	public int a=0;
	public int count =0;
	public void print()
	{
		int c[]= new int[100];

		for(a=101;a<=200;a++)
		{
			for(int b=2;b<a;b++)
			{
				if(a%b!=0){
					if(b==a-1)
						{
						    c[count]=a; 
						    count++;
						    break;
						}
					continue;
					}
				else 
				{
					break;
				}
			}
		}
		System.out.println("101-200间总共有"+count+"个素数，分别是：");
		for(int i=0;i<count;i++)
		{
		     System.out.print(c[i]+"  ");
		}
	}
		
}
public class App 
{
    public static void main( String[] args )
    {
        A a =new A();
        a.print();
    }
}
