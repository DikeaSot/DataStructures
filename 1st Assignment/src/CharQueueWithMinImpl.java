
import java.util.NoSuchElementException;

public class CharQueueWithMinImpl implements CharQueueWithMin {
	CharDoubleEndedQueueImpl doublyLinkedList=new CharDoubleEndedQueueImpl();
	CharQueueImpl queue=new CharQueueImpl();

	public CharQueueWithMinImpl() {}

	public char min() {
		return doublyLinkedList.getFirst();
	}

	public char get() throws NoSuchElementException {
		if(queue.get()==doublyLinkedList.getFirst()) {
			doublyLinkedList.removeFirst();
		}
		return 0;
	}

	public void put(char item) {
		
		queue.put(item);
		while(true) {
			if(doublyLinkedList.isEmpty() || item>=doublyLinkedList.getLast()) {
				doublyLinkedList.addLast(item);
				break;
			}else { //item < doublyLinkedList.getLast()
				doublyLinkedList.removeLast();
			}
		}
	}
}
