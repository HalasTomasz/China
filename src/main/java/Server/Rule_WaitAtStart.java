package Server;

public class Rule_WaitAtStart extends Rule {


    Rule_WaitAtStart(serverHead head) {
        super(head);
    }

    @Override
    boolean check(Player player, String command) {
        if (command.startsWith("WAITING")){
            head.newMessageWrite("WAIT_FOR_OTHER " + head.board.getClass().getName() + ";" + head.getShape() + ";" + player.getColor() + ";" + head.getAmountPlayers(), player);
            return true;
        }
        return false;
    }
}
/*else if (players.size() != amountPlayers){
            player.sendMessage("WAIT");
        } else if (currentPlayer.equals(player)) {
            player.sendMessage("NOT_YOU");
        } */