package _2241013379_;
import java.util.Scanner;
public class Test {
	static Scanner k=new Scanner(System.in);
	public static void main(String []bold) {
		System.out.print("Enter the number of employees for database: ");
		int n=k.nextInt();
		k.nextLine();
		Employee e[]=new Employee[n];
		for (int i=0;i<e.length;i++) {
			System.out.println("\nEmployee_"+(i+1)+"----");
			System.out.print("Enter name: ");
			String name=k.nextLine();
			System.out.print("Enter unique employee ID: ");
			int empId=k.nextInt();
			System.out.print("Enter designation: ");
			k.nextLine();
			String jobPosition=k.nextLine();
			System.out.print("Enter date of hiring (dd-mm-yyyy): ");
			int dd=k.nextInt(), mm=k.nextInt(), yyyy=k.nextInt();
			Date hireDate=new Date(dd,mm,yyyy);
			System.out.print("Enter salary: ");
			double salary=k.nextDouble();
			System.out.print("Enter contact number with a space between the country code and number (<country code> <number>): ");
			k.nextLine();
			String contactNumber=k.nextLine();
			System.out.print("Enter address of employee-- "
					+ "\nPlot no.:");String pln=k.nextLine();
			System.out.print("Street: ");String street=k.nextLine();
			System.out.print("Pin code: ");String pinCode=k.nextLine();
			System.out.print("Country: ");String country=k.nextLine();
			Address address=new Address(pln,street,pinCode,country);
			e[i]=new Employee(name,jobPosition,contactNumber,empId,salary,hireDate,address);
			k.nextLine();
		}
		System.out.println("Input Successful...\n\n");
		arrangeEmployeeBySalary(e);
		System.out.print("Enter the requisite designation to display respective employee details: ");
		String jp=k.nextLine();k.nextLine();
		getEmployeesByJobPosition(e,jp);
		System.out.print("\n\nEnter the range of date in which employees were hired---"
				+ "\nEnter first date: ");
		int dd1=k.nextInt(), mm1=k.nextInt(), yyyy1=k.nextInt();
		System.out.print("Enter second date: ");
		int dd2=k.nextInt(), mm2=k.nextInt(), yyyy2=k.nextInt();
		Date d1=new Date(dd1,mm1,yyyy1),d2=new Date(dd2,mm2,yyyy2);
		getEmployeesByHireDate(e,d1,d2);
		System.out.println("Number of foreign employees are "+foreignEmployeeCount(e));
		System.out.print("\n\nEnter the range of salary to find the employees with respective salaries: "
				+ "\nEnter the lower limit: ");
		double s1=k.nextDouble();
		System.out.print("Enter the upper limit: ");
		double s2=k.nextDouble();
		getEmployeesBySalary(e,s1,s2);
	}
	
	public static void arrangeEmployeeBySalary(Employee e[]) {
		for (int i=0;i<e.length-1;i++) {
			for (int j=i+1;j<e.length;j++) {
				if (e[i].salary<e[j].salary) {
					Employee t=e[i];
					e[i]=e[j];
					e[j]=t;
				}
			}
		}
	}
	
	public static void getEmployeesByJobPosition(Employee e[], String jp) {
		System.out.println("Details of employees with designation: "+jp);
		for (int i=0;i<e.length;i++) {
			if(e[i].jobPosition.equalsIgnoreCase(jp)) {
				e[i].display(i+1);
			}
		}
	}
	
	public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2) {
		System.out.println("\nDetails of employees hired between "+d1.day+"-"+d1.month+"-"+d1.year+" and "+d2.day+"-"+d2.month+"-"+d2.year+"--\n");
		for (int i=0;i<e.length;i++) {
			if ((e[i].hireDate.year>=d1.year)&&(e[i].hireDate.year<=d2.year)) {
				if ((e[i].hireDate.month>=d1.month)&&(e[i].hireDate.month<=d2.month)) {
					if ((e[i].hireDate.day>=d1.day)&&(e[i].hireDate.day<=d2.day)) {
						e[i].display(i+1);
					}
				}
			}
		}
	}
	
	public static int foreignEmployeeCount(Employee e[]) {
		int c=0;
		for (int i=0;i<e.length;i++) {
			if ((e[i].contactNumber.substring(0,3)!="+91")||(e[i].contactNumber.substring(0,2)!="91")){
				c++;
			}
		}
		return c;
	}
	
	public static void getEmployeesBySalary(Employee e[], double s1, double s2) {
		System.out.println("Details of employees having salary in range "+s1+" to "+s2+"--\n");
		for (int i=0;i<e.length;i++) {
			if (e[i].salary>=150000.0 && e[i].salary<=300000.0) {
				e[i].display(i+1);
			}
		}
	}
}
