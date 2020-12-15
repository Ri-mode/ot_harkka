/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.logic;
import miinanraivaaja.dao.MiinanraivaajaDao;
import miinanraivaaja.domain.Gamedata;
import miinanraivaaja.domain.Minefield;
import miinanraivaaja.domain.Playerfield;

/**
 * Luokka tarjoaa pelinlogiikan ja hallitsee peliä varten luotavia pelaaja- ja
 * miinakenttiä.
 */
public class GameLogic {

    private int n;
    private Minefield mField;
    private Playerfield pField;
    private Gamedata gData;
    private MiinanraivaajaDao newDao;
    
    /**
     * Konstruktori, jonka avulla voidaan luoda ennalta määritelty pelilogiikka
     * testejä varten.
     *
     * @param mField Testin antama miinakenttä
     * @param pField Testin antama pelaajakenttä
     * @param n Testin miinojen lukumäärä
     */
    public GameLogic(Minefield mField, Playerfield pField, int n) {
        this.mField = mField;
        this.pField = pField;
        this.gData = new Gamedata();
        this.newDao = new MiinanraivaajaDao();
        this.n = n;
    }

    /**
     * Konstruktori, jonka avulla luodaan n*n kokoinen pelilogiikka, jossa on n
     * miinaa. Miinat arvotaan miinakentälle ja kentätä alustetaan.
     *
     * @param n Pelialueen koko ja miinojen lukumäärä
     */
    public GameLogic(int n) {
        this.mField = new Minefield(n, n, n);
        this.pField = new Playerfield(n, n);
        this.gData = new Gamedata();
        this.newDao = new MiinanraivaajaDao();
        this.n = n;
        mField.scatterMines();
        mField.prepareField();
        pField.preparePlayerField();
        gData.startGame();
    }

    public int getN() {
        return this.n;
    }

    public Playerfield getPlayerField() {
        return this.pField;
    }

    public Minefield getMineField() {
        return this.mField;
    }

    /**
     * Metodi avaa pelaajakentän ruudun ja palauttaa siihen miinakentältä
     * tulleen viereisten miinojen määrän (0-8) tai miinan (9).
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     * @return vereisten ruutujen miinat tai miina ruudussa
     */
    public int openPlayerCell(int y, int x) {
        if (pField.checkCell(y, x) == -1) {
            pField.setCell(y, x, mField.cell(y, x));
            if (pField.checkCell(y, x) == 0) {
                openAround(y, x);
            }
        }
        System.out.println(pField.unOpenedCells());
        if (pField.unOpenedCells() == n) {
            gData.endGame();
            System.out.println("Kaikki löydetty. Aikaa kului: " 
                    + Long.toString(gData.totalGameTime()));
            newDao.saveToFile(gData);
        }
        return pField.checkCell(y, x);
    }

    /**
     * Metodi avaa yhdessä openPlayerCell-metodin kanssa rekursiivisesti ruudut,
     * joiden vieressä ei ole yhtään miinaa.
     *
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     */
    public void openAround(int y, int x) {
        for (int j = y - 1; j < y + 2; j++) {
            for (int i = x - 1; i < x + 2; i++) {
                if (pField.checkCell(j, i) == -1) {
                    openPlayerCell(j, i);
                }
            }
        }
    }
}
