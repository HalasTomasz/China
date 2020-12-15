package Client.GUI;
import java.util.ArrayList;

public class StarBoard implements DrawBoard {
	
	@Override
	public ArrayList<int []> returnTables() {
		ArrayList<int[]> createdTables = new ArrayList<>();
		int[] array ={1,4,9, 4,4, 4,5, 4,6, 4,7, 4,8, 5,9, 6,3, 7,10, 8,2};
		int[] array2={0,12,9, 12,4, 12,5, 12,6, 12,7, 12,8, 11,9, 10,3, 9,10};
		createdTables.add(array);
		createdTables.add(array2);
		return createdTables;
	}
}
