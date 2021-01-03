package Server;

public class Rule_gameOver extends rule {

    Rule_gameOver(serverHead head) {
        super(head);
    }

    @Override
    boolean check(player player, String command) {
        if(head.endFlag){
            return true;
        }
        return false;
    }
}
