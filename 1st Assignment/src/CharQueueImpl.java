import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharQueueImpl implements CharQueue {
	private int size;
	private ListNode head;
	private ListNode tail;
	private char temp_char;
	
	public class ListNode {
		private char info;
		private ListNode next;
		
		public ListNode(char info) {
			this.info=info;
		}
	}
	
	public CharQueueImpl() {
		this.head=null;
		this.tail=null;
		this.size=0;
		
	}
	public boolean isEmpty() {
		return size==0;
	}

	/**
	 * insert a single character to the queue
	 */
	public void put(char item) {
		ListNode newNode = new ListNode(item);
		if(isEmpty()) {
			head=newNode;
		}else {
			tail.next=newNode;
		}
		tail=newNode;
		size++;
	}

	/**
 	 * remove and return the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char get() throws NoSuchElementException{
		if(isEmpty()) throw new NoSuchElementException();
		ListNode temp=head;
		head=head.next;
		temp_char=temp.info;
		temp=null;
		return temp_char;
	}

	/**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char peek() throws NoSuchElementException{
		if(isEmpty()) throw new NoSuchElementException();
		return head.info;
	}


	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream) {
		if(isEmpty()) stream.println("The list is empty.");
		ListNode temp=head;
		while(temp!=null) {
			stream.println(temp.info);
			temp=temp.next;
		}
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	public int size() {
		return size;
	}
}

