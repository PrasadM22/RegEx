package Problem;
import java.util.*;
import java.util.regex.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Registration {
	static Scanner sc = new Scanner(System.in);
	//Validate First Name
	public static void CheckfirstName(String Fname) throws InvalidDetailException
	{
		if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Fname))
		System.out.println("First Name Validate");
		else 
		throw new InvalidDetailException("Invalid  First Name Exception");
	}
	//Validate last name
	public static void ChecklastName(String Lname) throws InvalidDetailException
	{
		if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Lname))
		System.out.println("Last Name Validate");
		else
		throw new InvalidDetailException("Invalid Last Name Exception");
	}
	//Validate Email Address
	public static void Checkemail(String email) throws InvalidDetailException
	{
		if(Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",email))
			System.out.println("email Validate");
		else
			throw new InvalidDetailException("Invalid Email Exception");
	}
	
	//Validate Mobile Number
	public static void CheckPhoneNumber(String Number) throws InvalidDetailException
	{
		if(Pattern.matches("^[0-9]{2}[\\s][0-9]{10}",Number))
		System.out.println("Phone Number Validate");
		else
			throw new InvalidDetailException("Invalid Phone Number Exception");
	}
	//Validate Password Rule-1, Rule-2, Rule-3 & Rule-4
	public static void CheckPassword(String Password) throws InvalidDetailException
	{
		if(Pattern.matches("(?=.*[$#@!%^&*])(?=.*[0-9])(?=.*[A-Z]).{8,20}$",Password))
		System.out.println("Password Validate");
		else
			throw new InvalidDetailException("Invalid Password Exception");
	}
	
public static void main(String[] args){
	
	try {CheckfirstName("raghave");}catch(InvalidDetailException e){
		System.out.println(e.getMessage());
		}
	try {ChecklastName("shetty");}catch(InvalidDetailException e){
		System.out.println(e.getMessage());
		}
	try {Checkemail("abc.xyz@yahoo.com");}catch(InvalidDetailException e){
		System.out.println(e.getMessage());
		}
	try {CheckPhoneNumber("9656478569");}catch(InvalidDetailException e){
		System.out.println(e.getMessage());
		}
	try {CheckPassword("Abcd@321");}catch(InvalidDetailException e){
		System.out.println(e.getMessage());
		}

	//Checking all Email's Sample Separately
	ArrayList<String> emails = new ArrayList<String>();
	//Valid Email's
	emails.add("abc@yahoo.com");
	emails.add("abc.100@yahoo.com");
	emails.add("abc.100@yahoo.com");
	emails.add("abc111@abc.com");
	emails.add("abc-100@abc.net");
	emails.add("abc.100@abc.com.au");
	emails.add("abc@1.com");
	emails.add("abc+100@gmail.com");
	emails.add("abc@yahoo.com.com");
	
	//Invalid Email's
	emails.add("abc@.yahoo.com");
	emails.add("abc123@%*.com");
	
	String regex="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	
	Pattern pattern = Pattern.compile(regex);
	
	for(String mail : emails) {
		Matcher matcher = pattern.matcher(mail);
	    System.out.println(mail +" : "+ matcher.matches());
	}
 
}

//Parameterized Test cases

private String expected;
private String email;
public Registration(String expected,String email)
{
	this.expected=expected;
	this.email= email;
}

@Parameterized.Parameters
public static Collection<Object[]> input() {
    return Arrays.asList(new Object[][] { 
     { "HAPPY", "abc@yahoo.com" },{ "SAD", "abc@.com.my" },
     { "HAPPY", "abc-100@com" }, { "SAD",  "abc123@gmail.a" },
     { "HAPPY", "abc.100@yahoo.com"},{ "SAD", "abc123@com" },
     { "HAPPY", "abc111@abc.com" },{ "SAD" , "abc()*@gmail.com" },
     { "HAPPY", "abc-100@abc.net" },{ "SAD", "abc@%*.com" },
     { "HAPPY", "abc.100@abc.com.au" },{ "SAD", "abc..2002@gmail.com" },
     { "HAPPY",  "abc@1.com" },    { "SAD", "abc@gmail.com.1a" },
     { "HAPPY",  "abc+100@gmail.com" }
    });
}

@Test
public void testemail()
{
	Assert.assertEquals(expected,Checkmail(email));
}
public  String Checkmail(String email) 
{
	if(Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",email))
		return "HAPPY";
	else
		return "SAD";
}
	
}



