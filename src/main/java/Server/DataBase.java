package Server;

import java.util.ArrayList;

public class DataBase {
    private static DataBase database;
    private int game;
    private int currentMove = 0;

    public static DataBase getInstance() {

                if (database == null) {
                    database = new DataBase();
                }
        return database;
    }

    public void saveToSql(String message) {
        int i = 0;


    }

    public void setGameID(int numerGry) {
        game = numerGry;
    }

    public ArrayList<String> nextMove() {
        ArrayList<String> tmp = new ArrayList<String>();
        return tmp;

    }

    public ArrayList<String> backMove() {
        ArrayList<String> tmp = new ArrayList<String>();
        if(currentMove == 0) {
            tmp.add("None");
        }else {

        }
        return tmp;
    }

}
