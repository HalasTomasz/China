package Server;

public class Rule_SBLeft extends Rule{
    Rule_SBLeft(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("LEFT")){
            System.out.println("Done " + this.getClass().getSimpleName());
            for (Player x : head.players){
                head.newMessageWrite("SB_LEFT", x);

            }
            return true;
        }
        return false;
    }
}
