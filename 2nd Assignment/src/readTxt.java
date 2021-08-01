import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class readTxt {
	//private Scanner file;
	public int processors; //arithmos epeksergaston
	public int procedures; //arithmos diergasion
	public int[] time; // xronoi epeksergasias diergasion
	//Scanner in = new Scanner(System.in);
	

	public void openFile(Scanner file) {
		//try {
			//Scanner file= new Scanner(new File("inputB.txt"));
		
			//elegxos egkyrotitas
			
			int lines=0; //gia na ksero se poia grammi vriskomai
			boolean wrongFormat=false; //esto oti to txt arxeio exei sosti morfi 
			
			while(file.hasNext()) {
				String nextData=file.nextLine();
				if(check(nextData) == false) {
					wrongFormat=true;
					break;
				}
				if(lines==0) { //orizw to plithos ton epeksergaston
					processors = Integer.parseInt(nextData);
				}else if(lines==1) { //orizw to plithos ton diergasion
					procedures = Integer.parseInt(nextData);
					time= new int [procedures]; // periexei tous xronous ton diergasion (apo to txt)
				}else { //vazo ta ypoloipa stoixeia toy txt mesa se ena pinaka
					time[lines-2] = Integer.parseInt(nextData);
				}
				lines++;
			}
			System.out.println("\n");
			if(wrongFormat) System.out.println("The format of the file is incorrect!!!");
			
			try {
				file.close();
			}catch(Exception ex) {
				System.out.println("There was a problem closing the file!!!");
			}
	/*	}catch(Exception e){
			System.out.println("There was a problem opening or reading the file.");
		}*/
	}
	
	public boolean check(String s) {
		boolean flag=false;
		try {
			Integer.parseInt(s);
			flag=true;
		}catch(Exception e) {
			System.out.println(s + " is not a number");
		}
		return flag;
	}
}