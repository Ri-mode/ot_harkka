
package miinanraivaaja.domain;

import java.lang.System;

/**
 * Luokka tarjoaa Gamedata-olion peliajan mittaamiseen ja laskemiseen.
 */
public class Gamedata {
    private String playerName;
    private long startTime;
    private long endTime;
    
    public Gamedata() {
        this.playerName = "Anonymous";
    }
    
    public void setPlayerName(String pName) {
        this.playerName = pName;
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public long getEndTime() {
        return this.endTime;
    }

    public void startGame() {
        this.startTime = System.currentTimeMillis();
    }
    
    public void endGame() {
        if (this.endTime == 0) {
            this.endTime = System.currentTimeMillis();
        }
    }
    
    public long totalGameTime() {
        return this.endTime - this.startTime;
    }
}
