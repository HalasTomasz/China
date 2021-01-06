package Server;

/**
 * abstract for all rules thining about fields
 */
public abstract class RuleMove extends rule {

    int new_x;
    int new_y;
    logicBoard board;

    RuleMove(serverHead head) {
        super(head);
    }

    /**
     * to set about what board should rule think
     * @param board board to think
     */
    void init(logicBoard board){
        this.board = board;
    }


    /**
     * if player try to move and good data think can i done sth
     * @param player who done action
     * @param command what action
     * @return
     */
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

    /**
     * specifc thinnking about claiming for a rule
     * @param player who done sth
     * @return true if rule needs to stop chain
     */
    protected abstract boolean canDo(player player);

    /**
     * simple cheecker move, wheren old field is white, new have players color
     */
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

    /**
     * specific move where neeeds to swich fields color
     */
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



}
