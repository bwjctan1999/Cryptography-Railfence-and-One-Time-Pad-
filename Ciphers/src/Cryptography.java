
public interface Cryptography
{
	byte[] encrypt(byte[] data, String key);
	
	byte[] decrypt(byte[] data, String key);
	
	void run();
}
