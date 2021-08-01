import java.io.PrintStream;
import java.util.NoSuchElementException;

public class ST {
	TreeNode warehouse = new TreeNode();
	private TreeNode head;
	private int size;
	private class TreeNode{
		
		private TreeNode() {}
		
		private int id;
		private String city;
		private TreeNode l;
		private TreeNode r;
		TreeNode parent;
		private int N;
		List booklist;
		
		private TreeNode(int id , String city) {
			this.id=id;
			this.city=city;
			booklist=new List();
		}
		
		protected void unlink() {
			id = 0;
			head = l = r = null;
	    }
		
		private int getN() {
			N=0;
			if(l!=null) N++;
			if(r!=null) N++;
			return N;
		}

		private void setBooklist(int isbn, int copies) {
			boolean flag=false;
			for(int i=0; i < booklist.size(); i++) {
				BookInfo temp = new BookInfo();
				temp=booklist.get(i);
				if (isbn == temp.getISBN()) {
					temp.setCopies(copies);
					flag=true;
				}
			}
			
			if(!flag) { 
				BookInfo book = new BookInfo(isbn,copies);
				booklist.put(book);
			}
		}
		
		private int searchBooklist(int isbn) {
			int pos=-1; //the book is not in the list
			for(int i=0; i < booklist.size(); i++) {
				BookInfo temp = new BookInfo();
				temp=booklist.get(i);
				if (isbn == temp.getISBN()) {
					pos = i;
					break;
				}
			}
			return pos;
		}
		
		private void printList(int key, String name) {
			System.out.println("Warehouse " + key+ " located in " + name + ": \n");
			for(int i=0; i < booklist.size(); i++) {
				BookInfo temp = new BookInfo();
				temp= booklist.get(i);
				System.out.println("Book: " + temp.getISBN() + ", copies:" + temp.getCopies() + "\n"); 
			}
		}
		
		public int key() {
			return id;
		}
		
		public String name() {
			return city;
		}
	}


	public void insert (int id, String city){
		head=insert(head,id,city);
	}
	 
	public TreeNode insert(TreeNode h, int id, String city){
		if (id <0) throw new IllegalArgumentException();
		TreeNode n = head;
		TreeNode p = null;
		if(h==null){
			++size;
			return new TreeNode(id,city);
		}
		if(Math.random()*(h.getN()+1)<1.0) return insertT(h,id,city);
		int result = compare(id,n.id);
		if(result == 0){
			System.out.println("The warehouse is already in the tree!!!\n");
	        return null;
		}else if(result==-1){
			h.l=insertR(h.l,id,city);
		}else{
			h.r=insertR(h.r,id,city);
		}
		++size;
		return h;
	}
		
	private TreeNode insertR(TreeNode h, int id, String city){
		if (id == 0) throw new IllegalArgumentException();
		TreeNode n = head;
		TreeNode p = null;
		int result = 0;
		if(h ==null){ 
			++size;
			return new TreeNode(id,city);
		}
		result = compare(id,n.id);
		if (result==-1){
			h.l =insertR(h.l,id,city);
		}else{
			h.r=insertR(h.r,id,city);
		}
		++size;
		return h;
	}
		
	private TreeNode insertT(TreeNode h, int id, String city){
		if(h==null){
			++size;
			return new TreeNode(id,city);
			}
		int result = compare(id,h.id);
		if (result==-1){
			h.l=insertT(h.l,id,city);
			h=rotateRight(h);
		}else{
			h.r=insertT(h.r,id,city);
			h=rotateLeft(h);
		}
		++size;
		return h;
	}
	
	private TreeNode rotateLeft(TreeNode pivot) {
		TreeNode parent = pivot.parent;
	    TreeNode child = pivot.r;
	    if (parent == null) {
	        head = child;
	    } else if (parent.l == pivot) {
	        parent.l = child;
	    } else {
	        parent.r = child;
	    }
	    child.parent = pivot.parent;
	    pivot.parent = child;
	    pivot.r = child.l;
	    if (child.l != null) child.l.parent = pivot;
	    child.l = pivot;
	    return child;
	}
		
	private TreeNode rotateRight(TreeNode pivot) {
		TreeNode parent = pivot.parent;
	    TreeNode child = pivot.l;
        if (parent == null) {
			head = child;
	    } else if (parent.l == pivot) {
	        parent.l = child;
		} else {
	        parent.r = child;
	    }
        child.parent = pivot.parent;
        pivot.parent = child;
        pivot.l = child.r;
        if (child.r != null) child.r.parent = pivot;
        child.r = pivot;
        return child;
    }
	
