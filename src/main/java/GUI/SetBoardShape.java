package GUI;

public class SetBoardShape {
	
	public DrawBoard returnBoardShape(String type){
		if(type =="star") {
			return new StarBoard();
		}
		else if(type =="square"){
			return new SquareBoard();
		}
		else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
