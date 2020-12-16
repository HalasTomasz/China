package Server;

public class Rule_WaitAtStart extends Rule {


    Rule_WaitAtStart(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        return false;
    }
}
