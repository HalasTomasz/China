package GUI;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SQUARE extends Rectangle2D.Float implements Land
{
	Color mycolor = Color.WHITE;
	
	public SQUARE(float x, float y , float x1, float y1)
	{
		this.x=x;
		this.y=y;
		this.width=x1;
		this.height=y1;
		
	}
	
	@Override
	public boolean isHIt(Point dragStart)
	{
		return this.contains(dragStart);
	}
	
	@Override
	public void set_color(Color color) {
		this.mycolor=color;
	}
	
	@Override
	public Color getcolor() {
		return mycolor;
	}
}
