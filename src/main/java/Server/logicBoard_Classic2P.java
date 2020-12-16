package Server;

import java.util.ArrayList;

public class logicBoard_Classic2P extends logicBoard_Classic {
    ArrayList<int[]> houses;
    logicBoard_Classic2P(){
        super();
        fields = new Field[17][13];


        int[] house1 ={1,0,4, 0,6, 1,7, 2,5, 3,8};
        int[] house2 ={0,16,13, 16,6, 15,7, 14,5, 13,8};
//        int[] house3 ={0,7,4, 7,2, 6,1, 5,3, 4,0};
//        int[] house4 ={0,7,4, 7,11, 6,10, 5,12, 4,9};
 //       int[] house5 ={1,9,13, 9,2, 10,1, 11,3, 12,0};
//        int[] house6 ={1,9,13, 9,11 ,10,10, 11,12, 12,9};
        decoder(house1, "red");
        decoder(house2, "yellow");

        //zakoduj kolory
        //ustal liczbe domkow i pola
    }
}
