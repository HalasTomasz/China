package Server;

public abstract class Rule {
    serverHead head;
    Rule(serverHead head) {
        this.head = head;
    }
     boolean tryCheck(Player player, String command){
        if (head.bannedRules.contains(this)){
            return false;
        }
        return check(player, command);
    }
    abstract boolean check(Player player, String command);
}
