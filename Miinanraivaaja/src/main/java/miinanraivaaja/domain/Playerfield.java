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

    /**
     * Konstruktori tietynkokoisen pelaajakentän luomiseksi.
     *
     * @param y Ruudukon sarakkeiden lukumäärä
     * @param x Ruudukon rivien lukumäärä
     */
    public Playerfield(int y, int x) {
        this.field = new int[y + 2][x + 2];
    }

    /**
     * Metodi palauttaa tietyn ruudun pelitilanteen.
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     * @return ruudun tila
     */
    public int checkCell(int y, int x) {
        return field[y][x];
    }

    /**
     * Metodi Playerfield-kentän ruudun arvon asettamiseksi.
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     * @param value ruutuun asetettava arvo
     */
    public void setCell(int y, int x, int value) {
        field[y][x] = value;
    }

    /**
     * Metodi muuttaa Playerfield-kentän avaamattoman ruudun sellaiseksi, ettei
     * sitä voi avata.
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     */
    public void flagCellMine(int y, int x) {
        field[y][x] = -2;
    }

    /**
     * Meodi palauttaa Playerfield-kentän ruudun takaisin avattavaksi.
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     */
    public void unflagCellMine(int y, int x) {
        field[y][x] = -1;
    }

    /**
     * Metodi alustaa pelaajakentän pelialueen, jotta voidaan seurata pelajaan
     * toimia.
     *
     */
    public void preparePlayerField() {
        for (int j = 1; j < field.length - 1; j++) {
            for (int i = 1; i < field[j].length - 1; i++) {
                field[j][i] = -1;
            }
        }
    }

    /**
     * Metodi laskee montako Playerfield-kentän ruuduista on avaamatonta.
     *
     * @return avaamattomien ruutujen lukumäärä
     */
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
