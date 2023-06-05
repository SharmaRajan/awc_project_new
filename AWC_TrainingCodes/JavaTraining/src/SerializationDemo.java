import java.io.Serializable;

public class SerializationDemo implements Serializable {
	
	private static final long serialversionUID =1L;
	
	public int a;
	public String name;
	
	public SerializationDemo() {
	}

	public SerializationDemo(int a, String name) {
		super();
		this.a = a;
		this.name = name;
	}
	

	
}
