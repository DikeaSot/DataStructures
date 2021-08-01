import java.util.Scanner;
import java.io.PrintStream;
import java.util.*;

public class SystemMenu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int answer;
		PrintStream stream=new PrintStream(System.out);
		ST st = new ST();
		
		while(true) {
			System.out.println("\nPlease, type the number of the action you want to do: \n");
			System.out.println("1: Create a new warehouse.");
			System.out.println("2: Add new book in warehouse.");
			System.out.println("3: Remove warehouse.");
			System.out.println("4: Remove book.");
			System.out.println("5: Search warehouse and print all its books.");
			System.out.println("6: Search book in a given warehouse.");
			System.out.println("7: Search book in all warehouses.");
			System.out.println("8: Print the information of all books.");
			System.out.println("0: Exit.");
			answer = in.nextInt();
			
			if(answer == 1) {
				System.out.println("Please, give the ID for the new warehouse.");
				int nodeid = in.nextInt();
				System.out.println("Please, give the location of the new warehouse.");
				String name = in.next();
				st.insertWarehouse(nodeid, name);				
			}else if (answer == 2) {
				System.out.println("Please, give the ID for the warehouse you want to add a book.");
				int nodeid = in.nextInt();
				System.out.println("Please, give the ISBN of the new book.");
				int isbn = in.nextInt();
				while(isbn<0 || isbn>9999) {
					System.out.println("The ISBN you gave is wrong! Please try again!");
					isbn = in.nextInt();
				}
				System.out.println("Please, give the number of copies.");
				int copies = in.nextInt();
				st.insertBookAtWarehouse(nodeid, isbn, copies);	
			}else if (answer == 3) {
				System.out.println("Please, type the ID of the warehouse you want to remove.");
				int nodeid=in.nextInt();
				st.removeWarehouse(nodeid);
			}else if (answer == 4) {
				System.out.println("Please, give the ID for the warehouse you want to remove a book.");
				int nodeid = in.nextInt();
				System.out.println("Please, give the ISBN of the book you want to remove.");
				int isbn = in.nextInt();
				st.removeBook(nodeid, isbn);
			}else if (answer == 5) {
				System.out.println("Please, give the ID for the warehouse you are looking for.");
				int nodeid = in.nextInt();
				st.searchByWarehouse(nodeid);
			}else if (answer == 6) {
				System.out.println("Please, give the ID for the warehouse you want ot find a book.");
				int nodeid = in.nextInt();
				System.out.println("Please, give the ISBN of the book you are looking for.");
				int isbn = in.nextInt();
				st.searchBookInWarehouse(nodeid, isbn);
			}else if (answer == 7) {
				System.out.println("Please, give the ISBN of the book you are looking for.");
				int isbn = in.nextInt();
				st.searchBook(isbn);
			}else if (answer == 8) {
				st.print‘ree(stream);
				
			}else if (answer == 0) {
				System.out.println("End program....");
				break;
			}else {
				System.out.println("You have given wrong number. Please, try again.");
				
			}
			
		}
	}
}
