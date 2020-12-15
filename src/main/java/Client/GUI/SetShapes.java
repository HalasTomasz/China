package Client.GUI;

public class SetShapes {
	
	public Land returnShape(String type, float x, float y, float x1, float y1){
		if(type =="circle") {
			return new CIRCLE(x, y, x1, y1);
		}
		 else if(type =="square"){
		 	return new SQUARE(x, y, x1, y1);
		}
		 	else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
