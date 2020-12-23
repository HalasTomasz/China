package Server;

public class logicBoard_Classical4P extends logicBoard_Classical {

    logicBoard_Classical4P(){
        super();
        decoder(houseUpLeft, "yellow");
        decoder(houseUpRight, "black");
        decoder(houseDownLeft, "blue");
        decoder(houseDownRight, "red");
    }

    @Override
    protected String hasSbWon() {
        if(checker(houseDownRight, "yellow", 10)){
            return "yellow";
        } else if(checker(houseUpLeft, "red", 10)){
            return "red";
        } else if(checker(houseUpRight, "blue", 10)){
            return "blue";
        } else if(checker(houseDownLeft, "black", 10)){
            return "black";
        }
        return null;
    }
}
