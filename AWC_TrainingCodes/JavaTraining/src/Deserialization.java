import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String fileName = "C:/Users/Admin/Desktop/file.txt";

		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			SerializationDemo sd1 = (SerializationDemo) in.readObject();

			in.close();
			file.close();
			System.out.println(sd1.name);

		} catch (IOException io) {
			throw io;

		} catch (ClassNotFoundException c) {
			throw c;
		}

	}
}
