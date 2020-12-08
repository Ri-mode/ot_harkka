/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.domain;

/**
 *
 * @author antti
 */
public class Playerfield {

    private int[][] field;

    public Playerfield(int y, int x) {
        this.field = new int[y + 2][x + 2];
    }

    public int checkCell(int y, int x) {
        return field[y][x];
    }

    public void openCell(int y, int x) {
        field[y][x] = 1;
    }

    public void flagCellMine(int y, int x) {
        field[y][x] = 2;
    }
    
    public int cell(int y, int x) {
        return field[y][x];
    }
    
    public void preparePlayerField() {
        for (int j = 1; j < field.length - 1; j++) {
            for (int i = 1; i < field[j].length - 1; i++) {
                field[j][i] = -1;
            }
        }
    }
    
}
