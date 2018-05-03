package com.example.jordan.theroyalgameofur;

public class Player {
    public final int PLAYER_SEQUENCE;
    public Stone[] Stones = new Stone[5];

    public Player(int playerSequence) {
        this.PLAYER_SEQUENCE = playerSequence;
        for (int x = 0; x < 5; x++) {
            this.Stones[x] = new Stone(PLAYER_SEQUENCE);
        }
    }

    /**
     * @return the PLAYER_SEQUENCE
     */
    public int getPlayerSequence() {
        return PLAYER_SEQUENCE;
    }

    /**
     * @return the Stones
     */
    public Stone[] getStones() {
        return Stones;
    }

    public Stone getStones(int x) {
        return Stones[x];
    }
    /**
     * @param Stones the Stones to set
     */
    public void setStones(Stone[] Stones) {
        this.Stones = Stones;
    }
}
