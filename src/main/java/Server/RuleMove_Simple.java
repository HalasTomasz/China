package Server;

public class RuleMove_Simple extends RuleMove{


    RuleMove_Simple(serverHead head, LogicBoard board) {
        super(head, board);
    }

    @Override
    protected boolean canDo() {
        return false;
    }


}
