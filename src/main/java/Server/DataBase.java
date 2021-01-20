package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import Hiber.GameData;
import Hiber.SavingDataGame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBase {
    private static DataBase database;
    private int game;
    private int currentMove = 0;
    private static SessionFactory factory;
    private Integer gameID;
 
    public static DataBase getInstance() {
    
        if (database == null) {
            synchronized (DataBase.class){
            if (database == null) {
                database = new DataBase();
             }
            }
        }
        return database;
    }
    public void saveToSql(String string){
        DataBase Me2 = DataBase.getInstance();
        Me2.addNewMove(string);
    }
    public void addNewMove(String string){
        
        Session session = factory.openSession();
        Transaction tx = null;
        System.out.println("Karol nie wierzy ze jego serwer lezy1"+" "+gameID);
    
        try {
            tx = session.beginTransaction();
            SavingDataGame games = new SavingDataGame(gameID,1,1,string);
            Integer ID = (Integer) session.save(games); ;
            System.out.println("Karol nie wierzy ze jego serwer lezy2");
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Karol nie wierzy ze jego serwer lezy");
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void createSQl(String Board, int Players, String shape) {
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        DataBase Me = DataBase.getInstance();
        Me.gameID = Me.addNewGame(Board,Players,shape);
        System.out.println(gameID);
    }
    public Integer addNewGame(String Board, int Players, String shape) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        Integer NrGry = null;
    
        try {
            tx = session.beginTransaction();
            GameData game = new GameData(Board,Players, shape);
            NrGry = (Integer) session.save(game);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return NrGry;
    }
    

    public void setGameID(int numerGry) {
        game = numerGry;
    }
    
    public ArrayList<String> nextMove() {
        ArrayList<String> tmp = new ArrayList<String>();
        if(currentMove == 9999) {
            tmp.add("None");
        }else {
        }
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
