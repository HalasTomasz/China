package Client.GUI;

import java.util.ArrayList;

public class Classical extends Board{
	
	public Classical(int sizeX, int sizeY){
		setSizeBoard(sizeX,sizeY);
		addHouses();
	}
	
	@Override
	public void setHouses(int[] house) {
		
		houses.add(house);
	}
	
	@Override
	public void setSizeBoard(int x, int y){
		sizeBoard = new Land[y][x];
	}
	
	@Override
	public void addHouses() {
		houses = new ArrayList<>();
		int[] house1 ={1,0,4, 0,6, 1,7, 2,5, 3,8};
		int[] house2 ={0,16,13, 16,6, 15,7, 14,5, 13,8};
		int[] house3 ={0,7,4, 7,2, 6,1, 5,3, 4,0};
		int[] house4 ={0,7,4, 7,11, 6,10, 5,12, 4,9};
		int[] house5 ={1,9,13, 9,2, 10,1, 11,3, 12,0};
		int[] house6 ={1,9,13, 9,11 ,10,10, 11,12, 12,9};
		
			setHouses(house1);
			setHouses(house2);
			setHouses(house3);
			setHouses(house4);
			setHouses(house5);
			setHouses((house6));
			
	}
}
