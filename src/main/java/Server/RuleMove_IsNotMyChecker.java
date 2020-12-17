package Server;

public class RuleMove_IsNotMyChecker extends RuleMove {

    RuleMove_IsNotMyChecker(serverHead head, LogicBoard board) {
        super(head, board);
    }

    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(board.getFieldColor(new_x, new_y) != player.getColor() && board.getFieldColor(new_x, new_y) != "white"){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("NOT_YOUR_CHECKER", player);
            return true;
        }
        return false;
    }
}
