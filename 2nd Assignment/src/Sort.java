import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.*;
public class Sort {
	
	public Sort() {}
	public int [] sortedList;
	//public readTxt txt=new readTxt();
	public int processors;
	public int procedures;
	public void HeapSort(int b)throws FileNotFoundException{
		    readTxt txt=new readTxt();
			Scanner file= new Scanner(new File("data" + b + ".txt"));
			txt.openFile(file);
		MaxPQ list = new MaxPQ(txt.procedures);
		sortedList = new int [txt.procedures]; 
		processors=txt.processors;
		procedures=txt.procedures;
		for(int i=0; i<txt.procedures; i++) {
			list.insert(txt.time[i]);
		}
		
		for(int i=0; i<txt.procedures; i++) {
			sortedList[i]= (Integer) list.getMax();
		}
		
	}
	public int getproceduresSort(){
		return procedures;
	}
	public int getprocessorsSort(){
		return processors;
	}
}