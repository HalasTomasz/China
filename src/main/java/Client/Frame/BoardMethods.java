package Client.Frame;

import java.util.ArrayList;

public interface BoardMethods {
	void setHouses(int[] house);
	void setSizeBoard(int x, int y);
	void addHouses();
	Land[][] giveSize();
	ArrayList<int[]> giveHouses();
}
