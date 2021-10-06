package ass2;

import java.util.Scanner;

class Computer {
	
	Scanner sc1 = new Scanner(System.in);
	String brand;
	String model;
	static int serial=0;
	int SN;
	int price;
	int count = 0;
	
	
	Computer()
	{
		
	}
	
	void createComp()
	{
		System.out.println("Enter computer brand - ");
		brand = sc1.nextLine();
		System.out.println("Enter computer model - ");
		model = sc1.nextLine();
		System.out.println("serial number is "+ serial);
		SN = serial;
		serial++;
		System.out.println("Enter computer price - ");
		price = Integer.parseInt(sc1.nextLine());
	}
	
	void getData(int i)
	{
		//System.out.println("What do you want to do?");
		System.out.println("Computers #" + i);
		System.out.println("Brand: "+ this.brand);
		System.out.println("Model: "+ this.model);
		System.out.println("SN: " +this.SN);
		System.out.println("Price: "+this.price);
		System.out.println("please enter your choice >");

	}
	
	void updateBrand()
	{
		System.out.println("enter new brand - ");
		this.brand = sc1.nextLine();
		System.out.println("updated successfully");
	}
	void updateModel()
	{
		System.out.println("enter new model - ");
		this.model = sc1.nextLine();
		System.out.println("updated successfully");
	}
	void updatePrice()
	{
		System.out.println("enter new price - ");
		this.price = Integer.parseInt(sc1.nextLine());
		System.out.println("updated successfully");
	}
	public static void print()
	{
		System.out.println("What do you want to do?");
		System.out.println("	1. Enter new Computers(password required)");
		System.out.println("	2. Change information of computer");
		System.out.println("	3. Display all computer by specific brand");
		System.out.println("	4. Display all computers under a certain price");
		System.out.println("	5. Quit");
		System.out.println("please enter your choice >");
	}	
}


class Create
{
	final String password = "password";
	int maxComputer;
	static int objectNum = 0;
	Scanner sc2 = new Scanner(System.in);
	Computer[] c1;
	
	public void funSwitch(int number)
	{
		switch(number)
		{
			case 1:
				function1();
				break;
			case 2:
				function2();
				break;
			case 3:
				function3();
				System.out.println();
				break;
			case 4:
				function4();
				System.out.println();
				break;
			case 5:
				function5();
				break;
			default:
				break;		
		}
	}
	
	public void function1()
	{
		int count = 0;
		boolean b= false;
		int i=0;
		while(i<3)
		{
			System.out.println("Enter Password:- ");
			String passwordEnt = sc2.nextLine();
			if(passwordEnt.equals(password))
			{
				b=true;
				if(objectNum <= maxComputer)
				{
					c1[objectNum] = new Computer();
					c1[objectNum].createComp();
					objectNum++;
					loopWhile();
				}
				else
				{
					System.out.println("you reached your capacity");
				}
				
			}
			else
			{
				i++;
			}
			if(b)
			{
				break;
			}
		}
		if(!b)
		{
			loopWhile();
		}
	}
	public void function2()
	{
		int count = 0;
		boolean b= false;
		int i=0;
		while(i<3)
		{
			System.out.println("Enter Password:- ");
			String passwordEnt = sc2.nextLine();
			if(passwordEnt.equals(password))
			{
				System.out.println("For which Computer you want to change data - ");
				int enter = Integer.parseInt(sc2.nextLine());
				b=true;
				if(enter < objectNum)
				{
					c1[enter].getData(enter);
					System.out.println("What information would you like to change?");
					System.out.println("	1.brand");
					System.out.println("	2.model");
					System.out.println("	3.SN");
					System.out.println("	4.price");
					System.out.println("	5. Quit");
					System.out.println("Enter you choice >");
					int enterNum = Integer.parseInt(sc2.nextLine());
					switch(enterNum)
					{
						case 1:
							c1[enter].updateBrand();
							c1[enter].getData(enter);
							break;
						case 2:
							c1[enter].updateModel();
							c1[enter].getData(enter);
							break;
						case 3:
							updateSN();
						case 4:
							updatePrice();
						case 5:
							break;
					}
					loopWhile();
				}
				else
				{
					System.out.println("Oops! Not exist.");
					System.out.println("If you want to enter new computer - enter 1 else press 2 ");
					enter = Integer.parseInt(sc2.nextLine());
					if(enter == 1)
					{
						function1();
					}
					else
					{
						loopWhile();
					}
				}
				
			}
			else
			{
				i++;
			}
			if(b)
			{
				break;
			}
		}
		if(!b)
		{
			loopWhile();
		}
	}
	public void function3()
	{
		System.out.println("In funtion 3");
		//in function3
	}
	public void function4()
	{
		System.out.println("In funtion 4");
		//in function4
	}
	public void function5()
	{
		System.out.println("Good bye!!");
		//in function5
	}	
	
	public static void print()
	{
		System.out.println("What do you want to do?");
		System.out.println("	1. Enter new Computers(password required)");
		System.out.println("	2. Change information of computer");
		System.out.println("	3. Display all computer by specific brand");
		System.out.println("	4. Display all computers under a certain price");
		System.out.println("	5. Quit");
		System.out.println("please enter your choice >");
	}
	
	public void setComputer()
	{
		Scanner temp = new Scanner(System.in);
		maxComputer=temp.nextInt();
		c1 = new Computer[maxComputer];
	}
	
	public void loopWhile()
	{
		Scanner sc = new Scanner(System.in);
		print();		
		int number = sc.nextInt();
		while(number<1 || number>5)
		{
			print();
			number = sc.nextInt();
		}
		funSwitch(number);
	}
	public static void main(String[] args)
	{
		
		System.out.println("Welcome!");
		System.out.println("Enter you stores capacity of in terms of max computer:- ");
		Create cr1 = new Create();
		cr1.setComputer();				
		cr1.loopWhile();
		
		//cr1.funSwitch(number);		
		//sc.close();
	}
}