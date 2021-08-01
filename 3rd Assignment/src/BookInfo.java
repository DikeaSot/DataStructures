public class BookInfo {

		
		public BookInfo() {}
		
		private int ISBN;
		private int numOfCopies=0;
		
		public BookInfo(int ISBN, int numOfCopies) {
			this.ISBN=ISBN;
			this.numOfCopies=numOfCopies;
		}
		
		public int getCopies() {
			return numOfCopies;
		}
		
		public int getISBN() {
			return ISBN;
		}
		
		public void setCopies(int copies) {
			numOfCopies+=copies;
		}
		
}

