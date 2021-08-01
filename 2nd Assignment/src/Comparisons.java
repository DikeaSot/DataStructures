import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
public class Comparisons  {
	public static void main(String[] args)throws FileNotFoundException {
		 int momakespanwithsort=0;
		 int momakespanwithoutsort=0;
		 int mosort100=0;
		 int monosort100=0;
		 int mosort500=0;
		 int monosort500=0;
		 int mosort1000=0;
		 int monosort1000=0;
		 
		for(int b=1; b<=30; b++) {
		GreedyAlgorithm withsort = new GreedyAlgorithm();
		withsort.GreedyAlgorithm(0,b);
		int makespanwithsort=withsort.makespanreturn();
		GreedyAlgorithm withoutsort = new GreedyAlgorithm();
		withoutsort.GreedyAlgorithm(1,b);
		int makespanwithoutsort=withoutsort.makespanreturn();
		
		if (makespanwithsort<makespanwithoutsort){
			System.out.println("The programm using the sort alorithm has makespan: "+makespanwithsort+"\nand the one without using sort has :"+makespanwithoutsort);
			System.out.println("As it seems the program with sort is much faster than the other");
		}else if(makespanwithsort==makespanwithoutsort){
			System.out.println("The programm using the sort alorithm has makespan: "+makespanwithsort+"\nand the one without using sort has :"+makespanwithoutsort);
			System.out.println("As it seems the program with sort and the other program have the same makespan ,so the efficiency is the same");
		}else{
			System.out.println("The programm using the sort alorithm has makespan: "+makespanwithsort+"\nand the one without using sort has :"+makespanwithoutsort);
			System.out.println("As it seems the program with sort is much slower than the other");
		}
		momakespanwithsort +=makespanwithsort;
		momakespanwithoutsort+=makespanwithoutsort;
		if (b==10){
			mosort100=momakespanwithsort/10;
			monosort100=momakespanwithoutsort/10;
			makespanwithoutsort=0;
			momakespanwithsort=0;
			
		}else if(b==20){
			 mosort500=momakespanwithsort/10;
			 monosort500=momakespanwithoutsort/10;
			makespanwithoutsort=0;
			momakespanwithsort=0;
		}else{
			 mosort1000=momakespanwithsort/10;
			 monosort1000=momakespanwithoutsort/10;
			makespanwithoutsort=0;
			momakespanwithsort=0;
			
		}
		
		
		}
		System.out.println("\n\n\nthe average makespan when the number of procedures is 100, using sort method is: "+mosort100+"\nand the average without sort: "+monosort100);
		System.out.println("the average makespan when the number of procedures is 500, using sort method is: "+mosort500+"\nand the average without sort: "+monosort500);
		System.out.println("the average makespan when the number of procedures is 1000, using sort method is: "+mosort1000+"\nand the average without sort: "+monosort1000);
			}
}
