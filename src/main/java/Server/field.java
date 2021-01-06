package Server;

/**
 * represents one filed on board
 */
public class field {

    String color = null;

    String colorToWin = null;

    /**
     * @return color getter
     */
    public String getColor() { return color; }

    /**
     * change fields color
     * @param color new fields color
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * sets winning color on field
     * @param color winning color
     */
    public void setHause(String color) { this.colorToWin = color; }

}
