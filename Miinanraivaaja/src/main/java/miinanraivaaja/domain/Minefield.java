/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.domain;

import java.util.Random;

/**
 *
 * @author antti
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

    public int cell(int y, int x) {
        return field[y][x];
    }
    
    public int getAmmount() {
        return mines;
    }

    @Override
    public boolean equals(Object obj) {
        Minefield other = (Minefield) obj;
        return mines == other.getAmmount();
    }
}
