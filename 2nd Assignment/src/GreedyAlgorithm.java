import java.util.Collections;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.io.File;
public class GreedyAlgorithm {
	public static Processor [] listOfPro;
	public static MaxPQ listOfProcessors;
	public int processors;
	public int procedures;
	public int makespanpublic;
	public GreedyAlgorithm() {}
	Sort S=new Sort();
	
	public void GreedyAlgorithm(int a,int b)throws FileNotFoundException{
		readTxt txt=new readTxt();
			Scanner file= new Scanner(new File("data" + b + ".txt"));
		if(a==1){
			txt.openFile(file);
			 processors=txt.processors;
			 procedures= txt.procedures;
		}else{
			 S.HeapSort(b);
			 processors=S.getprocessorsSort();
			 procedures= S.getproceduresSort();
		}
		listOfPro = new Processor [processors]; //pinakas typou Processor pou periexei mesa antikeimena typou Processor	
		listOfProcessors = new MaxPQ(processors,Collections.reverseOrder()); // lista typou MaxPQ pou periexei to getActiveTime ton Processors
		for(int i=0; i<processors; i++) {
			Processor pi= new Processor(i);
			listOfPro[i]=pi;
			if(a==1){
				listOfPro[i].setTimeQueue(txt.time[i]);
			}else{
				listOfPro[i].setTimeQueue(S.sortedList[i]);
			}
			listOfProcessors.insert(listOfPro[i].getActiveTime());
		}
		for(int i=processors; i<procedures; i++) { 
			Object minTime = listOfProcessors.getMax();
			for(int j=0; j<processors; j++) {
				if(listOfPro[j].getActiveTime() == (Integer) minTime) {
					if(a==1){
						listOfPro[j].setTimeQueue(txt.time[i]);
					}else{
						listOfPro[j].setTimeQueue(S.sortedList[i]);
					}
					listOfProcessors.insert(listOfPro[j].getActiveTime());
					break;
				}
			}
		}
		int makespan=listOfPro[0].getActiveTime();
		for(int i=0; i<processors; i++) {
			if(procedures>100) {
				System.out.println("id " + i + ", load=" + listOfPro[i].getActiveTime() + ": " + listOfPro[i].getTimeQueue()); //id 2, load=30: 30
				if(i==processors-1) {
					makespan=listOfPro[i].getActiveTime();
				}
			}else {
				Object min = listOfProcessors.getMax();
				for(int j=0; j<processors; j++) {
					if(listOfPro[j].getActiveTime()== (Integer) min) {
						System.out.println("id " + j + ", load=" + listOfPro[j].getActiveTime() + ": " + listOfPro[j].getTimeQueue()); //id 2, load=30: 30
						if(i==processors-1) {
							makespan=listOfPro[j].getActiveTime();
						}
						listOfPro[j].setTimeQueue(1-(Integer)min);
						break;
					}
				}
			}
		}
		System.out.println("Makespan = " + makespan);
		makespanpublic=makespan;
}
	
	public int makespanreturn(){
		return makespanpublic;
	}
}