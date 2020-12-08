/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.logic;

import miinanraivaaja.domain.Minefield;
import miinanraivaaja.domain.Playerfield;

/**
 *
 * @author antti
 */
public class GameLogic {
    private int n;
    private Minefield mField;
    private Playerfield pField;
    
    public GameLogic(Minefield mField, Playerfield pField, int n) {
        this.mField = mField;
        this.pField = pField;
        this.n = n;
    }
    
    public GameLogic(int n) {
        this.mField = new Minefield(n, n, n);
        this.pField = new Playerfield(n, n);
        this.n = n;
        mField.scatterMines();
        mField.prepareField();
        pField.preparePlayerField();
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
    
    public int openPlayerCell(int y, int x) {
        if (pField.checkCell(y, x) == -1) {
            pField.setCell(y, x, mField.cell(y, x));
            if (pField.checkCell(y, x) == 0) {
                openAround(y, x);
            }
        }
        return pField.checkCell(y, x);
    }
    
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
