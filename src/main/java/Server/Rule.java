package Server;

public abstract class Rule {
    serverHead head;
    Rule(serverHead head) {
        this.head = head;
    }

    abstract boolean check(Player player, String command);
}
