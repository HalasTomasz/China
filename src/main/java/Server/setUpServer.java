package Server;

import java.util.ArrayList;

public class setUpServer {
    public static void main() throws Exception {
        serverHead game = new serverHead();
        ArrayList<Rule> listRule = new ArrayList<>();
        LogicBoard board = new logicBoard_Classic2P();
        listRule.add(new Rule_WaitAtStart(game));
        listRule.add(new Rule_SBLeft(game));
        listRule.add(new Rule_OnlyCurrentPlayer(game));
        listRule.add(new Rule_NoActiveField(game));

        ArrayList<RuleMove> listMove = new ArrayList<>();
        listRule.add(new RuleMove_Simple(game, board));
        String shape = "Circle";


        game.init(board, 2, listRule, listMove, shape);

    }
}
/* stringConverter = serverHead.class.getPackage().getName() + "." + board;
            Class<?> clazz = Class.forName(stringConverter);
            Constructor<?> ctor = clazz.getConstructor(serverHead.class);
            this.board = (LogicBoard) ctor.newInstance(new Object[] { this });

            for(String rule: rules){
                stringConverter = serverHead.class.getPackage().getName() + "." + rule;
                clazz = Class.forName(stringConverter);
                ctor = clazz.getConstructor(serverHead.class);
                this.rules.add((Rule) ctor.newInstance(new Object[] {this}));
            }

            for(String move: moves){
                stringConverter = serverHead.class.getPackage().getName() + "." + move;
                clazz = Class.forName(stringConverter);
                ctor = clazz.getConstructor(serverHead.class);
                this.moves.add((RuleMove) ctor.newInstance(new Object[] {this}));
            }*/