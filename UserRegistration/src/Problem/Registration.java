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
}
}



