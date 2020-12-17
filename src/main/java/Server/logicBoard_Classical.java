package Server;

import java.util.ArrayList;

public abstract class logicBoard_Classical extends LogicBoard {


        logicBoard_Classical(){

            fields = new Field[17][13];
            for(int x = 0; x<17; x++){
                for (int y = 0; y<13; y++){
                    fields[x][y] = new Field();
                }

            }
            int[] array ={1,4,9, 4,4, 4,5, 4,6, 4,7, 4,8, 5,9, 6,3, 7,10, 8,2};
            int[] array2={0,12,9, 12,4, 12,5, 12,6, 12,7, 12,8, 11,9, 10,3, 9,10};

            int[] house1 ={1, 0, 4, 0, 6, 1, 7, 2, 5, 3, 8};
            int[] house2 ={0, 16, 13, 16, 6, 15, 7, 14, 5, 13, 8};
            int[] house3 ={0, 7,4, 7, 2, 6, 1, 5, 3, 4, 0};
            int[] house4 ={0, 7, 4, 7, 11, 6, 10, 5, 12, 4, 9};
            int[] house5 ={1, 9, 13, 9, 2, 10, 1, 11, 3, 12, 0};
            int[] house6 ={1, 9, 13, 9, 11 ,10, 10, 11, 12, 12, 9};

            decoder(array, "white");
            decoder(array2, "white");

            decoder(house1, "white");
            decoder(house2, "white");
            decoder(house3, "white");
            decoder(house4, "white");
            decoder(house5, "white");
            decoder(house6, "white");
    }

}
