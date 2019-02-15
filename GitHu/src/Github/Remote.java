package Github;

import java.util.ArrayList;
import java.util.Scanner;

public class Remote {
	
	private int channel;
	private int volume;
	private int adjust;
	
	public static int c = 0;
	
	static ArrayList <Integer> array = new ArrayList<>();
	
	

	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getChannel() {
		return this.channel;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public void UpDownButton() {
		
		adjust = 0;
		
	}
	
	public static void setBank( int a) {
				
		array.add(c,a);
		
		if(array.size() > 0) {
			
			array.add(0,a);
			
			array.subList(2, array.size()).clear();
			c = 0;	
		}
		
			c++;		
	}
	
		
	public  int getArrayOne() {
		
		return array.get(0);
	}
	
	public int getArrayTwo() {
		
		return array.get(1);
	}
	
}

		

