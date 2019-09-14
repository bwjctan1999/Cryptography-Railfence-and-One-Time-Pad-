
public class Test implements Cryptography {

	ReadWrite rw = new ReadWrite();
	Input in = new Input();
	
	
	public byte[] encrypt(byte[] data, String key) {
		byte[] enc = new byte[data.length];
		
		for(int i = 0; i < data.length; i++) 
		{		
			enc[i] = (byte) ((i % 2 == 0) ? data[i] + 1 : data[i] - 1);
		}
		
		return enc;
	}


	public byte[] decrypt(byte[] data,String key) {
		byte[] enc = new byte[data.length];
		
		for(int i = 0; i < data.length; i++) 
		{
			enc[i] = (byte) ((i % 2 == 0) ? data[i] - 1 : data[i] + 1);
		}
		
		
		return enc;
	}

	
	public void run() {
		
			String FileName;
			String FileType;
			String Key;
			
			System.out.println("[1] Encrypt a Binary File");
			System.out.println("[3] Decrypt an Encryption");
			System.out.print("?: ");
				
			in.setInt();
			switch(in.getInt()) {
				
				case 1: System.out.print("FileName?: ");
				
						in.setString();
						FileName = in.getString();
						
						System.out.print("File Type: ");
						in.setString();
						FileType = in.getString();
						
						System.out.print("Key?: ");
						in.setString();
						Key = in.getString();
						
						byte[] encrypted = encrypt(rw.readFile("/Files/" + FileName + "." + FileType), Key);
						
						rw.writeFile(encrypted, ("/Encryptions/" + FileName + "." + FileType));
						break;

						
				case 2: System.out.print("File Name: ");
						in.setString();
						FileName = in.getString();
						
						System.out.print("File Type: ");
						in.setString();
						FileType = in.getString();
				
						System.out.print("Key?: ");
						in.setString();
						Key = in.getString();
					
						byte[] decrypted = decrypt(rw.readFile("/Encryptions/" + FileName + "." + FileType), Key);
						rw.writeFile(decrypted, ("/Decryptions/" + FileName + "." + FileType));
						break;
			}
		}
}
