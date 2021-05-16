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
	public String CheckfirstName(String Fname)
	{
		if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Fname))
		return "HAPPY";
		else
		return "SAD";
	}
	//Validate last name
	public String ChecklastName(String Lname)
	{
		if(Pattern.matches("[A-Z]{1}[a-z]{2,}",Lname))
		return "HAPPY";
		else
		return "SAD";
	}
	//Validate Email Address
	public String Checkemail(String email)
	{
		if(Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",email))
		return "HAPPY";
		else
		return "SAD";
	}
	//Validate Mobile Number
	public String CheckPhoneNumber(String Number)
	{
		if(Pattern.matches("^[0-9]{2}[\\s][0-9]{10}",Number))
		return "HAPPY";
		else
		return "SAD";
	}
	//Validate Password Rule-1, Rule-2, Rule-3 & Rule-4
	public String CheckPassword(String Password)
	{
		if(Pattern.matches("(?=.*[$#@!%^&*])(?=.*[0-9])(?=.*[A-Z]).{8,20}$",Password))
		return "HAPPY";
		else
		return "SAD";
	}
	
public static void main(String[] args) {

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
@Test
public void CheckfirstName()
{
	 Assert.assertEquals("HAPPY",CheckfirstName("Raghav")); 	 
}
@Test
public void ChecklastName()
{
	 Assert.assertEquals("HAPPY",ChecklastName("Shetty")); 	 
}
@Test
public void Checkemail()
{
	 Assert.assertEquals("HAPPY",Checkemail("abc.xyz@yahoo.com")); 	 
}
@Test
public void CheckPhoneNumber()
{
	 Assert.assertEquals("HAPPY",CheckPhoneNumber("91 5647962543")); 	 
}
@Test
public void CheckPassword()
{
	 Assert.assertEquals("HAPPY",CheckPassword("Abcd@321")); 	 
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
	Assert.assertEquals(expected,Checkemail(email));
}
	
}



