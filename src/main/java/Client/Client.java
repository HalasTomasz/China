package Client;

import Client.Frame.GUI;

import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    
    private GUI gui;
    private ClientPostman postman;

    public Client(String serverAddress) throws Exception {

        postman = new ClientPostman(serverAddress, this);
        postman.takeWelcomeMessage();
        postman.waitForNewMessage();

    }
    
    public void getResponse(String response){
        System.out.println("FROM SERVER: " + response);
        if(response.equals("WAIT_FOR_ALL")){
            gui.waitForMove();
        }
        else if(response.equals("NOT_YOU")){
            gui.notYou();
        }
        else if(response.equals("SB_LEFT")){
            gui.left();
        }
        else if( response.startsWith("CHANGE")){
            String[] tmp = response.substring(7).split(";");
            try{
                gui.change(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
            }catch(Exception e){
                System.out.println("BAD_DATA");
            }
        }
        else if(response.startsWith("WON")){
            gui.winner();
        }
        else if (response.startsWith("ACTIVE")){
            String[] tmp2 = response.substring(7).split(";");
            try{
                gui.change(Integer.parseInt(tmp2[0]), Integer.parseInt(tmp2[1]), "orange");
            }catch(Exception e){
                System.out.println("BAD_DATA");
            }
        }
        else if(response.startsWith("NOT_YOUR")){
            gui.notChecker();
        }
        else if(response.startsWith("NOW")){
            String[] tmp3 = response.substring(3).split(" ");
            gui.changePlayer(tmp3[1]);
        }
       
    }
    
    public void writeMessage(String message){
        postman.sendMessage(message);
    }


    public boolean WelcomeMassageRead(String responseSetUP) {
        if (responseSetUP.startsWith("HELLO")) {
            String[] tmp = responseSetUP.substring(6).split(";");
            System.out.println(tmp[0]+  tmp[1] + tmp[2] + tmp[3]);
            gui = new GUI("Classical", tmp[1], tmp[2], tmp[3], this);
            return true;
        }
        return false;
    }
}