package Server;

public class Rule_NoActiveField extends Rule{

    Rule_NoActiveField(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        if (command.startsWith("MOVE")) {
            try {
                head.currentField[0] = Integer.parseInt(command.substring(5).split(";")[0]);
                head.currentField[1] = Integer.parseInt(command.substring(5).split(";")[1]);
                head.newMessageWrite("ACTIVE " + head.currentField[0] + ";" + head.currentField[1], player);
                return true;
            }catch (Exception e){
                player.sendMessage("BAD_DATA");
            }
        }
        return false;
    }
}
