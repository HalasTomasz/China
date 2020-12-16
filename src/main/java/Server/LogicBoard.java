package Server;

import java.awt.*;
import java.util.ArrayList;

public abstract class LogicBoard {

    Field[][] fields;
    String color;


    public void decoder(int[] createTables, String color) {
        int[] tablica = createTables;
        this.color = color;

            if (tablica[0] == 1) {
                for (int h = 3; h <= tablica.length - 1; h = h + 2) {
                    for (int i = tablica[h]; i < tablica[2]; i++) {
                        fields[i][tablica[h + 1]].setColor(color);
                    }

                }
            } else {
                for (int h = 3; h <= tablica.length - 1; h = h + 2) {
                    for (int i = tablica[h]; i >= tablica[2]; i--) {
                        fields[i][tablica[h + 1]].setColor(color);
                    }
                }
            }

    }
}
