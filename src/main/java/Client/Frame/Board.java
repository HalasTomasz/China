package Client.Frame;

import java.util.ArrayList;

public abstract class Board implements BoardMethods{
	public Land[][] sizeBoard;
	public ArrayList<int[]> houses;
	
	public Land[][] giveSize(){
	return sizeBoard;
	}
	
	public ArrayList<int[]> giveHouses(){
		return houses;
	}
}
