import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWrite {
	public byte[] readFile(String File) {
		byte[] data = null;
		
		try {
			data = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File));		
		} catch (IOException e) {
			System.out.println("File Loading Failed!");
			e.printStackTrace();
		}	
		
		return data;
	}
	
	
	public void writeFile(byte[] data, String File) {
		try {
			Files.write(Paths.get(System.getProperty("user.dir") + File), data);
		} catch (IOException e) {
			System.out.println("File Saving Failed!");
			e.printStackTrace();
		}
	}
}
