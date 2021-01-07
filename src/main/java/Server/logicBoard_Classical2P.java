package Server;

/**
 * star board for 2 players
 */
public class logicBoard_Classical2P extends logicBoard_Classical {

    public logicBoard_Classical2P(){
        super();
        decoder(houseUp, "red", "yellow");
        decoder(houseDown, "yellow", "red");
    }

    /**
     * check winning statment for 2 players
     * @return true if sb win, else false
     */
    @Override
    protected String hasSbWon() {
        if(checker(houseUp, "yellow", 10)){
            return "yellow";
        } else if(checker(houseDown, "red", 10)){
            return "red";
        }
        return null;
    }
}
