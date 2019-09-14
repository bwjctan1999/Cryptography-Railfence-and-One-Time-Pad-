import java.util.Scanner;

public class Input 
{
	Scanner sc = new Scanner(System.in);
	
	private String input_String;
	private int input_Int;
	
	Input()
	{
		input_String = "";
	}
	
	//Setters
	public void setString() {
		this.input_String = sc.nextLine();
	}
	
	public void setInt() {
		this.input_Int = sc.nextInt();
		setString();
	}
	
	//Getters
	public String getString() {
		return input_String;
	}
	
	public int getInt() {
		return input_Int;
	}
}
