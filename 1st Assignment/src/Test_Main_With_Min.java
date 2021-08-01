
import java.util.*;
	public class Test_Main_With_Min {
		public static void main(String args[]) {
			
			Scanner in = new Scanner(System.in);
			String inputValue;
			CharQueueWithMinImpl queue_min=new CharQueueWithMinImpl();
			System.out.println("Please give the element you want to find the minimum character. ");
			inputValue=in.nextLine();
			
			for(int i=0; i<inputValue.length(); i++) {
				queue_min.put(inputValue.charAt(i));
			}
			char charMin=queue_min.min();
			System.out.println("The minimum character of the word " +inputValue+ " is "+charMin);
			
			
		}
	}		
	