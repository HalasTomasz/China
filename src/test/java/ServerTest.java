
import Server.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.Math.abs;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServerTest {
    serverHead game;


    ArrayList<rule> listRule = new ArrayList<>();
    int howManyPlayers;
    logicBoard board;
    String shape;
    ArrayList<RuleMove> listMove = new ArrayList<>();

    @Before
    public void createServer(){


    }

    @After
    public void closeServer(){
        game.stop();

    }

    @Test
    public void setUpTest() {
        initSimpleStuffForServer();

        try {
            setUpServer.createNewGame(board, howManyPlayers, shape, listRule, listMove);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(RuleMove ruleMove: listMove){
            assertSame(ruleMove.getBoard(),  board);
        }
    }

    @Test
    public void serverHeadInitTest() {
        createGame();

        assertSame(game.getShape(),  shape);
        assertSame(game.board,  board);
        assertSame(game.getAmountPlayers(),  0);
        assertSame(game.firstRule,  listRule.get(0));

        for(int i = 0; i <listRule.size()-1; i++){
            assertSame(listRule.get(i).getNextRule(), listRule.get(i+1));
        }
        rule ruleTest = new Rule_SayHello(game);
        for(int i = 0; i <listRule.size()-1; i++){
            listRule.get(i).setNextRule(ruleTest);
        }
        for(int i = 0; i <listRule.size()-1; i++){
            assertSame(listRule.get(i).getNextRule(), ruleTest);
        }
    }

    @Test
    public void simpleFunctionHeadStackTest() {
        createGame();
        game.setCurrentX(1);
        game.setCurrentY(2);
        assertEquals(game.getCurrentX(), 1);
        assertEquals(game.getCurrentY(), 2);
        assertSame(game.getShape(), shape);
        assertSame(game.getAmountPlayers(),0);
        game.setAmountPlayers(2);
        assertSame(game.getAmountPlayers(), 2);


        Socket socket = null;
        try {
            socket = new Socket("localhost", 58901);
        } catch (IOException e) {
            e.printStackTrace();
        }



        game.newPlayer(socket);
        game.newPlayer(socket);
        try {
            game.players.get(0).setup();
            game.players.get(1).setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.nextPlayer();
        assertEquals(game.getCurrentX(), -1);
        assertEquals(game.getCurrentY(), -1);
        assertSame(game.currentPlayer, game.players.get(1));
        game.nextPlayer();
        assertSame(game.currentPlayer, game.players.get(0));
        assertEquals(game.players.get(0).getColor(), "red");


    }

    @Test
    public void simpleFunctionBoard2PStackTest() {
        createGame();
        board = new logicBoard_Classical2P();
        assertEquals(board.getFieldColor(0, 0), null);
        assertEquals(board.getFieldColor(8, 8), "white");
        assertEquals(board.getFieldColor(3, 5), "red");
        assertEquals(board.getFieldHause(3,5), "yellow");
        board.setFieldColor(8,8, "yellow");
        assertEquals(board.getFieldColor(8, 8), "yellow");
    }
    @Test
    public void simpleFunctionBoard3PStackTest() {
        createGame();
        board = new logicBoard_Classical3P();
        assertEquals(board.getFieldColor(0, 0), null);
        assertEquals(board.getFieldColor(8, 8), "white");
        assertEquals(board.getFieldColor(3, 5), "red");
        board.setFieldColor(8,8, "yellow");
        assertEquals(board.getFieldColor(8, 8), "yellow");
    }
    @Test
    public void simpleFunctionBoard4PStackTest() {
        createGame();
        board = new logicBoard_Classical4P();
        assertEquals(board.getFieldColor(0, 0), null);
        assertEquals(board.getFieldColor(8, 8), "white");
        assertEquals(board.getFieldColor(5, 2), "yellow");
        board.setFieldColor(8,8, "black");
        assertEquals(board.getFieldColor(8, 8), "black");
    }
    @Test
    public void simpleFunctionBoard6PStackTest() {
        createGame();
        board = new logicBoard_Classical6P();
        assertEquals(board.getFieldColor(0, 0), null);
        assertEquals(board.getFieldColor(8, 8), "white");
        assertEquals(board.getFieldColor(3, 5), "purple");
        board.setFieldColor(8,8, "yellow");
        assertEquals(board.getFieldColor(8, 8), "yellow");
    }

    @Test
    public void messageTest() {
        createGame();
        Socket socket = null;
        try {
            socket = new Socket("localhost", 58901);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player player1 = spy(new player(socket,"red", game));
        player player2 = spy(new player(socket,"red", game));
        game.players.add(player1);
        game.players.add(player2);
        try {
            game.players.get(0).setup();
            game.players.get(1).setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.newMessageWrite("WON red", player1);
        verify(player1).sendMessage("WON red");
        game.newMessageWrite("TEST", player2);
        verify(player2).sendMessage("TEST");

    }
    @Test
    public void ruleTest() {
        createGame();
        Socket socket = null;
        try {
            socket = new Socket("localhost", 58901);
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.firstRule = spy(game.firstRule);
        game.firstRule.setNextRule(spy(game.firstRule.getNextRule()));
        game.firstRule.getNextRule().setNextRule(spy(game.firstRule.getNextRule().getNextRule()));
        game.firstRule.getNextRule().getNextRule().setNextRule(spy(game.firstRule.getNextRule().getNextRule().getNextRule()));

        game.setAmountPlayers(2);
        game.newPlayer(socket);
        game.newPlayer(socket);
        try {
            game.players.get(0).setup();
            game.players.get(1).setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.newMessageRead(game.getPlayers().get(0), "TEST");
        verify(game.firstRule).tryCheck(game.getPlayers().get(0), "TEST");
        verify(game.firstRule.getNextRule()).tryCheck(game.getPlayers().get(0), "TEST");
        verify(game.firstRule.getNextRule().getNextRule()).tryCheck(game.getPlayers().get(0), "TEST");
        verify(game.firstRule.getNextRule().getNextRule().getNextRule()).tryCheck(game.getPlayers().get(0), "TEST");



    }
    @Test
    public void betterRuleTest() {
        createGame();
        Socket socket = null;
        try {
            socket = new Socket("localhost", 58901);
        } catch (IOException e) {
            e.printStackTrace();
        }

        game.setAmountPlayers(2);
        game.newPlayer(socket);
        game.newPlayer(socket);
        try {
            game.players.get(0).setup();
            game.players.get(1).setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rule testingRule = new Rule_SayHello(game);
        assertFalse(testingRule.tryCheck(game.players.get(0), "BAD!@#!DATA"));
        assertTrue(testingRule.tryCheck(game.players.get(0), "WAITING"));

        testingRule = new Rule_SBLeft(game);
        assertFalse(testingRule.tryCheck(game.players.get(0), "BAD!@#!DATA"));
        assertTrue(testingRule.tryCheck(game.players.get(0), "LEFT"));

        testingRule = new Rule_OnlyCurrentPlayer(game);
        assertFalse(testingRule.tryCheck(game.players.get(0), "good player dont stop/false"));
        assertTrue(testingRule.tryCheck(game.players.get(1), "stop bad player"));

        testingRule = new Rule_WaitForAll(game);
        game.setAmountPlayers(2);
        assertFalse(testingRule.tryCheck(game.players.get(0), "enough"));
        game.setAmountPlayers(3);
        assertTrue(testingRule.tryCheck(game.players.get(0), "not  enough"));
        game.setAmountPlayers(2);


        RuleMove testingRuleMove = new RuleMove_NoActiveField(game);
        testingRuleMove.init(board);
        game.setCurrentX(-1);
        game.setCurrentY(-1);
        assertTrue(testingRuleMove.tryCheck(game.players.get(0), "MOVE 1;1"));
        game.setCurrentX(5);
        game.setCurrentY(5);
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 5;5"));



        testingRuleMove = new RuleMove_ToHause(game);
        testingRuleMove.init(board);
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 12;7"));
        board.setFieldColor(12,6,"red");
        game.setCurrentX(12);
        game.setCurrentY(7);
        assertTrue(testingRuleMove.tryCheck(game.players.get(0), "MOVE 13;6"));


        testingRuleMove = new RuleMove_SimpleJump(game);
        testingRuleMove.init(board);
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 8;7"));
        board.setFieldColor(7,4,"red");
        board.setFieldColor(7,5,"yellow");
        board.setFieldColor(7,6,"white");
        game.setCurrentX(7);
        game.setCurrentY(4);
        assertTrue(testingRuleMove.tryCheck(game.players.get(0), "MOVE 7;6"));

        testingRuleMove = new RuleMove_SimpleWalk(game);
        testingRuleMove.init(board);
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 12;6"));

        assertTrue(testingRuleMove.tryCheck(game.players.get(0), "MOVE 7;7"));

        testingRuleMove = new RuleMove_SkipTurn(game);
        testingRuleMove.init(board);
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 7;1"));
        assertFalse(testingRuleMove.tryCheck(game.players.get(0), "MOVE 3;6"));
        game.setCurrentX(7);
        game.setCurrentY(7);
        assertTrue(testingRuleMove.tryCheck(game.players.get(0), "MOVE 7;7"));

    }

    private void initSimpleStuffForServer(){
        game = new serverHead();
        listRule = new ArrayList<>();
        listMove = new ArrayList<>();
        listRule.add(new Rule_SayHello(game));
        listRule.add(new Rule_SBLeft(game));
        listRule.add(new Rule_WaitForAll(game));
        listRule.add(new Rule_OnlyCurrentPlayer(game));

        howManyPlayers = 0;
        board = new logicBoard_Classical2P();
        shape = "Circle";

        listMove.add(new RuleMove_NoActiveField(game));
        listMove.add(new RuleMove_SkipTurn(game));
        listMove.add(new RuleMove_SimpleWalk(game));
        listMove.add(new RuleMove_SimpleJump(game));
        listMove.add(new RuleMove_ToHause(game));
        listRule.addAll(listMove);
    }

    void createGame(){
        initSimpleStuffForServer();
        for(RuleMove ruleMove: listMove){
            ruleMove.init(board);
        }

        try {
            game.start(board, howManyPlayers, listRule, shape);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}