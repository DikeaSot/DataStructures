
import java.util.NoSuchElementException; 

public interface CharQueueWithMin {
	public char min();
	
	public char get() throws NoSuchElementException;
	
	public void put(char item);
	
}
