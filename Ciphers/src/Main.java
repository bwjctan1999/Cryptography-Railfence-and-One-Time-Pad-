
public class Main 
{
	public static void main(String args[]) 
	{
		RailFence rf = new RailFence();
		Test test = new Test();
		Input in = new Input();
		
		System.out.println("BINARY FILE ENCRYPTOR AND DECRYPTOR\n");
		System.out.println("Classical Encryption Methods:");
		System.out.println("[1] RailFence");
		System.out.println("[2] One-Time Pad");
		System.out.println("[3] Test");
		System.out.print("?: ");
		
		in.setInt();	
		switch(in.getInt()) 
		{
			case 1: rf.run();
					break;
					
			case 2:
					break;
					
			case 3: test.run();
					break;
		}
	}
}
