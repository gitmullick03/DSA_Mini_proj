package _2241013379_;

class Employee {
	String name,jobPosition,contactNumber;int empId;double salary;Date hireDate;Address address;
	Employee(String name,String jobPosition,String contactNumber,int empId,double salary,Date hireDate,Address address){
		this.name=name;
		this.jobPosition=jobPosition;
		this.contactNumber=contactNumber;
		this.empId=empId;
		this.salary=salary;
		this.hireDate=hireDate;
		this.address=address;
	}
	void display(int i) {
		System.out.println("\n\nInformation of Employee_"+i+": \n"
				+"Name: "+name
				+"\nUnique employee ID: "+empId
				+"\nDesignation: "+jobPosition
				+"\nDate of hiring: "+hireDate.day+"/"+hireDate.month+"/"+hireDate.year
				+"\nSalary: "+salary
				+"\nContact number: "+contactNumber
				+"\nAddress: "+address.plotNo+", "+address.street+", "+address.pinCode+", "+address.country);
	}
}

class Date{
	int day,month,year;
	Date(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
}

class Address{
	String  plotNo,street,pinCode,country;
	Address(String plotNo,String street,String pinCode,String country){
		this.plotNo=plotNo;
		this.street=street;
		this.pinCode=pinCode;
		this.country=country;
	}
}