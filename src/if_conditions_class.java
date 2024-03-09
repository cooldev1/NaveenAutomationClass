import java.util.Scanner;

public class if_conditions_class {

	public static void main(String[] args) {
		//int a = 10;
		
		//if statements 
	/*	if(a==10)
		{
			System.out.println("yes a is equal to 10");
				if(a<20)
				{
					System.out.println("a is let then 20");
					if(a>5) 
					{
						System.out.println("a is grater then 5");
						if(a<5) 
						{
							System.out.println("a is lesthen 5");
							if(a!=10)
							{
								System.out.println("a is graterthen and equel to 11");
							}
						}
					}
				}
			
		}*/
		
		//if-else statment
		
		/*if(a==10) 
		{
			System.out.println("yes a is equal to 10");
		}
		else 
		{
			System.out.println("No a is not equal to 10");
		} */

		//if else ladder
		
		Scanner scan = new Scanner(System.in); //for input we use System.in
		System.out.println("Enter your number");
		int num = scan.nextInt();
		//System.out.println(num);
		
		//print Name
		System.out.println("Enter Your Name");
		//String cname = scan.nextLine();
		String cname = scan.next();
		System.out.println(cname);
		
		if(num >=30 && num<=40)
			{
				System.out.println("Thirt Div pass");
			}
		else if(num >40 && num<60 ) 
			{
				System.out.print("second div pass");
			}
		else if(num>=60 && num<=80) 
			{
				System.out.print("First class pass");
			}
		else if(num>80)
			{
			 System.out.print("You got more then 80%, Distintion");
			}
		else 
			{
				System.out.println("Faild");
			}
	} 
		
}
