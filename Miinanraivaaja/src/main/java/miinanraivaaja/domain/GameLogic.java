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
public class GameLogic {
    private int n;
    private Minefield mField;
    private Playerfield pField;
    
    public GameLogic(Minefield mField, Playerfield pField, int n) {
        this.mField = mField;
        this.pField = pField;
        this.n = n;
    }
    
    
    
}
