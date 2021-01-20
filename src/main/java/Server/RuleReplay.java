package Server;

public class RuleReplay extends Rule {
    RuleReplay(ServerHead head) {
        super(head);
    }

    @Override
    protected boolean check(Player player, String command) {
        if(command.startsWith("MOVE -1;-1")){
            int i;
        }
        return true;
    }
}
