package Server;

import static java.lang.Math.abs;

public class RuleMove_SimpleJump extends RuleMove{





    RuleMove_SimpleJump(serverHead head, LogicBoard board) {
        super(head, board);
    }

    @Override
    protected boolean canDo(Player player) {
            if (abs(head.getCurrentX() - new_x) <= 1 && abs(head.getCurrentY() - new_y) <= 1) {
                System.out.println("Done " + this.getClass().getSimpleName());
                doMove();
                return true;
//                    head.nextPlayer();

            }
            return false;

    }
}



