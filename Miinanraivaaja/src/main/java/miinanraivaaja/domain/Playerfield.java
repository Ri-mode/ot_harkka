/*
 * 
 */
package miinanraivaaja.domain;

/**
 * Luokka tarjoaa Playerfield-olion, jonka avulla voidaan seurata pelaajan
 * toimia ja pitää kirjaa pelaalle näkyvästä miinakentästä.
 */
public class Playerfield {

    private int[][] field;

    public Playerfield(int y, int x) {
        this.field = new int[y + 2][x + 2];
    }

    public int checkCell(int y, int x) {
        return field[y][x];
    }

    public void setCell(int y, int x, int value) {
        field[y][x] = value;
    }

    public void flagCellMine(int y, int x) {
        field[y][x] = -2;
    }

    public void unflagCellMine(int y, int x) {
        field[y][x] = -1;
    }

    /**
     * Metodi alustaa pelaajakentän pelialueen, jotta voidaan seurata pelajaan
     * toimia.
     *
     * @param pelialue Pelialueen valmistelu
     *
     * @return pelialueen valmistelu
     */
    public void preparePlayerField() {
        for (int j = 1; j < field.length - 1; j++) {
            for (int i = 1; i < field[j].length - 1; i++) {
                field[j][i] = -1;
            }
        }
    }

    public int unOpenedCells() {
        int unOpen = 0;
        for (int j = 1; j < field.length - 1; j++) {
            for (int i = 1; i < field[j].length - 1; i++) {
                if (field[j][i] < 0) {
                    unOpen++;
                }
            }
        }
        return unOpen;
    }

}
