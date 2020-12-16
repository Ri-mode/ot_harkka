package miinanraivaaja.domain;

import java.lang.System;

/**
 * Luokka tarjoaa Gamedata-olion peliajan mittaamiseen ja laskemiseen.
 */
public class Gamedata implements Comparable<Gamedata> {

    private String playerName;
    private long startTime;
    private long endTime;

    /**
     * Konstruktori anonyymien pelaajan pelidatan luomiseen.
     */
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

    /**
     * Metodi aloittaa pelin ajanmittauksen.
     */
    public void startGame() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Metodi pysäyttää pelin ajanmittauksen, jos ajanmittausta ei ole vielä
     * aiemmin pysäytetty.
     */
    public void endGame() {
        if (this.endTime == 0) {
            this.endTime = System.currentTimeMillis();
        }
    }

    /**
     * Metodi laskee peliin kuluneen ajan millisekunteina.
     *
     * @return peliaika millisekunteina
     */
    public long totalGameTime() {
        return this.endTime - this.startTime;
    }

    @Override
    public int compareTo(Gamedata gData) {
        if (this.totalGameTime() == gData.totalGameTime()) {
            return 0;
        } else if (this.totalGameTime() > gData.totalGameTime()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return playerName;
    }
}
