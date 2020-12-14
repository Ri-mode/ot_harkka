
package miinanraivaaja.domain;

import java.lang.System;

/**
 * Luokka tarjoaa Gametime-olion peliajan mittaamiseen ja laskemiseen.
 */
public class Gametime {
    
    private long startTime;
    private long endTime;
    
    public Gametime() {
    }
    
    public void startGame() {
        this.startTime = System.currentTimeMillis();
    }
    
    public void endGame() {
        this.endTime = System.currentTimeMillis();
    }
    
    public long totalGameTime() {
        return this.endTime - this.startTime;
    }
}
