package Server;

public class logicBoard_Classical6P extends logicBoard_Classical {

    logicBoard_Classical6P(){
        super();
        decoder(houseUpLeft, "yellow", "red");
        decoder(houseUpRight, "black", "blue");
        decoder(houseDownLeft, "blue", "black");
        decoder(houseDownRight, "red", "yellow");
        decoder(houseUp, "purple", "green");
        decoder(houseDown, "green", "purple");
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
        } else if(checker(houseDown, "purple", 10)){
            return "purple";
        } else if(checker(houseUp, "green", 10)){
            return "green";
        }
        return null;
    }

}
