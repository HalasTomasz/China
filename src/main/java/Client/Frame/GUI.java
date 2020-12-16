package Client.Frame;


import javax.swing.*;
import java.awt.*;

public class GUI {
	
	private final int Players;
	
	public GUI (String Boardname, String typeOfFigures, String mycolor, String Players)  {
		this.Players=Integer.parseInt(Players);
		
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new Draw(Boardname, typeOfFigures, mycolor, this.Players);
			frame.setVisible(true);
		});
	}
}
