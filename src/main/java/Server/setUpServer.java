package Server;

import java.util.ArrayList;

public class setUpServer {
    public static void main() throws Exception {

        ArrayList<String> listRule = new ArrayList<String>() {{
            add("ruleA");
            add("ruleB");
            add("ruleC");
            add("moveA");
            add("moveB");
        }};

        serverHead game = new serverHead("classiBoard", 2, listRule);

    }
}
