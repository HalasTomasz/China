package Server;

public class Rule_gameOver extends Rule {

    Rule_gameOver(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        if(head.endFlag){
            return true;
        }
        return false;
    }
}
