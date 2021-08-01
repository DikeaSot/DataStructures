
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class TimeQueue {
	
		private int size;
		private ListNode head;
		private ListNode tail;
		private int temp_int;
		
		public class ListNode {
			private int info;
			private ListNode next;
			
			public ListNode(int info) {
				this.info=info;
			}
		}
		
		public TimeQueue() {
			this.head=null;
			this.tail=null;
			this.size=0;
			
		}
		public boolean isEmpty() {
			return size==0;
		}

		public void put(int item) {
			ListNode newNode = new ListNode(item);
			if(isEmpty()) {
				head=newNode;
			}else {
				tail.next=newNode;
			}
			tail=newNode;
			size++;
		}

		
		public int get(int j) throws NoSuchElementException{
			if(isEmpty()) throw new NoSuchElementException();
			ListNode temp=head;
			for(int i=0; i<j; i++) {
				temp=temp.next;
			}
			return temp.info;
		}


		public void printQueue(PrintStream stream) {
			if(isEmpty()) stream.println("The list is empty.");
			ListNode temp=head;
			while(temp!=null) {
				stream.println(temp.info);
				temp=temp.next;
			}
		}

		
		public int size() {
			return size;
		}
	}


