package Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JFrame {
	int Height;
	int Width;
	private Draw_space panel;
	public Land[][] sizeBoard;
	public ArrayList<int[]> domki;
	
	public Draw(String type, Land[][] sizeBoard,ArrayList<int[]> domki)
	{
		this.domki=domki;
		setSizes();
		this.sizeBoard=fillArray(type, sizeBoard);
		
		setLocationByPlatform(true);
		setResizable(true);
		setTitle("Plansza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel= new Draw_space(this.sizeBoard,this.domki);
		panel.setBackground(Color.WHITE);
		add(panel,BorderLayout.CENTER);
		
	}
	
	private void setSizes() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.Height = (3*screenSize.height/4);
		this.Width = (3*screenSize.width/4);
		setSize( Width ,Height );
	}
	
	public Land[][] fillArray(String type, Land[][] fields){
		SetShapes setShapes = new SetShapes();
			for(int i=0;i<fields.length;i++)
			{
				for(int j=0; j<fields[i].length;j++){
					if((i+1)%2==0)fields [i][j] =  setShapes.returnShape( type,  (float) Width/7+ (float) j*Width/19, (float) Height/20 +(float) i*Height/20, (float) Width/21, (float) Height/20);
					else fields[i][j] =  setShapes.returnShape( type, (float) (Width/6)+ (float) j*Width/19, (float) Height/20 + (float) i*Height/20, (float) Width/21, (float) Height/20);
				}
			}
			return fields;
		}
		
	
}
