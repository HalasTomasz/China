package Client.Frame;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JFrame {
	private int Height;
	private int Width;
	private Draw_space panel;
	private Land[][] sizeBoard;
	private final ArrayList<int[]> Poles = new ArrayList<>();
	private int filedOfCommand;
	
	public Draw(String boardName, String typeOfFigures, String myColor, int Players, Client client) {
		JButton button = new JButton();
		button.setBackground(Color.RED);
		button.setOpaque(true);
		
		setSizes();
		prepare(boardName,typeOfFigures);
		
		setLocationByPlatform(true);
		setResizable(true);
		setTitle("Plansza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Draw_space(this.sizeBoard, this.Poles, myColor,Players,filedOfCommand,client);
		panel.setBackground(Color.WHITE);
		panel.add(button);
		add(panel, BorderLayout.CENTER);
		
	}
	private void prepare(String Boardname, String typeOfFigures){
		
		this.sizeBoard = CreateBoard.BoardPropetis(Boardname).giveSize();
		this.sizeBoard = fillArray(typeOfFigures);
		
		this.Poles.addAll(SetBoardShape.returnBoardShape(Boardname).returnTables());
		filedOfCommand=this.Poles.size();
		this.Poles.addAll(CreateBoard.BoardPropetis(Boardname).giveHouses());
	}
	
	private void setSizes() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.Height = (3 * screenSize.height / 4);
		this.Width = (3 * screenSize.width / 4);
		setSize(Width, Height);
	}
	public void change(int x, int y, String color){
		panel.change(x, y, color);
	
	}
	public Land[][] fillArray(String type) {
		SetShapes setShapes = new SetShapes();
		for (int i = 0; i < sizeBoard.length; i++) {
			for (int j = 0; j < sizeBoard[i].length; j++) {
				if ((i + 1) % 2 == 0)
					sizeBoard[i][j] = setShapes.returnShape(type, (float) Width / 7 + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
				else
					sizeBoard[i][j] = setShapes.returnShape(type, (float) (Width / 6) + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
			}
		}
		return sizeBoard;
	}
}
