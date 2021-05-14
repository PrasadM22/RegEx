package Problem;
import java.util.*;
import java.util.regex.*;

public class Registration {
	static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
	System.out.println("Enter The first Name");
	String Fname = sc.nextLine();
	if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Fname))
	{
		System.out.println("Name is Valid");
	}
	else
	{
		System.out.println("Invalid Name. Enter proper Name");
		
	}
	//Validate last name
	System.out.println("Enter The last Name");
	String Lname = sc.nextLine();
	if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Lname))
	{
		System.out.println("Name is Valid");
	}
	else
	{
		System.out.println("Invalid Name.Enter proper Name");
	}
	
	//Validate Email Address
	System.out.println("Enter The Email");
	var email = sc.nextLine();
	if(Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",email))
	{
		System.out.println("Email is Valid email");
	}
	else
	{
		System.out.println("Invalid email.Enter Valid Email");
	}
	
	//Validate Mobile Number
	System.out.println("Enter the Phone Number");
	String Number = sc.nextLine();

	if(Pattern.matches("^[0-9]{2}[\\s][0-9]{10}",Number))
	{
		System.out.println("Number is Valid Number");
	}
	else
	{
		System.out.println("Invalid Number.Enter Valid Number");
	}
	
	//Validate Password Rule-1
	
	System.out.println("Enter your Password");
	String Password = sc.nextLine();
	if(Pattern.matches("[A-Za-z0-9]{8,20}",Password))
	{
		System.out.println("Password is Valid ");
	}
	else
	{
		System.out.println("Invalid Passsword.Enter Valid Password");
	}
}	
}




