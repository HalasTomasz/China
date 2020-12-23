package Server;

import java.util.ArrayList;

public class setUpServer {
    public static void main(String[] args) throws Exception {
        serverHead game = new serverHead();
        ArrayList<Rule> listRule = new ArrayList<>();
        LogicBoard board = new logicBoard_Classical2P();
        listRule.add(new Rule_SayHello(game));
        listRule.add(new Rule_SBLeft(game));
        listRule.add(new Rule_gameOver(game));
        listRule.add(new Rule_WaitForAll(game));
        listRule.add(new Rule_OnlyCurrentPlayer(game));



        ArrayList<RuleMove> listMove = new ArrayList<>();
        listMove.add(new RuleMove_IsNotMyChecker(game, board));
        listMove.add(new RuleMove_NoActiveField(game, board));
        listMove.add(new RuleMove_SkipTurn(game, board));
        listMove.add(new RuleMove_SimpleWalk(game, board));
        listMove.add(new RuleMove_SimpleJump(game, board));
        listRule.addAll(listMove);
        String shape = "Circle";


        game.start(board, 2, listRule, "Circle");

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