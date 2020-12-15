package GUI;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		Land[][] sizeBoard;
		ArrayList<int[]> domki ;
		CreateBoard createBoard = new CreateBoard();
		sizeBoard=createBoard.BoardPropetis("Classical", 13,17).giveSize();
		domki=createBoard.BoardPropetis("Classical", 13,17).giveHouses();
		EventQueue.invokeLater(() ->
		{

			JFrame frame = new Draw("circle", sizeBoard,domki);
			frame.setVisible(true);
		});
		
	}
}
