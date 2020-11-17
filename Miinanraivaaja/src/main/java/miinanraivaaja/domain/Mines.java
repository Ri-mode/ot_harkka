/*
 * Miinojen hallintaan tehty luokka
 */
package miinanraivaaja.domain;

/**
 *
 * @author antti
 */
public class Mines {
    
    private int amount;
    
    public Mines(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
    
    @Override
    public boolean equals(Object obj) {
        Mines other = (Mines) obj;
        return amount == other.getAmount();
    }
    
}
