package Server;

public class logicBoard_Classical3P extends logicBoard_Classical {

    logicBoard_Classical3P(){
        super();
        decoder(houseUp, "red");
        decoder(houseDownLeft, "yellow");
        decoder(houseDownRight, "blue");
    }

    @Override
    protected String hasSbWon() {
        if(checker(houseUpRight, "yellow", 10)){
            return "yellow";
        } else if(checker(houseDown, "red", 10)){
            return "red";
        } else if(checker(houseUpLeft, "blue", 10)){
            return "blue";
        }
        return null;
    }
}
