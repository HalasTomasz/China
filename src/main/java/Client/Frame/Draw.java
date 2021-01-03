package Client.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JFrame {
	private int Height;
	private int Width;
	private DrawSpace panel;
	private Land[][] sizeBoard;
	private final ArrayList<int[]> Poles = new ArrayList<>();
	JButton button = new JButton();
	JButton button2 = new JButton();
	JLabel writing = new JLabel("Gracz:");
	JLabel turn = new JLabel("Tura:");
	private int filedOfCommand;
	
	public Draw(String boardName, String typeOfFigures, String myColor, int Players, GUI gui) {
		setSizes();
		prepare(boardName,typeOfFigures);
		
		setLocationByPlatform(true);
		setResizable(true);
		setTitle("Plansza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel = new DrawSpace(this.sizeBoard, this.Poles, myColor,Players,filedOfCommand,gui);
		panel.setBackground(Color.WHITE);
		
		button.setBackground(panel.colorDecoder(myColor));
		button.setBounds(Width,Height,Width,Height);
		button.setOpaque(true);
		writing.setBounds(Width,Height,50,20);
		
		button2.setBackground(panel.colorDecoder("red"));
		button2.setBounds(Width,Height,Width,Height);
		button2.setOpaque(true);
		turn.setBounds(Width,Height,50,20);
		
		panel.add(writing);
		panel.add(button);
		panel.add(turn);
		panel.add(button2);
		add(panel, BorderLayout.CENTER);
	}
	
	public void changePlayer(String color){
	button2.setBackground(panel.colorDecoder(color));
	}
	private void prepare(String Boardname, String typeOfFigures){
		
		this.sizeBoard = CreateBoard.boardProperties(Boardname).giveSize();
		this.sizeBoard = fillArray(typeOfFigures);
		
		this.Poles.addAll(SetBoardShape.returnBoardShape(Boardname).returnTables());
		filedOfCommand=this.Poles.size();
		this.Poles.addAll(CreateBoard.boardProperties(Boardname).giveHouses());
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
	public void changer() {
		this.Height =   getHeight() ;
		this.Width =  getWidth() ;
		for (int i = 0; i < sizeBoard.length; i++) {
			for (int j = 0; j < sizeBoard[i].length; j++) {
				if ((i + 1) % 2 == 0)
					sizeBoard[i][j].changeShape((float) Width / 7 + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
				else
					sizeBoard[i][j].changeShape((float) (Width / 6) + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
			}
		}
		panel.rePaint();
	}
	
}