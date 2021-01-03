package Server;

public abstract class logicBoard {

    field[][] fields;


    protected void decoder(int[] createTables, String color, String winningHause) {

            if (createTables[0] == 1) {
                for (int h = 3; h <= createTables.length - 1; h = h + 2) {
                    for (int i = createTables[h]; i < createTables[2]; i++) {
                        fields[i][createTables[h + 1]].setColor(color);
                        fields[i][createTables[h + 1]].setHause(winningHause);
                    }

                }
            } else {
                for (int h = 3; h <= createTables.length - 1; h = h + 2) {
                    for (int i = createTables[h]; i >= createTables[2]; i--) {
                        fields[i][createTables[h + 1]].setColor(color);
                        fields[i][createTables[h + 1]].setHause(winningHause);
                    }
                }
            }
    }

    protected boolean checker(int[] createdTables, String color, int positiveHouse) {

        int counter = 0;

        if (createdTables[0] == 1) {
            for (int h = 3; h <= createdTables.length - 1; h = h + 2) {
                for (int i = createdTables[h]; i < createdTables[2]; i++) {
                    if(fields[i][createdTables[h + 1]].getColor().equals(color)){
                        counter++;
                    }
                }

            }
        } else {
            for (int h = 3; h <= createdTables.length - 1; h = h + 2) {
                for (int i = createdTables[h]; i >= createdTables[2]; i--) {
                    if(fields[i][createdTables[h + 1]].getColor().equals(color)){
                        counter++;
                    }
                }
            }
        }

        if(counter == positiveHouse){
            return true;
        }else {
            return false;
        }
    }

    public String getFieldColor(int x, int y){
        return fields[x][y].getColor();
    }
    public void setFieldColor(int x, int y,String color) {
        fields[x][y].setColor(color);
    }
    public String getFieldHause(int x, int y) { return fields[x][y].colorToWin; }

    protected abstract String hasSbWon();
}
