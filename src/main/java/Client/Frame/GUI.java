package Client.Frame;

import Client.Client;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends ServerAdapter{
	
	private final int Players;
	private final Client Client;
	public Draw frame;
	
	public GUI (String Boardname, String typeOfFigures, String mycolor, String Players,Client client)  {
		this.Players=Integer.parseInt(Players);
		this.Client=client;
		EventQueue.invokeLater(() ->
		{
			frame = new Draw(Boardname, typeOfFigures, mycolor, this.Players,this);
			frame.addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent componentEvent) {
					frame.changer();
				}
			});
			frame.setVisible(true);
		});
	}
	@Override
	public void sendInfo(int x, int y){
		String Data="MOVE "+x+";"+y;
		Client.writeMessage(Data);
	}
	
	@Override
	public void change(int x, int y, String color){
		frame.change(x, y, color);
	}
	
	@Override
	public void changePlayer(String color){
		frame.changePlayer(color);
	}
	@Override
	public Draw returnFrame(){
		return frame;
	}
	
}
