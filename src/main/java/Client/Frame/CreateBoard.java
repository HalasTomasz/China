package Client.Frame;

public class CreateBoard {
	
	 static BoardMethods BoardPropetis(String name){
		
		if(name.equals("Classical")){
			return new Classical(13,17);
		}
		
		else if( name.equals("Square")){
			return new RectangleBoard(10,10);
		}
		else {
			throw new IllegalArgumentException("Unknown board " + name);
		}
	}
}
