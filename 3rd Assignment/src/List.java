import java.io.PrintStream;
import java.util.NoSuchElementException;


	public class List {
	
		private int size;
		private ListNode head;
		private ListNode tail;
		private BookInfo temp_info;
		
		public class ListNode {
			private BookInfo info;
			private ListNode next;
			
			public ListNode(BookInfo info) {
				this.info=info;
			}
		}
		
		public List() {
			this.head=null;
			this.tail=null;
			this.size=0;
			
		}
		public boolean isEmpty() {
			return size==0;
		}

		public void put(BookInfo item) {
			
			//sorted linked list
			
			
			 ListNode current;
			 ListNode newNode = new ListNode(item);
	         
	         if (head == null || head.info.getISBN() >= newNode.info.getISBN()){
	        	 newNode.next = head;
	            head = newNode;
	         }else {
	            current = head;
	            while (current.next != null && current.next.info.getISBN() < newNode.info.getISBN()) {
	                  current = current.next;
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	         }
	         size++;
		}
		
		public BookInfo get(int j) throws NoSuchElementException{
			if(isEmpty()) throw new NoSuchElementException();
			ListNode temp=head;
			for(int i=0; i<j; i++) {
				temp=temp.next;
			}
			return temp.info;
		}
		
		public BookInfo remove(int j) throws NoSuchElementException{
			if(isEmpty()) throw new NoSuchElementException();
			ListNode temp=head;//the previous node from the one we want to remove
			
			if (j==0){
				head.info.setCopies(-1);
				if(head.info.getCopies()==0){
				head=head.next;
				temp_info=temp.info;
				temp=head;
				--size;
				
				}
			}else{
			for(int i=0; i<j; i++) {
				if(i==j-1) {
					break;
				}
				temp=temp.next;
			}
			temp.info.setCopies(-1);
			if(temp.info.getCopies()==0){
			temp_info=temp.next.info;//data from the node we want to remove
			temp.next=temp.next.next;
			--size;
			}
			
			}
			return temp_info;
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


