package com.hand.EXAM_2;

import java.util.Scanner;

class Exam1
{
	public int a;
	public void say(int a)
	{
		if(a<=3500)
		{
			System.out.println("所需要交纳的税费为：0");
		}
		else if (3500<a && a<=5000)
		{
		    System.out.println("所需要交纳的税费为："+(a-3500)*0.03);
		}
		else if(5000<a && a<=8000 )
		{
			System.out.println("所需要交纳的税费为："+((a-5000)*0.1+1500*0.03));
		}
		else if(8000<a && a<=12500)
		{
			System.out.println("所需要交纳的税费为："+((a-8000)*0.2+3000*0.1+1500*0.03));
		}
		else if(12500<a && a<=38500)
		{
			System.out.println("所需要交纳的税费为："+((a-12500)*0.25+4500*0.2+3000*0.1+1500*0.03));
		}
		else if(38500<a && a<=58500)
		{
			System.out.println("所需要交纳的税费为："+((a-38500)*0.3+26000*0.25+4500*0.2+3000*0.1+1500*0.03));
		}
		else if(58500<a && a<=83500)
		{
			System.out.println("所需要交纳的税费为："+((a-58500)*0.35+20000*0.3+26000*0.25+4500*0.2+3000*0.1+1500*0.03));
		}
		else
		{
			System.out.println("所需要交纳的税费为："+((a-83500)*0.45+25000*0.35+20000*0.3+26000*0.25+4500*0.2+3000*0.1+1500*0.03));
		}
	}
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.print("请输入工资：");
        Scanner scan =new Scanner(System.in);
        int a = scan.nextInt();
        Exam1 exam=new Exam1();
        exam.say(a);
    }
}
