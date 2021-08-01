import java.util.*;

public class DNAPalindrome {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please give a DNA.\n");
		String DNA = in.nextLine();
		StringBuilder WatsonCrickDNA=new StringBuilder("");
		boolean flag_DNA=true; //esto oti to DNA einai sosta dosmeno
		boolean flag_char=true; //esto oti ola ta char sto DNA kai to WatsonCrickDNA einai idia
		for(int i =0; i<DNA.length(); i++) { //elegxos egkyrotitas
			if(!CheckDNA(DNA.charAt(i))) {
				flag_DNA=false;
				break;
			}else if(DNA==null) break;
		}
		if(flag_DNA) { // main programm
			CharDoubleEndedQueueImpl listDNA=new CharDoubleEndedQueueImpl();
			for(int i=0; i<DNA.length(); i++) {
				listDNA.addLast(Supplement(DNA.charAt(i)));
			}
			for(int i=0; i<DNA.length(); i++) {
				WatsonCrickDNA.append(listDNA.getLast());
				listDNA.removeLast();
			}
			for(int i=0; i<DNA.length(); i++) {
				if((DNA.charAt(i))==(WatsonCrickDNA.charAt(i))) {
				}else {
					flag_char=false;
					break;
				}
			}
			if(flag_char) {
				System.out.println("The DNA " + DNA + " is Watson-Crick complemented palindrome");
			}else {
				System.out.println("The DNA " + DNA + " is not Watson-Crick complemented palindrome");
			}
			
		}else {
			System.out.println("You have given wrong DNA.");
		}
	}
	
	public static boolean CheckDNA(char character) {
		if(character=='A') {
		}else if (character=='T') {
		}else if (character=='G') {
		}else if (character=='C') {
		}else {
			return false;
		}
		return true;
	}
	
	public static char Supplement(char character) {
		if(character=='A') {
			return 'T';
		}else if (character=='T') {
			return 'A';
		}else if (character=='G') {
			return 'C';
		}else {
			return 'G';
		}
	}
}
