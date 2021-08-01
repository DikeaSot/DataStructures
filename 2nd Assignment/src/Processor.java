import java.io.*;
import java.util.*;

public class Processor {
	
	private int ID;
	TimeQueue processed_jobs=new TimeQueue();
	
	public Processor() {}
	
	
	public Processor(int ID) {
		this.ID=ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setId(int ID) {
		this.ID=ID;
	}
	
	public void setTimeQueue(int process_time) {
		processed_jobs.put(process_time);
	}
	
	public String getTimeQueue() { //epistrefei to xrono kathe diergasias ksexorista
		String xronos="";
		for(int i=0; i<processed_jobs.size(); i++) {
			xronos=xronos.concat((Integer.toString(processed_jobs.get(i)))+ " ");	
		}
		return xronos;
	}
	
	
	public int getActiveTime() { //epistrefei to synoliko xrono ton diergasion
		int makespan=0;
		if(!processed_jobs.isEmpty()) {
			for(int i=0; i<processed_jobs.size(); i++) {
				makespan += processed_jobs.get(i);
			}
		}
		return makespan;
	}
	
	
	

	
}
