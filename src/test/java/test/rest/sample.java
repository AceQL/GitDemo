package test.rest;

public class sample {

	public static void main(String[] args) {
		int a = 5002;
		int b = 60;
		
		while(a>b)
		{
			System.out.println("a is greater___________While Loop");
			break;
		}
		
		while(b>a)
		{
			System.out.println("b is greater___________While Loop");
			break;
		}
		
		System.out.println((a>b) ? "a is greater___________Ternary Operator" : "b is greater___________Ternary Operator");
		
		System.out.println("\n________________________________Febonicci Serise ________________________________\n");
		int g =0;
		int h=1;
		System.out.print(g + "   ");
		System.out.print(h + "   ");
		
		
		for(int k = h;k<=10;k++)
		{
			int i=g+h;
			System.out.print(i + "   ");
			g=h;
			h=i;
		}

	}

}
