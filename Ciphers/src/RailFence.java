
public class RailFence implements Cryptography {

	ReadWrite rw = new ReadWrite();
	Input in = new Input();
	
	public byte[] encrypt(byte[] data, String passkey) {
		
		byte[] encryption = new byte[data.length];
		int key = Integer.parseInt(passkey);
		
		byte[][] RailEnc = new byte[key][data.length];
		
		boolean reachedLastRow = false;
		int columns = 0;
		int rows = 0;
		
		while(columns != encryption.length) {
			
			RailEnc[rows][columns] = (byte) (data[columns]);
			columns += 1;
			
			if(reachedLastRow == false && rows == key-1) 
			{
				reachedLastRow = true;
			}else if(reachedLastRow == true && rows == 0) {
				reachedLastRow = false;
			}
			
			
			if(reachedLastRow == false) {
				rows += 1;
			} else{
				rows -= 1;
			}
		}
		
		int nextIndex = 0;
		for(int x = 0; x < key; x++) {
			for(int y = 0; y < encryption.length; y++) {
				if(RailEnc[x][y] != 0) {
					encryption[nextIndex] = (byte) (RailEnc[x][y]);
					nextIndex +=1;
				}
			}
		}
		
		System.out.println("file: " + data.length);
		System.out.println("encryption: " + encryption.length);
		
		return encryption;
	}

	
	public byte[] decrypt(byte[] data, String passkey) {
		
		byte[] decryption = new byte[data.length];
		int key = Integer.parseInt(passkey);
	
		byte[][] RailDec = new byte[key][data.length];
		
		boolean reachedLastRow = false;
		int columns = 0;
		int rows = 0;
		
		while(columns != decryption.length) {
			
			RailDec[rows][columns] = 1;
			columns += 1;
			
			if(reachedLastRow == false && rows == key-1) 
			{
				reachedLastRow = true;
			}else if(reachedLastRow == true && rows == 0) {
				reachedLastRow = false;
			}
			
			
			if(reachedLastRow == false) {
				rows += 1;
			} else{
				rows -= 1;
			}
		}
		
		int nextIndex = 0;
		for(int x = 0; x < key; x++) {
			for(int y = 0; y < decryption.length; y++) {
				if(RailDec[x][y] != 0) {
					RailDec[x][y] = (byte) (data[nextIndex]);
					nextIndex += 1;
				}
			}
		}
		
		rows = 0;
		columns = 0;
		
		while(columns != decryption.length) {
			
			decryption[columns] = (byte) (RailDec[rows][columns]);
			columns += 1;
			
			if(reachedLastRow == false && rows == key-1) 
			{
				reachedLastRow = true;
			}else if(reachedLastRow == true && rows == 0) {
				reachedLastRow = false;
			}
			
			
			if(reachedLastRow == false) {
				rows += 1;
			} else{
				rows -= 1;
			}
		}
		
		System.out.println("decryption: " + decryption.length);
		
		System.out.println("file: " + data.length);
		return decryption;
	}

	
	public void run() {
		
		String FileName;
		String FileType;
		String Key;
		
		System.out.println("\nRailFence Encryptor:");
		System.out.println("[1] Encrypt a Binary File");
		System.out.println("[2] Encrypt a Plaintext");
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
					
			case 2: 
					break;
					
			case 3: System.out.print("File Name: ");
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
