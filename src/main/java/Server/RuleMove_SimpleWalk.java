package Server;

import static java.lang.Math.abs;

public class RuleMove_SimpleWalk extends RuleMove{

    RuleMove_SimpleWalk(serverHead head, LogicBoard board) {
        super(head, board);
    }

    @Override
    protected boolean canDo(Player player) {
        if(abs(head.getCurrentX()-new_x)<=1 && abs(head.getCurrentY()-new_y)<=1 && board.getFieldColor(new_x, new_y) != player.getColor()){
                System.out.println("Done " + this.getClass().getSimpleName());
                doMove();
                 head.nextPlayer();
                 return true;
            }
        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
        }
}





