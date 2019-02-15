package Github;

public class Networks {
	
	public String list(int n) {
	String[] networks = new String[17];
	
	 networks[0] = "Channel Not Found";
	 networks[2] = "DISNEY JR";
	 networks[4] = "TNN";
	 networks[6] = "CHANNEL GUIDE";
	 networks[8] = "TBS";
	 networks[10] = "HBO";
	 networks[12] = "NBC";
	 networks[14] = "Showtime";
	 networks[16] = "USA";
	 
	 return networks[n];
	}
}
	