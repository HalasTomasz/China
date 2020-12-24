package Server;

public class logicBoard_Classical2P extends logicBoard_Classical {

    logicBoard_Classical2P(){
        super();
        decoder(houseUp, "red", "yellow");
        decoder(houseDown, "yellow", "red");
    }

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
