package Github;

import java.util.Random;
import java.util.Scanner;


public class TvDemo {
	
	public static void main(String[] args) {
		
		int primeChannel = 0;
		int count = 1;
		int answer = 0;
		
		
		Random r = new Random();
		Remote remote = new Remote();
		Networks networks = new Networks();
		Scanner input = new Scanner(System.in);
		
		int volume = r.nextInt(98) + 1;
		
		//Used input to start TV.
		System.out.println("Turn TV On By Pressing 1");	
		answer = input.nextInt();
		
		System.out.println(" ");
		 
		//Used while loop statement to loop if input isn't 1. 
		while(answer != 1) {
		
			System.out.println("Enter 1 To Turn On TV.");
			answer = input.nextInt();
		}
				
		if(answer == 1) {
			
			System.out.println("TV Is On.");	
			System.out.println(" ");
			
		}		
				
		while(true) {
		
			//User options for choices
			System.out.println("What Do You Wanna Do?");
			System.out.println("  1.Change Channel\n"
							 + "  2.Change Volume\n"
							 + "  3.Recall\n"
							 + "  4.Turn Off TV");
			 answer = input.nextInt();
			 
			 System.out.println(" ");
			 
			 //Loops if input isn't one of the options.
			 while(answer < 1 || answer > 4) {
					System.out.println("Choose An Option 1 - 4.");
					System.out.println("  1.Change Channel\n"
									 + "  2.Change Volume\n"
									 + "  3.Recall\n"
									 + "  4.Turn Off TV");
					answer = input.nextInt();
					 
					System.out.println(" ");
			 }
			 
				 
			//Used for input to get channels
			if(answer == 1) {
				System.out.println("Pick A Channel 2 - 16");
				remote.setChannel(input.nextInt());
				
				System.out.println(" ");
				
			//control what numbers are input for the channels
			while(remote.getChannel() % 2 != 0 || remote.getChannel() > 16) {
				System.out.println("All Channels Are Even Numbers.Pick a Channel 2 - 16");
				remote.setChannel(input.nextInt());
				System.out.println(" ");
			}
			
			System.out.println("CH " + remote.getChannel() + ": "+ networks.list(remote.getChannel()));
			Remote.setBank(remote.getChannel()); 
			System.out.println(" ");
				
			//puts the prime channel in the 1 index after primeChannel has been filled
			if(primeChannel  > 0) {
				Remote.array.set(1, primeChannel);
				count = 1;
			}
				
				
			}
			
			//Used to control the Volume Options to raise 1 or 5.
			else if(answer == 2) {
				
				do {
					System.out.println("Volume Is At: " + volume);
					System.out.println(" ");
					System.out.println("Do You Want To Turn The Volume Up Or Down?\n Enter 1 Or 2:\n"
							+ " 1. Up\n"
							+ " 2. Down\n");
					answer = input.nextInt();
				
				} while(answer < 1  || answer > 2);
			

				//Controls Volume Options 
				if(answer == 1) {
					
					do {
						System.out.println("Choose 1 To Turn Volume Up By 1 Or 2 To Turn Volume Up By 5.\n Enter 1 Or 2\n" 
										  +"1. Volume +1\n" 
										  +"2. Volume +5\n");
						answer = input.nextInt();
					
					} while(answer < 1 || answer > 2);
					
					if(answer == 1) {
						int adjust = 1;
						volume += adjust;	
						remote.setVolume(volume);
						
						if(remote.getVolume()> 99) {
							System.out.println("Volume Can't Go Above 99.");
							remote.setVolume(volume = 99); 
						}
						
						System.out.println("Volume Is Set To " + remote.getVolume());
						System.out.println(" ");
					}
					
					else if(answer == 2){
						int adjust = 5; 
						volume+= adjust;
						remote.setVolume(volume);
						
						if(remote.getVolume() > 99) {
							System.out.println("Volume Can't Go Above 99.");
							remote.setVolume(volume = 99); 
						}

						System.out.println("Volume Is Set To " + remote.getVolume());
						System.out.println(" ");
					}

				}
				
				//Controls the Volume Options to lower down by 1 or 5. 
				else { 
					
					do {
						System.out.println("Choose 1 To Turn Volume Down By 1 OR 2 To Turn Volume Down By 5.\n" 
								  +"1. Volume -1\n" 
								  +"2. Volume -5\n");
						answer = input.nextInt();
			
					} while(answer < 1 || answer > 2 );
				
					if(answer == 1) {
						
					    int adjust = 1;
						volume -= adjust;	
						remote.setVolume(volume);
						
						if(remote.getVolume() < 0) {
							System.out.println("Volume Can't Go Below 0.");
							remote.setVolume(volume = 0); 
						}
						
						System.out.println("Volume Is Set To " + remote.getVolume());
						System.out.println(" ");
					}
					
					else if(answer == 2) {

							int adjust = 5;
							volume -= adjust;
							remote.setVolume(volume);

							if(remote.getVolume() < 0) {
								System.out.println("Volume Can't Go Below 0.");
								remote.setVolume(volume = 0); 
							}
						
						System.out.println("Volume Is Set To " + remote.getVolume());
						System.out.println(" ");
					}
					
				}
				
			}
			
			//Controls how the channels are displayed.
			else if(answer == 3) {
				
				//Displays No channels available if no channels are stored 
				if(Remote.array.isEmpty() ) {
					
					System.out.println("NO CHANNELS AVAILABLE!!");
					System.out.println(" ");
				}
				
					
				 if(count == 0 && !Remote.array.isEmpty()) {
					System.out.println("CH:" + remote.getArrayOne() + " " + networks.list(remote.getArrayOne()));	
					primeChannel = remote.getArrayOne();
					System.out.println("Last CH:" + remote.getArrayTwo() + " " + networks.list(remote.getArrayTwo()));
					count++;
					System.out.println(" ");
				  }
					
				 else if(count ==1 && !Remote.array.isEmpty()) {
					System.out.println("CH:" + remote.getArrayTwo() + " " + networks.list(remote.getArrayTwo()));
					primeChannel = remote.getArrayTwo();
					System.out.println("Last CH:" + remote.getArrayOne() + " " + networks.list(remote.getArrayOne()));
					count --;
					System.out.println(" ");
				 }
					
			}
			
			//Breaks out of the loop when answer equals 4
			else if(answer == 4){
				System.out.println("TV Is Off.");
				System.out.println();
				break;
			}
				
		  }	
	}

}
	
	

