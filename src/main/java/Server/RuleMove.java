package Server;

public abstract class RuleMove extends rule {

    int new_x;
    int new_y;
    logicBoard board;

    RuleMove(serverHead head) {
        super(head);
    }

    void init(logicBoard board){
        this.board = board;
    }


    @Override
    boolean check(player player, String command){
        if (command.startsWith("MOVE")) {
            try {
                new_x = Integer.parseInt(command.substring(5).split(";")[0]);
                new_y = Integer.parseInt(command.substring(5).split(";")[1]);
                if (canDo(player)){
                    return true;
                }
            }catch (Exception e){
                head.newMessageWrite("BAD_DATA", player);
            }
        }
        return false;

    }

    protected abstract boolean canDo(player player);

    void doMove(){
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());
        board.setFieldColor(head.currentX, head.currentY, "white");
        for (Server.player player: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), player);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + "white", player);
        }

        head.setCurrentX(new_x);
        head.setCurrentY(new_y);

        if(board.hasSbWon() != null) {
            for(Server.player player: head.getPlayers()){
                head.newMessageWrite("WON " + board.hasSbWon(), player);
            }
        }
    }

    void switchFields(){
        String tmpColor = board.getFieldColor(new_x, new_y);
        board.setFieldColor(head.currentX, head.currentY, board.getFieldColor(new_x, new_y));
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());

        for (Server.player player: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), player);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + tmpColor, player);
        }

        head.setCurrentX(new_x);
        head.setCurrentY(new_y);

        if(board.hasSbWon() != null) {
            for(Server.player player: head.getPlayers()){
                head.newMessageWrite("WON " + board.hasSbWon(), player);
            }
        }
    }

    protected boolean isActivePlayerCheecker(player player) {

        if(head.currentX == -1 && board.getFieldColor(new_x, new_y) != player.getColor() && board.getFieldColor(new_x, new_y) != "white"){
            head.newMessageWrite("NOT_YOUR_CHECKER", player);
            return true;
        }
        return false;
    }
}
