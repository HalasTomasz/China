package Server;

import java.util.ArrayList;

public class Mainnnn {
	
	public static void maine(ArrayList<String> Data,int sizeOfFirst){
		int size;
		size=Data.size()-sizeOfFirst;
		String[] Separation = new String[size];
		size=Data.size()-sizeOfFirst;
		
		for(int i=sizeOfFirst;i<Data.size();i++){
			Separation[i-sizeOfFirst]=Data.get(i);
		}
		
		serverHead game = new serverHead();
		ArrayList<Rule> listRule = new ArrayList<>();
		LogicBoard board = new logicBoard_Classical2P();
		listRule.add(new Rule_SayHello(game));
		listRule.add(new Rule_SBLeft(game));
		listRule.add(new Rule_OnlyCurrentPlayer(game));
		
		ArrayList<RuleMove> listMove = new ArrayList<>();
		listRule.add(new RuleMove_SimpleWalk(game, board));
		String shape = "Circle";


		try {
			game.start(board, 2, listRule, shape);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void startMenu(){
		new Menu();
	}
}
