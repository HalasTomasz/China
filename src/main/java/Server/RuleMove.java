package Server;

public abstract class RuleMove extends Rule {

    int new_x;
    int new_y;
    LogicBoard board;

   /* int old_x;
    int old_y;
    int whenMoved;
    int howManyTimesUsed;*/

    RuleMove(serverHead head, LogicBoard board) {
        super(head);
        this.board = board;
    }



    @Override
    boolean check(Player player, String command){
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

    protected abstract boolean canDo(Player player);

    void doMove(){
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());
        board.setFieldColor(head.currentX, head.currentY, "white");
        for (Player player: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), player);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + "white", player);
        }
       /* old_x = head.getCurrentX();
        old_y = head.getCurrentY();*/
        head.setCurrentX(new_x);
        head.setCurrentY(new_y);
        /*head.addAmountMoves(1);
        howManyTimesUsed++;
        whenMoved = head.howManyMoves();*/
    }
  /*  void restartStats(){
        int old_x = -1;
        int old_y = -1;
        int whenMoved = 0;
        int howManyTimesUsed = 0;
    }*/



}
