package GUI;

public class CreateBoard {
	
	BoardMethods BoardPropetis(String name, int X, int Y){
		
		if(name.equals("Classical")){
			return new Classical(X,Y);
		}
		
		else if( name.equals("Square")){
			return new RectangleBoard(X,Y);
		}
		else {
			throw new IllegalArgumentException("Unknown board " + name);
		}
	}
}
