package Client.Frame;


import Client.Client;

import java.awt.*;

public class GUI {
	
	private final int Players;
	private Draw frame;
	
	public GUI (String Boardname, String typeOfFigures, String mycolor, String Players,Client client)  {
		this.Players=Integer.parseInt(Players);
	
		EventQueue.invokeLater(() ->
		{
			frame = new Draw(Boardname, typeOfFigures, mycolor, this.Players,client);
			frame.setVisible(true);
		});
	}
	
	public void change(int x, int y, String color){
			frame.change(x, y, color);


	}
}
