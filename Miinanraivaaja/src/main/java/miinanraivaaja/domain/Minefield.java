/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.domain;

import java.util.Random;

/**
 * Luokka tarjoaa Minefield-olion ja metodeita miinakentän pyörittämiseen.
 */
public class Minefield {

//    private int x;
//    private int y;
    private int mines;
    private int[][] field;

    public Minefield(int y, int x, int mines) {
//        this.x = x;
//        this.y = y;
        this.field = new int[y + 2][x + 2];
        this.mines = mines;
    }
    
    public Minefield(int[][] yx, int mines) {
        this.field = yx;
        this.mines = mines;
    }

    /**
     * Metodi arpoo miinat miinakentälle. Miinattomaan ruutuun arvotaan miina
     * todennäköisyydellä 0.95. Miinakenttää käydään läpi kunnes on pudotetty
     * oikea määrä miinoja.
     */
    
    public void scatterMines() {
        Random rnd = new Random();

        int minesToDrop = mines;

        while (minesToDrop > 0) {
            for (int j = 1; j < field.length - 1; j++) {
                for (int i = 1; i < field[j].length - 1; i++) {
                    if (field[j][i] == 0) {
                        if (rnd.nextDouble() > 0.95) {
                            if (minesToDrop > 0) {
                                field[j][i] = 9;
                                minesToDrop--;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Metodi käy läpi miinakentän miinattomat ruudut ja laskee 
     * countNearByMines-metodin avulla ruudun viereisissä ruuduissa
     * olevien miinojen lukumäärän miinakentälle.
     */

    public void prepareField() {
        for (int j = 1; j < field.length - 1; j++) {
            for (int i = 1; i < field[j].length - 1; i++) {
                if (field[j][i] != 9) {
                    field[j][i] = countNearByMines(j, i);
                }
            }
        }
    }

    /**
     * Metodi laskee ruudun viereisissä ruuduissa olevien miinojen lukumäärän.
     * 
     * @param y Ruudun sarake
     * @param x Ruudun rivi
     * @return viereisten miinojen lukumäärä
     */
    public int countNearByMines(int y, int x) {
        int nearByMines = 0;
        for (int j = y - 1; j < y + 2; j++) {
            for (int i = x - 1; i < x + 2; i++) {
                if (field[j][i] == 9) {
                    nearByMines++;
                }
            }
        }
        return nearByMines;
    }

    public int cell(int y, int x) {
        return field[y][x];
    }

    public int getAmmount() {
        return mines;
    }
    
    /**
     * Metodilla verrataan onko kahdella miinakentällä yhtä monta miinaa.
     * 
     * @param obj 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        Minefield other = (Minefield) obj;
        return mines == other.getAmmount();
    }
}
