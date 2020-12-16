package Client.Frame;

public class SetBoardShape {
	
	public static DrawBoard returnBoardShape(String type){
		
		if(type.equals("Classical")) {
			return new StarBoard();
		}
		else if(type.equals("Square")){
			return new SquareBoard();
		}
		else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
