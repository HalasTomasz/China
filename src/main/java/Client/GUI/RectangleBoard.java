package Client.GUI;

public class RectangleBoard extends Board {
	public RectangleBoard(int sizeX, int sizeY){
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
		int[] house1 ={3,4,6,3,7,2,5,1,8};
		int[] house2 ={3,4,2,3,1,2,3,1,0};
		int[] house3 ={3,4,11,3,10,2,12,1,9};
		int[] house4 ={3,4,11,3,10,2,12,1,9};
		
		setHouses(house1);
		setHouses(house2);
		setHouses(house3);
		setHouses(house4);
		
	}
}
