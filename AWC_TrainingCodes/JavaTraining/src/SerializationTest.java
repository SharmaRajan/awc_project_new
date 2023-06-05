import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {
	
	public static void main(String[] args) throws IOException {
		SerializationDemo sd = new SerializationDemo(4,"abc");
		String fileName = "C:/Users/Admin/Desktop/file.txt";
		
		try {
		FileOutputStream file = new FileOutputStream(fileName);
		
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		//serialization
		out.writeObject(sd);
		
		out.close();
		file.close();
		
		}
		catch(IOException io) {
			throw io;
		}
		
		System.out.println("serialzation done");
	}
	
	

}