	 private TreeNode find(int id) {
		 TreeNode p = head;
		 boolean flag = false;
	     while (p != null) {
	         int result = compare(id, p.id);
	         if (result == 0) {
	        	 flag=true;
	             break;
	         }
	         p = result < 0 ? p.l : p.r;
	     }
	     if(!flag) {
	    	 return null;
	     }
	     return p;
	    }

	public boolean remove(int id) {
		TreeNode n = find(id);
		if (n == null) return false;
		remove(n);
		return true;
	}
	
	private void remove(TreeNode p) {
        if (p.l != null && p.r != null) {
        	TreeNode succ = succ(p);
            p.id = succ.id;
            p = succ;
        }
        TreeNode parent = p.parent;
        TreeNode child = p.l != null ? p.l : p.r;

        if (parent == null) {
            head = child;
        }else if (p == parent.l) {
            parent.l = child;
        }else {
            parent.r = child;
        }
        if (child != null) {
            child.parent = parent;
        }
        p.unlink();
        --size;
    }
	
	private TreeNode succ(TreeNode q) {
		if (q.r != null) {
			TreeNode p = q.r;
	        while (p.l != null) p = p.l;
	        return p;
	    }else {
	        TreeNode p = q.parent;
	        TreeNode ch = q;
	        while (p != null && ch == p.r) {
	        	ch = p;
	            p = p.parent;
	        }
	        return p;
	    }
	}
	
	private void inOrder(int flag) {
		inOrder(head,flag);
	}
		  
	private void inOrder(TreeNode n, int flag) {
		if(flag==-1){ //print tree
			if (n == null) return;
			inOrder(n.l,flag);
			System.out.println("\nWarehouse: " + n.id + " in city " + n.name());
			for(int i=0; i < n.booklist.size(); i++) {
				BookInfo temp = new BookInfo();
				temp=n.booklist.get(i);
				System.out.println("Book " + temp.getISBN() + " has " + temp.getCopies() + " copies.");
			}
			inOrder(n.r,flag);
		}else{ //search tree
			if (n == null) return;
			inOrder(n.l,flag);
			searchBookInWarehouse(n.id, flag);
			inOrder(n.r,flag);
		}
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public int compare(int a,int b){
		if (a>b){
			return 1;
		}else if(a==b){
			return 0;
		}else{
			return  -1;
		}
	}
	
	public void insertWarehouse(int nodeid, String name) {
		warehouse=find(nodeid);
		if(warehouse==null) {
			insert(nodeid, name);
		}else {
			System.out.println("This warehouse is already in the tree!!\n");
		}
		
	}

	public void insertBookAtWarehouse(int nodeid, int isbn, int copies) {
		warehouse=find(nodeid);
		if(warehouse!=null) warehouse.setBooklist(isbn, copies);
	}
	
	public void removeWarehouse(int nodeid) throws NoSuchElementException {
		if(isEmpty()) throw new NoSuchElementException();
		warehouse=find(nodeid);
		if(warehouse!=null) {
			remove(warehouse);
			System.out.println("The warehouse has been successfully removed!!");
		}
	}
	
	public void removeBook(int nodeid, int isbn) throws NoSuchElementException{
		if(isEmpty()) throw new NoSuchElementException();
		warehouse=find(nodeid);
		if(warehouse!=null) {
			int found=warehouse.searchBooklist(isbn);
			warehouse.booklist.remove(found);
		}
	}
	
	public void searchByWarehouse(int nodeid) {
		if(isEmpty())System.out.println("This warehouse does not exist!!");
		warehouse=find(nodeid);
		if(warehouse!=null) warehouse.printList(warehouse.key(),warehouse.name());
	}
	
	public void searchBookInWarehouse(int nodeid, int isbn) {
		warehouse=find(nodeid);
		if(warehouse.booklist.isEmpty()) System.out.println("This warehouse is empty!!");
		if(warehouse!=null) {
			int found=warehouse.searchBooklist(isbn);
			BookInfo temp = new BookInfo();
			temp=  warehouse.booklist.get(found);
			if(found>=0){
			System.out.println("Warehouse: " + warehouse.key() + " in city " + warehouse.name()+ "\nBook " + temp.getISBN() + " has " + temp.getCopies() + " copies.");
			}
		}else {
			System.out.println("This book does not exist in this warehouse!!");
		}
	}
	
	public void searchBook(int isbn) {
		   inOrder(isbn);
	}

	public void print‘ree(PrintStream stream) {
		    inOrder(-1);
	}
	
	
}
