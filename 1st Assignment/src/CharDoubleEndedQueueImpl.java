import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharDoubleEndedQueueImpl implements CharDoubleEndedQueue{
	private int size;
	private Node head;
	private Node tail;
	
	public class Node {
		private char info;
		private Node next;
		private Node previous;
		
		public Node(char info) {
			this.info=info;
		}
		
	}
	
	
	public CharDoubleEndedQueueImpl() {
		this.head=null;
		this.tail=null;
		this.size=0;
		
	}

	
	public boolean isEmpty() {
		return size==0;
	}
		
	/**
	 * insert a character at the front of the queue
	 */
	public void addFirst(char item) {
		Node newNode= new Node(item);
		if(isEmpty()) {
			tail=newNode;
		}else {
			head.previous=newNode;
		}
		newNode.next=head;
		head=newNode;
		size++;
	}

	/**
	 * remove and return a character from the front of the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char removeFirst() throws NoSuchElementException{
		if(isEmpty()) throw new NoSuchElementException();
		
		Node temp=head;
		if(head==tail) {
			tail=null;
		}else {
			head.next.previous=null;
		}
		head=head.next;
		temp.next=null;
		size--;
		return temp.info;
	}

	/**
	 * insert a character at the end of the queue
	 */
	public void addLast(char item) {
		Node newNode= new Node(item);
		if(isEmpty()) {
			head=newNode;
		}else {
			tail.next=newNode;
		}
		newNode.previous=tail;
		tail=newNode;
		size++;
	}

	/**
	 * remove and return a character from the end of the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char removeLast() throws NoSuchElementException{
		if(isEmpty()) throw new NoSuchElementException();
		Node temp=tail;
		if(head==tail) {
			head=null;
		}else {
			tail.previous.next=null;
		}
		tail=tail.previous;
		temp.previous=null;
		size--;
		return temp.info;
	}
	
	/**
	 * return without removing the first item in the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char getFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		return head.info;
	}

	/**
	 * return without removing the last item in the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public char getLast() {
		if(isEmpty()) throw new NoSuchElementException();
		return tail.info;
	}
	
	
	/**
	 * print the elements of the queue, starting from the front, 
     	 * to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream) {
		if(isEmpty()) stream.println("The list is empty.");
		Node temp=head;
		while(temp!=null) {
			stream.println(temp.info);
			temp=temp.next;
		}
	}

	/**
	 * return the size of the queue, 0 if empty
	 * @return number of elements in the queue
	 */
	public int size() {
		return size;
	}
}


