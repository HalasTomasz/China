package Server;

public class Rule_SBLeft extends Rule{
    Rule_SBLeft(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        if (command.startsWith("LEFT")){
            for (Player x : head.players){
                head.newMessageWrite("SB_LEFT", x);

            }
            return true;
        }
        return false;
    }
}
