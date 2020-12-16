package Client.Frame;

import java.awt.*;

public interface Land extends Shape{
	void set_color (Color color);
	Color getcolor();
	boolean isHIt(Point starDrag);
}
