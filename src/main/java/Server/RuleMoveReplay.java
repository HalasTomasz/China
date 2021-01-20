package Server;

public class RuleMoveReplay extends RuleMove {
    RuleMoveReplay(ServerHead head) {
        super(head);
    }

    @Override
    protected boolean canDo(Player player) {
        return false;
    }
}
