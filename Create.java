package ass2;

import java.util.Scanner;

//Computer class
class Computer {
	
	Scanner sc1 = new Scanner(System.in);
	String brand;
	String model;
	static long serial=0;
	long SN;
	int price;
	int count = 0;
	
	//Setter method for all variable
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
	
	//printing data for particular objects
	void getData(int i)
	{
		//System.out.println("What do you want to do?");
		System.out.println("Computers #" + i);
		System.out.println("Brand: "+ this.brand);
		System.out.println("Model: "+ this.model);
		System.out.println("SN: " +this.SN);
		System.out.println("Price: "+this.price);
		//System.out.println("please enter your choice >");

	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	//update methods
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
	void updateSN()
	{
		System.out.println("enter new model - ");
		this.SN = Integer.parseInt(sc1.nextLine());
		System.out.println("updated successfully");
	}
	void updatePrice()
	{
		System.out.println("enter new price - ");
		this.price = Integer.parseInt(sc1.nextLine());
		System.out.println("updated successfully");
	}
	
//	//Dialog box printing
//	public static void print()
//	{
//		System.out.println("What do you want to do?");
//		System.out.println("	1. Enter new Computers(password required)");
//		System.out.println("	2. Change information of computer");
//		System.out.println("	3. Display all computer by specific brand");
//		System.out.println("	4. Display all computers under a certain price");
//		System.out.println("	5. Quit");
//		System.out.println("please enter your choice >");
//	}	
}

// main class
class Create
{
	final String password = "password";
	int maxComputer;
	static int objectNum = 0;
	Scanner sc2 = new Scanner(System.in);
	Computer[] c1;
	
	//function holding switch method
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
				break;
			case 4:
				function4();
				break;
			case 5:
				function5();
				break;
			default:
				break;		
		}
	}
	
	//switch method function 1
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
	
	//switch method function 2 
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
					System.out.println("	5.Quit");
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
							c1[enter].updateSN();
							c1[enter].getData(enter);
						case 4:
							c1[enter].updatePrice();
							c1[enter].getData(enter);
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
	
	//switch method function 3
	public void function3()
	{
		System.out.println("Enter brand you are looking for - ");
		String brandName = sc2.nextLine();
		for(int i=0;i<objectNum;i++)
		{
			if(brandName.equals(c1[i].getBrand()))
			{
				c1[i].getData(i);
			}
		}
		loopWhile();
	}
	
	//switch method function 4
	public void function4()
	{
		//sc2.nextLine();
		System.out.println("Enter the price - ");
		int price = Integer.parseInt(sc2.nextLine());
		for(int i=0;i<objectNum;i++)
		{
			if(price>(c1[i].getPrice()))
			{
				c1[i].getData(i);
			}
		}
		loopWhile();
		//in function4
	}
	
	//switch method function 5
	public void function5()
	{
		System.out.println("Good bye!!");
		//in function5
	}	
	
	//Dialog box printing
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
	
	//Getting store capacity and creating array for tracing
	public void setComputer()
	{
		Scanner temp = new Scanner(System.in);
		maxComputer=temp.nextInt();
		c1 = new Computer[maxComputer];
	}
	
	//While loop for dialog box
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
	
	//main method
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