import Client.Client;
import Client.Frame.CreateBoard;
import Client.Frame.DrawSpace;
import Client.Frame.GUI;
import Client.Frame.SetBoardShape;
import Server.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DrawSpaceTest {
	
	@Test
	public void colorDecoder() throws Exception {
		runServer();
		
		Client client = new Client("localhost");
		GUI gui = new GUI("Classical", "Circle", "red","2",client);
		DrawSpace drawSpace = new DrawSpace(CreateBoard.boardProperties("Classical").giveSize(), SetBoardShape.returnBoardShape("Circle").returnTables(),2,2,gui);
		assertEquals(Color.red,drawSpace.colorDecoder("red"));
	}
	public void runServer(){
		serverHead game = new serverHead();
		int howManyPlayers =2;
		ArrayList<Rule> listRule = new ArrayList<>();
		ArrayList<LogicBoard> whatsBoard = new ArrayList<>();
		ArrayList<String> shape = new ArrayList<>();
		ArrayList<RuleMove> listMove = new ArrayList<>();
		listRule.add(new Rule_SayHello(game));
		listRule.add(new Rule_SBLeft(game));
		listRule.add(new Rule_gameOver(game));
		listRule.add(new Rule_WaitForAll(game));
		listRule.add(new Rule_OnlyCurrentPlayer(game));
		whatsBoard.add(new logicBoard_Classical2P());
		shape.add("Circle");
		listMove.add(new RuleMove_NoActiveField(game));
		listMove.add(new RuleMove_SkipTurn(game));
		listMove.add(new RuleMove_SimpleWalk(game));
		listMove.add(new RuleMove_SimpleJump(game));
		listMove.add(new RuleMove_ToHause(game));
		listRule.addAll(listMove);
		setUpServer.createNewGame(whatsBoard.get(0), howManyPlayers, shape.get(0), listRule, listMove);
	}
	@Test
	public void sendInfo() {
	}
	
	@Test
	public void change() {
	}
}