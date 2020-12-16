package Server;

public class Rule_MoveSimple extends RuleMove{
    int new_x;
    int new_y;
    Rule_MoveSimple(serverHead head) {
        super(head);
    }

    @Override
    protected boolean canDo() {
        return false;
    }


}
